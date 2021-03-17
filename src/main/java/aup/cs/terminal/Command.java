package aup.cs.terminal;

import java.io.File;
import java.util.Scanner;

public class Command {

    protected Command() {

    }

    /**
     * Read use command, split it into command and object of command, and then direct it to the right type of command
     * @return a concrete command
     * @throws TerminalParsingException if the user inputs a command that isn't recognized
     */
    public static Command parseCommand() throws TerminalParsingException {
        Scanner s = new Scanner(System.in);
        String com = s.nextLine();
        String[] elems = com.split(" ");
        if (elems.length < 1) {
            throw new TerminalParsingException("No command was given");
        }
        String mainCommand = elems[0];
        switch (mainCommand) {
            case "exit":
                return new ExitCommand();
            case "cd":
                return new CDCommand(elems);
            case "ls`":
                return new LSCommand();
            case "rm":
                return new RMCommand(elems);
            case "cat":
                return new PrintCommand(elems);
            case "mkdir":
                return new MkDirCommand(elems);
            /** Save this for when I have more time. Which means probably never.
             * But here's the idea: Check if dir has directories. Cd into first directory. Rerun that until there are no dirs
             * Then, delete the files of the dir you're in. Then, cd up one, run that loop again.
            case "rm`":
                return new RMRecCommand(elems);
             */
            default:
                throw new TerminalParsingException("Command: " + com + " is not known");
        }
    }

    /**
     * Ensures that no one tries to call exec on a Command that hasn't been built in
     * @param f
     * @return
     * @throws TerminalExecutionException
     */
    public File exec(File f) throws TerminalExecutionException {
        throw new TerminalExecutionException("Only concrete commands are executable");
    }
}