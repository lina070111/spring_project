package com.spring.project.vo;

public class CommentVO {

	private int coseq;
	private String writer;
	private String content;
	private String regdata;
	private int freeseq;
	
	public CommentVO() {
	}

	public CommentVO(int coseq, String writer, String content, String regdata, int freeseq) {
		super();
		this.coseq = coseq;
		this.writer = writer;
		this.content = content;
		this.regdata = regdata;
		this.freeseq = freeseq;
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

	public int getFreeseq() {
		return freeseq;
	}

	public void setFreeseq(int freeseq) {
		this.freeseq = freeseq;
	}

	@Override
	public String toString() {
		return "CommentVO [coseq=" + coseq + ", writer=" + writer + ", content=" + content + ", regdata=" + regdata
				+ ", freeseq=" + freeseq + "]";
	}



	

	
}
