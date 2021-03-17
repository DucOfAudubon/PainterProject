package aup.cs.terminal;

public class TerminalExecutionException extends TerminalParsingException{
    //Denotes an error on execution

    public TerminalExecutionException() {
        super("TerminalExecutionException: Error on execution");
    }
    public TerminalExecutionException(String msg){
        super("TerminalExecutionException: Error on execution" + msg);
    }
    public TerminalExecutionException(Exception e, String msg){
        super("Error: " + e.getMessage() + " Throws TerminalExecutionException: Error on execution" + msg);
    }
}
