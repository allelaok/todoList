package com.nsr.spring.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Arrays;

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
	
	private String[] types;
	private String keyword;
	private boolean finished;
	private Date from;
	private Date to;
	
	public PageRequestDTO() {}
	

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


	public String[] getTypes() {
		return types;
	}


	public void setTypes(String[] types) {
		this.types = types;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public boolean isFinished() {
		return finished;
	}


	public void setFinished(boolean finished) {
		this.finished = finished;
	}


	public Date getFrom() {
		return from;
	}


	public void setFrom(Date from) {
		this.from = from;
	}


	public Date getTo() {
		return to;
	}


	public void setTo(Date to) {
		this.to = to;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public int getSkip() {
		return (page - 1) * 10;
	}

	public String getLink() {
		StringBuilder builder = new StringBuilder();
		builder.append("page=" + this.page);
		builder.append("&size="+this.size);
		
		if(finished) {
			builder.append("&finished=on");
		}
		
		if(types != null && types.length > 0) {
			for(int i = 0; i < types.length; i++) {
				builder.append("&types=" + types[i]);
			}
		}
		
		if(keyword != null) {
			try {
				builder.append("&keyword="+URLEncoder.encode(keyword, "UTF-8"));
			}catch(UnsupportedEncodingException e) {
				System.err.println("PageRequestDTO => getLink() => ERROR => " + e.getMessage());
			}
		}
		
		if(from != null) {
			builder.append("&from=" + from.toString());
		}
		
		if(to != null) {
			builder.append("&to=" + to.toString());
		}
		
		return builder.toString();
	}

	public boolean checkType(String type) {
		if(types == null || types.length == 0) {
			
		}
		return Arrays.stream(types).anyMatch(type::equals);
	}
	
	@Override
	public String toString() {
		return "PageRequestDTO [page=" + page + ", size=" + size + ", link=" + link + ", types="
				+ Arrays.toString(types) + ", keyword=" + keyword + ", finished=" + finished + ", from=" + from
				+ ", to=" + to + "]";
	}

}
