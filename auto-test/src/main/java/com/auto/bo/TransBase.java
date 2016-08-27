package com.auto.bo;

public class TransBase {
	private long orderNo;
	private Integer carNo;
	private long ownerPhone;
	private long renterPhone;
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getCarNo() {
		return carNo;
	}
	public void setCarNo(Integer carNo) {
		this.carNo = carNo;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public long getRenterPhone() {
		return renterPhone;
	}
	public void setRenterPhone(long renterPhone) {
		this.renterPhone = renterPhone;
	}
}
