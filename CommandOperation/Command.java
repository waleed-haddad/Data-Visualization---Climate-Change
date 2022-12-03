package src.CommandOperation;

/**
 * This is the command interface, which is implemented by all concrete
 * command classes.
 */
public interface Command {
    void execute();
    void unexecute();

    default boolean isReversible() {
        return true;
    }
}
