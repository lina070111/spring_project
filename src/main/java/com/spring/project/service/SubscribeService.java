package com.spring.project.service;

import java.util.List;

import com.spring.project.vo.SubscribeVO;

public interface SubscribeService {

	List<SubscribeVO> getSubscribe(SubscribeVO vo);	//구독정보가져오기
	int insertSubscribe(SubscribeVO vo);	//구독정보 등록

}
