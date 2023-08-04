package com.kh.notice.model.vo;

import java.util.List;

public class PageData {
	private List<Notice> nList;
	private String pageNavi;
	
	
	public PageData() {};
	
	
	
	public PageData(List<Notice> nList, String pageNave) {
		super();
		this.nList = nList;
		this.pageNavi = pageNave;
	}



	public List<Notice> getnList() {
		return nList;
	}
	public void setnList(List<Notice> nList) {
		this.nList = nList;
	}
	public String getpageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	@Override
	public String toString() {
		return "PageData [nList=" + nList + ", pageNavi=" + pageNavi +"]";
	}
}
