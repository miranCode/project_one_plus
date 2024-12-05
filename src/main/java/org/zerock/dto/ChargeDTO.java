package org.zerock.dto;

public class ChargeDTO {
//	Field
	
	private int BPower;					// 요금적용전력
	private int PFactor;				// 지상역률
	private String SVoltage;			// 수전전압
	private int UQuentity;				// 사용량
	private int RDPFactor;				// 잔상역률
	private java.sql.Timestamp UStart;	// 사용시작일
	private java.sql.Timestamp UEnd;	// 사용종료일
	private boolean APaid;				// 납부여부
	
//	Method
	
	public int getBPower() {
		return BPower;
	}
	public void setBPower(int bPower) {
		BPower = bPower;
	}
	public int getPFactor() {
		return PFactor;
	}
	public void setPFactor(int pFactor) {
		PFactor = pFactor;
	}
	public String getSVoltage() {
		return SVoltage;
	}
	public void setSVoltage(String sVoltage) {
		SVoltage = sVoltage;
	}
	public int getUQuentity() {
		return UQuentity;
	}
	public void setUQuentity(int uQuentity) {
		UQuentity = uQuentity;
	}
	public int getRDPFactor() {
		return RDPFactor;
	}
	public void setRDPFactor(int rDPFactor) {
		RDPFactor = rDPFactor;
	}
	public java.sql.Timestamp getUStart() {
		return UStart;
	}
	public void setUStart(java.sql.Timestamp uStart) {
		UStart = uStart;
	}
	public java.sql.Timestamp getUEnd() {
		return UEnd;
	}
	public void setUEnd(java.sql.Timestamp uEnd) {
		UEnd = uEnd;
	}
	public boolean isAPaid() {
		return APaid;
	}
	public void setAPaid(boolean aPaid) {
		APaid = aPaid;
	}
	
	@Override
	public String toString() {
		return "ChargeDTO [BPower=" + BPower + ", PFactor=" + PFactor + ", SVoltage=" + SVoltage + ", UQuentity="
				+ UQuentity + ", RDPFactor=" + RDPFactor + ", UStart=" + UStart + ", UEnd=" + UEnd + ", APaid=" + APaid
				+ "]";
	}
}
