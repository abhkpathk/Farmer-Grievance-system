package com.farmers.daoServices;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.Entity.User;
import com.farmers.Entity.sell;


	public interface sellDao extends JpaRepository<sell,BigInteger>{

		

		

}
