package se.lexicon.sneha.model;

import java.util.Objects;
import java.util.UUID;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;


    public Person(int id, String firstName, String lastName, String email, AppUser credentials) {
        if (firstName == null) {
            throw new RuntimeException("Firstname cannot be null");
        }
        if (lastName == null) {
            throw new RuntimeException("lastname cannot be null");
        }
        if (email == null) {
            throw new RuntimeException("email cannot be null");
        }

            setId(id);
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);

    }

    public Person(String  firstName, String lastName, String email, AppUser credentials) {
        this(UUID.randomUUID().variant(), firstName,lastName, email, credentials);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

}