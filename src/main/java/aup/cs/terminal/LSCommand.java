package aup.cs.terminal;

import java.io.File;

public class LSCommand extends Command {

    public File exec(File f) throws TerminalExecutionException {
        String[] list = f.list(); //well that's convenient
        /** If the directory is empty, throw an exception to say so rather than printing an empty line */
        if(list.length == 0){
            throw new TerminalExecutionException("Directory is empty");
        }
        for (int i=0; i<list.length; i++) {
            System.out.print(list[i]);
            if (i < list.length-1) {
                System.out.println("\t");
            }
        }
        System.out.println();
        return f;
    }
}