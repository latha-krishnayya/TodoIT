package se.lexicon.sneha.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTaskTest {
    public static final int id=1;
    public static  boolean assigned;
    private TodoItem testtodoItem;
    private Person testassignee;
    private TodoItemTask testItask;
    private AppUser user;

    @Before
    public void setUp() throws Exception {

        testtodoItem = new TodoItem(id,"Title1","nothing to do", LocalDate.parse("2021-05-11"), true, testassignee);
        testassignee = new Person(1,"Sneha","Bande","email@gmail",user);
        testItask = new TodoItemTask(id,true,testtodoItem,testassignee);
    }

    @Test
    public void testObject_successfully_instantiated() {
        assertEquals(id,testItask.getId());
        assertEquals(testtodoItem,testItask.getTodoItem());
        assertEquals(testassignee,testItask.getAssignee());
        assertTrue(testItask.isAssigned());
        assertNotNull(testassignee);
    }

}