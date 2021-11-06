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
    private Person testPerson1,testPerson2;
    private AppUser testUser1, testUser2;
    private TodoItem testTodoItem1,testTodoItem2;

    @Before
    public void setUp() {
        testUser1 = new AppUser("sneha1Admin","password1", AppRole.ROLE_APP_ADMIN);
        testUser2 = new AppUser("sneha2User","password2", AppRole.ROLE_APP_USER);
        testPerson1 = new Person(1,"sneha1","Nama","sneha1@gmail",testUser1);
        testPerson2 = new Person(2,"Sneha2","Nama","sneha2@gmail",testUser2);

        testTodoItem1 = new TodoItem(id,title,taskDescription,deadLine,done,testPerson1);
        testTodoItem2 = new TodoItem(id,title,taskDescription,deadLine,done,testPerson2);

    }

    @Test
    public void testTodoItem1_successfully_instantiated() {
        assertEquals(id,testTodoItem1.getId());
        assertEquals(title,testTodoItem1.getTitle());
        assertEquals(taskDescription, testTodoItem1.getTaskDescription());
        assertEquals(deadLine, testTodoItem1.getDeadLine());
        assertTrue(testTodoItem1.isDone());
    }
    @Test
    public void testTodoItem2_successfully_instantiated() {
        assertEquals(id, testTodoItem2.getId());
        assertEquals(title, testTodoItem2.getTitle());
        assertEquals(taskDescription, testTodoItem2.getTaskDescription());
        assertEquals(deadLine, testTodoItem2.getDeadLine());
        assertTrue(testTodoItem2.isDone());
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_Title() {
        new TodoItem(id, null,taskDescription,deadLine,done, testPerson1);
    }
    @Test(expected = RuntimeException.class)
    public void constructor_throws_runtime_exception_on_null_deadline() {
        new TodoItem(id, title,taskDescription, LocalDate.parse(""),done, testPerson1);
    }



}