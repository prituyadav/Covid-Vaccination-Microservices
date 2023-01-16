package com.micoservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micoservices.entities.VaccineCenter;
import com.micoservices.repos.VaccineCenterRepo;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	@Autowired
	private VaccineCenterRepo vrepo;
    
    @PostMapping("/AddVaccineCenter")
    public ResponseEntity<VaccineCenter> addVaccineCenterHandler(@RequestBody VaccineCenter center){
    	VaccineCenter c=vrepo.save(center);
    	
    	return new ResponseEntity<VaccineCenter>(c,HttpStatus.CREATED);
    }
    

}
