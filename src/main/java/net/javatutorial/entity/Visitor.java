package net.javatutorial.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Visitor {
	private String vmsId;
    private String name;
    private String companyName;
    private String idNo;
    private String mobileNo;
    private String vehicleNo;
    private String hostName;
    private String hostNo;
    private String visitorCardId;
    private String covidDeclare;
    private String visitPurpose;
    private String temperature;
    private Timestamp timeInDt;
    private Timestamp timeOutDt;
    
	public Visitor(String vmsId, String name, String companyName, String idNo, String mobileNo, String vehicleNo,
			String hostName, String hostNo, String visitorCardId, String covidDeclare, String visitPurpose, String temperature,
			Timestamp timeInDt, Timestamp timeOutDt) {
		super();
		this.vmsId = vmsId;
		this.name = name;
		this.companyName = companyName;
		this.idNo = idNo;
		this.mobileNo = mobileNo;
		this.vehicleNo = vehicleNo;
		this.hostName = hostName;
		this.hostNo = hostNo;
		this.visitorCardId = visitorCardId;
		this.covidDeclare = covidDeclare;
		this.visitPurpose= visitPurpose;
		this.setTemperature(temperature);
		this.timeInDt = timeInDt;
		this.timeOutDt = timeOutDt;
	}

	public Visitor(String vmsId, String name, String companyName, String idNo, String mobileNo, String vehicleNo,
			String hostName, String hostNo, String visitorCardId, String covidDeclare, String visitPurpose, String temperature,
			Timestamp timeInDt) {
		super();
		this.vmsId = vmsId;
		this.name = name;
		this.companyName = companyName;
		this.idNo = idNo;
		this.mobileNo = mobileNo;
		this.vehicleNo = vehicleNo;
		this.hostName = hostName;
		this.hostNo = hostNo;
		this.visitorCardId = visitorCardId;
		this.covidDeclare = covidDeclare;
		this.visitPurpose= visitPurpose;
		this.setTemperature(temperature);
		this.timeInDt = timeInDt;
	}

	public String getVmsId() {
		return vmsId;
	}

	public void setVmsId(String vmsId) {
		this.vmsId = vmsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostNo() {
		return hostNo;
	}

	public void setHostNo(String hostNo) {
		this.hostNo = hostNo;
	}

	public String getVisitorCardId() {
		return visitorCardId;
	}

	public void setVisitorCardId(String visitorCardId) {
		this.visitorCardId = visitorCardId;
	}

	public Timestamp getTimeInDt() {
		return timeInDt;
	}

	public void setTimeInDt(Timestamp timeInDt) {
		this.timeInDt = timeInDt;
	}

	public Timestamp getTimeOutDt() {
		return timeOutDt;
	}

	public void setTimeOutDt(Timestamp timeOutDt) {
		this.timeOutDt = timeOutDt;
	}

	public String getCovidDeclare() {
		return covidDeclare;
	}

	public void setCovidDeclare(String covidDeclare) {
		this.covidDeclare = covidDeclare;
	}
	/**
	 * @return the visitPurpose
	 */
	public String getVisitPurpose() {
		return visitPurpose;
	}

	/**
	 * @param visitPurpose the visitPurpose to set
	 */
	public void setVisitPurpose(String visitPurpose) {
		this.visitPurpose = visitPurpose;
	}

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Visitor [vmsId=" + vmsId + ", name=" + name + ", companyName=" + companyName + ", idNo=" + idNo
				+ ", mobileNo=" + mobileNo + ", vehicleNo=" + vehicleNo + ", hostName=" + hostName + ", hostNo="
				+ hostNo + ", visitorCardId=" + visitorCardId + ", covidDeclare=" + covidDeclare + ", visitPurpose="
				+ visitPurpose + ", temperature=" + temperature + ", timeInDt=" + timeInDt + ", timeOutDt=" + timeOutDt
				+ "]";
	}
	
}
