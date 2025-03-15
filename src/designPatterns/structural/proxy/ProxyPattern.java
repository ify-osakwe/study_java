package designPatterns.structural.proxy;

interface ImageY {
    void display();
}

class RealImage implements ImageY {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(this.fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements ImageY {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

/**
 * <p> A proxy controls and manage access to the object they are protecting. Types of proxy -
 * remote, virtual, copy-on-write, protection (access), cache, firewall, synchronization,
 * smart reference. Decorator adds behaviour to an object, Proxy controls access.
 *
 * <p> Example = Java API remote method invocation package (java.rmi.*)
 */
public class ProxyPattern {
    public static void main(String[] args) {
        ImageY image = new ProxyImage("someFileName.jpg");
        image.display();
        System.out.println(" ");

        image.display();
    }
}
