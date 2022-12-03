package src.CommandOperation;

import src.Country;

/**
 * This is the command interface, which is implemented by all concrete
 * command classes.
 */
public interface Command {
    void execute();
    void unexecute();

    Country getInfo();

    default boolean isReversible() {
        return true;
    }
}
