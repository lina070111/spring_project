package com.spring.project.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.project.service.SubscribeService;
import com.spring.project.service.UserService;
import com.spring.project.vo.SubscribeVO;
import com.spring.project.vo.UserVO;

//스프링에서 컨트롤러 띄우고 @RequestMapping에 맞는 주소를 찾음
//(서블릿에서 .do로 된것은 모두 컨트롤러로 연결되도록 세팅)
@Controller
public class SubscribeController {

	//자동주입 (메서드에서 SubscribeService, UserService를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능) 
	@Autowired
	private SubscribeService subservice;
	@Autowired
	private UserService uservice;
	
	//구독정보 가져오기
	@RequestMapping(value = "/getSubscribe.do")
	@ResponseBody
	public SubscribeVO getSubscribe(SubscribeVO vo) {
		//해당아이디의 구독 정보 가져오기(서비스->서비스impl->dao->mapping)가져와서 페이징 메서드 호출
		List<SubscribeVO> sublist =subservice.getSubscribe(vo);
		System.out.println("svo:"+sublist);
		//구독기간 알기위해 가장 최근에 구독한 정보 2개가 list에 담아져 있는데 그중 최근 구매날짜가 직전에 구매해서 종료날짜찾아서 변수 담음
		String cvo =sublist.get(0).getStart_date();
		String evo =sublist.get(1).getEnd_date();
		//날짜 세팅을 위해서 현재 날짜 구하고 세팅한 값으로 포맷 변경
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, -1);
		String now_dt =sdf.format(cal.getTime());
		System.out.println(now_dt);
		
		//구독정보 담기위해 새로 SubscribeVO생성하고
		SubscribeVO svo= new SubscribeVO();
		
		//해당아이디 구독정보 가져온 값이 있다면
		if(sublist != null) {
			//날짜비교 : 최근날짜가 직전에 구매한 종료날짜보다 작거나 같으면(=아직 구독기간이 남아있다면)
			if(cvo.compareTo(evo)<=0) {
				//구독시작날짜를 직전에 구매한 시작날짜로 세팅하고
				sublist.get(0).setStart_date(sublist.get(1).getStart_date());
				//세팅된값을 새로 생성한 SubscribeVO에 담는다.
				svo = sublist.get(0);
				//세팅된값의 종료날짜도 세팅해야 하는데 값이 디폴트값이거나 현재 날짜보다 작다면
				if(svo.getEnd_date().equals("0000-00-00") || svo.getEnd_date().compareTo(now_dt)<0 ) {
					//종료날짜를 현재날짜로 세팅해서 값을 저장한다.
					svo.setEnd_date(now_dt);
			}
				//최종 json으로 만들어질 SubscribeVO정보 한번 찍어보자
				System.out.println("최종svo"+svo);
			}
		}
		return svo;
	}
	
	//구독정보 등록
	@RequestMapping(value = "/insertSubscribe.do")
	public String insertSubscribe(SubscribeVO vo, UserVO uvo) {
		//결제할 포인트 정보는 UsserVO가 가지고 있으닌까 UserVO 가져오고
		int point= uvo.getPoint();
		//결제금액은 SubscribeVO에서 가져오고
		int payment = vo.getPayment();
		String path="";
		
		//포인트가 결제금액보다 적으면 index.jsp로 보냄(js에서 한번 확인하지만 혹시모르니 한번 더 확인)
		if(point<payment) {
			System.out.println("포인트 부족");
			path="redirect:index.jsp";
		}else {
			//결제가능한 금액이면
			System.out.println("결제진행");
			//포인트에서 결제금액 차감하고 그 값을 UserVO 정보에 셋팅함
			point=point-payment;
			uvo.setPoint(point);
	
			//포인트차감(서비스->서비스impl->dao->mapping)
			uservice.updateUserPoint(uvo);
			//구독정보 등록 (서비스->서비스impl->dao->mapping)
			subservice.insertSubscribe(vo);
			System.out.println(uvo);
			//전달값 없으닌까 redirect로 보내기
			path="redirect:index.jsp";
		}
		return path;
	}
	
}
