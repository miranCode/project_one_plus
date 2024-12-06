package org.zerock.dto;

import java.util.Date;

public class MemberDTO {
	private String id;
	private String pw; 
	private String email;
	private String phone_num;
	private String uname;
	private Date birth;
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
	public String getEmali() {
		return email;
	}
	public void setEmali(String emali) {
		this.email = emali;
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
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", emali=" + email + ", phone_num=" + phone_num + ", uname="
				+ uname + ", birth=" + birth + ", regidate=" + regidate + "]";
	}

	
}
