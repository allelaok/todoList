package com.nsr.spring.vo;

import java.util.List;

public class pageResponseDTO<E> {
	private int page;
	private int size;
	private int total;
	
	private int start;
	private int end;
	
	private boolean prev;
	private boolean next;
	
	private List<E> dtoList;

	public pageResponseDTO(pageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
		super();
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		this.total = total;
		this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
		this.start = this.end - 9;
		this.prev = this.start > 1;
		this.next = total > this.end * this.size;
		this.dtoList = dtoList;
	}

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public List<E> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<E> dtoList) {
		this.dtoList = dtoList;
	}

	@Override
	public String toString() {
		return "pageResponseDTO [page=" + page + ", size=" + size + ", total=" + total + ", start=" + start + ", end="
				+ end + ", prev=" + prev + ", next=" + next + ", dtoList=" + dtoList + "]";
	}
}
