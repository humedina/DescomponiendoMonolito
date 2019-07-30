package com.cursoms.practica.practica8Employee.employee.workstation.restclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.cursoms.practica.practica8Employee.employee.model.Workstation;

import jdk.internal.jline.internal.Log;

@Component
public class WorkstationRestClient {

	private static final Logger LOG = LoggerFactory.getLogger(WorkstationRestClient.class);
	
	private String urlWorkStationsService = "http://localhost:8081/v1/workstations/";

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Metodo para consultar el servicio de consulta de Workstation por ID de
	 * empleado
	 * 
	 * @param employeeId
	 * @return
	 */
	public Optional<Workstation> findByEmployeeId(long employeeId) {
		Workstation returnedWorkstation = null;
		try {
			returnedWorkstation = restTemplate.getForObject(
					urlWorkStationsService + "search/findByEmployeeId?employeeId=" + employeeId,
					Workstation.class);

		} catch (RestClientResponseException ex) {
			LOG.info("Status: {}, StatusCode: {}", ex.getStatusText(), ex.getRawStatusCode());
		}

		return Optional.ofNullable(returnedWorkstation);
	}

	/**
	 * Metodo que consumira el servicio de WorkStation para obtenerla por ID
	 * 
	 * @param workstationId
	 * @return
	 */
	public Workstation findById(long workstationId) {
		Workstation returnedWorkstation = null;

		try {
			LOG.info("ID a buscar: {}, path: {}", workstationId, urlWorkStationsService);
		returnedWorkstation = restTemplate.getForObject(urlWorkStationsService + workstationId,
				Workstation.class);

		} catch (RestClientResponseException ex) {
			LOG.info("{} {}",ex.getStatusText(), ex.getRawStatusCode());
		}

		return /* Optional.ofNullable( */returnedWorkstation/* ) */;
	}
	
	/**
	 * Metodo que buscara una ws por el serial number para saber si existe
	 * @param serialNumber
	 * @return
	 */
	public Workstation findByFacilitiesSerialNumber(String serialNumber){
		try {
			return restTemplate.getForObject(urlWorkStationsService + "search/findByFacilitiesSerialNumber?serieNumber=" + serialNumber, Workstation.class);

			} catch (RestClientResponseException ex) {
				LOG.info("{} {}",ex.getStatusText(), ex.getRawStatusCode());
			}
		return null;

	}

	public Workstation save(Workstation ws) {

		Workstation returnedWorkstation = restTemplate.postForObject(urlWorkStationsService, ws,
				Workstation.class);

		return returnedWorkstation;
	}

	public Workstation update(Workstation ws) {

		LOG.info("WS a modificar : {}", ws);

		restTemplate.put(urlWorkStationsService, ws);
		LOG.info("Se modifico la WS...");
		return findById(ws.getId());
	}

}
