package se.lexicon.sneha.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TodoItemTest{
    public static final int id=1;
    public static final String title="Title";
    public static final String taskDescription="nothing to do";
    public static final LocalDate deadLine= LocalDate.parse("2021-05-11");
    public static final boolean done=true;
    private Person testPerson;

    private TodoItem testTodoItem;

    @Before
    public void setUp() {
        testPerson = new Person("sneha","bande","email@gmail");
        testTodoItem = new TodoItem(id,title,taskDescription,deadLine,done,testPerson);


    }

    @Test
    public void testTodoItem_successfully_instantiated() {
        assertEquals(id,testTodoItem.getId());
        assertEquals(title,testTodoItem.getTitle());
        assertEquals(taskDescription, testTodoItem.getTaskDescription());
        assertEquals(deadLine, testTodoItem.getDeadLine());
        assertTrue(testTodoItem.isDone());
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_Title() {
        new TodoItem(id, null,taskDescription,deadLine,done, testPerson);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_deadline() {
        new TodoItem(id, title,taskDescription, LocalDate.parse(""),done, testPerson);
    }


}