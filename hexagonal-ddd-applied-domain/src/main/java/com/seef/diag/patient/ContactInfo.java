package com.seef.diag.patient;

import com.seef.diag.commons.ValueObject;

import java.util.Collections;
import java.util.List;

class ContactInfo extends ValueObject {

    private final List<PhoneNumber> phoneNumbers;
    private final Address address;
    private final String email;

    ContactInfo(List<PhoneNumber> phoneNumbers, Address address, String email) {
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.email = email;
    }

    List<PhoneNumber> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    Address getAddress() {
        return address;
    }

    String getEmail() {
        return email;
    }

}
