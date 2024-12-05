package org.zerock.dto;

public class ChargeDTO {
//	Field
	
	private int BPower;					// �����������
	private int PFactor;				// ���󿪷�
	private String SVoltage;			// ��������
	private int UQuentity;				// ��뷮
	private int RDPFactor;				// �ܻ󿪷�
	private java.sql.Timestamp UStart;	// ��������
	private java.sql.Timestamp UEnd;	// ���������
	private boolean APaid;				// ���ο���
	
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
