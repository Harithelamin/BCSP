package com.bcsp.project.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{

	ADMIN("ADMIN"),	DIMENSIONSADMIN("SUPERVISOR");

	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
