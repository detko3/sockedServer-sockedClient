package sockedServer;

public class StateSentClue implements SockedThreadState {


    @Override
    public String input(SocketProtocol context, String theInput, int currentJoke, String[] clues, String[] answers, int NUMJOKES) {
        String theOutput;
        if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + "\nWant another? (y/n)";
                context.setState(new StateAnother());
            } else {
                theOutput = "You're supposed to say \"" + clues[currentJoke] + " who?\"!\n"
                        + "Try again.\n\n";
                context.setState(new StateWaiting());
            }
        return theOutput;
    }
    
}
