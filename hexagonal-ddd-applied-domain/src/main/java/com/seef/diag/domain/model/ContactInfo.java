package com.seef.diag.domain.model;

import com.seef.diag.commons.ValueObject;

import java.util.Collections;
import java.util.List;

public class ContactInfo extends ValueObject {

    private final List<PhoneNumber> phoneNumbers;
    private final Address address;
    private final String email;

    public ContactInfo(List<PhoneNumber> phoneNumbers, Address address, String email) {
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.email = email;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

}
