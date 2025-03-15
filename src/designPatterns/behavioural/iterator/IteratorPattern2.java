package designPatterns.behavioural.iterator;

import java.util.LinkedList;

interface SubjectInterface {
    IteratorF createIterator();
}

interface IteratorF {
    void first();

    String next();

    boolean isDone();

    String currentItem();
}

class ArtSubjects implements SubjectInterface {
    private String[] subjects;

    public ArtSubjects() {
        subjects = new String[2];
        subjects[0] = "Bengali";
        subjects[1] = "English";
    }

    @Override
    public IteratorF createIterator() {
        return new ArtsIterator(subjects);
    }
}

class ScienceSubjects implements SubjectInterface {
    private LinkedList<String> subjects;

    public ScienceSubjects() {
        subjects = new LinkedList<>();
        subjects.addLast("Maths");
        subjects.addLast("Computer Science");
        subjects.addLast("Physics");
    }

    @Override
    public IteratorF createIterator() {
        return new ScienceIterator(subjects);
    }
}

class ArtsIterator implements IteratorF {
    private String[] subjects;
    int position;

    public ArtsIterator(String[] subjects) {
        this.subjects = subjects;
        position = 0;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public String next() {
        return subjects[position++];
    }

    @Override
    public boolean isDone() {
        return position >= subjects.length;
    }

    @Override
    public String currentItem() {
        return subjects[position];
    }
}

class ScienceIterator implements IteratorF {
    private LinkedList<String> subjects;
    private int position;

    public ScienceIterator(LinkedList<String> subjects) {
        this.subjects = subjects;
        position = 0;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public String next() {
        return subjects.get(position++);
    }

    @Override
    public boolean isDone() {
        return position >= subjects.size();
    }

    @Override
    public String currentItem() {
        return subjects.get(position);
    }
}

public class IteratorPattern2 {
    public static void main(String[] args) {
        SubjectInterface scienceSubject = new ScienceSubjects();
        SubjectInterface artsSubject = new ArtSubjects();

        IteratorF scienceIterator = scienceSubject.createIterator();
        IteratorF artsIterator = artsSubject.createIterator();

        System.out.println("\nScience subjects::");
        print(scienceIterator);

        System.out.println("\nArts subjects::");
        print(artsIterator);

    }

    public static void print(IteratorF iterator) {
        while (!iterator.isDone()) {
            System.out.println(iterator.next());
        }
    }
}
