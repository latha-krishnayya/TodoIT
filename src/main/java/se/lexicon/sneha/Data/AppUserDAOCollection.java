package se.lexicon.sneha.Data;

import se.lexicon.sneha.model.AppUser;

import java.util.*;


public class AppUserDAOCollection implements AppUserDAO{

    private static final AppUserDAOCollection INSTANCE;

    static {
        INSTANCE = new AppUserDAOCollection(null);
    }

    public static AppUserDAOCollection getInstance(){
        return INSTANCE;
    }

    private final Set<AppUser> appUsers;

    private AppUserDAOCollection(Collection<AppUser> appUserCollection){

        this.appUsers = appUserCollection == null ? new HashSet<>() : new HashSet<>(appUserCollection);
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {

        return appUsers.stream()
                .filter(appUser -> appUser.getUsername()
                        .equalsIgnoreCase(username)).findFirst();

    }

    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public Collection<AppUser> findAll() {

        return new ArrayList<>(appUsers);

    }

    @Override
    public void remove(String s){
        findByUsername(s).map(appUsers::remove);
    }
}
