package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.TodoItemTask;

import java.util.Collection;
import java.util.Optional;

public interface TodoItemTaskDAO extends GenericCRUD<TodoItemTask, Integer>{

    Optional<TodoItemTask> findById(Integer id);
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int id);


}
