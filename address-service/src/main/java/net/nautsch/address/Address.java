package net.nautsch.address;

public class Address {

    private final String id;
    private final String firstName;
    private final String surname;

    public Address(String id, String surname, String firstName) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }
}
