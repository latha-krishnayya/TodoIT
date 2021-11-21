package se.lexicon.sneha.Data;

import java.util.Collection;
import java.util.Optional;

public interface GenericCRUD<T, ID> {

     T persist(T t);
     Collection<T> findAll();
     void remove(ID id);

}

