package se.lexicon.sneha;

import se.lexicon.sneha.model.Person;
import se.lexicon.sneha.model.TodoItem;
import se.lexicon.sneha.model.TodoItemTask;

import java.time.LocalDate;
import java.time.Period;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person p1 = new Person("Sneha1","Nama","sneha1@gmail.com");
        Person p2 = new Person("Sneha2","Nama","sneha2@gmail.com");


        System.out.println(p1.getSummary());
        System.out.println(p2.getSummary());
        TodoItem t1 = new TodoItem(1, "test", "test practice","2021-05-11",true,p1);
        System.out.println(t1.getSummary());
        TodoItemTask items = new TodoItemTask(1,true,t1, p2);
        System.out.println(items.getSummary());

    }

}
