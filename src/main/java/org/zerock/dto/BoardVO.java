package org.zerock.dto;

import java.util.Date;

public class BoardVO {
	private Long idx;
	private String title;
	private String content;
	private String name;
	private String ofile;
	private String sfile;
	private String email;
	private String pass;
	private int visitcount;
	private Date postdate;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	@Override
	public String toString() {
		return "BoardVO [idx=" + idx + ", title=" + title + ", content=" + content + ", name=" + name + ", ofile="
				+ ofile + ", sfile=" + sfile + ", email=" + email + ", pass=" + pass + ", visitcount=" + visitcount
				+ ", postdate=" + postdate + "]";
	}
	
}
