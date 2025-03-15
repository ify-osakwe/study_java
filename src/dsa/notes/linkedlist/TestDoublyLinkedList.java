package dsa.notes.linkedlist;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        // Create DLL
        DoublyLinkedList<Character> letterList = new DoublyLinkedList<>();
        for (char i = 97; i < 109; i++) {
            letterList.append(i);
        }
        System.out.println("LetterList = " + letterList + "\n");

        // Get and Set node at an index
        System.out.println("Node at index 3: " + letterList.get(3));
        letterList.set(3, 'z');
        System.out.println("Change node value at index 3: " + letterList + "\n");

        // Get length of list and iterate through
        System.out.println("Length of list: " + letterList.size() + "|" + letterList.getLength());
        for (Character s : letterList) {
            System.out.print(s + " | ");
        }
        System.out.println("\n");

        // Insert and delete at head and tail
        letterList.push('x');
        System.out.println("Head insertion: " + letterList);
        letterList.append('y');
        System.out.println("Tail insertion: " + letterList);
        System.out.println("\n");
        letterList.deleteHead();
        System.out.println("Delete head: " + letterList);
        letterList.deleteTail();
        System.out.println("Delete tail: " + letterList);

        // Insert at an index
        letterList.insertNth(4, 'q');
        System.out.println("Insert at index 4: " + letterList);
        letterList.deleteNth(4);
        System.out.println("Delete at index 4: " + letterList);
        System.out.println("\n");

        // Print elements
        System.out.println("Print elements");
        letterList.print();
        System.out.println("Print elements in reverse");
        letterList.printReverse();
        letterList.printReverse2();

    }
}
