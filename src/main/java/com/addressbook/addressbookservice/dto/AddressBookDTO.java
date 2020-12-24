package com.addressbook.addressbookservice.dto;

import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Invalid Name")
	private String fullName;
	private String address;
	private String city;
	private String state;
	
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$",message="Invalid zip code")
	private String zip;
	@Pattern(regexp="^[1-9]{2}[ ][1-9]{1}[0-9]{9}$",message="Invalid phone number")
	private String phoneNumber;
	

	public AddressBookDTO(String fullName,String address, String city, String state, String zip,
			String phoneNumber) {
		this.fullName = fullName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		
	}

	
}
