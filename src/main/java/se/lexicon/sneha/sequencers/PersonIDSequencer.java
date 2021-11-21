package se.lexicon.sneha.sequencers;

public class PersonIDSequencer {

    private static int currentId;

    public static int nextId(){
        ++currentId;
        return currentId;
    }
    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonIDSequencer.currentId = currentId;
    }


}
