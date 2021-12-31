package com.spring.project.vo;

public class FreeBoardVO {

	private int freeseq;
	private String title;
	private String writer;
	private String content;
	private String regdata;
	private int cnt;
	private String searchSelect;
	private String searchText;
	
	private String id;
	
	public FreeBoardVO() {
	}

	public FreeBoardVO(int freeseq, String title, String writer, String content, String regdata, int cnt) {
		super();
		this.freeseq = freeseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
	}

	
	public FreeBoardVO(int freeseq, String title, String writer, String content, String regdata, int cnt,
			String searchSelect, String searchText) {
		super();
		this.freeseq = freeseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
		this.searchSelect = searchSelect;
		this.searchText = searchText;
	}
	
	

	public FreeBoardVO(int freeseq, String title, String writer, String content, String regdata, int cnt,
			String searchSelect, String searchText, String id) {
		super();
		this.freeseq = freeseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
		this.searchSelect = searchSelect;
		this.searchText = searchText;
		this.id = id;
	}

	public int getFreeseq() {
		return freeseq;
	}

	public void setFreeseq(int freeseq) {
		this.freeseq = freeseq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdata() {
		return regdata;
	}

	public void setRegdata(String regdata) {
		this.regdata = regdata;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	

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
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [freeseq=" + freeseq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdata=" + regdata + ", cnt=" + cnt + ", searchSelect=" + searchSelect + ", searchText="
				+ searchText + ", id=" + id + "]";
	}

	
	
	
	
	
	
}
