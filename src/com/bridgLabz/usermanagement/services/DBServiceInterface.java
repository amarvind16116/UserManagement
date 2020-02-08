package com.bridgLabz.usermanagement.services;

import java.sql.PreparedStatement;

public interface DBServiceInterface {
	
	public PreparedStatement fetchGender();
	
	public PreparedStatement fetchAllDetails();
	
	public PreparedStatement fetchTop5Data();
	
	public PreparedStatement fetchDecreasingOrderAge();
	
	public PreparedStatement fetchIncreasingOrderAge();
	
	public PreparedStatement graphMaleData();
	
	public PreparedStatement deleteData();
	
	public PreparedStatement checkEmailPswd();
	
	public PreparedStatement updateData();
	
	public PreparedStatement fetchUserDetail();
}
