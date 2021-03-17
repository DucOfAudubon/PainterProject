package aup.cs.terminal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrintCommand extends Command{
    private String arg;

    public PrintCommand(String[] elems) throws TerminalFlagParsingException {
        if (elems.length != 2) {
            throw new TerminalFlagParsingException("cd command expects one argument");
        }
        arg = elems[1];
    }

    public File exec(File someF) throws TerminalExecutionException {
        File f = new File(someF, arg);
        if(!f.exists()){
            throw new TerminalExecutionException(" " + arg + " does not exist");
        }
        try {
            Scanner s = new Scanner(f, StandardCharsets.UTF_8.name());
            String builder = "";
            while (s.hasNextLine()) {
                builder += (s.nextLine());
            }
            System.out.println(builder);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return someF;
    }
}
