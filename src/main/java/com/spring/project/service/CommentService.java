package com.spring.project.service;

import java.util.List;

import com.spring.project.vo.CommentVO;

public interface CommentService {

	List<CommentVO> getCommentList(CommentVO vo); //댓글 리스트 가져오기
	int insertComment(CommentVO vo);	//댓글등록
	int updateComment(CommentVO vo);	//댓글 수정
	int deleteComment(CommentVO vo);	//댓글 삭제
	int deleteAllComment(CommentVO vo);	//게시글의 댓글 모두 삭제
	CommentVO getCommentJson(CommentVO vo);	//댓글 가져오기
}
