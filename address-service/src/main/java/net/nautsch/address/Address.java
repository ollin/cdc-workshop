package net.nautsch.address;

public class Address {

    private final String firstname;
    private final String surname;

    public Address(String surname, String firstName) {
        this.surname = surname;
        this.firstname = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }
}
