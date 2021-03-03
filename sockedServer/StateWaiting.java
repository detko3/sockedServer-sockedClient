package sockedServer;

public class StateWaiting implements SockedThreadState {


    @Override
    public String input(SocketProtocol context, String theInput, int currentJoke, String[] clues, String[] answers, int NUMJOKES) {
        
       String theOutput = "\nKnock! Knock!";
       context.setState(new StateSentKnockKnock());
       return theOutput;
    }
    
}
