package com.ubot.application.entity;

public class AnnoucementBean {
	String Uuid;
	String Title;
	String Content;
	String Top;
	String Cdate;
	public String getUuid() {
		return Uuid;
	}
	public String getTitle() {
		return Title;
	}
	public String getContent() {
		return Content;
	}
	public String getTop() {
		return Top;
	}
	public String getCdate() {
		return Cdate;
	}
	public void setUuid(String uuid) {
		this.Uuid = uuid;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public void setTop(String top) {
		this.Top = top;
	}
	public void setCdate(String cdate) {
		this.Cdate = cdate;
	}
	@Override
	public String toString() {
		return "AnnoucementModel [uuid=" + Uuid + ", title=" + Title + ", content=" + Content + ", top=" + Top
				+ ", cdate=" + Cdate + "]";
	}
	
	
}
