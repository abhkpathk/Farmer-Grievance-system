package com.farmers.Services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.farmers.Entity.Expert;
import com.farmers.Entity.LoginDetails;
import com.farmers.daoServices.ExpertDao;

//import com.farmers.expertDaoServices.ExpertDao;
//import com.farmers.expertEntity.Expert;
////import com.farmers.userEntity.ExpertLogin;
////import com.farmers.expertEntity.Expert;
//import com.farmers.expertEntity.ExpertLogin;

@Service
public class MyServiceImplExpert implements MyServicesExpert {
	@Autowired
	private ExpertDao services;
	public MyServiceImplExpert() {
		 
	}
	public List<Expert> getExpert() {
		// TODO Auto-generated method stub
		return services.findAll();
	}
	
//	public Expert addExpert1(Expert expert) {
//		// TODO Auto-generated method stub
//		return services.save(expert);
//	}
//	
	public ResponseEntity<Expert> expertLogin(LoginDetails expert) {
		String email  = expert.getEmail();
		String pass = expert.getPassword();
		List<Expert>registered_expert = getExpert();
		Iterator<Expert>it = registered_expert.iterator();
		while(it.hasNext()) {
			Expert u = it.next();
			if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(pass)) {
				if(u.isActivated()) {
					return ResponseEntity.of(Optional.of(u));
				}else {
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
				}
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
//	public ResponseEntity<String>activateAccount(String activationCode){
//		List<Expert>list = services.findAll();
//		Iterator<Expert>it = list.iterator();
//		while(it.hasNext()) {
//			Expert u = it.next();
//			if(u.getActivationCode().equals(activationCode)) {
//				u.setActivated(true);
//				services.save(u);
//				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//			}
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
//	}
	
	public Expert addExpert(Expert expert) {
		
		return services.save(expert);
	}
	

}
