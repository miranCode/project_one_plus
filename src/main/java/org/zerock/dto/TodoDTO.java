package org.zerock.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TodoDTO {

	private String title;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "TodoDTO [title=" + title + ", dueDate=" + dueDate + "]";
	}
	
}
