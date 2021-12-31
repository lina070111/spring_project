package com.spring.project.service;

import java.util.List;

import com.spring.project.common.PaginationNews;
import com.spring.project.vo.NewsBoardVO;

public interface NewsBoardService {
	
	int getBoardListCnt() ;				//페이징위해서 전체 게시글 개수 가져오기
	List<NewsBoardVO> getnewsBoardList(PaginationNews pagination);	//게시글 리스트가져오기(페이징만큼)
	NewsBoardVO getNewsBoard(NewsBoardVO vo);		//해당게시글 가져오기	
	int updateCntNewsBoard(NewsBoardVO vo);			//해당게시글 조회수+1
	int insertNewsBoard(NewsBoardVO vo);			//게시글쓰기
	int updateNewsBoard(NewsBoardVO vo);			//게시글 수정
	int deleteNewsBoard(NewsBoardVO vo);			//해당 게시글 삭제
	List<NewsBoardVO> getnewsBoardListNewsJson(NewsBoardVO vo);	//메인화면에 출력될 게시글 리스트 가져오기

	
}
