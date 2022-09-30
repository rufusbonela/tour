package com.fis.tour_service.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Package {
	
	@Id
	String package_id;
	String source;
	String dest;
	int basic_fare;
	
	public Package() {
		super();
	}
	
	public Package(String package_id, String source, String dest, int basic_fare) {
		super();
		this.package_id = package_id;
		this.source = source;
		this.dest = dest;
		this.basic_fare = basic_fare;
	}
	
	public String getPackage_id() {
		return package_id;
	}
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public int getBasic_fare() {
		return basic_fare;
	}
	public void setBasic_fare(int basic_fare) {
		this.basic_fare = basic_fare;
	}

	@Override
	public String toString() {
		return "Package [package_id=" + package_id + ", source=" + source + ", dest=" + dest + ", basic_fare="
				+ basic_fare + "]";
	}
	
}
