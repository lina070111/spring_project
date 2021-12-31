package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.dao.SubscribeDAO;
import com.spring.project.vo.SubscribeVO;

//Service용 Controller지정
@Service("subscribeService")
public class SubscribeServiceImpl implements SubscribeService {

	@Autowired
	private SubscribeDAO dao;
	
	//구독정보 가져오기
	@Override
	public List<SubscribeVO> getSubscribe(SubscribeVO vo) {
		List<SubscribeVO> subscribe =dao.getSubscribe(vo);
		return subscribe;
	}
	
	//구독정보 등록
	@Override
	public int insertSubscribe(SubscribeVO vo) {
		int rs = dao.insertSubscribe(vo);
		return rs;
	}
	
}
