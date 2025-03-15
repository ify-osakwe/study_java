package timBuchalka.classes;

import java.util.ArrayList;
import java.util.List;

public class Interface01 {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House",
                UsageType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", UsageType.SPORTS));

        mappables.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for (var m : mappables) {
            Mappable.mapIt(m);
        }
    }
}

enum Geometry {LINE, POINT, POLYGON}

enum Color {BLACK, BLUE, GREEN, ORANGE, RED}

enum PointMarker {CIRCLE, PUSH_PIN, STAR, SQUARE, TRIANGLE}

enum LineMarker {DASHED, DOTTED, SOLID}

interface Mappable {

    String JSON_PROPERTY = """
            "properties": {%s}""";

    String getLabel();

    Geometry getShape();

    String getMarker();

    default String toJSON() {
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable) {
        //System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
        System.out.printf((JSON_PROPERTY) + "%n", mappable.toJSON());
    }
}


enum UsageType {ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORTS}

class Building implements Mappable {

    private final String name;
    private final UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case GOVERNMENT -> Color.RED + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.BLUE + " " + PointMarker.SQUARE;
            case SPORTS -> Color.ORANGE + " " + PointMarker.PUSH_PIN;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, usage);
    }
}

enum UtilityType {ELECTRICAL, FIBER_OPTIC, GAS, WATER}

class UtilityLine implements Mappable {

    private final String name;
    private final UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "utility": "%s" """.formatted(name, type);
    }
}

