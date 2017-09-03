package com.yiren.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GoodsInfo")
public class GoodsInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
@Column
private Long id;
	@Column
private String name;
	@Column
private Long styleid;
	@Column
private Long zoneid;
	@Column
private String pictureurl;
	@Column
private String description;
	@Column
private Double price;
	@Column
private String time;
	@Column
private Integer state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getStyleid() {
		return styleid;
	}
	public void setStyleid(Long styleid) {
		this.styleid = styleid;
	}
	public Long getZoneid() {
		return zoneid;
	}
	public void setZoneid(Long zoneid) {
		this.zoneid = zoneid;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
			

}
