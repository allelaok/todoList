package com.nsr.spring.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.springframework.stereotype.Component;

@Component("pageRequestDTO")
public class PageRequestDTO {
	
	@Min(value = 1)
	@Positive
	private int page = 1;
	
	@Min(value = 10)
	@Max(value = 100)
	@Positive
	private int size = 10;
	
	private String link;
	
	public int getSkip() {
		return (page - 1) * 10;
	}

	public String getLink() {
		if(link == null) {
			StringBuilder builder = new StringBuilder();
			builder.append("page=" + this.page);
			builder.append("&size="+this.size);
			link = builder.toString();
		}
		return link;
	}
	
	public PageRequestDTO() {}
	
//	public pageRequestDTO(@Positive int page, @Positive int size) {
//		super();
//		this.page = page;
//		this.size = size;
//	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "pageRequestDTO [page=" + page + ", size=" + size + "]";
	}

}
