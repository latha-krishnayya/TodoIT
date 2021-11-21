package se.lexicon.sneha.Data;


import se.lexicon.sneha.model.TodoItem;
import se.lexicon.sneha.model.TodoItemTask;

import java.util.*;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{

    private static final TodoItemTaskDAOCollection INSTANCE;

    static {
        INSTANCE = new TodoItemTaskDAOCollection(null);
    }

    public static TodoItemTaskDAOCollection getInstance(){
        return INSTANCE;
    }

    private final Set<TodoItemTask> todoItemTasks;

    private TodoItemTaskDAOCollection(Collection<TodoItemTask> todoTaskItemCollection){
        this.todoItemTasks = todoTaskItemCollection == null
                ? new HashSet<>() : new HashSet<>(todoTaskItemCollection);
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public void remove(Integer id) {

        findById(id).map(todoItemTasks::remove);

    }

    @Override
    public Optional<TodoItemTask> findById(Integer id) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.getId() == id)
                .findFirst();
    }
    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTasks.stream()
                .filter(todoItemTask -> todoItemTask.isAssigned())
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int id) {
        return findByAssignedStatus(true).stream()
                .filter(todoItemTask -> todoItemTask.getAssignee().getId() == id)
                .collect(Collectors.toList());
    }
}
