package se.lexicon.sneha.model;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, boolean assigned, TodoItem todoItem, Person assignee) {
        setId(id);
        setAssigned(assigned);
        setTodoItem(todoItem);
        setAssignee(assignee);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        if(assignee != null){
            return true;
        } else{
            return false;
        }
    }


    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
    public String getSummary(){
        return "{ " +"Name : "+assignee.getFirstName()+" "+assignee.getLastName()+", Task : "+todoItem.getTitle()+ " }";
    }

}
