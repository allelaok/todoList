package com.nsr.spring.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.Arrays;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String to;
	
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


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}
	
	


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
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
			return false;
		}
		
		boolean result = Arrays.asList(types).contains(type);
		return result;
	}
	
	@Override
	public String toString() {
		return "PageRequestDTO [page=" + page + ", size=" + size + ", link=" + link + ", types="
				+ Arrays.toString(types) + ", keyword=" + keyword + ", finished=" + finished + ", from=" + from
				+ ", to=" + to + "]";
	}

}
