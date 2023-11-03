package com.farmers.Services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.farmers.Entity.Expert;
import com.farmers.Entity.LoginDetails;
import com.farmers.Entity.NewGriev;
import com.farmers.Entity.User;
import com.farmers.Entity.sell;

public interface UserServices {
	public List<User>getUsers();
	public User addUser(User user);
	//public Expert addExpert(Expert Expert);
	public NewGriev addGriev(NewGriev griev);
	public ResponseEntity<User> userLogin(LoginDetails user);
	//public ResponseEntity<Expert> expertLogin(LoginDetails expert);
	public ResponseEntity<String>activateAccount(String activationCode);
	public ResponseEntity<Expert> expertLogin(LoginDetails expert);
	public NewGriev getquestionById(BigInteger griev_id);
	
	public NewGriev getsolutionById(BigInteger griev_id);
	//public void updateGriev(NewGriev expert);
	//public NewGriev updateGriev(NewGriev expert);

	public NewGriev updateGriev(NewGriev expert);
	
	public sell addproduct(sell sellprod);
	public sell getsellById(BigInteger id);
	//public sell getsellById(Long id);
	
	
	
}
