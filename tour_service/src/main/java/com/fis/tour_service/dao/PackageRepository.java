package com.fis.tour_service.dao;

import org.springframework.data.repository.CrudRepository;

import com.fis.tour_service.model.Package;

public interface PackageRepository extends CrudRepository<Package, String>{
	
	public Package findBySourceAndDest(String source, String destination);
}
