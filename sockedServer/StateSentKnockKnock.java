package sockedServer;

public class StateSentKnockKnock implements SockedThreadState {


    @Override
    public String input(SocketProtocol context, String theInput, int currentJoke, String[] clues, String[] answers, int NUMJOKES) {
        String theOutput;
        if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = clues[currentJoke];
                context.setState(new StateSentClue());
            } else {
                theOutput = "You're supposed to say \"Who's there?\"!\n"
                        + "Try again.\n\n";
                context.setState(new StateWaiting());
            }
        return theOutput;
    }
    
}
