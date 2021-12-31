package com.spring.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.common.Pagination;
import com.spring.project.vo.FreeBoardVO;

//DAO용 Controller지정
@Repository
public class FreeBoardDAO {

	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;

	//페이징위해서 전체 게시글 개수 가져오기
	public int getBoardListCnt() {
		return mybatis.selectOne("FreeBoardDAO.getBoardListCnt");
	}

	//게시글 리스트가져오기(페이징만큼)
	public List<FreeBoardVO> getFreeBoardList(Pagination pagination){
		System.out.println("mybatis-getFreeBoardList()");		
		return mybatis.selectList("FreeBoardDAO.getFreeBoardList", pagination);
	}

	//해당게시글 가져오기	
	public FreeBoardVO getFreeBoard(FreeBoardVO vo) {
		System.out.println("mybatis-getFreeBoard()");		
		return mybatis.selectOne("FreeBoardDAO.getFreeBoard", vo);
	}

	//해당게시글 조회수+1
	public int updateCntFreeBoard(FreeBoardVO vo) {
		System.out.println("mybatis-updateCntFreeBoard()");
		return mybatis.update("FreeBoardDAO.updateCntFreeBoard", vo);
	}


	//게시글쓰기
	public int insertFreeBoard(FreeBoardVO vo) {
		System.out.println("mybatis-insertFreeBoard()");
		return mybatis.insert("FreeBoardDAO.insertFreeBoard", vo);
	}

	//게시글 수정
	public int updateFreeBoard(FreeBoardVO vo) {
		System.out.println("mybatis-updateFreeBoard()");		
		return mybatis.update("FreeBoardDAO.updateFreeBoard", vo);
	}

	//해당 게시글 삭제
	public int deleteFreeBoard(FreeBoardVO vo) {
		System.out.println("mybatis-deleteFreeBoard()");
		return mybatis.delete("FreeBoardDAO.deleteFreeBoard", vo);
	}

	//메인화면에 출력될 게시글 리스트 가져오기
	public List<FreeBoardVO> getFreeBoardListIndexJson(FreeBoardVO vo){
		System.out.println("mybatis-getFreeBoardListIndexJson()");		
		return mybatis.selectList("FreeBoardDAO.getFreeBoardListIndexJson", vo);
	}


}
