package net.javatutorial.entity;

import java.util.Date;

public class Employee {
	private String employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private String maritalStatus;
    private Date dob;
    private int age;
    private String nationality;
    private String pob;
    private String identification;
    private String idType;
    private String idNo;
    private String religion;
    private String race;
    private String mobileNo;
    private String email;
    private String emergencyName;
    private String emergencyRlp;
    private String emergencyNo;
    private String employeeStatus;
    private String highestQualification;
    private Date joiningDt;
    private Date probDtFrm;
    private Date probDtTo;
    private String password;
    private String salt;
    
    private Date created_dt;
    private Date last_modified_dt;
    
	public Employee(String employeeId, String firstName, String lastName, String gender, String maritalStatus, Date dob,
			int age, String nationality, String pob, String identification, String idType, String idNo, String religion,
			String race, String mobileNo, String email, String emergencyName, String emergencyRlp, String emergencyNo,
			String employeeStatus, String highestQualification, Date joiningDt, Date probDtFrm, Date probDtTo,
			String password, String salt, Date created_dt, Date last_modified_dt) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.dob = dob;
		this.age = age;
		this.nationality = nationality;
		this.pob = pob;
		this.identification = identification;
		this.idType = idType;
		this.idNo = idNo;
		this.religion = religion;
		this.race = race;
		this.mobileNo = mobileNo;
		this.email = email;
		this.emergencyName = emergencyName;
		this.emergencyRlp = emergencyRlp;
		this.emergencyNo = emergencyNo;
		this.employeeStatus = employeeStatus;
		this.highestQualification = highestQualification;
		this.joiningDt = joiningDt;
		this.probDtFrm = probDtFrm;
		this.probDtTo = probDtTo;
		this.password = password;
		this.salt = salt;
		this.created_dt = created_dt;
		this.last_modified_dt = last_modified_dt;
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the pob
	 */
	public String getPob() {
		return pob;
	}
	/**
	 * @param pob the pob to set
	 */
	public void setPob(String pob) {
		this.pob = pob;
	}
	/**
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}
	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}
	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}
	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}
	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the emergencyName
	 */
	public String getEmergencyName() {
		return emergencyName;
	}
	/**
	 * @param emergencyName the emergencyName to set
	 */
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	/**
	 * @return the emergencyRlp
	 */
	public String getEmergencyRlp() {
		return emergencyRlp;
	}
	/**
	 * @param emergencyRlp the emergencyRlp to set
	 */
	public void setEmergencyRlp(String emergencyRlp) {
		this.emergencyRlp = emergencyRlp;
	}
	/**
	 * @return the emergencyNo
	 */
	public String getEmergencyNo() {
		return emergencyNo;
	}
	/**
	 * @param emergencyNo the emergencyNo to set
	 */
	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}
	/**
	 * @return the employeeStatus
	 */
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	/**
	 * @param employeeStatus the employeeStatus to set
	 */
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	/**
	 * @return the highestQualification
	 */
	public String getHighestQualification() {
		return highestQualification;
	}
	/**
	 * @param highestQualification the highestQualification to set
	 */
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	/**
	 * @return the joiningDt
	 */
	public Date getJoiningDt() {
		return joiningDt;
	}
	/**
	 * @param joiningDt the joiningDt to set
	 */
	public void setJoiningDt(Date joiningDt) {
		this.joiningDt = joiningDt;
	}
	/**
	 * @return the probDtFrm
	 */
	public Date getProbDtFrm() {
		return probDtFrm;
	}
	/**
	 * @param probDtFrm the probDtFrm to set
	 */
	public void setProbDtFrm(Date probDtFrm) {
		this.probDtFrm = probDtFrm;
	}
	/**
	 * @return the probDtTo
	 */
	public Date getProbDtTo() {
		return probDtTo;
	}
	/**
	 * @param probDtTo the probDtTo to set
	 */
	public void setProbDtTo(Date probDtTo) {
		this.probDtTo = probDtTo;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * @return the created_dt
	 */
	public Date getCreated_dt() {
		return created_dt;
	}
	/**
	 * @param created_dt the created_dt to set
	 */
	public void setCreated_dt(Date created_dt) {
		this.created_dt = created_dt;
	}
	/**
	 * @return the last_modified_dt
	 */
	public Date getLast_modified_dt() {
		return last_modified_dt;
	}
	/**
	 * @param last_modified_dt the last_modified_dt to set
	 */
	public void setLast_modified_dt(Date last_modified_dt) {
		this.last_modified_dt = last_modified_dt;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", dob=" + dob + ", age=" + age
				+ ", nationality=" + nationality + ", pob=" + pob + ", identification=" + identification + ", idType="
				+ idType + ", idNo=" + idNo + ", religion=" + religion + ", race=" + race + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", emergencyName=" + emergencyName + ", emergencyRlp=" + emergencyRlp
				+ ", emergencyNo=" + emergencyNo + ", employeeStatus=" + employeeStatus + ", highestQualification="
				+ highestQualification + ", joiningDt=" + joiningDt + ", probDtFrm=" + probDtFrm + ", probDtTo="
				+ probDtTo + ", password=" + password + ", salt=" + salt + ", created_dt=" + created_dt
				+ ", last_modified_dt=" + last_modified_dt + "]";
	}
    
}
