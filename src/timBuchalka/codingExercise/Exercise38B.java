package timBuchalka.codingExercise;

public class Exercise38B {
    public static void main(String[] args) {
        WallF wall1 = new WallF("West");
        WallF wall2 = new WallF("East");
        WallF wall3 = new WallF("South");
        WallF wall4 = new WallF("North");

        CeilingF ceiling = new CeilingF(12, 55);

        BedF bed = new BedF("Modern", 4, 3, 2, 1);

        LampF lamp = new LampF("Classic", false, 75);

        BedroomF bedRoom = new BedroomF("Kelvin", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedRoom.makeBed();

        bedRoom.getLamp().turnOn();
    }
}


class BedroomF {
    private String name;
    private WallF wall1;
    private WallF wall2;
    private WallF wall3;
    private WallF wall4;
    private CeilingF ceiling;
    private final BedF bed;
    private final LampF lamp;

    public BedroomF(String name, WallF wall1, WallF wall2, WallF wall3, WallF wall4,
                    CeilingF ceiling, BedF bed, LampF lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public LampF getLamp() {
        return lamp;
    }

    public void makeBed() {
        System.out.println("Bedroom -> Making bed |");
        bed.make();
    }
}


record WallF(String direction) {
}

record CeilingF(int height, int paintedColor) {
}

record BedF(String style, int pillows, int height, int sheets, int quilt) {

    public void make() {
        System.out.println("Bed -> Making | ");
    }
}


record LampF(String style, boolean battery, int globRating) {

    public void turnOn() {
        System.out.println("Lamp -> Turning on");
    }
}

