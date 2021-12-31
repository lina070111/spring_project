package com.spring.project.common;


public class Pagination {
	
	//freeboard 페이징 클래스
	private int listSize = 10;                //초기값으로 목록개수를 10으로 셋팅
	private int rangeSize = 10;            //초기값으로 페이지범위를 10으로 셋팅
	private int page;		//현재페이지
	private int range;		//현재 페이지 범위
	private int listCnt;	//한 페이지당 보여질 리스트의 개수
	private int pageCnt;	//총 게시풀의 개수
	private int startPage;	// 각페이지 범위 시작 번호
	private int startList;
	private int endPage;	// 각 페이지 범위 끝 번호
	private boolean prev;	// 이전 페이지 여부
	private boolean next;	// 다음 페이지 여부
	
	private String searchSelect;
	private String searchText;
	

	public String getSearchSelect() {
		return searchSelect;
	}

	public void setSearchSelect(String searchSelect) {
		this.searchSelect = searchSelect;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		System.out.println("getter:"+endPage);
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}


	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}


	public int getStartList() {
		return startList;
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;

		System.out.println("listSize:"+listSize);
		//전체 페이지수 
		this.pageCnt = (int)Math.ceil((double)listCnt/listSize);		
		System.out.println("pageCnt: "+ pageCnt);
		
		//시작 페이지
		this.startPage = (range - 1) * rangeSize + 1 ;		
		System.out.println("startPage: "+ startPage);
		
		//끝 페이지
		this.endPage = range * rangeSize;				
		System.out.println("endPage: "+ endPage);
		
		//게시판 시작번호
		this.startList = (page - 1) * listSize;		
		System.out.println("startList: "+ startList);
		
		//이전 버튼 상태
		this.prev = range == 1 ? false : true;

		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
		}

	
}
