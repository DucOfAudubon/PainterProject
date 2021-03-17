package aup.cs.terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        terminal.start();
    }

    /**
     * Start method allows for exceptions that don't break the whole program
     */
    public void start() {
        File f = new java.io.File( ".", "." ); //get a file to make the initial path name. Outside the loop so that it can be changed with cd
        while (true) {
            try {
                displayPath(f);
                Command com = Command.parseCommand(); //gives us the command that we will be executing
                f = com.exec(f); // executes the command. Will execute differently based on the command subclass
            } catch (TerminalParsingException tpe) {
                System.out.println("Cannot parse command: " + tpe.getMessage());
            }
        }
    }

    /**
     * Kind of self-explanatory. Displays the current path where the user is working
     * @param f is the File object it displays the path of
     */
    private static void displayPath(File f) {
        try{
            String current = f.getCanonicalPath();
            System.out.print(current + "> ");
        }
        catch (java.io.IOException ioExc){
            System.out.print(ioExc.getMessage());
        }
    }

}