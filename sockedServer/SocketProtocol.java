package sockedServer;

public class SocketProtocol {
    //private static final int WAITING = 0;
   // private static final int SENTKNOCKKNOCK = 1;
    //private static final int SENTCLUE = 2;
    //private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;
    
    private SockedThreadState state = new StateWaiting();
    private int currentJoke = 0;

    
    private final String[] clues = {"Turnip", "Little Old Lady", "Atch", "Who", "Who"};
    private final String[] answers = {
            "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?"};
    
    
    void setState(SockedThreadState state) {
        this.state = state;
    }
    
    public void setCurrentJoke(int currentJoke) {
        this.currentJoke = currentJoke;
    }
    
    public String processInput(String theInput) {
        String theOutput = this.state.input(this, theInput, currentJoke, clues, answers, NUMJOKES);
        
        
        
        return theOutput;
    }
    
}
