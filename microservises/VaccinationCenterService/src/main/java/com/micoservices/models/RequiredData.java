package com.micoservices.models;

import java.util.List;

import javax.persistence.Entity;

import com.micoservices.entities.VaccineCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequiredData {

	private VaccineCenter center;
	private List<Citizen> citizens;
	
}
