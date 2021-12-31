package com.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.dao.UserDAO;
import com.spring.project.vo.UserVO;

//Service용 Controller지정
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	//로그인
	@Override
	public UserVO login(UserVO vo) {
		UserVO uvo =dao.getUser(vo);
		return uvo;
	}

	//회원가입	
	@Override
	public int join(UserVO vo) {
		int rs = dao.join(vo);
		return rs;
	}

	//아이디체크
	@Override
	public int idCheck(UserVO vo) {
		System.out.println("service:"+vo);
		int rs =dao.idCheck(vo);
		return rs;
	}

	//회원정보 가져오기
	@Override
	public UserVO userInfo(UserVO vo) {
		UserVO uvo = dao.userInfo(vo);
		return uvo;
	}

	//회원정보 수정
	@Override
	public int updateUser(UserVO vo) {
		int rs =dao.updateUser(vo);
		return rs;
	}

	//회원정보 삭제
	@Override
	public int deleteUser(UserVO vo) {
		int rs =dao.deleteUser(vo);
		return rs;
	}

	//회원 포인트 수정
	@Override
	public int updateUserPoint(UserVO vo) {
		int rs= dao.updateUserPoint(vo);
		return rs;
	}

	//회원 포인트 가져오기
	@Override
	public int getUserPoint(UserVO vo) {
		int rs = dao.getUserPoint(vo);
		return rs;
	}



}
