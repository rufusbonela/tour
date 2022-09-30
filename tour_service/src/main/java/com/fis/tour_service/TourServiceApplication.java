package com.fis.tour_service;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fis.tour_service.dao.PackageRepository;
import com.fis.tour_service.model.Package;

@SpringBootApplication
public class TourServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TourServiceApplication.class, args);
		
		PackageRepository packageRepository = context.getBean(PackageRepository.class);
		
		Package p = new Package();
		p.setPackage_id("PKG0001");
		p.setSource("DEL");
		p.setDest("MUM");
		p.setBasic_fare(5000);

//		packageRepository.save(p);
		
		Package p1 = new Package();
		p1.setPackage_id("PKG0002");
		p1.setSource("HYD");
		p1.setDest("DEL");
		p1.setBasic_fare(10000);
	
		Package p2 = new Package();
		p2.setPackage_id("PKG0003");
		p2.setSource("BLR");
		p2.setDest("DEL");
		p2.setBasic_fare(7000);
		
		List<Package> l = List.of(p, p1, p2);
		packageRepository.saveAll(l);
		
		System.out.println("ADDED DEMO DATA TO DB SUCCESSFULLY");
	}

}