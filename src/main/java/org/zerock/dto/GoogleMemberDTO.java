package org.zerock.dto;

//push
public class GoogleMemberDTO {
	private String id;
	private String uname;
	private String email;
	
	public GoogleMemberDTO() {
		
	}
	
	public GoogleMemberDTO(String id, String uname, String email) {
		this.id = id;
		this.uname = uname;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return uname;
	}

	public void setName(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
