package com.micoservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micoservices.entities.VaccineCenter;

public interface VaccineCenterRepo extends JpaRepository<VaccineCenter, Integer>{

}
