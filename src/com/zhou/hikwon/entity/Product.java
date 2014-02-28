package com.zhou.hikwon.entity;

import com.zhou.hikwon.activity.R;

/**
 * 产品实体
 * @author jhao
 * @version 1.0
 */
public class Product {
	private int id;
	private String name;
	private String type;
	private String overview;//产品综述
	private String param;//参数
	private String bland;//品牌
	private int categoryId;
	private int photo;
	private double unitPrice;
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPhoto() {
		if (this.id==1)
		   return R.drawable.p1;
		else if (this.id==2)
		   return R.drawable.p2;
		else if (this.id==3)
			   return R.drawable.p3;
		else if (this.id==4)
			   return R.drawable.p4;
		else if (this.id==5)
			   return R.drawable.p5;
		else if (this.id==6)
			   return R.drawable.p6;
		else
		return R.drawable.icon;
		   
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getOverview()
	{
		return overview;
	}

	public void setOverview(String overview)
	{
		this.overview = overview;
	}

	public String getParam()
	{
		return param;
	}

	public void setParam(String param)
	{
		this.param = param;
	}

	public String getBland()
	{
		return bland;
	}

	public void setBland(String bland)
	{
		this.bland = bland;
	}

	/**
	 * @param id
	 * @param name
	 * @param categoryId
	 * @param photo
	 * @param unitPrice
	 * @param note
	 */
	
	
	public Product(){}

	public Product(int id, String name, String type, String overview,
			String param, String bland, int categoryId, int photo,
			double unitPrice, String note)
	{
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.overview = overview;
		this.param = param;
		this.bland = bland;
		this.categoryId = categoryId;
		this.photo = photo;
		this.unitPrice = unitPrice;
		this.note = note;
	}

	@Override
	public String toString()
	{
		return "Product [id=" + id + ", name=" + name + ", type=" + type
				+ ", overview=" + overview + ", param=" + param + ", bland="
				+ bland + ", categoryId=" + categoryId + ", photo=" + photo
				+ ", unitPrice=" + unitPrice + ", note=" + note + "]";
	}
	

}
