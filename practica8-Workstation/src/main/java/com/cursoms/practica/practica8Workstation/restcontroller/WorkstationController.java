package com.cursoms.practica.practica8Workstation.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoms.practica.practica8Workstation.model.Workstation;
import com.cursoms.practica.practica8Workstation.service.WorkstationService;

import lombok.Setter;

@RestController
@RequestMapping("/v1/workstations")
public class WorkstationController {

	@Autowired
	private @Setter WorkstationService workstationService;

	@GetMapping
	public List<Workstation> getAllWorkstation() {
		return workstationService.retrieveAll();
	}

	@GetMapping("/{workstationId}")
	public Workstation getWorkstation(@PathVariable long workstationId) {
		return workstationService.retrieveById(workstationId);
	}
	
	@GetMapping("/search/findByEmployeeId")
	public Workstation findByEmployeeId(@RequestParam long employeeId) {
		return workstationService.retrieveByEmployeeId(employeeId);
	}
	
	@GetMapping("/search/findByFacilitiesSerialNumber")
	public Workstation findByFacilitiesSerialNumber(@RequestParam String serieNumber) {
		return workstationService.retrieveByFacilitiesSerialNumber(serieNumber);
	}
	
	@PostMapping("/")
	public Workstation postWorkstation(@RequestBody Workstation workStation) {
		return workstationService.register(workStation);
	}
	
	@PutMapping("/")
	public Workstation putWorkstation(@RequestBody Workstation workStation) {
		return workstationService.update(workStation);
	}

}