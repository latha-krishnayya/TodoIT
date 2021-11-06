package se.lexicon.sneha;

import se.lexicon.sneha.model.*;

import java.time.LocalDate;
import java.time.Period;

import static se.lexicon.sneha.model.AppRole.*;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        AppRole Admin= ROLE_APP_ADMIN;
        AppRole User= ROLE_APP_USER;

        AppUser user1Login = new AppUser("Sneha1Admin", "password1", Admin);
        AppUser user2Login = new AppUser("Sneha1User", "password2", User);

        Person p1 = new Person(1,"Sneha1","Nama","sneha1@gmail.com", user1Login);
        Person p2 = new Person(2,"Sneha2","Nama","sneha2@gmail.com", user2Login);


        TodoItem t1 = new TodoItem(1, "test", "test practice","2021-05-11",true,p1);
        System.out.println(t1.toString());
        TodoItemTask items = new TodoItemTask(1,true,t1, p2);
        System.out.println(items.toString());




    }

}
