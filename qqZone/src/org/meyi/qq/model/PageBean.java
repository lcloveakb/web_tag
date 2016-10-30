package org.meyi.qq.model;

import java.util.List;
@SuppressWarnings("all")
public class PageBean {
     private  Integer pageNo;
     private  Integer pageSize;
	 private  List pageList;
     private  Integer countData;
     private  Integer pageCount;
	 public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
	
		this.pageCount = pageCount;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}
	public Integer getCountData() {
		return countData;
	}
	public void setCountData(Integer countData) {
		this.countData = countData;
		
	}
	public PageBean(Integer pageNo, Integer pageSize, List pageList,
			Integer countData) {
		
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageList = pageList;
		this.countData = countData;
		if(countData%pageSize==0){
			this.pageCount = countData/pageSize;
		}else{
			this.pageCount = countData/pageSize+1;
		}
	
	}
	public PageBean() {
		pageNo = 1;
	}
     
     
	
}
