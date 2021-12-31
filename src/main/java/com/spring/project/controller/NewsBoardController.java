package com.spring.project.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.project.common.PaginationNews;
import com.spring.project.service.CommentNewsService;
import com.spring.project.service.NewsBoardService;
import com.spring.project.vo.CommentNewsVO;
import com.spring.project.vo.NewsBoardVO;

//기본적으로 freeboardController와 같음
//@SessionAttributes를 통해 어디선가 getFreeBoard가 model에 add되면 해당 getNewsBoard이름으로 세션에 저장
@Controller
@SessionAttributes("getNewsBoard")
public class NewsBoardController {

	//자동주입 (메서드에서 NewsBoardService, CommentNewsService를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능) 
	@Autowired
	private NewsBoardService nservice;
	@Autowired
	private CommentNewsService cservice;

	//newsboard관리(주석은 freeboardController 참고하고 다른점만 주석달음)
	
	//게시글 리스트 가져오기(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/newsboard.do")
	public String getnewsBoardList(NewsBoardVO vo, Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range, PaginationNews pagination){				

		//리스트 검색기능, null값 처리
		if(vo.getSearchSelect() == null) vo.setSearchSelect("TITLE");
		if(vo.getSearchText() == null) vo.setSearchText("");

		//미스테리---이게 없으닌까 자꾸 예외가 떠서 넣긴 했는데,, 자유게시판에는 안넣어도 오류안뜨던디,,,//
		if(pagination.getSearchSelect() == null) pagination.setSearchSelect("TITLE");
		if(pagination.getSearchText() == null) pagination.setSearchText("");

		//전체 게시글 개수(서비스->서비스impl->dao->mapping)가져와서 페이징 메서드 호출, model에 값담음
		int listCnt = nservice.getBoardListCnt();
		pagination.pageInfo(page, range, listCnt);	
		model.addAttribute("paginationNews", pagination);
		//게시글 리스트(서비스->서비스impl->dao->mapping)가져와서 model에 저장
		model.addAttribute("newsboardlist", nservice.getnewsBoardList(pagination));

		return "newsboard.jsp";
	}

	//게시글 가져오기
	@RequestMapping(value = "/getNewsBoard.do")
	public String getNewsBoard(NewsBoardVO vo, CommentNewsVO cvo, Model model) {
		//코멘트(서비스->서비스impl->dao->mapping)
		List<CommentNewsVO> clist= cservice.getCommentList(cvo);

		//조회수+1(서비스->서비스impl->dao->mapping)
		nservice.updateCntNewsBoard(vo);
		
		//게시글 가져오기(서비스->서비스impl->dao->mapping)
		NewsBoardVO fvo =nservice.getNewsBoard(vo);
		String path="";
		if(fvo !=null) {
			model.addAttribute("getNewsBoard", fvo);
			model.addAttribute("getCommentListNews", clist);
			path="getNewsBoard.jsp";
		}else {
			path="newsBoard.do";
		}
		return path;
	}
	
	//게시글 입력(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/insertNewsBoard.do")
	public String insertNewsBoard(NewsBoardVO vo, HttpServletRequest request) {
		//파일업로드 기능 추가(vo에서 MultipartFile데이터 타입으로 지정해놓은것 가져와서 변수 담음)
		MultipartFile upFile = vo.getUploadFile();
		//해당 값이 존재한다면
		if(!upFile.isEmpty()) {
			//파일업로도 경로 지정(request이용하여 홈경로 찾고 최종 업로드 경로는 http://suyoung07.cafe24.com/images/가 되도록함)
			String filePath = request.getSession().getServletContext().getRealPath("/images/"); 
			//파일 저장할때 이름 지정, 파일 원본이름 가져오기.getOriginalFilename();
			String fileName = upFile.getOriginalFilename();
			//파일이름에 현재 날짜 찍어줄려고 날짜 포맷 생성
			SimpleDateFormat date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			//현재날짜를 만들어놓은 포멧으로 지정
			String timeStamp = date.format(new Date());
			System.out.println("Current Time Stamp: "+timeStamp);
			//현재날짜+원본파일이름해서 최종 파일 이름 변수로 담고 vo에 값 세팅함
			String fname = timeStamp+fileName;
			vo.setFilename(fname);
			try {
				//.transferTo()를 통해 최종 업로드된 파일의 경로 지정 
				//(ex. http://suyoung07.cafe24.com/images/2021_10_27_13_12_57img6.jpg)
				upFile.transferTo(new File(filePath+fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//게시글 작성 (서비스->서비스impl->dao->mapping : insert문이므로 따로 변수 안담음)
		nservice.insertNewsBoard(vo);
		return "redirect:newsboard.do";
	}

	//게시글 수정
	@RequestMapping(value = "/updateNewsBoard.do")
	public String updateNewsBoard(@ModelAttribute("getNewsBoard") NewsBoardVO vo) {
		//게시글수정(서비스->서비스impl->dao->mapping : update문이므로 따로 변수 안담음)
		nservice.updateNewsBoard(vo);
		return "redirect:getNewsBoard.do?newsseq="+vo.getNewsseq();
	}

	//게시글 삭제
	@RequestMapping(value = "/deleteNewsBoard.do")
	public String deleteNewsBoard(NewsBoardVO vo, CommentNewsVO cvo) {
		System.out.println("deleteNewsBoard cvo.getNewsseq(): "+cvo.getNewsseq());
		//게시글이 삭제될때 해당 게시글의 코멘트도 전부 삭제
		cservice.deleteAllComment(cvo);
		//해당 게시글 삭제(서비스->서비스impl->dao->mapping : delte문이므로 따로 변수 안담음)
		nservice.deleteNewsBoard(vo);
		return "redirect:newsboard.do";
	}

	//메인화면에 출력될 리스트 가져오기 json @ResponseBody를 통해 스프링이json으로 변환/ index.js에서 ajax로 요청옴
	@RequestMapping(value = "/getnewsBoardListNewsJson.do")
	@ResponseBody
	public List<NewsBoardVO> getnewsBoardListNewsJson(NewsBoardVO vo)	{	
		//게시글리스트 ajax로 요청오면 json으로 값 전달, FreeBoardVO데이터타입으로 List에 변수로 담기
		List<NewsBoardVO> list =nservice.getnewsBoardListNewsJson(vo);
		return list;
	}


}
