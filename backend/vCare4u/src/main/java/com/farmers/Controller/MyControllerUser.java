package com.farmers.Controller;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.farmers.Entity.Expert;
import com.farmers.Entity.LoginDetails;
import com.farmers.Entity.NewGriev;
import com.farmers.Entity.User;
import com.farmers.Entity.sell;
import com.farmers.Services.MyServicesExpert;
import com.farmers.Services.UserServices;
import com.farmers.Services.UserServicesImp;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@CrossOrigin("http://localhost:3000")
@RestController
public class MyControllerUser {
	@Autowired
	private UserServices services;
	
	@Autowired
	private MyServicesExpert expertservice;
	
	
	
	@GetMapping("/users")
	public List<User>getUsers(){
		return services.getUsers();
	}
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		System.out.println(user.getActivated());
		services.addUser(user);
		return user;
	}
	@PostMapping("/expert")
	public Expert addExpert(@RequestBody Expert expert) {
		System.out.println(expert);
		return expertservice.addExpert(expert);
		//return expert;
	}
	
	
	
	@PostMapping("/login/user-login")
	public ResponseEntity<User> userLogin(@RequestBody LoginDetails user){
//		System.out.println(user.getPassword());
		return services.userLogin(user);
	}
	@GetMapping("/email-verification/activating-account/{activationCode}")
	public ResponseEntity<String> activateAccount(@PathVariable String activationCode){
		return services.activateAccount(activationCode);
	}
	@PostMapping("/login/expert-login")
	public ResponseEntity<Expert> expertLogin(@RequestBody LoginDetails expert){
		return services.expertLogin(expert);
	}
	
	@PostMapping("/Newgriev")
	public NewGriev addGriev(@RequestParam("image") MultipartFile file,@RequestParam("expert") String expertString) throws IOException {
		
		ObjectMapper obj = new ObjectMapper();
		NewGriev expert = obj.readValue(expertString, NewGriev.class);
		System.out.println(expert);
		expert.setDate(new Date());
		expert.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		services.addGriev(expert);
		return expert;
	}
	
	@GetMapping("/questionById/{id}")
    public NewGriev findquestionById(@PathVariable BigInteger id) {
        return services.getquestionById(id);
    }
	
//	@GetMapping("/solutionById/{id}")
//    public NewGriev findsolutionById(@PathVariable BigInteger id) {
//        return services.getquestionById(id);
//    }
	
	@PutMapping("/update")
	public NewGriev updateGriev(@RequestParam("image") MultipartFile file,@RequestParam("expert") String expertString) throws IOException {
		System.out.println(expertString);
		ObjectMapper obj = new ObjectMapper();
		NewGriev expert = obj.readValue(expertString, NewGriev.class);
		System.out.println(expert.getAnstextGriev());
		expert.setAnsimage(Base64.getEncoder().encodeToString(file.getBytes()));
		return  services.updateGriev(expert);
	}
	
	@PostMapping("/sell")
	public sell addproduct(@RequestParam("productimage") MultipartFile file,@RequestParam("prod") String sellString) throws IOException {
		
		ObjectMapper obj = new ObjectMapper();
		sell prod = obj.readValue(sellString, sell.class);
		System.out.println(prod);
	
		prod.setProductimage(Base64.getEncoder().encodeToString(file.getBytes()));
		services.addproduct(prod);
		return prod;
	}
	
	@GetMapping("/sellById/{id}")
    public sell getsellById(@PathVariable BigInteger id) {
        return services.getsellById(id);
    }
	
}
