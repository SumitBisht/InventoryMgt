package com.tss.ocean.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Invoice implements Serializable {
	
	private Integer id;
	private Date date;
	private String buyerName;
	private String address;
	private Boolean boxMode;
	private List<Item> items;
	private Float discount;
	private Float tax;
	private Number grossAmount;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getBoxMode() {
		return boxMode;
	}
	public void setBoxMode(Boolean boxMode) {
		this.boxMode = boxMode;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Float getTax() {
		return tax;
	}
	public void setTax(Float tax) {
		this.tax = tax;
	}
	public Number getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Number grossAmount) {
		this.grossAmount = grossAmount;
	}
	
	@Override
	public String toString(){
		String string = "";
		if(this.id!=null)
			string += this.id;
		if(this.date!=null)
			string += this.date.toString();
		if(this.buyerName!=null)
			string += this.buyerName;
		if(this.address!=null)
			string += this.address;
		if(this.boxMode!=null)
			string += boxMode ? "bank collection":"cash collection";
		if(this.items!=null)
			string += items.size()+" items present ";
		if(this.discount!=null)
			string += this.discount;
		if(this.tax!=null)
			string += this.tax;
		if(this.grossAmount!=null)
			string += this.grossAmount;
		return string;
	}

}
