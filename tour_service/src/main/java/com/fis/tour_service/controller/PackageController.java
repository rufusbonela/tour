package com.fis.tour_service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fis.tour_service.model.Package;
import com.fis.tour_service.service.PackageService;
import com.fis.tour_service.service.PackageServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@RequestMapping(value = "/package", method = RequestMethod.GET)
	public List<Package> getAllPackage() {
		return this.packageService.getAllPackage();
	}
	
	@RequestMapping(value = "/package/{packageId}", method = RequestMethod.GET)
	public Package getPackage(@PathVariable String packageId) {		
		return this.packageService.getPackage(packageId);
	}
	

	@RequestMapping(value = "/package/source/{source}/destination/{destination}/cost/{numOfDays}", method = RequestMethod.GET)
	public ResponseEntity<Double> getPackage(@PathVariable("source") String source, @PathVariable("destination") String destination, @PathVariable("numOfDays") int numOfDays) {		
	  
		PackageServiceImpl serviceImpl = (PackageServiceImpl)  packageService; 
		return new  ResponseEntity<>(serviceImpl.getTotalPackageCostByFilter(source, destination, numOfDays), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/package", method=RequestMethod.POST)
	public Map<Number, String> addPackage(@RequestBody Package newPackage) {
		return this.packageService.addPackage(newPackage);
	}
}
