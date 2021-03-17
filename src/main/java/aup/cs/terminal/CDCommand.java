package aup.cs.terminal;

import java.io.File;

public class CDCommand extends Command {

    private String arg;

    public CDCommand(String[] elems) throws TerminalFlagParsingException {
        if (elems.length != 2) {
            throw new TerminalFlagParsingException("cd command expects one argument");
        }
        arg = elems[1];
    }

    public File exec(File fold) throws TerminalExecutionException {
        File f = new File(fold, arg);
        if (!f.isDirectory()) {
            throw new TerminalExecutionException("Cannot change directory into " + arg);
        }
        return f;

    }
}