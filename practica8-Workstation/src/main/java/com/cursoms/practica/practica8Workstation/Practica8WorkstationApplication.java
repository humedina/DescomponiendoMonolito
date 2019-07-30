package com.cursoms.practica.practica8Workstation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cursoms.practica.practica8Workstation.model.Workstation;
import com.cursoms.practica.practica8Workstation.repository.WorkstationRepository;
import com.cursoms.practica.practica8Workstation.utils.HRUtils;

@SpringBootApplication
public class Practica8WorkstationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practica8WorkstationApplication.class, args);
	}

	private WorkstationRepository workstationRepository;

	public Practica8WorkstationApplication(WorkstationRepository workstationRepository) {
		this.workstationRepository = workstationRepository;
	}

	@Bean
	public CommandLineRunner startup() {

		return (args) -> {
			Workstation workstation = Workstation.builder().vendor("Mac").model("Mac Book Pro 15 Retina")
					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();

			workstationRepository.save(workstation);

			workstation = Workstation.builder().vendor("Mac").model("Mac Book Air 13")
					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();

			workstationRepository.save(workstation);

			workstation = Workstation.builder().vendor("Mac").model("iMac Pro 25 Retina")
					.facilitiesSerialNumber(HRUtils.nextFacilitiesSerialNumber()).build();

			workstationRepository.save(workstation);

		};
	}
}
