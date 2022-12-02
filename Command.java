package src.CommandOperation;

public interface Command {
    void execute();
    void unexecute();

    default boolean isReversible() {
        return true;
    }
}
