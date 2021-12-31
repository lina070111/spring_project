package com.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.common.PaginationNews;
import com.spring.project.dao.NewsBoardDAO;
import com.spring.project.vo.NewsBoardVO;

//Service용 Controller지정
@Service("newsboardService")
public class NewsBoardServiceImpl implements NewsBoardService {

	@Autowired
	private NewsBoardDAO dao;

	//페이징위해서 전체 게시글 개수 가져오기
	@Override
	public int getBoardListCnt() {
		return dao.getBoardListCnt();
	}

	//게시글 리스트가져오기(페이징만큼)
	@Override
	public List<NewsBoardVO> getnewsBoardList(PaginationNews pagination) {
		return dao.getnewsBoardList(pagination);
	}

	//해당게시글 가져오기	
	@Override
	public NewsBoardVO getNewsBoard(NewsBoardVO vo) {
		NewsBoardVO fvo=dao.getNewsBoard(vo);
		return fvo;
	}

	//해당게시글 조회수+1
	@Override
	public int updateCntNewsBoard(NewsBoardVO vo) {
		int rs =dao.updateCntNewsBoard(vo);
		return rs;
	}

	//게시글쓰기
	@Override
	public int insertNewsBoard(NewsBoardVO vo) {
		int rs =dao.insertNewsBoard(vo);
		return rs;
	}

	//게시글 수정
	@Override
	public int updateNewsBoard(NewsBoardVO vo) {
		int rs =dao.updateNewsBoard(vo);
		return rs;
	}

	//해당 게시글 삭제
	@Override
	public int deleteNewsBoard(NewsBoardVO vo) {
		int rs= dao.deleteNewsBoard(vo);
		return rs;
	}

	//메인화면에 출력될 게시글 리스트 가져오기
	@Override
	public List<NewsBoardVO> getnewsBoardListNewsJson(NewsBoardVO vo) {
		List<NewsBoardVO> boardList =dao.getnewsBoardListNewsJson(vo);
		return boardList;
	}


}
