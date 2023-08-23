package com.project.Property_Details.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "property_details")
public class PropModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int propertyId;
    private String propertyName;
    private String location;
    private double rentPrice;
    private double sellPrice;
    private double leasePrice;
    private int ownerId;
    private String ownerName;
    private long ownerContact;
 

    public PropModel() {
        super();
    }

	

	public PropModel(int propertyId, String propertyName, String location, double rentPrice, double sellPrice,
			double leasePrice, int ownerId, String ownerName, long ownerContact) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.location = location;
		this.rentPrice = rentPrice;
		this.sellPrice = sellPrice;
		this.leasePrice = leasePrice;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getLeasePrice() {
		return leasePrice;
	}

	public void setLeasePrice(double leasePrice) {
		this.leasePrice = leasePrice;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(long ownerContact) {
		this.ownerContact = ownerContact;
	}
    
}
