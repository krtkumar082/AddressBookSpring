package com.addressbook.addressbookbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.addressbookbservice.dto.AddressBookDTO;
import com.addressbook.addressbookbservice.model.AddressBookData;


@Service
public class AddressBookService implements IAddressBookService{

	List<AddressBookData> contactList =new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return contactList;
	}

	@Override
	public AddressBookData getAddressBookDataById(long contactId) {
		return contactList.get((int) (contactId-1));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData contact=null;
		contact=new AddressBookData(contactList.size()+1,addressBookDTO);
		contactList.add(contact);
		return contact;
	}

	@Override
	public AddressBookData updateAddressBookData(long contactId,AddressBookDTO addressBookDTO) {
		AddressBookData contact = this.getAddressBookDataById(contactId);
		contact.setFirstName(addressBookDTO.firstName);
		contact.setLastName(addressBookDTO.lastName);
		contact.setAddress(addressBookDTO.address);
		contact.setCity(addressBookDTO.city);
		contact.setState(addressBookDTO.state);
		contact.setZip(addressBookDTO.zip);
		contact.setPhoneNumber(addressBookDTO.phoneNumber);
		contact.setEmail(addressBookDTO.email);
		contactList.set((int) (contactId - 1), contact);
		return contact;
	}

	@Override
	public void deleteAddressBookData(long contactId) {
		contactList.remove(contactId-1);
		
	}

}
