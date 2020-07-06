package com.demo.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employees")
public class Employee {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 @NotEmpty(message = "Please provide a name")
	 private String name;
	 @NotEmpty(message = "Please provide an address")
	 private String address;
	 private String city;
	 
	 public Employee() {}
	 
	public Employee(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("address") String address, @JsonProperty("city") String city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	 
}
