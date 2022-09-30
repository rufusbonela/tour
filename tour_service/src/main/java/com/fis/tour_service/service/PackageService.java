package com.fis.tour_service.service;

import java.util.List;
import java.util.Map;

import com.fis.tour_service.model.Package;

public interface PackageService {
	
	public List<Package> getAllPackage();
	public Package getPackage(String package_id);
	public Map<Number, String> addPackage(Package p);
}
