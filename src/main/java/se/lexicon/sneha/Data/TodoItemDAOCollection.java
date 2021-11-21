package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.TodoItem;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO{

    private static final TodoItemDAOCollection INSTANCE;

    static {
        INSTANCE = new TodoItemDAOCollection(null);
    }

    public static TodoItemDAOCollection getInstance(){
        return INSTANCE;
    }

    static TodoItemDAOCollection getTestInstance(Collection<TodoItem> todoItemCollection){
        return new TodoItemDAOCollection(todoItemCollection);
    }

    private final Set<TodoItem> todoItems;

    private TodoItemDAOCollection(Collection<TodoItem> todoItemCollection){
        this.todoItems = todoItemCollection == null
                ? new HashSet<>() : new HashSet<>(todoItemCollection);
    }


    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public void remove(Integer id) {
        findById(id).map(todoItems::remove);
    }

    @Override
    public Optional<TodoItem> findById(Integer id) {

        return todoItems.stream().filter(todoItem -> todoItem.getId() == id).findFirst();
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {

        return findAll().stream()
                .filter(todoItem -> todoItem.isDone() == true)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {

        return todoItems.stream()
                .filter(todoItems -> todoItems.getTitle().matches(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(Integer id) {
        return todoItems.stream()
                .filter(todoItems -> todoItems.getId()==id)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {

        return todoItems.stream()
                .filter(todoItems -> todoItems.getDeadLine().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(todoItems -> todoItems.getDeadLine().isAfter(date))
                .collect(Collectors.toList());
    }
}
