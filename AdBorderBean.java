package com.ubot.application.entity;

/**
 * @author Jenny
 *
 * @Description
 */

public class AdBorderBean {

	String Uuid;
	String Uptime;
	String Downtime;
	String Block;
	String Archives;
	String Title;
	String Link;
	String Memo;
	String Status;
	String Uploadtime;
	String Updatetime;


	public String getArchives() {
		return Archives;
	}

	public void setArchives(String archives) {
		this.Archives = archives;
	}

	public String getUuid() {
		return Uuid;
	}

	public String getUptime() {
		return Uptime;
	}

	public String getDowntime() {
		return Downtime;
	}

	public String getBlock() {
		return Block;
	}

	public String getTitle() {
		return Title;
	}

	public String getLink() {
		return Link;
	}

	public String getMemo() {
		return Memo;
	}

	public String getStatus() {
		return Status;
	}

	public String getUploadtime() {
		return Uploadtime;
	}

	public String getUpdatetime() {
		return Updatetime;
	}

	public String setUuid(String uuid) {
		return this.Uuid = uuid;
	}

	public void setUptime(String uptime) {
		this.Uptime = uptime;
	}

	public void setDowntime(String downtime) {
		this.Downtime = downtime;
	}

	public void setBlock(String block) {
		this.Block = block;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public void setLink(String link) {
		this.Link = link;
	}

	public void setMemo(String memo) {
		this.Memo = memo;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public void setUploadtime(String uploadtime) {
		this.Uploadtime = uploadtime;
	}

	public void setUpdatetime(String updatetime) {
		this.Updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "AdBorderModel [uuid=" + Uuid + ", uptime=" + Uptime + ", downtime=" + Downtime + ", block=" + Block
				+ ", archives=" + Archives + ", title=" + Title + ", link=" + Link + ", memo=" + Memo + ", status="
				+ Status + ", uploadtime=" + Uploadtime + ", updatetime=" + Updatetime + "]";
	}

}
