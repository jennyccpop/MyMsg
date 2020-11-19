package com.ubot.application.entity;

public class RespCodeBean {
	
	String SvcName;
	String RtnCode;
	String RtnDesc;
	String Time;

	public String getSvcName() {
		return SvcName;
	}
	public String getRtnCode() {
		return RtnCode;
	}
	public String getRtnDesc() {
		return RtnDesc;
	}
	public String getTime() {
		return Time;
	}
	public void setSvcName(String svcName) {
		this.SvcName = svcName;
	}
	public void setRtnCode(String rtnCode) {
		this.RtnCode = rtnCode;
	}
	public void setRtnDesc(String rtnDesc) {
		this.RtnDesc = rtnDesc;
	}
	public void setTime(String time) {
		this.Time = time;
	}
	@Override
	public String toString() {
		return "RespCodeBean [svcName=" + SvcName + ", rtnCode=" + RtnCode + ", rtnDesc=" + RtnDesc + ", time=" + Time
				+ "]";
	}
	
	
}
