package org.zerock.dto;

public class MemberDTO {
	private String id;
	private String password; 
	private String name;
	private String joindate;
	
	// ���� ���� ���� 
	// lombok.Date @Date �� ����ϸ� ����&����&toString�� ��������� �ʾƵ� �ȴ�. 
	// lombok ������̼��� ����ϸ� ���װ� ����. 
	// �װ� �ƴ϶�� ����&����&toString�� �����. 
	
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
