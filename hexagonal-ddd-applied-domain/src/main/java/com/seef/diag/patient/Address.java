package com.seef.diag.patient;

class Address {

    private final String street;
    private final String number;
    private final String zip;
    private final String town;
    private final String state;
    private final String country;

    private Address(String street, String number, String zip, String town, String state, String country) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.town = town;
        this.state = state;
        this.country = country;
    }

    String getStreet() {
        return street;
    }

    String getNumber() {
        return number;
    }

    String getZip() {
        return zip;
    }

    String getTown() {
        return town;
    }

    String getState() {
        return state;
    }

    String getCountry() {
        return country;
    }

    static AddressBuilder builder() {
        return new AddressBuilder();
    }

    private static Address instanceAddress(AddressBuilder builder) {
        return new Address(builder.street,
                builder.number,
                builder.zip,
                builder.town,
                builder.state,
                builder.country);
    }

    static class AddressBuilder {
        private String street;
        private String number;
        private String zip;
        private String town;
        private String state;
        private String country;

        AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        AddressBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        AddressBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        AddressBuilder withTown(String town) {
            this.town = town;
            return this;
        }

        AddressBuilder withState(String state) {
            this.state = state;
            return this;
        }

        AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        Address build() {
            return Address.instanceAddress(this);
        }
    }
}
