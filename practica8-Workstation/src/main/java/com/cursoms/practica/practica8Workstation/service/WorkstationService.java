package com.cursoms.practica.practica8Workstation.service;

import java.util.List;

import com.cursoms.practica.practica8Workstation.model.Workstation;

public interface WorkstationService {

	Workstation retrieveById(Long id);

	List<Workstation> retrieveAll();

	Workstation register(Workstation workstation);

	Workstation update(Workstation workstation);

	Workstation delete(Workstation workstation);

	List<Workstation> retrieveByVendor(String vendor);

	Workstation retrieveByFacilitiesSerialNumber(String facilitiesSerialNumber);

	Workstation retrieveByEmployeeId(long employeeId);
}
