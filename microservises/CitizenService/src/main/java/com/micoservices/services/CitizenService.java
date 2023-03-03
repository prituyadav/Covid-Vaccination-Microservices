package com.micoservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micoservices.Enties.Citizen;
import com.micoservices.repos.CitizenRepo;

@Service
public class CitizenService {
	
	@Autowired
	private CitizenRepo repo;
		
	public Citizen addPeople(Citizen man) {
		Citizen c=repo.save(man);
		return c;
	}

}
