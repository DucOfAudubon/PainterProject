package aup.cs.terminal;

public class TerminalCommandParsingException extends TerminalParsingException {
    //illegal command exception
    public TerminalCommandParsingException(String str) {
        super(str);
    }
    public TerminalCommandParsingException() {
        super("TerminalCommandParsingException: Illegal command has been passed");
    }
}
