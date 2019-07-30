package com.cursoms.practica.practica8Employee.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workstation {

	private long id;

	private String vendor;

	private String model;

	private String facilitiesSerialNumber;
	
	@JsonIgnore
	private Long employeeId;
}
