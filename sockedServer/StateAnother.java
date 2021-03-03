package sockedServer;

public class StateAnother  implements SockedThreadState {

    @Override
    public String input(SocketProtocol context, String theInput, int currentJoke, String[] clues, String[] answers, int NUMJOKES) {
        String theOutput;
        if (theInput.equalsIgnoreCase("y")) {
                theOutput = "\nKnock! Knock!";
                currentJoke++;
                if (currentJoke == NUMJOKES) currentJoke = 0;
                context.setCurrentJoke(currentJoke);
                context.setState(new StateSentKnockKnock());
            } else {
                theOutput = "Bye.\n";
                context.setState(new StateWaiting());
            }
        return theOutput;
    }
    
}
