package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.project.common.Pagination;
import com.spring.project.service.CommentService;
import com.spring.project.service.FreeBoardService;
import com.spring.project.vo.CommentVO;
import com.spring.project.vo.FreeBoardVO;


//스프링에서 컨트롤러 띄우고 @RequestMapping에 맞는 주소를 찾음
//(서블릿에서 .do로 된것은 모두 컨트롤러로 연결되도록 세팅)
//@SessionAttributes를 통해 어디선가 getFreeBoard가 model에 add되면 해당 getFreeBoard이름으로 세션에 저장하고
//필요할때 @ModelAttribute를 통해서 불러서 쓸수 있음
@Controller
@SessionAttributes("getFreeBoard")
public class FreeBoardController {

	//자동주입 (메서드에서 FreeBoardService, CommentService를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능) 
	@Autowired
	private FreeBoardService fservice;
	@Autowired
	private CommentService cservice;

	//freeboard관리

	//게시글 리스트 가져오기(void값은 string으로 해서 이동될 주소 return)
	//페이징기능 추가(페이지, 범위 값 받고(없으면 초기값은 1), Pagination클래스 받음)
	@RequestMapping(value = "/freeboard.do")
	public String getFreeBoardList(FreeBoardVO vo, Model model
			, @RequestParam(required = false, defaultValue = "1") int page
			, @RequestParam(required = false, defaultValue = "1") int range, Pagination pagination){				

		//리스트 검색기능, null값 처리
		if(vo.getSearchSelect() == null) vo.setSearchSelect("TITLE");
		if(vo.getSearchText() == null) vo.setSearchText("");

		//페이징위해서 전체 게시글 개수 가져오기(서비스->서비스impl->dao->mapping)
		int listCnt = fservice.getBoardListCnt();
		//Pagination 클래스의 pageInfo() 실행
		pagination.pageInfo(page, range, listCnt);
		//model에 pagination이름으로 pagination값 저장하여 jsp에서 pagination으로 사용가능
		model.addAttribute("pagination", pagination);
		//model에 freeboardlist이름으로 게시글 리스트(서비스->서비스impl->dao->mapping)가져와서 저장, jsp에서 freeboardlist으로 사용가능
		model.addAttribute("freeboardlist", fservice.getFreeBoardList(pagination));
		//이동할주소는 세팅된값 같이 전달하여 게시글 페이지로 이동
		return "freeboard.jsp";
	}


	//해당 게시글 가져오기(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/getFreeBoard.do")
	public String getFreeBoard(FreeBoardVO vo, CommentVO cvo, Model model) {
		//해당 게시글의 코멘트리스트 가져오기(CommentController가 아니라 해당 게시글에 접근했을때 comment list가 보여야 하므로
		//freeboard를 관리하는 Controller에서 호출
		//CommentVO데이터타입으로 list로 값을 받음 (서비스->서비스impl->dao->mapping)가져와서 저장
		List<CommentVO> clist= cservice.getCommentList(cvo);
		
		//해당 게시글을 클릭했을때(=getFreeBoard.do로 접근하면) 
		//조회수+1(서비스->서비스impl->dao->mapping : update문이므로 변수에 따로 안담음)
		fservice.updateCntFreetBoard(vo);
		
		//해당게시글 가져오기(서비스->서비스impl->dao->mapping : select로 한개 가져오므로 FreeBoardVO로 변수 담음)
		FreeBoardVO fvo =fservice.getFreetBoard(vo);
		String path="";
		if(fvo !=null) {
			//해당게시글이 존재하면 model에 각각 게시글과 코멘트리스트 담아서 해당 페이지로 보내기
			//model로 getFreeBoard으로 저장된 값은 위에 Controller에서 @SessionAttributes("getFreeBoard")로 저장됨
			model.addAttribute("getFreeBoard", fvo);
			model.addAttribute("getCommentList", clist);
			path="getFreeBoard.jsp";
		}else {
			//해당게시글이 존재안하면
			path="freeBoard.do";
		}
		return path;
	}

	//게시글 입력(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/insertFreeBoard.do")
	public String insertFreeBoard(FreeBoardVO vo) {
		//게시글쓰기(서비스->서비스impl->dao->mapping : insert문이므로 따로 변수 안담음)
		fservice.insertFreetBoard(vo);
		//전달할 값 없으므로 redirct로 보내며, .do로 보내서 게시글 리스트를 보여줄수 있게함 
		return "redirect:freeboard.do";
	}

	//Controller에서 세션에 담아져있는 값을 @ModelAttribute("getFreeBoard")로 가져와서
	//게시글 수정(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/updateFreeBoard.do")
	public String updateFreeBoard(@ModelAttribute("getFreeBoard") FreeBoardVO vo) {
		//게시글수정(서비스->서비스impl->dao->mapping : update문이므로 따로 변수 안담음)
		fservice.updateFreetBoard(vo);
		//freeseq값 같이 전달하여 해당 게시글로 이동
		return "redirect:getFreeBoard.do?freeseq="+vo.getFreeseq();
	}

	//게시글 삭제(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping(value = "/deleteFreeBoard.do")
	public String deleteFreeBoard(FreeBoardVO vo, CommentVO cvo) {
		//게시글이 삭제될때 해당 게시글의 코멘트도 전부 삭제
		cservice.deleteAllComment(cvo);
		//해당 게시글 삭제(서비스->서비스impl->dao->mapping : delte문이므로 따로 변수 안담음)
		fservice.deleteFreetBoard(vo);
		//전달할 값 없으므로 redirct로 보내며, .do로 보내서 게시글 리스트를 보여줄수 있게함
		return "redirect:freeboard.do";
	}


	//메인화면에 출력될 리스트 가져오기 json @ResponseBody를 통해 스프링이json으로 변환/ index.js에서 ajax로 요청옴
	@RequestMapping(value = "/getFreeBoardListIndexJson.do")
	@ResponseBody
	public List<FreeBoardVO> getFreeBoardListIndexJson(FreeBoardVO vo)	{	
		//게시글리스트 ajax로 요청오면 json으로 값 전달, FreeBoardVO데이터타입으로 List에 변수로 담기
		List<FreeBoardVO> list =fservice.getFreeBoardListIndexJson(vo);
		return list;

	}

}
