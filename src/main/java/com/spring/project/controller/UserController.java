package com.spring.project.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.project.service.UserService;
import com.spring.project.vo.UserVO;

//스프링에서 컨트롤러 띄우고 @RequestMapping에 맞는 주소를 찾음
//(서블릿에서 .do로 된것은 모두 컨트롤러로 연결되도록 세팅)
//@SessionAttributes를 통해 어디선가 getUser가 model에 add되면 해당 getUser이름으로 세션에 저장하고
//필요할때 @ModelAttribute를 통해서 불러서 쓸수 있음
@Controller
@SessionAttributes("getUser")
public class UserController {

	//자동주입 (메서드에서 FreeBoardService, CommentService를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능) 
	@Autowired
	private UserService uservice;

	
	//로그인 기능
	@RequestMapping("/login.do")
	public String login(UserVO vo, HttpSession session, Model model) {
		System.out.println("login");
		String path ="";
		
		//로그인이 안되어 있다면
		if(vo.getId() == null || vo.getId().equals("")) {
			System.out.println("아이디 패스워드 입력바람");
			path="redirect:login.jsp";
		}
		
		//로그인 정보 가져오기(서비스->서비스impl->dao->mapping)
		UserVO cvo = uservice.login(vo);
		
		if(cvo != null) {
			//로그인이 되면 해당 아이디와 이름 세션에 담아놓고 어디서든 가져갈수 있게 하기
			session.setAttribute("userName", cvo.getName());
			session.setAttribute("userId", cvo.getId());
			//회원정보 전체 model에 담아서 위의 컨트롤러 세션에 담아놓기
			model.addAttribute("getUser", cvo);
			System.out.println(cvo);
			path="redirect:index.jsp";
		}else {
			//로그인 실패
			System.out.println("일치하는 login정보 없음");
			path="redirect:login.jsp";
		}
		return path;
	}
	
	//로그아웃
	@RequestMapping("/logout.do")
	public String logout(UserVO vo, HttpSession session) {
		System.out.println("logout");
		//세션초기환
		session.invalidate();	
		return "redirect:index.jsp";
	}
	
	//회원가입
	@RequestMapping("/join.do")
	public String  join(UserVO vo) {
		System.out.println("join");
		//회원추가 (서비스->서비스impl->dao->mapping) 후에 다시 로그인하게 하기
		uservice.join(vo);		
		return "redirect:login.jsp";
	}

	//아이디체크
	@RequestMapping("/loginCheck.do")
	public String loginCheck(HttpSession session, String check, HttpServletResponse response) throws Exception {
		System.out.println("loginCheck");
		String path ="";
		//세션에 저장되어 있는 id값 가져오기(현재로그인된 아이디)
		String userId= (String)session.getAttribute("userId");
		
		//해당아이디의 회원정보 가져오기 (서비스->서비스impl->dao->mapping)
		UserVO vo = new UserVO();
		vo.setId(userId);
		UserVO uvo =uservice.userInfo(vo);
		System.out.println("loginCheck VO :"+uvo);
		System.out.println("userId:"+userId);
		
		
		if(userId == null || userId.equals("") || userId.equals("null") ) {
			//로그인이 안되어 있으면
			System.out.println("로그인하세요");
			path="redirect:login.jsp";
		}else {
			//로그인이 된 상태면
			System.out.println("userID :" + userId);
			//jsp에서 check값 전달받아서
			if(check.equals("freeboard")) {
				//freeboard면 자유게시판 글쓰기 화면으로 이동
				path="insertFreeBoard.jsp";
			}else if(check.equals("newsboard")){
				//newboard면 뉴스게시판 이고
				if(uvo.getGrade().equals("admin")) {
					//가져온 회원정보의 등급이 admim일 경우 뉴스게시판 글쓰기 가능
					path="insertNewsBoard.jsp";
				}else {
					//회원등급이 admin이 아니라면 script로 어드민만 글쓰기 가능문구 창 띄어주기
					PrintWriter out = response.getWriter();					 
					out.println("<script>alert('Only admin can write'); location.href='index.jsp';</script>");					 
					out.flush();
				}
			}else if(check.equals("subscribe")) {
				//subscribe면 구독하기로 이동, 이동될때는 해당 아이디값도 같이 전달
				path="userSubscribe.jsp?id="+userId;
			}
		}		
		return path;
	}
	
	//아이디 중복체크 / join.jsp에서 ajax으로 요청됨
	@RequestMapping("/idcheck.do")
    @ResponseBody
    public int idcheck(UserVO vo) {
		System.out.println("idcheck-json");
        int count = 0;
        //아이디 개수 가져오기, select문 (서비스->서비스impl->dao->mapping)이여서 값 저장
        count= uservice.idCheck(vo);
        System.out.println(count);
 
        return count;
    }
	
	//회원정보 수정
	//회원정보 위의Controller에서 model로 값 전체 가져와서 보내주기
	@RequestMapping(value = "/updateUser.do")
	public String updateUser(@ModelAttribute("getUser") UserVO vo, HttpSession session) {
		//회원정보 수정(서비스->서비스impl->dao->mapping)
		uservice.updateUser(vo);
		//회원정보 수정되면 세션값 초기화, 즉 로그아웃된 상태로 만듬
		session.invalidate();	
		return "redirect:login.jsp";
	}
	
	//회원정보 삭제
	@RequestMapping(value = "/deleteUser.do")
	public String deleteFreeBoard(UserVO vo, HttpSession session) {
		System.out.println("delete id:"+vo.getId());
		//회원정보 삭제(서비스->서비스impl->dao->mapping)
		uservice.deleteUser(vo);
		//회원정보 수정되면 세션값 초기화, 즉 로그아웃된 상태로 만듬
		session.invalidate();	
		return "redirect:login.jsp";
	}
	
	//회원 포인트 수정, 구독할때 포인트 결제되면 SubscribeController에서 요청됨
	@RequestMapping(value = "/updateUserPoint.do")
	public String updateUserPoint(UserVO vo) {
		uservice.updateUserPoint(vo);
		return "redirect:index.jsp";
	}

	//회원 포인트 가져오기, ajsx로 요청오면 json으로 전달
	@RequestMapping("/getUserPoint.do")
    @ResponseBody
    public int getUserPoint(UserVO vo) {
		System.out.println("getUserPoint-json");
        int point = 0;
        //포인트 정보 가져오기(서비스->서비스impl->dao->mapping)
        point= uservice.getUserPoint(vo);
        System.out.println(point); 
        return point;
    }
	
	//회원정보 가져오기, uswerModify.jsp에서 ajax로 요청되면 사용
	@RequestMapping("/userInfo.do")
    @ResponseBody
    public UserVO userInfo(UserVO vo) {
		System.out.println("userInfo-json");
		//회원정보가져오기(서비스->서비스impl->dao->mapping)
		UserVO uvo = uservice.userInfo(vo);
        return uvo;
    }
	
	//죽은코드
//	@RequestMapping("/getUserList.do")
//	public String  getUserList(UserVO vo) {
//		System.out.println("getUserList");
//		uservice.getUserList(vo);
//		return "redirect:index.jsp";
//	}

}
