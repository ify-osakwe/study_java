package timBuchalka.classes;

import timBuchalka.UtilsX;

class Main {
    public static void main(String[] args) {
        Record00 record00 = new Record00("Birth", 20);
        System.out.println(record00);

        UtilsX.newLineSpace();

//        Record00 record001 = new Record00(30);
//        System.out.println(record001);
    }
}

public record Record00(String name, int period) {
    public Record00 {
        System.out.println("INIT FROM COMPACT CONSTRUCTOR");
    }

    public Record00(int period) {
        this("BIRTH FROM CUSTOM CONSTRUCTOR", period);
    }

    // this 2nd canonical constructor can exist when you remove
    // the compact and custom constructor
//    public Record00(String name, int period) {
//        this.name = name + " FROM 2ND CANONICAL CONSTRUCTOR";
//        this.period = period;
//    }


}
