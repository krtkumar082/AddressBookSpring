package com.addressbook.addressbookservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.addressbookservice.dto.AddressBookDTO;
import com.addressbook.addressbookservice.exceptions.AddressBookException;
import com.addressbook.addressbookservice.model.AddressBookData;


@Service
public class AddressBookService implements IAddressBookService{

	List<AddressBookData> contactList =new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return contactList;
	}

	@Override
	public AddressBookData getAddressBookDataById(long contactId) {
		return contactList.stream().filter(obj->obj.getId()==contactId)
                .findFirst().orElseThrow(()-> new AddressBookException("Contact Not Found"));
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
		contact.setFullName(addressBookDTO.getFullName());
		contact.setAddress(addressBookDTO.getAddress());
		contact.setCity(addressBookDTO.getCity());
		contact.setState(addressBookDTO.getState());
		contact.setZip(addressBookDTO.getZip());
		contact.setPhoneNumber(addressBookDTO.getPhoneNumber());
		contactList.set((int) (contactId - 1), contact);
		return contact;
	}

	@Override
	public void deleteAddressBookData(long contactId) {
		AddressBookData contact = this.getAddressBookDataById(contactId);
		contactList.remove(contactId-1);
		
	}

}
