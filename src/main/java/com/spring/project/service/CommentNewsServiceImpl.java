package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.dao.CommentNewsDAO;
import com.spring.project.vo.CommentNewsVO;

//Service용 Controller지정
@Service("commentNewsService")
public class CommentNewsServiceImpl implements CommentNewsService {

	@Autowired
	private CommentNewsDAO dao;
	
	//댓글 리스트 가져오기
	@Override
	public List<CommentNewsVO> getCommentList(CommentNewsVO vo) {
		List<CommentNewsVO> list =dao.getCommentListNews(vo);
		return list;
	}

	//댓글 등록
	@Override
	public int insertComment(CommentNewsVO vo) {
		int rs =dao.insertCommentNews(vo);
		return rs;
	}

	//댓글 수정
	@Override
	public int updateComment(CommentNewsVO vo) {
		int rs = dao.updateCommentNews(vo);
		return rs;
	}

	//댓글 삭제
	@Override
	public int deleteComment(CommentNewsVO vo) {
		int rs = dao.deleteCommentNews(vo);
		return rs;
	}

	//게시글의 댓글 모두 삭제	
	@Override
	public int deleteAllComment(CommentNewsVO vo) {
		int rs = dao.deleteALLCommentNews(vo);
		return rs;
	}
	
	//댓글 가져오기
	@Override
	public CommentNewsVO getCommentJson(CommentNewsVO vo) {
		CommentNewsVO cvo =dao.getCommentJsonNews(vo);
		return cvo;
	}

}
