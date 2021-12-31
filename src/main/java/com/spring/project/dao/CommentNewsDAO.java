package com.spring.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.vo.CommentNewsVO;

//DAO용 Controller지정
@Repository
public class CommentNewsDAO {

	//mybatis로 sql매핑할거라 자동주입 (메서드에서 SqlSessionTemplate를 생성하지 않아도 @Autowired를 통해 자동주입되어 사용가능)
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//댓글리스트 가져오기newsboardController에서 사용됨
	public List<CommentNewsVO> getCommentListNews(CommentNewsVO vo){
		System.out.println("mybatis-getCommentListNews");		
		List<CommentNewsVO> list= mybatis.selectList("CommentNewsDAO.getCommentList", vo);
		return list;
	}

	//댓글 등록	
	public int insertCommentNews(CommentNewsVO vo) {
		System.out.println("mybatis-insertCommentNews");
		return mybatis.insert("CommentNewsDAO.insertComment", vo);
	}

	//댓글수정
	public int updateCommentNews(CommentNewsVO vo) {
		System.out.println("mybatis-updateCommentNews");
		return mybatis.update("CommentNewsDAO.updateComment", vo);
	}
	
	//댓글 삭제
	public int deleteCommentNews(CommentNewsVO vo) {
		System.out.println("mybatis-deleteCommentNews");
		return mybatis.delete("CommentNewsDAO.deleteComment", vo);
	}
	
	//게시글의 댓글 모두 삭제
	public int deleteALLCommentNews(CommentNewsVO vo) {
		System.out.println("mybatis-deleteALLCommentNews");
		return mybatis.delete("CommentNewsDAO.deleteALLComment", vo);
	}

	//댓글 가져오기
	public CommentNewsVO getCommentJsonNews(CommentNewsVO vo){
		System.out.println("mybatis-getCommentJsonNews");		
		return mybatis.selectOne("CommentNewsDAO.getCommentJson", vo);
	}

}
