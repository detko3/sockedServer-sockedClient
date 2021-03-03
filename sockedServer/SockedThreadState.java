package sockedServer;

public interface SockedThreadState {
    String input(SocketProtocol context, String theInput, int currentJoke, String[] clues, String[] answers, int NUMJOKES);
}
