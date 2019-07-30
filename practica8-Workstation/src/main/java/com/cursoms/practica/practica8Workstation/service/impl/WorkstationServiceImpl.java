package com.cursoms.practica.practica8Workstation.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoms.practica.practica8Workstation.exceptions.WorkstationNotFoundException;
import com.cursoms.practica.practica8Workstation.model.Workstation;
import com.cursoms.practica.practica8Workstation.repository.WorkstationRepository;
import com.cursoms.practica.practica8Workstation.service.WorkstationService;

@Service
@Transactional
public class WorkstationServiceImpl implements WorkstationService {

	private static final Logger LOG = LoggerFactory.getLogger(WorkstationServiceImpl.class);
	
	@Autowired
	private WorkstationRepository workstationRepository;

	@Override
	public Workstation retrieveById(Long id) {
		return workstationRepository.findById(id)
				.orElseThrow(() -> new WorkstationNotFoundException("Workstation not found"));
	}

	@Override
	public List<Workstation> retrieveAll() {
		return workstationRepository.findAll();
	}

	@Override
	public Workstation register(Workstation workstation) {
		workstation = workstationRepository.save(workstation);
		return workstation;
	}

	@Override
	public Workstation update(Workstation workstation) {
		LOG.info("WS a modificar 2 : {}", workstation);
		return register(workstation);
	}

	@Override
	public Workstation delete(Workstation workstation) {
		workstationRepository.delete(workstation);
		return workstation;
	}

	@Override
	public List<Workstation> retrieveByVendor(String vendor) {
		return workstationRepository.findByVendor(vendor);
	}

	@Override
	public Workstation retrieveByFacilitiesSerialNumber(String facilitiesSerialNumber) {
		List<Workstation> list = workstationRepository.findByFacilitiesSerialNumber(facilitiesSerialNumber);
		for (Workstation workstation : list) {
			if(workstation.getFacilitiesSerialNumber().equalsIgnoreCase(facilitiesSerialNumber))
				return workstation;
		}
		return null;
	}

	@Override
	public Workstation retrieveByEmployeeId(long employeeId) {
		return workstationRepository.findByEmployeeId(employeeId);
	}

}
