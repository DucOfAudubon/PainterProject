package aup.cs.terminal;

import java.io.File;

public class ExitCommand extends Command {
    public File exec(File f) throws TerminalExecutionException {
        System.exit(0);
        throw new TerminalExecutionException("Unreachable"); //Uh-oh
    }
}