package designPatterns.behavioural.command;

public class FileInvoker {
    private CommandInterface commandInterface;

    public FileInvoker(CommandInterface commandInterface) {
        this.commandInterface = commandInterface;
    }

    public void execute() {
        commandInterface.execute();
    }
}
