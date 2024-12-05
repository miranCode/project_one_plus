package org.zerock.dto;

public class MemberDTO {
	private String id;
	private String password; 
	private String name;
	private String joindate;
	
	// 게터 세터 제작 
	// lombok.Date @Date 을 사용하면 게터&세터&toString를 만들어주지 않아도 된다. 
	// lombok 어노테이션을 사용하면 버그가 많다. 
	// 그게 아니라면 게터&세터&toString를 만든다. 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	// source > G toString()
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", joindate=" + joindate + "]";
	}
}
