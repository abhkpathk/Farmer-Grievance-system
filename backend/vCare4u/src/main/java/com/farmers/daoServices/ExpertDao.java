package com.farmers.daoServices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.Entity.Expert;

//import com.farmers.expertEntity.Expert;

public interface ExpertDao extends JpaRepository<Expert,Long>{

}
