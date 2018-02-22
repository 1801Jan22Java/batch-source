package com.revature.vo;

public class ImgVo {

	public int no;
	public int request_no;
	public String filename;
	
	public ImgVo(int no, int request_no, String filename) {
		super();
		this.no = no;
		this.request_no = request_no;
		this.filename = filename;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRequest_no() {
		return request_no;
	}
	public void setRequest_no(int request_no) {
		this.request_no = request_no;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "ImgVo [no=" + no + ", request_no=" + request_no + ", filename=" + filename + "]";
	} 
}
