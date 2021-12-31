package com.spring.project.service;

import java.util.List;

import com.spring.project.vo.CommentNewsVO;

public interface CommentNewsService {

	List<CommentNewsVO> getCommentList(CommentNewsVO vo);	//댓글 리스트 가져오기
	int insertComment(CommentNewsVO vo);	//댓글등록
	int updateComment(CommentNewsVO vo);	//댓글 수정
	int deleteComment(CommentNewsVO vo);	//댓글 삭제
	int deleteAllComment(CommentNewsVO vo);	//게시글의 댓글 모두 삭제
	CommentNewsVO getCommentJson(CommentNewsVO vo);	//댓글 가져오기
}
