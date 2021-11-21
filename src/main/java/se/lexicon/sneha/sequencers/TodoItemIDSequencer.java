package se.lexicon.sneha.sequencers;

public class TodoItemIDSequencer<currentId> {

    public static int currentId;

    public static int nextId(){
        ++currentId;
        return currentId;
    }
    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIDSequencer.currentId = currentId;
    }


}
