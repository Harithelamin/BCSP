package com.bcsp.project.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;

public class DimInfo {

    private Integer id;
    private Date createdOn;
    private String createdBy;
    private Date updatedOn;
    private String updatedBy;
    private String dimensionId;
    private String dimensionName;
    private Date dateOfIdea;
    private String personalOrInstitute;   // form:radiobutton - radio button//Personal, Inistitute.
    private String name;
    private String mobileNumber;
    private String email;
    private String country; //Norway, Sweeden, USA.
    private String dimensiondescription;
    //Dimensions
    private int dControl;
    private int dMeaning;
    private int dExposure;
    private int dEncouragement;
    private int dTiming;
    private int dEmpathy;
    private int dObtrusiveness;
    private int dImportance;
    private int dDirection;

    private CommonsMultipartFile fileData;
    private boolean newDim=false;

    public DimInfo(){}

    public DimInfo(Dimensions dimensions) {
        this.id = id;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.updatedOn = updatedOn;
        this.updatedBy = updatedBy;
        this.dimensionId = dimensionId;
        this.dimensionName = dimensionName;
        this.dateOfIdea = dateOfIdea;
        this.personalOrInstitute = personalOrInstitute;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.country = country;
        this.dimensiondescription = dimensiondescription;
        this.dControl = dControl;
        this.dMeaning = dMeaning;
        this.dExposure = dExposure;
        this.dEncouragement = dEncouragement;
        this.dTiming = dTiming;
        this.dEmpathy = dEmpathy;
        this.dObtrusiveness = dObtrusiveness;
        this.dImportance = dImportance;
        this.dDirection = dDirection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(String dimensionId) {
        this.dimensionId = dimensionId;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public Date getDateOfIdea() {
        return dateOfIdea;
    }

    public void setDateOfIdea(Date dateOfIdea) {
        this.dateOfIdea = dateOfIdea;
    }

    public String getPersonalOrInstitute() {
        return personalOrInstitute;
    }

    public void setPersonalOrInstitute(String personalOrInstitute) {
        this.personalOrInstitute = personalOrInstitute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDimensiondescription() {
        return dimensiondescription;
    }

    public void setDimensiondescription(String dimensiondescription) {
        this.dimensiondescription = dimensiondescription;
    }

    public int getdControl() {
        return dControl;
    }

    public void setdControl(int dControl) {
        this.dControl = dControl;
    }

    public int getdMeaning() {
        return dMeaning;
    }

    public void setdMeaning(int dMeaning) {
        this.dMeaning = dMeaning;
    }

    public int getdExposure() {
        return dExposure;
    }

    public void setdExposure(int dExposure) {
        this.dExposure = dExposure;
    }

    public int getdEncouragement() {
        return dEncouragement;
    }

    public void setdEncouragement(int dEncouragement) {
        this.dEncouragement = dEncouragement;
    }

    public int getdTiming() {
        return dTiming;
    }

    public void setdTiming(int dTiming) {
        this.dTiming = dTiming;
    }

    public int getdEmpathy() {
        return dEmpathy;
    }

    public void setdEmpathy(int dEmpathy) {
        this.dEmpathy = dEmpathy;
    }

    public int getdObtrusiveness() {
        return dObtrusiveness;
    }

    public void setdObtrusiveness(int dObtrusiveness) {
        this.dObtrusiveness = dObtrusiveness;
    }

    public int getdImportance() {
        return dImportance;
    }

    public void setdImportance(int dImportance) {
        this.dImportance = dImportance;
    }

    public int getdDirection() {
        return dDirection;
    }

    public void setdDirection(int dDirection) {
        this.dDirection = dDirection;
    }

    public  CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public boolean isNewDim() {
        return newDim;
    }

    public void setNewDim(boolean newDim) {
        this.newDim = newDim;
    }

    @Override
    public String toString() {
        return "DimInfo{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", updatedOn=" + updatedOn +
                ", updatedBy='" + updatedBy + '\'' +
                ", dimensionId='" + dimensionId + '\'' +
                ", dimensionName='" + dimensionName + '\'' +
                ", dateOfIdea=" + dateOfIdea +
                ", personalOrInstitute='" + personalOrInstitute + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", dimensiondescription='" + dimensiondescription + '\'' +
                ", dControl=" + dControl +
                ", dMeaning=" + dMeaning +
                ", dExposure=" + dExposure +
                ", dEncouragement=" + dEncouragement +
                ", dTiming=" + dTiming +
                ", dEmpathy=" + dEmpathy +
                ", dObtrusiveness=" + dObtrusiveness +
                ", dImportance=" + dImportance +
                ", dDirection=" + dDirection +
                ", fileData=" + fileData +
                ", newDim=" + newDim +
                '}';
    }
}
