package src.CommandOperation;

import java.util.ArrayList;

/**
 * The CommandHistory class acts as the Iterable class to store
 * commands.
 */
public class CommandHistory {
    private ArrayList<Command> Previous;

    public CommandHistory() {
        Previous = new ArrayList<Command>();
    }

    /**
     * Adds a command into the ArrayList, Previous[]
     * @param c, where c is a Command
     */
    public void addCommand(Command c) {
        Previous.add(c);
    }

    /**
     * Undo the top command in Previous[], and return it.
     * @return c, where c is the command popped from Previous[]
     */
    public Command undoCommand () {
        Command c = Previous.get(Previous.size() - 1);
        Previous.remove(Previous.size() - 1);
        return c;
    }

    /**
     * Remove the specified command in Previous[].
     * @param c, where c is the command to be removed
     */
    public void removeCommand (Command c) {
        Previous.remove(c);
    }

    /**
     * prints the arraylist Previous[] for testing purposes.
     * Returns the commands in the console.
     */
    public void printCommands () {
        for (Command c: Previous){
            System.out.println(c);
        }
    }
}
