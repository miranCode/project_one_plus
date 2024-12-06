package org.zerock.dto;

public class ChargeDTO {
//	Field
	private int code;						// 번호
	private String uname;					// 이름
	private String email;					// PHONE NUMBER
	private String phone_num;				// EMAIL
	private int billing_power;				// 요금적용전력
	private int power_factor;				// 지상역률
	private String supply_voltage;			// 수전전압
	private int use_quentity;				// 사용량
	private int rdpower_factor;				// 잔상역률
	private java.sql.Timestamp use_start;	// 사용시작일
	private java.sql.Timestamp use_end;		// 사용종료일
	private String already_paid;			// 납부여부
	private java.sql.Timestamp paid_day;	// 납부일
	private java.sql.Timestamp dill_date;	// 청구일
	private java.sql.Timestamp paid_limit;	// 납부기한
	private String how_to_pay;				// 납부방식
	private int charge;						// 요금
	
//	Method
	public int getCode() {
		return code;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public int getBilling_power() {
		return billing_power;
	}
	public void setBilling_power(int billing_power) {
		this.billing_power = billing_power;
	}
	public int getPower_factor() {
		return power_factor;
	}
	public void setPower_factor(int power_factor) {
		this.power_factor = power_factor;
	}
	public String getSupply_voltage() {
		return supply_voltage;
	}
	public void setSupply_voltage(String supply_voltage) {
		this.supply_voltage = supply_voltage;
	}
	public int getUse_quentity() {
		return use_quentity;
	}
	public void setUse_quentity(int use_quentity) {
		this.use_quentity = use_quentity;
	}
	public int getRdpower_factor() {
		return rdpower_factor;
	}
	public void setRdpower_factor(int rdpower_factor) {
		this.rdpower_factor = rdpower_factor;
	}
	public java.sql.Timestamp getUse_start() {
		return use_start;
	}
	public void setUse_start(java.sql.Timestamp use_start) {
		this.use_start = use_start;
	}
	public java.sql.Timestamp getUse_end() {
		return use_end;
	}
	public void setUse_end(java.sql.Timestamp use_end) {
		this.use_end = use_end;
	}
	public String getAlready_paid() {
		return already_paid;
	}
	public void setAlready_paid(String already_paid) {
		this.already_paid = already_paid;
	}
	public java.sql.Timestamp getPaid_day() {
		return paid_day;
	}
	public void setPaid_day(java.sql.Timestamp paid_day) {
		this.paid_day = paid_day;
	}
	public java.sql.Timestamp getDill_date() {
		return dill_date;
	}
	public void setDill_date(java.sql.Timestamp dill_date) {
		this.dill_date = dill_date;
	}
	public java.sql.Timestamp getPaid_limit() {
		return paid_limit;
	}
	public void setPaid_limit(java.sql.Timestamp paid_limit) {
		this.paid_limit = paid_limit;
	}
	public String getHow_to_pay() {
		return how_to_pay;
	}
	public void setHow_to_pay(String how_to_pay) {
		this.how_to_pay = how_to_pay;
	}
	
	@Override
	public String toString() {
		return "ChargeDTO [code=" + code + ", uname=" + uname + ", email=" + email + ", phone_num=" + phone_num
				+ ", billing_power=" + billing_power + ", power_factor=" + power_factor + ", supply_voltage="
				+ supply_voltage + ", use_quentity=" + use_quentity + ", rdpower_factor=" + rdpower_factor
				+ ", use_start=" + use_start + ", use_end=" + use_end + ", already_paid=" + already_paid + ", paid_day="
				+ paid_day + ", dill_date=" + dill_date + ", paid_limit=" + paid_limit + ", how_to_pay=" + how_to_pay
				+ ", charge=" + charge + "]";
	}
	
}
