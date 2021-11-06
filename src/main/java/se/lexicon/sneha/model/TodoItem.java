package se.lexicon.sneha.model;

import java.time.LocalDate;
import java.util.Objects;


public class TodoItem {
    private int id=0;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        if( title == null){
            throw new RuntimeException(" Task cannot be null ");
        } else if( deadLine == null){
            throw new RuntimeException(" must specify the Deadline for the task");
        }
            this.id = id;
            this.title = title;
            this.taskDescription = taskDescription;
            this.deadLine = deadLine;
            this.done = done;
            this.creator = creator;

    }

    public TodoItem(int id,
                    String title,
                    String taskDescription,
                    String targetDate, boolean done,
                    Person creator) {

        this(id,title,taskDescription,LocalDate.parse(targetDate), done, creator);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {

        this.creator = creator;
    }
    public boolean isOverdue(){
        LocalDate currentDate= LocalDate.now();
        if(isDone()){
            System.out.println("TASK IS ALREADY FINISHED");
            return false;
        }else
        return currentDate.isAfter(deadLine);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine) && Objects.equals(creator, todoItem.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done, creator);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", creator=" + creator +
                '}';
    }
}
