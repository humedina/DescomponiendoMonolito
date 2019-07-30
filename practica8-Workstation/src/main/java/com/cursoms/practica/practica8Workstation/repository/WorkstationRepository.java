package com.cursoms.practica.practica8Workstation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoms.practica.practica8Workstation.model.Workstation;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

	List<Workstation> findByVendor(String vendor);

	List<Workstation> findByFacilitiesSerialNumber(String facilitiesSerialNumber);

	Workstation findByEmployeeId(long employeeId);
}
