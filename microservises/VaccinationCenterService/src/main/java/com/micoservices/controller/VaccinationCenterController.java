package com.micoservices.controller;

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
import org.springframework.web.client.RestTemplate;

import com.micoservices.entities.VaccineCenter;
import com.micoservices.models.Citizen;
import com.micoservices.models.RequiredData;
import com.micoservices.repos.VaccineCenterRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private VaccineCenterRepo vrepo;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	  @GetMapping("/welcome")
	   	public ResponseEntity<String> greetings(){
	   		return new ResponseEntity<String>("welcome folks! in VaccinationCenter_Services",HttpStatus.OK);
	   	}
	    
    
    @PostMapping("/AddVaccineCenter")
    public ResponseEntity<VaccineCenter> addVaccineCenterHandler(@RequestBody VaccineCenter center){
    	VaccineCenter c=vrepo.save(center);
    	
    	return new ResponseEntity<VaccineCenter>(c,HttpStatus.CREATED);
    }
    
    @GetMapping("/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDownTown")
    public ResponseEntity<RequiredData> getAllDataBaesdonCenterId(@PathVariable Integer id){
    	RequiredData requiredResponse=new RequiredData();
    	//first get vaccination center datails
    	
    	VaccineCenter center= vrepo.findById(id).get();
    	requiredResponse.setCenter(center);
    	
    	//then get all citizen registered to it
    	
      	List<Citizen> listOfCitizen=restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/allCitizenByCenter/"+id, List.class);
    	requiredResponse.setCitizens(listOfCitizen);
      	
    	return new ResponseEntity<RequiredData>(requiredResponse, HttpStatus.OK);
    }

    public ResponseEntity<RequiredData> handleCitizenDownTown(@PathVariable Integer id){
    	RequiredData requiredResponse=new RequiredData();
    	//vaccination center datails
    	
    	VaccineCenter center= vrepo.findById(id).get();
    	requiredResponse.setCenter(center);

    	return new ResponseEntity<RequiredData>(requiredResponse, HttpStatus.OK);
    }
  

}
