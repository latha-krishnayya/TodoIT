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

    @Before
    public void setUp() throws Exception {
        testPerson = new Person(firstName,lastName,email);

    }

    @Test
    public void TestPerson_successfully_instantiated() {

        assertNotNull(testPerson.getId());
        assertEquals(firstName,testPerson.getFirstName());
        assertEquals(lastName, testPerson.getLastName());
        assertEquals(email,testPerson.getEmail());
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_firstName() {
        new Person(null, lastName, email);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_lastName() {
        new Person(firstName, null, email);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_Email() {
        new Person(firstName, lastName, null);
    }
}