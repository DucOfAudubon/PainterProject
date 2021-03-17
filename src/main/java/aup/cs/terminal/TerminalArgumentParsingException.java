package aup.cs.terminal;

public class TerminalArgumentParsingException extends TerminalParsingException {
    // illegal number of arguments to a command
    public TerminalArgumentParsingException(String msg) {
        super(msg);
    }
    public TerminalArgumentParsingException() {
        super("TerminalArgumentParsingException: Illegal number of arguments to a command");
    }
}
