package com.tss.ocean.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Invoice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String date;
	private String buyerName;
	private String address;
	private Boolean boxMode;
	private BigDecimal discount;
	private BigDecimal tax;
	private Number grossAmount;
	private Integer item_id;
	private Integer quantity;
	private String mealType;
	public Invoice(){
	}

	public Invoice(Integer id, String date, String buyerName, String address, Boolean boxMode, BigDecimal discount, BigDecimal tax, Number grossAmount, Integer item_id, Integer quantity){
		try {
			this.id = id;
			this.date = date;
			this.buyerName = buyerName;
			this.address = address;
			this.boxMode = boxMode;
			this.discount = discount;
			this.tax = tax;
			this.grossAmount = grossAmount;
			this.item_id = item_id;
			this.quantity = quantity;
		} catch (Exception e) {
			System.out.println("Exception in initializing an invoice: "+e.getMessage());
		}
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public Number getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Number grossAmount) {
		this.grossAmount = grossAmount;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
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
		if(this.discount!=null)
			string += this.discount;
		if(this.tax!=null)
			string += this.tax;
		if(this.grossAmount!=null)
			string += this.grossAmount;
		if(this.item_id!=null)
			string += this.item_id;
		if(this.quantity!=null)
			string += this.quantity;
		if(this.mealType!=null)
			string += this.mealType;
		return string;
	}

}
