package com.mySSH.web.entity;

import java.util.List;

public class Page <T>{
	private int page_code;
	private int total_record;
	private int page_size;
	private String url;
	private List<T>beanList;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageCode() {
		return page_code;
	}
	public void setPageCode(int page_code) {
		this.page_code = page_code;
	}
	public int getTotalPage() {
		int total_page=total_record/page_size;
		return total_record%page_size==0?  total_page: total_page+1;
	}
	public int getTotalRecord() {
		return total_record;
	}
	public void setTotalRecord(int total_record) {
		this.total_record = total_record;
	}
	public int getPageSize() {
		return page_size;
	}
	public void setPageSize(int page_size) {
		this.page_size = page_size;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
