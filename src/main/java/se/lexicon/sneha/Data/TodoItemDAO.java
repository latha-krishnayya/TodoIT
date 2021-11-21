package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TodoItemDAO extends GenericCRUD<TodoItem, Integer> {



    Optional<TodoItem> findById(Integer id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(Integer id);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);


}


