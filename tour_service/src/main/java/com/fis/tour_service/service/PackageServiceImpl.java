package com.fis.tour_service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.tour_service.dao.PackageRepository;
import com.fis.tour_service.model.Package;

@Service
public class PackageServiceImpl implements PackageService{
	
	//fake list
	@Autowired
	PackageRepository packageRepository;
	@Override
	public List<Package> getAllPackage(){
		return (List<Package>) packageRepository.findAll();
	}
	
	@Override
	public Package getPackage(String package_id) {
		Package pkg = null;
		Optional<Package> optional = packageRepository.findById(package_id);
		if(optional.isPresent()) {
			pkg = optional.get();
		}
		return pkg;
	}
	
	@Override
	public Map<Number, String> addPackage(Package p) {
		packageRepository.save(p);
		HashMap<Number, String> mp = new HashMap<>();
		mp.put(200, "Successfully added " + p.getPackage_id());
		return mp;
	}
	
	public Double getTotalPackageCostByFilter(String source, String destination, int numDays) {

        // taking the first one
        Package tourPackage = packageRepository.findBySourceAndDest(source, destination);
        return getTotalCostForTourPackage(numDays, tourPackage);
    }
	
	private Double getTotalCostForTourPackage(int numberOfDays, Package tourPackage) {

       

        int discount = getDiscount(numberOfDays);

        double packageCost = (tourPackage.getBasic_fare() * numberOfDays);
        double discountedPackageCost = packageCost - (packageCost * discount / 100);
        double totalPackCost = discountedPackageCost + (discountedPackageCost * 12/ 100);

       
        return totalPackCost;
    }
	private int getDiscount(int numberOfDays) {

        int discount = 0;
        if (numberOfDays > 5 && numberOfDays <= 8) {
            discount = 3;
        } else if (numberOfDays > 8 && numberOfDays <= 10) {
            discount = 5;
        } else if (numberOfDays > 10) {
            discount = 7;
        }
        return discount;
    }
}

