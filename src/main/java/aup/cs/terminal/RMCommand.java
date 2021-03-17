package aup.cs.terminal;

import java.io.File;

public class RMCommand extends Command {
    private String arg;

    public RMCommand(String[] elems) throws TerminalFlagParsingException {
        if (elems.length != 2) {
            throw new TerminalFlagParsingException("cd command expects one argument");
        }
        arg = elems[1];
    }

    public File exec(File someF) throws TerminalExecutionException{
        File f = new File(someF, arg);
        if(!f.exists()){
            throw new TerminalExecutionException(" Can't delete a file that doesn't exist");
        }
        if(f.list().length > 0){
            throw new TerminalExecutionException(" This command only deletes empty files");
        }
        f.delete();
        return someF;
    }
}
