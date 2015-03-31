package br.com.balancin.amazingcep.data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.balancin.amazingcep.validator.Zipcode;

@Document
public class Address {
	
	@Id
	private String addressId;
	
	@NotEmpty(message="campo numero deve ser preenchido")
	private String number;
	
	@NotEmpty(message="campo rua deve ser preenchido")
	private String street;
	
	@Zipcode
	private String zipcode;
	
	@NotEmpty(message="campo cidade deve ser preenchido")
	private String city;
	
	@NotEmpty(message="campo estado deve ser preenchido")
	private String state;
	
	private String extras;
	private String neighborhood;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

}
