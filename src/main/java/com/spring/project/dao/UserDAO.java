package com.spring.project.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.vo.UserVO;

//DAO용 Controller지정
@Repository
public class UserDAO {

	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//로그인
	public UserVO getUser(UserVO vo) {
		System.out.println("mybatis - getUser()");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	
	//회원가입	
	public int join(UserVO vo) {
		System.out.println("mybatis - getUserList()");
		return mybatis.insert("UserDAO.join", vo);
	}

	//아이디체크
	public int idCheck(UserVO vo) {
		System.out.println("mybatis - idCheck()");
		int rs = mybatis.selectOne("UserDAO.idCheck", vo);
		System.out.println("rs:" +rs);
		return rs;
	}
	
	//회원정보 가져오기
	public UserVO userInfo(UserVO vo) {
		System.out.println("mybatis - userInfo()");
		return (UserVO) mybatis.selectOne("UserDAO.userInfo", vo);
	}

	//회원정보 수정
	public int updateUser(UserVO vo) {
		System.out.println("mybatis-updateUser()");		
		return mybatis.update("UserDAO.updateUser", vo);
	}
	
	//회원정보 삭제
	public int deleteUser(UserVO vo) {
		System.out.println("mybatis-deleteFreeBoard()");
		return mybatis.delete("UserDAO.deleteUser", vo);
	}

	//회원 포인트 수정
	public int updateUserPoint(UserVO vo) {
		System.out.println("mybatis - updateUserPoint()");
		return mybatis.update("UserDAO.updateUserPoint", vo);
	}

	//회원 포인트 가져오기
	public int getUserPoint(UserVO vo) {
		System.out.println("mybatis - getUserPoint()");
		int rs = mybatis.selectOne("UserDAO.getUserPoint", vo);
		System.out.println("rs:" +rs);
		return rs;
	}
	
	
}
