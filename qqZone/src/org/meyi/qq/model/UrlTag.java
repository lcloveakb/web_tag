package org.meyi.qq.model;

import java.io.Serializable;

public class UrlTag implements Serializable {

	private int id;
	private String url;
	private String urlName;
	private String imgName;
	private int userId;
	private int canDel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCanDel() {
		return canDel;
	}
	public void setCanDel(int canDel) {
		this.canDel = canDel;
	}
	@Override
	public String toString() {
		return "UrlTag [id=" + id + ", url=" + url + ", urlName=" + urlName + ", imgName=" + imgName + ", userId="
				+ userId + ", canDel=" + canDel + "]";
	}
	
	
}
