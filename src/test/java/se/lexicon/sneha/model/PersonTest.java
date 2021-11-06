package se.lexicon.sneha.model;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest{
    public static final String firstName="Sneha";
    public static final String lastName="Bande";
    public static final String email="email";
    private Person testPerson;
    private AppUser user;


    @Before
    public void setUp() throws Exception {
        testPerson = new Person(1, firstName,lastName,email, user);

    }

    @Test
    public void TestPerson_successfully_instantiated() {

        assertNotNull(testPerson.getId());
        assertEquals(firstName,testPerson.getFirstName());
        assertEquals(lastName, testPerson.getLastName());
        assertEquals(email,testPerson.getEmail());
        assertEquals(user, testPerson.getCredentials());
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_firstName() {
        new Person(testPerson.getId(), null, lastName, email,user);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_lastName() {
        new Person(testPerson.getId(), firstName, null, email, user);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_Email() {
        new Person(testPerson.getId(),firstName, lastName, null,user);
    }

}