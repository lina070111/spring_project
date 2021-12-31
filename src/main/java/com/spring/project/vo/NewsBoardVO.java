package com.spring.project.vo;

import org.springframework.web.multipart.MultipartFile;

public class NewsBoardVO {

	private int newsseq;
	private String title;
	private String writer;
	private String content;
	private String regdata;
	private int cnt;
	private String searchSelect;
	private String searchText;
	private MultipartFile uploadFile;
	private String filename;
	
	private String id;
	
	
	public NewsBoardVO() {
	}

	public NewsBoardVO(int newsseq, String title, String writer, String content, String regdata, int cnt,
			String searchSelect, String searchText) {
		super();
		this.newsseq = newsseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
		this.searchSelect = searchSelect;
		this.searchText = searchText;
	}

	public NewsBoardVO(int newsseq, String title, String writer, String content, String regdata, int cnt,
			String searchSelect, String searchText, MultipartFile uploadFile, String filename) {
		super();
		this.newsseq = newsseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
		this.searchSelect = searchSelect;
		this.searchText = searchText;
		this.uploadFile = uploadFile;
		this.filename = filename;
	}
	
	

	public NewsBoardVO(int newsseq, String title, String writer, String content, String regdata, int cnt,
			String searchSelect, String searchText, MultipartFile uploadFile, String filename, String id) {
		super();
		this.newsseq = newsseq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.cnt = cnt;
		this.searchSelect = searchSelect;
		this.searchText = searchText;
		this.uploadFile = uploadFile;
		this.filename = filename;
		this.id = id;
	}

	public int getNewsseq() {
		return newsseq;
	}

	public void setNewsseq(int newsseq) {
		this.newsseq = newsseq;
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

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NewsBoardVO [newsseq=" + newsseq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdata=" + regdata + ", cnt=" + cnt + ", searchSelect=" + searchSelect + ", searchText="
				+ searchText + ", uploadFile=" + uploadFile + ", filename=" + filename + ", id=" + id + "]";
	}



	
	
	

	
	
	
	
	
}
