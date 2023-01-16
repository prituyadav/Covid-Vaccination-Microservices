package com.micoservices.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micoservices.Enties.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

	public List<Citizen> findAllCitizenByVaccinationCenterId(Integer id);
	
}
