package com.micoservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micoservices.Enties.Citizen;
import com.micoservices.repos.CitizenRepo;
import com.micoservices.services.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepo repo; 
	
	@Autowired
	private CitizenService citizenService;
	
	@RequestMapping("/hello")
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hello there!",HttpStatus.OK);
	}
	
	
    @GetMapping("/welcome")
	public ResponseEntity<String> greetings(){
		return new ResponseEntity<String>("welcome folks!",HttpStatus.OK);
	}
    
    

    @GetMapping("/allCitizenByCenter/{id}")
	public ResponseEntity<List<Citizen>> getAllCitizenbyVaccinationCenterHandler(@PathVariable("id") Integer id){
    	
    	List<Citizen> list=repo.findAllCitizenByVaccinationCenterId(id);
		return new ResponseEntity<List<Citizen>>(list,HttpStatus.OK);
	}
    
    
    @PostMapping("/addCitizen")
    public ResponseEntity<Citizen> addCitizenHandler(@RequestBody Citizen citizen){
    	Citizen ci=citizenService.addPeople(citizen);
    	
    	return new ResponseEntity<Citizen>(ci,HttpStatus.CREATED);
    }
    
    

}
