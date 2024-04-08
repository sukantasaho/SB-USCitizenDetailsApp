package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.model.CitizenDetails;

public interface ICitizenDetailsRepo extends JpaRepository<CitizenDetails, Long> 
{
    
}
