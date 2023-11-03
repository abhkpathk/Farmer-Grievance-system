package com.farmers.daoServices;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.Entity.NewGriev;

public interface NewGrievDao extends JpaRepository<NewGriev,BigInteger> {
}
