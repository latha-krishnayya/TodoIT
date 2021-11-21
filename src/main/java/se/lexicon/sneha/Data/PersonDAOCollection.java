package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.Person;

import java.util.*;

public class PersonDAOCollection implements PersonDAO{

    private static final PersonDAOCollection INSTANCE;
    static {
       INSTANCE = new PersonDAOCollection(null);
    }
    public static PersonDAOCollection getInstance(){
        return INSTANCE;
    }

    private final Set<Person> persons;
    private PersonDAOCollection(Collection<Person> PersonDAOCollection){
        this.persons = PersonDAOCollection == null ? new HashSet<>() : new HashSet<>(PersonDAOCollection);
    }

    @Override
    public Person persist(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Integer id) {
        findById(id).map(persons::remove);
    }

    @Override
    public Optional<Person> findById(Integer id) {

        return persons.stream().filter(persons -> persons.getId() == id).findFirst();
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        
        return persons.stream().filter(person -> person.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
