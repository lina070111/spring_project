package com.spring.project.service;

import com.spring.project.vo.UserVO;

public interface UserService {

	UserVO login(UserVO vo);		//로그인
	int join(UserVO vo);			//회원가입	
	int idCheck(UserVO vo );		//아이디체크
	UserVO userInfo(UserVO vo);		//회원정보 가져오기
	int updateUser(UserVO vo);		//회원정보 수정
	int deleteUser(UserVO vo);		//회원정보 삭제
	int updateUserPoint(UserVO vo);	//회원 포인트 수정
	int getUserPoint(UserVO vo );	//회원 포인트 가져오기
}
