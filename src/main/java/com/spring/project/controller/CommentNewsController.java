package com.spring.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.service.CommentNewsService;
import com.spring.project.vo.CommentNewsVO;


//CommentController와 기능 동일, 주석은 CommentController에서 확인
//다른점은 newsboard의 댓글관리
@Controller
public class CommentNewsController {

	@Autowired
	private CommentNewsService cservice;
	
	@RequestMapping("/insertCommentNews.do")
	public String  insertCommentNews(CommentNewsVO vo,  HttpSession session) {
		System.out.println("insertCommentNews");
		String userId= (String)session.getAttribute("userId");
		String path ="";
		if(userId == null || userId.equals("") || userId.equals("null") ) {
			System.out.println("로그인하세요");
			path="login.jsp";
		}else {
			cservice.insertComment(vo);
			path="redirect:getNewsBoard.do?newsseq="+vo.getNewsseq();
		}
		return path;
	}
		
	@RequestMapping("/deleteCommentNews.do")
	public String  deleteCommentNews(CommentNewsVO vo) {
		System.out.println("deleteCommentNews");
		cservice.deleteComment(vo);
		return "redirect:getNewsBoard.do?newsseq="+vo.getNewsseq();
	}
		
	@RequestMapping("/updateCommentNewsJson.do")
	@ResponseBody
	public int  updateCommentJsonNews(@ModelAttribute("getCommnet") CommentNewsVO vo) {
		System.out.println("updateCommentNews");
		int rs =cservice.updateComment(vo);
		return rs;
	}
	
	@RequestMapping("/getCommentNewsJson.do")
	@ResponseBody
	public CommentNewsVO  getCommentJsonNews(CommentNewsVO vo) {
		System.out.println("getCommentListJsonNews");
		CommentNewsVO cvo =cservice.getCommentJson(vo);
		return cvo;
	}
}
