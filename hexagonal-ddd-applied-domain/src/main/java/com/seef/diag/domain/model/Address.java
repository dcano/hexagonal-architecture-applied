package com.seef.diag.domain.model;

public class Address {

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

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getTown() {
        return town;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static AddressBuilder builder() {
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

    public static class AddressBuilder {
        private String street;
        private String number;
        private String zip;
        private String town;
        private String state;
        private String country;

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public AddressBuilder withZip(String zip) {
            this.zip = zip;
            return this;
        }

        public AddressBuilder withTown(String town) {
            this.town = town;
            return this;
        }

        public AddressBuilder withState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return Address.instanceAddress(this);
        }
    }
}
