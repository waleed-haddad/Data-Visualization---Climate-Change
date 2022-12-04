package src.CommandOperation;

import src.Country;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The CommandHistory class acts as the Iterable class to store
 * commands.
 */
public class CommandHistory {
    public ArrayList<Command> Previous;

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
     * @return returnC, where returnC is the command that is being removed
     */
    public Command removeCommand (Command c) {
        Command returnC = null;
        for (Command com : Previous) {
            if (com.getInfo().getName() == c.getInfo().getName()) {
                returnC = com;
                Previous.remove(com);
                break;
            }
        }
        return returnC;
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

    public HashMap<String, Command> getCommandHashMap () {
        HashMap<String, Command> result = new HashMap<>();
        for (Command c: Previous){
            result.put(c.getInfo().getName(), c);
        }
        return result;
    }
}
