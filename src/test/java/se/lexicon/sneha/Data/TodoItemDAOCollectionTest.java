package se.lexicon.sneha.Data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.sneha.model.Person;
import se.lexicon.sneha.model.TodoItem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TodoItemDAOCollectionTest {

    private final int id = 1;
    private final String title = "task1";
    private final String taskDescription = "task1-description";
    private final LocalDate deadLine = LocalDate.parse("2021-12-05");
    private final boolean done = true;
    private Person person;
    private TodoItemDAOCollection testTodoItemDAO;
    private TodoItem item;

    private ArrayList<TodoItem> items =
            new ArrayList<>(Arrays.asList(
            new TodoItem(id,title,taskDescription,deadLine,done,person)));

    @Before
    public void setUp(){
        testTodoItemDAO = TodoItemDAOCollection.getTestInstance(items);
        item = items.get(0);

    }

    @Test
    public void persist_successfully_added(){
        Collection<TodoItem> added = testTodoItemDAO.findAll();
        assertEquals(1, added.size());
    }

    @Test
    public void findAll_successfully_printed_all() {

        assertEquals(1, items.size());

    }

    @Test
    public void remove_successfully_removed() {
       TodoItem id = items.get(0);
       assertTrue(items.remove(id));
       assertFalse(testTodoItemDAO.findById(0).isPresent());
    }

    @Test
    public void findById_Successfully_Fetched() {
       Optional<TodoItem> findByIdTest = testTodoItemDAO.findById(item.getId());
        assertTrue(findByIdTest.isPresent());
        assertEquals(findByIdTest.get(),items.get(0));
    }

    @Test
    public void findAllByDoneStatus_successfully_received_status(){
        List<TodoItem> doneStatus = items.stream()
                .filter(todoItem -> todoItem.isDone()==true).collect(Collectors.toList());

        assertEquals(doneStatus,testTodoItemDAO.findAllByDoneStatus(true));

    }

    @Test
    public void findByTitleContains() {
        List<TodoItem> expected = items.stream()
                .filter(todoItem -> todoItem.getTitle() == title)
                .collect(Collectors.toList());
        assertEquals(expected,testTodoItemDAO.findByTitleContains(title));
    }

    @Test
    public void findByPersonId() {
        List<TodoItem> expected = items.stream()
                .filter(todoItem -> todoItem.getId()==id)
                .collect(Collectors.toList());
        assertEquals(expected,testTodoItemDAO.findByPersonId(id));

    }

    @Test
    public void findByDeadlineBefore() {
        List<TodoItem> expected = items.stream()
                .filter(todoItem -> todoItem.getDeadLine().isBefore(deadLine))
                .collect(Collectors.toList());

        assertEquals(expected,testTodoItemDAO.findByDeadlineBefore(deadLine));
    }

    @Test
    public void findByDeadlineAfter() {
        List<TodoItem> expected = items.stream()
                .filter(todoItem -> todoItem.getDeadLine().isAfter(deadLine))
                .collect(Collectors.toList());
        assertEquals(expected,testTodoItemDAO.findByDeadlineAfter(deadLine));
    }
}