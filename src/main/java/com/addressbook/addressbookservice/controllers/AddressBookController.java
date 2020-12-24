package com.addressbook.addressbookservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.addressbook.addressbookservice.dto.AddressBookDTO;
import com.addressbook.addressbookservice.dto.ResponseDTO;
import com.addressbook.addressbookservice.model.AddressBookData;
import com.addressbook.addressbookservice.service.IAddressBookService;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> contactList=null;
		contactList=addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", contactList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{contactId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("contactId") Long contactId) {
		AddressBookData addressData = null;
		addressData=addressBookService.getAddressBookDataById(contactId);
		ResponseDTO respDTO = new ResponseDTO("Get Call Success for id: " + contactId, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressData = null;
		addressData=addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Successfully for: " + addressBookDTO, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{contactId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("contactId") int contactId,@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData addressData = null;
		addressData = addressBookService.updateAddressBookData(contactId, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Successfully for: " + addressBookDTO, addressData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("contactId") Long contactId) {
		addressBookService.deleteAddressBookData(contactId);
		ResponseDTO respDTO = new ResponseDTO("Delete Successfully for id: " + contactId, contactId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
