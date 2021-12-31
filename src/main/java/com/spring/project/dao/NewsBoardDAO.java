package com.spring.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.common.PaginationNews;
import com.spring.project.vo.NewsBoardVO;

//DAO용 Controller지정
@Repository
public class NewsBoardDAO {

	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;

	//페이징위해서 전체 게시글 개수 가져오기
	public int getBoardListCnt() {
		return mybatis.selectOne("NewsBoardDAO.getBoardListCnt");
	}

	//게시글 리스트가져오기(페이징만큼)
	public List<NewsBoardVO> getnewsBoardList(PaginationNews pagination){
		System.out.println("mybatis-getnewsBoardList()");		
		return mybatis.selectList("NewsBoardDAO.getnewsBoardList", pagination);
	}

	//해당게시글 가져오기	
	public NewsBoardVO getNewsBoard(NewsBoardVO vo) {
		System.out.println("mybatis-getNewsBoard()");		
		return mybatis.selectOne("NewsBoardDAO.getNewsBoard", vo);
	}

	//해당게시글 조회수+1
	public int updateCntNewsBoard(NewsBoardVO vo) {
		System.out.println("mybatis-updateCntNewsBoard()");
		return mybatis.update("NewsBoardDAO.updateCntNewsBoard", vo);
	}
	
	//게시글쓰기
	public int insertNewsBoard(NewsBoardVO vo) {
		System.out.println("mybatis-insertNewsBoard()");
		return mybatis.insert("NewsBoardDAO.insertNewsBoard", vo);
	}

	//게시글 수정
	public int updateNewsBoard(NewsBoardVO vo) {
		System.out.println("mybatis-updateNewsBoard()");		
		return mybatis.update("NewsBoardDAO.updateNewsBoard", vo);
	}

	//해당 게시글 삭제
	public int deleteNewsBoard(NewsBoardVO vo) {
		System.out.println("mybatis-deleteNewsBoard()");
		return mybatis.delete("NewsBoardDAO.deleteNewsBoard", vo);
	}

	//메인화면에 출력될 게시글 리스트 가져오기
	public List<NewsBoardVO> getnewsBoardListNewsJson(NewsBoardVO vo){
		System.out.println("mybatis-getnewsBoardListNewsJson()");		
		return mybatis.selectList("NewsBoardDAO.getnewsBoardListNewsJson", vo);
	}

}
