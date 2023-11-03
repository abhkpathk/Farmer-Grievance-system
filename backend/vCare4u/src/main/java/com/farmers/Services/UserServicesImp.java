 package com.farmers.Services;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.farmers.Entity.Expert;
import com.farmers.Entity.LoginDetails;
import com.farmers.Entity.NewGriev;
import com.farmers.Entity.User;
import com.farmers.Entity.sell;
import com.farmers.daoServices.ExpertDao;
import com.farmers.daoServices.NewGrievDao;
import com.farmers.daoServices.UserDao;
import com.farmers.daoServices.sellDao;
@Service
public class UserServicesImp implements UserServices {
	@Autowired
	private UserDao services;
	@Autowired
	private ExpertDao expertServices;
	
	@Autowired
	private NewGrievDao grievance;
	
	@Autowired
	private sellDao product;
	
	public UserServicesImp(){
	}
	public List<User>getUsers(){
		return services.findAll();
	}
	public User addUser(User user){
		System.out.println(user.getActivated());
		return services.save(user);
	}
	
	public NewGriev addGriev(NewGriev griev) {
		// TODO Auto-generated method stub
			   System.out.println(griev); 
		return grievance.save(griev);
		
		
	}

	
	
	public ResponseEntity<User> userLogin(LoginDetails user) {
		String email  = user.getEmail();
		String pass = user.getPassword();
		List<User>registered_expert = getUsers();
		Iterator<User>it = registered_expert.iterator();
		while(it.hasNext()) {
			User u = it.next();
			if(u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(pass)) {
				if(u.getActivated()) {
					return ResponseEntity.of(Optional.of(u));
				}else {
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
				}
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	public ResponseEntity<String>activateAccount(String activationCode){
		List<User>list = services.findAll();
		Iterator<User>it = list.iterator();
		while(it.hasNext()) {
			User u = it.next();
			if(u.getActivationCode().equals(activationCode)) {
				u.setActivated(true);
				services.save(u);
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}
		}
		List<Expert>list1 = expertServices.findAll();
		Iterator<Expert>it1 = list1.iterator();
		while(it1.hasNext()) {
			Expert u = it1.next();
			if(u.getActivationCode().equals(activationCode)) {
				u.setActivated(true);
				expertServices.save(u);
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}
	
	public User addExpert(User user) {
		
		return services.save(user);
	}
	
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
	private List<Expert> getExpert() {
		
		return expertServices.findAll();
	}
	
	public NewGriev addgriev(NewGriev griev) {
		// TODO Auto-generated method stub
			    
		return grievance.save(griev);
		
		
	}
	@Override
	public NewGriev getquestionById(BigInteger griev_id) {
		// TODO Auto-generated method stub
		return grievance.findById(griev_id).orElse(null);
	}
//	@Override
//	public void updateGriev(NewGriev expert) {
//		NewGriev existingEmployee = services.findById(expert.GrievId()).orElse(null);
//	        existingEmployee.setTextGriev(expert.getTextGriev());
//	        existingEmployee.setGrievType(expert.getGrievType());
//	        existingEmployee.setSalary(expert.getSalary());
//	        return services.save(existingEmployee);
//	    }
//		
	@Override
	public NewGriev updateGriev(NewGriev expert) {
		System.out.println(expert.getAnstextGriev());
		BigInteger id = expert.getGrievId();
		NewGriev answer  = grievance.findById(id).orElse(null);
		answer.setAnsimage(expert.getAnsimage());
		answer.setAnstextGriev(expert.getAnstextGriev());
		answer.setAnsdate(new Date());
		return grievance.save(answer);
	}
	@Override
	public NewGriev getsolutionById(BigInteger griev_id) {
		// TODO Auto-generated method stub
		return grievance.findById(griev_id).orElse(null);
	}
	@Override
	public sell addproduct(sell sellprod) {
		// TODO Auto-generated method stub
		return product.save(sellprod);
	}
	@Override
	public sell getsellById(BigInteger id) {
		// TODO Auto-generated method stub
		return product.findById(id).orElse(null);
	}
	
	
	

	
	
}

