package by.nulay.taskexecutor;

/**
 * Created by miha on 14.05.2017.
 * Class execute some task
 */
public interface TaskExecutor {
    /**
     * Method start execute task
     * @param task task
     */
    void execute(Task task);
}
