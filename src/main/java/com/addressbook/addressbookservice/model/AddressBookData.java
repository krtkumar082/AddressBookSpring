package com.addressbook.addressbookservice.model;

import com.addressbook.addressbookservice.dto.AddressBookDTO;

import lombok.Data;

public @Data class AddressBookData {
	private Long id;
	private String fullName;
	private String address;
	private String state;
	private String city;
	private String zip;
	private String phoneNumber;
	

	public AddressBookData(long id, AddressBookDTO addressBookDTO) {
		this.id = id;
		this.fullName = addressBookDTO.getFullName();
		this.address = addressBookDTO.getAddress();
		this.state = addressBookDTO.getState();
		this.city = addressBookDTO.getCity();
		this.zip = addressBookDTO.getZip();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
		
	}

	
}
