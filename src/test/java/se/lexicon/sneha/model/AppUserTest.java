package se.lexicon.sneha.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppUserTest {

    private String username1 ="sneha1Admin";
    private String password1 = "password1";
    private String username2 ="sneha2user";
    private String password2 = "password2";
    private AppRole testrole1,testrole2;
    private AppUser testuser1,testuser2;

    @Before
    public void setUp() throws Exception {

        testrole1 = AppRole.ROLE_APP_USER;
        testrole2 = AppRole.ROLE_APP_ADMIN;
        testuser1= new AppUser(username1,password1,testrole1);
        testuser2= new AppUser(username2,password2,testrole2);

    }
    @Test
    public void testUser1_successfully_instantiated() {
        assertEquals(username1,testuser1.getUsername());
        assertEquals(password1,testuser1.getPassword());
        assertEquals(testrole1,testuser1.getRole());
    }
    @Test
    public void testUser2_successfully_instantiated() {
        assertEquals(username2,testuser2.getUsername());
        assertEquals(password2,testuser2.getPassword());
        assertEquals(testrole2,testuser2.getRole());
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_USERNAME1() {
        new AppUser(null,password1,testrole1);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_PASSWORD1() {
        new AppUser(username1,null,testrole1);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_ROLE1() {
        new AppUser(username1,password1,null);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_USERNAME2() {
        new AppUser(null,password2,testrole2);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_PASSWORD2() {
        new AppUser(username2,null,testrole2);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_ROLE2() {
        new AppUser(username2,password2,null);
    }
}