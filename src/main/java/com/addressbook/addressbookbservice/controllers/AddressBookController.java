package com.addressbook.addressbookbservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.addressbookbservice.dto.AddressBookDTO;
import com.addressbook.addressbookbservice.dto.ResponseDTO;
import com.addressbook.addressbookbservice.model.AddressBookData;

@RestController
public class AddressBookController {
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData addressData = null;
		addressData = new AddressBookData(1, new AddressBookDTO("John", "Singh", "Jaipur", "Jaipur", "Rajasthan",
				"333333", "+91 8888888888", "John@gmail.com"));
		ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("id") Long id) {
		AddressBookData addressData = null;
		addressData = new AddressBookData(1, new AddressBookDTO("John", "Singh", "Jaipur", "Jaipur", "Rajasthan",
				"333333", "+91 8888888888", "John@gmail.com"));
		ResponseDTO respDTO = new ResponseDTO("Get Call Success for id: " + id, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressData = null;
		addressData = new AddressBookData(2, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Successfully for: " + addressBookDTO, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressData = null;
		addressData = new AddressBookData(2, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Successfully for: " + addressBookDTO, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("id") Long id) {
		ResponseDTO respDTO = new ResponseDTO("Delete Successfully for id: " + id, id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
