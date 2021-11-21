package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public interface AppUserDAO extends GenericCRUD<AppUser, String>{

    Optional<AppUser> findByUsername(String username);

}
