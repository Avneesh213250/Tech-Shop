package com.STS.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {


private String name;
	
private String password;
	@Id
private String email;

private String address;
	
private String country;
	
private String city;
	
@Column(name = "phone_number")
private String number;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}



public String getNumber() {
	
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
@Override
public String toString() {
	return "register [ name=" + name + ", password=" + password + ", email=" + email + ", address="
			+ address + ", country=" + country + ", city=" + city + ", number=" + number + "]";
}



}
