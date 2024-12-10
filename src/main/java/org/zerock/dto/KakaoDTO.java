package org.zerock.dto;

import java.util.Date;

public class KakaoDTO {
	
	private String id;
    private String nickname;
    private String email;
    private Date regidate;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	@Override
	public String toString() {
		return "KakaoDTO [id=" + id + ", nickname=" + nickname + ", email=" + email + ", regidate=" + regidate + "]";
	}

}
