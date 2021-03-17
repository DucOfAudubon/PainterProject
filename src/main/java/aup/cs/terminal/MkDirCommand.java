package aup.cs.terminal;

import java.io.File;

public class MkDirCommand extends Command{
    private String arg;

    public MkDirCommand(String [] elems) throws TerminalFlagParsingException {
        if (elems.length != 2) {
            throw new TerminalFlagParsingException("cd command expects one argument");
        }
        if (elems[1].contains("\\")){
            throw new TerminalFlagParsingException(" cannot make subdirectories and directories at the same time");
        }
        arg = elems[1];
    }

    public File exec(File someF) throws TerminalExecutionException {
        File f = new File(someF, arg);
        if(f.isDirectory()){
            throw new TerminalExecutionException(arg + " already exists");
        }
        f.mkdir();
        return someF;
    }
}
