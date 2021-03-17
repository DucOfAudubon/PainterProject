package aup.cs.terminal;

public class TerminalFlagParsingException extends TerminalParsingException {
    // illegal flag to a command
    public TerminalFlagParsingException(String msg) {
        super(msg);
    }
    public TerminalFlagParsingException() {
        super("TerminalFlagParsingException: illegal file or directory");
    }
}
