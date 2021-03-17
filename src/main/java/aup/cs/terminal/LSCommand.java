package aup.cs.terminal;

import java.io.File;

public class LSCommand extends Command {

    public File exec(File f) throws TerminalExecutionException {
        String[] list = f.list(); //well that's convenient
        File[] fileList = f.listFiles();
        /** If the directory is empty, throw an exception to say so rather than printing an empty line */
        if(list.length == 0){
            throw new TerminalExecutionException("Directory is empty");
        }
        for (int i=0; i<list.length; i++) {
            long lastMod = fileList[i].lastModified();
            long size = fileList[i].getTotalSpace();
            String isDir;
            if(fileList[i].isDirectory()){
                isDir = "Directory";
            }
            else{
                isDir = "File";
            }
            System.out.print(list[i] + "\t" + lastMod + "\t" + size + "\t" + isDir);
            if (i < list.length-1) {
                System.out.println("\t");
            }
        }
        System.out.println();
        return f;
    }
}