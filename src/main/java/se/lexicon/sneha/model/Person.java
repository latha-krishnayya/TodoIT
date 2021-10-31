package se.lexicon.sneha.modal;

import java.util.UUID;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;


    public Person(int id, String firstName, String lastName, String email) {
        if (firstName == null) {
            throw new RuntimeException("Firstname cannot be null");
        } else if (lastName == null) {
            throw new RuntimeException("lastname cannot be null");
        } else if (email == null) {
            throw new RuntimeException("email cannot be null");
        } else {

            setId(id);
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);

        }
    }

    public Person(String  firstName, String lastName, String email) {
        this(UUID.randomUUID().variant(), firstName,lastName, email);
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
    public String getSummary(){
        return "{" + " ID : "+id+ ", Name : "+firstName+" "+lastName+", Email : "+email+" }";
    }
}