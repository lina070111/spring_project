package com.spring.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.vo.SubscribeVO;

//DAO용 Controller지정
@Repository
public class SubscribeDAO {
	
	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//구독리스트 2개 가져오기(가장최근결제, 그 직전결제)
	public List<SubscribeVO> getSubscribe(SubscribeVO vo) {
		System.out.println("mybatis-getSubscribe()");
		//구독정보 가져오기
		List<SubscribeVO> list =mybatis.selectList("SubscribeDAO.getSubscribe", vo);
		if(list.size()==1) {
			//사이즈가 1이면(기존에 구독을 한번밖에 안했으면)
			System.out.println("사이즈1");
			//하나더 똑같은것 추가하여 사이즈 2로 만들기
			list.add(list.get(0));
			System.out.println(list);
		}else if(list.size()==0) {
			//사이즈가 0이면(구독을 한번도 안했었으면)
			SubscribeVO uvo = new SubscribeVO();
			//구독정보 2개 (아이디, 시작날짜, 종료날짜) 세팅해서 담기
			uvo.setId(vo.getId());
			uvo.setStart_date("0000-00-00");
			uvo.setEnd_date("0000-00-00");
			list.add(uvo);
			list.add(uvo);
			System.out.println(list);
		}
		return list;
	}
	
	//구독 정보 등록
	public int insertSubscribe(SubscribeVO vo) {
		System.out.println("mybatis-insertSubscribe");
		return mybatis.insert("SubscribeDAO.insertSubscribe", vo);
	}
	
}
