package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.common.Pagination;
import com.spring.project.dao.FreeBoardDAO;
import com.spring.project.vo.FreeBoardVO;

//Service용 Controller지정
@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO dao;

	//페이징위해서 전체 게시글 개수 가져오기
	@Override
	public int getBoardListCnt() {
		return dao.getBoardListCnt();
	}

	//게시글 리스트가져오기(페이징만큼)
	@Override
	public List<FreeBoardVO> getFreeBoardList(Pagination pagination) {
		return dao.getFreeBoardList(pagination);
	}

	//해당게시글 가져오기	
	@Override
	public FreeBoardVO getFreetBoard(FreeBoardVO vo) {
		FreeBoardVO fvo=dao.getFreeBoard(vo);
		return fvo;
	}

	//해당게시글 조회수+1
	@Override
	public int updateCntFreetBoard(FreeBoardVO vo) {
		int rs =dao.updateCntFreeBoard(vo);
		return rs;
	}
	
	//게시글쓰기
	@Override
	public int insertFreetBoard(FreeBoardVO vo) {
		int rs =dao.insertFreeBoard(vo);
		return rs;
	}

	//게시글 수정
	@Override
	public int updateFreetBoard(FreeBoardVO vo) {
		int rs =dao.updateFreeBoard(vo);
		return rs;
	}

	//해당 게시글 삭제
	@Override
	public int deleteFreetBoard(FreeBoardVO vo) {
		int rs= dao.deleteFreeBoard(vo);
		return rs;
	}

	//메인화면에 출력될 게시글 리스트 가져오기
	@Override
	public List<FreeBoardVO> getFreeBoardListIndexJson(FreeBoardVO vo) {
		List<FreeBoardVO> boardList =dao.getFreeBoardListIndexJson(vo);
		return boardList;
	}

}
