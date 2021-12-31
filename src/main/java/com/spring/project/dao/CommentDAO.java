package com.spring.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.vo.CommentVO;

//DAO용 Controller지정
@Repository
public class CommentDAO {

	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;

	//댓글리스트 가져오기 freeboardController에서 사용됨
	public List<CommentVO> getCommentList(CommentVO vo){
		System.out.println("mybatis-getCommentList");		
		List<CommentVO> list= mybatis.selectList("CommentDAO.getCommentList", vo);
		return list;
	}
	
	//댓글 등록
	public int insertComment(CommentVO vo) {
		System.out.println("mybatis-getCommentList");
		return mybatis.insert("CommentDAO.insertComment", vo);
	}

	//댓글수정
	public int updateComment(CommentVO vo) {
		System.out.println("mybatis-getCommentList");
		return mybatis.update("CommentDAO.updateComment", vo);
	}
	
	//댓글 삭제
	public int deleteComment(CommentVO vo) {
		System.out.println("mybatis-deleteComment");
		return mybatis.delete("CommentDAO.deleteComment", vo);
	}

	//게시글의 댓글 모두 삭제
	public int deleteALLComment(CommentVO vo) {
		System.out.println("mybatis-deleteALLComment");
		return mybatis.delete("CommentDAO.deleteALLComment", vo);
	}

	//댓글 가져오기
	public CommentVO getCommentJson(CommentVO vo){
		System.out.println("mybatis-getCommentJson");		
		return mybatis.selectOne("CommentDAO.getCommentJson", vo);
	}


	//죽은코드
	//	public CommentVO getCommnet(CommentVO vo) {
	//		System.out.println("mybatis-getCommnet()");		
	//		return mybatis.selectOne("CommentDAO.getCommnet", vo);
	//	}
		

}
