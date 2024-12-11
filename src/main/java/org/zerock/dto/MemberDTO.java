package org.zerock.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	private String id;
	private String pw; 
	private String email;
	private String phone_num;
	private String uname;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birth;
	private String ag_privercy;
	private String ag_sevise;
	private String kind;
	private int level;
	private Date regidate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAg_privercy() {
		return ag_privercy;
	}
	public void setAg_privercy(String ag_privercy) {
		this.ag_privercy = ag_privercy;
	}
	public String getAg_sevise() {
		return ag_sevise;
	}
	public void setAg_sevise(String ag_sevise) {
		this.ag_sevise = ag_sevise;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", email=" + email + ", phone_num=" + phone_num + ", uname="
				+ uname + ", birth=" + birth + ", ag_privercy=" + ag_privercy + ", ag_sevise=" + ag_sevise + ", kind="
				+ kind + ", level=" + level + ", regidate=" + regidate + "]";
	}
	
}
