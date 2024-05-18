package timBuchalka.codingExercise;

public class Exercise38 {
    public static void main(String[] args) {
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedRoom = new Bedroom("Kelvin", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedRoom.makeBed();

        bedRoom.getLamp().turnOn();
    }
}

class Bedroom {
    private String name;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall wall1, Wall wall2, Wall wall3, Wall wall4, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public void makeBed() {
        System.out.println("Bedroom -> Making bed |");
        bed.make();
    }
}


class Wall {
    private final String direction;

    // Constructor
    public Wall(String direction) {
        this.direction = direction;
    }

    // Method to get the direction of the wall
    public String getDirection() {
        return direction;
    }
}

class Ceiling {
    private final int height;
    private final int paintedColor;

    // Constructor
    public Ceiling(int height, int paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    // Method to get the height of the ceiling
    public int getHeight() {
        return height;
    }

    // Method to get the painted color of the ceiling
    public int getPaintedColor() {
        return paintedColor;
    }
}

class Bed {
    private final String style;
    private final int pillows;
    private final int height;
    private final int sheets;
    private final int quilt;

    // Constructor
    public Bed(String style, int pillows, int height, int sheets, int quilt) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
    }

    // Method to make the bed
    public void make() {
        System.out.println("Bed -> Making | ");
    }

    // Method to get the bed style
    public String getStyle() {
        return style;
    }

    // Method to get the number of pillows
    public int getPillows() {
        return pillows;
    }

    // Method to get the height of the bed
    public int getHeight() {
        return height;
    }

    // Method to get the number of sheets
    public int getSheets() {
        return sheets;
    }

    // Method to get the value of quilt
    public int getQuilt() {
        return quilt;
    }
}


class Lamp {
    private final String style;
    private final boolean battery;
    private final int globRating;

    // Constructor
    public Lamp(String style, boolean battery, int globRating) {
        this.style = style;
        this.battery = battery;
        this.globRating = globRating;
    }

    // Method to turn on the lamp
    public void turnOn() {
        System.out.println("Lamp -> Turning on");
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobRating() {
        return globRating;
    }
}

