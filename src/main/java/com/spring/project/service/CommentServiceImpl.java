package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.dao.CommentDAO;
import com.spring.project.vo.CommentVO;

//Service용 Controller지정
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO dao;
	
	//댓글 리스트 가져오기
	@Override
	public List<CommentVO> getCommentList(CommentVO vo) {
		List<CommentVO> list =dao.getCommentList(vo);
		return list;
	}

	//댓글 등록
	@Override
	public int insertComment(CommentVO vo) {
		int rs =dao.insertComment(vo);
		return rs;
	}

	//댓글 수정
	@Override
	public int updateComment(CommentVO vo) {
		int rs = dao.updateComment(vo);
		return rs;
	}

	//댓글 삭제
	@Override
	public int deleteComment(CommentVO vo) {
		int rs = dao.deleteComment(vo);
		return rs;
	}

	//게시글의 댓글 모두 삭제	
	@Override
	public int deleteAllComment(CommentVO vo) {
		int rs = dao.deleteALLComment(vo);
		return rs;
	}
	
	//댓글 가져오기
	@Override
	public CommentVO getCommentJson(CommentVO vo) {
		CommentVO cvo =dao.getCommentJson(vo);
		return cvo;
	}

}
