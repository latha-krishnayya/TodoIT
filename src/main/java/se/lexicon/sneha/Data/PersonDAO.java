package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.Person;

import java.util.Optional;

public interface PersonDAO extends GenericCRUD<Person, Integer> {


    Optional<Person> findById(Integer id);
    Optional<Person> findByEmail(String email);

}
