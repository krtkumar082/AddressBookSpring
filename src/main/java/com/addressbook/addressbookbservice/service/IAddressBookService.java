package com.addressbook.addressbookbservice.service;

import java.util.List;

import com.addressbook.addressbookbservice.dto.AddressBookDTO;
import com.addressbook.addressbookbservice.model.AddressBookData;


public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();

	AddressBookData getAddressBookDataById(long contactId);

	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookData(long contactId,AddressBookDTO addressBookDTO);

	void deleteAddressBookData(long contactId);
}
