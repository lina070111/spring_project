package com.spring.project.service;

import java.util.List;

import com.spring.project.common.Pagination;
import com.spring.project.vo.FreeBoardVO;

public interface FreeBoardService {
	
	int getBoardListCnt() ;			//페이징위해서 전체 게시글 개수 가져오기
	List<FreeBoardVO> getFreeBoardList(Pagination pagination);	//게시글 리스트가져오기(페이징만큼)
	FreeBoardVO getFreetBoard(FreeBoardVO vo); 	//해당게시글 가져오기	
	int updateCntFreetBoard(FreeBoardVO vo);	//해당게시글 조회수+1
	int insertFreetBoard(FreeBoardVO vo);	//게시글쓰기
	int updateFreetBoard(FreeBoardVO vo);	//게시글 수정
	int deleteFreetBoard(FreeBoardVO vo);	//해당 게시글 삭제
	List<FreeBoardVO> getFreeBoardListIndexJson(FreeBoardVO vo);	//메인화면에 출력될 게시글 리스트 가져오기
	
}
