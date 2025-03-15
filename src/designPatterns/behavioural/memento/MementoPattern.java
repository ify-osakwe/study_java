package designPatterns.behavioural.memento;

class FileWriterUtil {
    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String fileName) {
        this.fileName = fileName;
        this.content = new StringBuilder();
    }

    @Override
    public String toString() {
        return this.content.toString();
    }

    public void write(String string) {
        content.append(string);
    }

    public Memento save() {
        return new Memento(this.fileName, this.content);
    }

    public void undoToLastSave(Object object) {
        Memento memento = (Memento) object;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    // A memento does not always have to be an inner class
    private class Memento {
        private String fileName;
        private StringBuilder content;

        public Memento(String fileName, StringBuilder content) {
            this.fileName = fileName;
            this.content = new StringBuilder(content);
        }
    }
}

class FileWriterCaretaker {
    private Object object;

    public void save(FileWriterUtil fileWriter) {
        this.object = fileWriter.save();
    }

    public void undo(FileWriterUtil fileWriter) {
        fileWriter.undoToLastSave(object);
    }
}

public class MementoPattern {
    public static void main(String[] args) {
        FileWriterCaretaker caretaker = new FileWriterCaretaker();
        FileWriterUtil fileWriterUtil = new FileWriterUtil("data_.txt");

        fileWriterUtil.write("First set of data:\nMyra\nLucy\n");
        System.out.println(fileWriterUtil + "\n\n");

        caretaker.save(fileWriterUtil);
        fileWriterUtil.write("Second set of data:\nJason\n");
        System.out.println(fileWriterUtil + "\n\n");

        caretaker.undo(fileWriterUtil);
        System.out.println(fileWriterUtil + "\n\n");

    }
}
