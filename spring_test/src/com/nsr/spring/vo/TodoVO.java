package com.nsr.spring.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("todoVO")
public class TodoVO {
	private Long tno;
	private String title;
	private Date duedate;
	private String writer;
	private boolean finished;
	
	public TodoVO() {
	}
	
	public TodoVO(String title, String writer, boolean finished) {
		this.title = title;
		this.writer = writer;
		this.finished = finished;
	}
	public Long getTno() {
		return tno;
	}
	public void setTno(Long tno) {
		this.tno = tno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	@Override
	public String toString() {
		return "TodoVO [tno=" + tno + ", title=" + title + ", duedate=" + duedate + ", writer=" + writer + ", finished="
				+ finished + "]";
	}
	
}