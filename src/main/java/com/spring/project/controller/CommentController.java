package com.spring.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.service.CommentService;
import com.spring.project.vo.CommentVO;

//스프링에서 컨트롤러 띄우고 @RequestMapping에 맞는 주소를 찾음
//(서블릿에서 .do로 된것은 모두 컨트롤러로 연결되도록 세팅)
@Controller
public class CommentController {

	//자동주입 (메서드에서 CommentService를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능) 
	@Autowired
	private CommentService cservice;

	//freeboard의 comment 관리
	
	//댓글 입력(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping("/insertComment.do")
	public String  insertComment(CommentVO vo,  HttpSession session) {
		System.out.println("insertComment");
		//userId는 세션에 저장되어 있으므로 세션으로 값을 가져올수 있다.(UserController 참고)
		//id값 체크해서 로그인 시에 댓글 입력
		String userId= (String)session.getAttribute("userId");
		String path ="";
		if(userId == null || userId.equals("") || userId.equals("null") ) {
			//id값 없을때: 로그인 페이지 이동
			System.out.println("로그인하세요");
			path="login.jsp";
		}else {
			//id값 존재할때: mybatis로 매핑된 sql실행(서비스->서비스impl->dao->mapping)
			cservice.insertComment(vo);
			//댓글입력된 해당게시글로 바로이동(redirect로 보내서 따로 값 전달 안하고 페이지 이동)
			path="redirect:getFreeBoard.do?freeseq="+vo.getFreeseq();
		}
		return path;
	}

	//댓글 삭제(void값은 string으로 해서 이동될 주소 return)
	@RequestMapping("/deleteComment.do")
	public String  deleteComment(CommentVO vo) {
		System.out.println("deleteComment");
		//댓글 삭제: mybatis로 매핑된 sql실행(서비스->서비스impl->dao->mapping)
		cservice.deleteComment(vo);
		//댓글삭제된 해당게시글로 바로이동(redirect로 보내서 따로 값 전달 안하고 페이지 이동)
		return "redirect:getFreeBoard.do?freeseq="+vo.getFreeseq();
	}


	//댓글수정 @ResponseBody를 통해 스프링이json으로 변환 /commentUpdate.js에서 ajax로 요청옴
	@RequestMapping("/updateCommentJson.do")
	@ResponseBody
	public int  updateCommentJson(CommentVO vo) {
		System.out.println("updateComment");
		//update문이기 때문에 int로 결과 받고 json은 성공여부만 전달
		int rs =cservice.updateComment(vo);
		return rs;
	}

	//댓글 가져오기 json @ResponseBody를 통해 스프링이json으로 변환/ commentUpdate.js에서 ajax로 요청옴
	@RequestMapping("/getCommentJson.do")
	@ResponseBody
	public CommentVO  getCommentJson(CommentVO vo) {
		System.out.println("getCommentListJson");
		//수정한 게시글 ajax로 요청오면 json으로 값 전달, 이때는 해당 코멘트 정보가 필요하므로 CommentVO로 담고
		CommentVO cvo =cservice.getCommentJson(vo);
		return cvo;
	}
	
	
	//이하죽은코드들
	
	//댓글 가져오기(void값은 string으로 해서 이동될 주소 return)
//	@RequestMapping("/getCommnet.do")
//	public String getCommnet(CommentVO vo, Model model) {
//		System.out.println("getCommnet");
//		//해당 게시글의 해당 댓글 가져오기 mybatis로 매핑된 sql실행(서비스->서비스impl->dao->mapping)
//		CommentVO cvo = cservice.getCommnet(vo);
//		//해당 댓글 수정할때 해당 코멘트 정보가 필요하므로
//		//가져온값을 getCommnet라는 이름으로 cvo를 저장
//		//추후 ajax으로 연결하여json으로 값전달하여 죽은코드 됨 
//		model.addAttribute("getCommnet", cvo);
//		return"updateComment.jsp";
//	}
	
	
	//댓글 수정(void값은 string으로 해서 이동될 주소 return)
//	@RequestMapping("/updateComment.do")
//	public String  updateComment(@ModelAttribute("getCommnet") CommentVO vo) {
//		System.out.println("updateComment");
//		//댓글 수정: mybatis로 매핑된 sql실행(서비스->서비스impl->dao->mapping)
//		//추후 ajax으로 연결하여json으로 값전달하여 죽은코드 됨 
//		cservice.updateComment(vo);
//		return "redirect:getFreeBoard.do?freeseq="+vo.getFreeseq();
//	}
	
	
}
