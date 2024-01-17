package designPatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

interface RobotInterfaceT {
    void print();

    void setColor(String colorOfRobot);
}

class RobotT implements RobotInterfaceT {
    String robotType;
    String colorOfRobot;

    public RobotT(String robotType) {
        this.robotType = robotType;
    }

    @Override
    public void setColor(String colorOfRobot) {
        this.colorOfRobot = colorOfRobot;
    }

    @Override
    public void print() {
        System.out.println("This is a " + robotType + " type robot with " + colorOfRobot + " color.");
    }
}

class RobotFactoryT {
    Map<String, RobotInterfaceT> shapes = new HashMap<>();

    public int totalObjectsCreate() {
        return shapes.size();
    }

    public RobotInterfaceT getRobotFromFactory(String robotType) throws Exception {
        RobotInterfaceT robot;
        if (shapes.containsKey(robotType)) {
            robot = shapes.get(robotType);
        } else {
            switch (robotType) {
                case "King":
                    System.out.println("We don't have a king. So we are creating a King robot");
                    robot = new RobotT("King");
                    shapes.put("small", robot);
                    break;
                case "Queen":
                    System.out.println("We don't have a queen. So we are creating a Queen robot");
                    robot = new RobotT("Queen");
                    shapes.put("large", robot);
                    break;
                default:
                    throw new Exception("Robot factory can create only King and Queen");
            }
        }
        return robot;
    }
}

public class FlyWeightPattern2 {
    public static void main(String[] args) throws Exception {
        RobotFactoryT robotFactory = new RobotFactoryT();
        RobotT shape;

        for (int i = 0; i < 3; i++) {
            shape = (RobotT) robotFactory.getRobotFromFactory("King");
            shape.setColor(getRandomColor());
            shape.print();
        }

        for (int i = 0; i < 3; i++) {
            shape = (RobotT) robotFactory.getRobotFromFactory("Queen");
            shape.setColor(getRandomColor());
            shape.print();
        }

        int distinctRobots = robotFactory.totalObjectsCreate();
        System.out.println("distinct robot objects created " + distinctRobots);
    }

    static String getRandomColor() {
        Random random = new Random();
        int randomInt = random.nextInt(20);
        if (randomInt % 2 == 0) {
            return "red";
        } else {
            return "green";
        }
    }
}
