package designPatterns.behavioural.command;

public interface FileSystemReceiver {
    void openFile();

    void writeFile();

    void closeFile();
}

class UnixFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in Unix OS");
    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in Unix OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in Unix oS");
    }
}

class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS");
    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows oS");
    }
}