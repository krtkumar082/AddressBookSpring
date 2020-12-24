package com.addressbook.addressbookservice.service;

import java.util.List;

import com.addressbook.addressbookservice.dto.AddressBookDTO;
import com.addressbook.addressbookservice.model.AddressBookData;


public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(long contactId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(long contactId,AddressBookDTO addressBookDTO);

	void deleteAddressBookData(long contactId);
}
