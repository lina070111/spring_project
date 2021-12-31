package com.spring.project.vo;

public class CommentNewsVO {

	private int coseq;
	private String writer;
	private String content;
	private String regdata;
	private int newsseq;
	
	public CommentNewsVO() {
	}

	public CommentNewsVO(int coseq, String writer, String content, String regdata, int newsseq) {
		super();
		this.coseq = coseq;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.newsseq = newsseq;
	}

	public int getCoseq() {
		return coseq;
	}

	public void setCoseq(int coseq) {
		this.coseq = coseq;
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

	public int getNewsseq() {
		return newsseq;
	}

	public void setNewsseq(int newsseq) {
		this.newsseq = newsseq;
	}

	@Override
	public String toString() {
		return "CommentNewsVO [coseq=" + coseq + ", writer=" + writer + ", content=" + content + ", regdata=" + regdata
				+ ", newsseq=" + newsseq + "]";
	}

	



	

	
}
