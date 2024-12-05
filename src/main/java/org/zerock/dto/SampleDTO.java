package org.zerock.dto;

public class SampleDTO {

	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "SampleDTO [name=" + name + ", age=" + age + "]";
	}
}
