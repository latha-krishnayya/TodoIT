package se.lexicon.sneha.sequencers;

public class TodoItemTaskIDSequencer{
    public static int currentId;

    public static int nextId(){
        ++currentId;
        return currentId;
    }
    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIDSequencer.currentId = currentId;
    }

}
