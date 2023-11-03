package com.farmers.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.farmers.Entity.Expert;
import com.farmers.Entity.LoginDetails;
import com.farmers.Entity.User;

public interface MyServicesExpert {
	
	public List<Expert>getExpert();

	public Expert addExpert(Expert expert);
	//public ResponseEntity<User> ExpertLogin(ExpertLogin expert);

	//public ResponseEntity<String> activateAccount(String activationCode);

}
