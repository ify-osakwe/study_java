package designPatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

interface RobotInterfaceG {
    void print();


}

class SmallRobot implements RobotInterfaceG {

    @Override
    public void print() {
        System.out.println("This is a small robot");
    }

}

class LargeRobot implements RobotInterfaceG {

    @Override
    public void print() {
        System.out.println("This is a large robot");
    }

}

class RobotFactory {
    Map<String, RobotInterfaceG> shapes = new HashMap<>();

    public int totalObjectsCreate() {
        return shapes.size();
    }

    public RobotInterfaceG getRobotFromFactory(String robotCategory) throws Exception {
        RobotInterfaceG robot;
        if (shapes.containsKey(robotCategory)) {
            robot = shapes.get(robotCategory);
        } else {
            switch (robotCategory) {
                case "small":
                    System.out.println("We don't have a small one. So we are creating a small robot");
                    robot = new SmallRobot();
                    shapes.put("small", robot);
                    break;
                case "large":
                    System.out.println("We don't have a large one. So we are creating a large robot");
                    robot = new LargeRobot();
                    shapes.put("large", robot);
                    break;
                default:
                    throw new Exception("Robot factory can create only small and large shapes");
            }
        }
        return robot;
    }
}

/**
 * <p> Examples of flyweight pattern - all the wrapper classes with the valueOf() method uses cached
 * objects. Java String class String pool implementation.
 *
 * <p> Intrinsic state: can be stored in the flyweight object and is shareable.
 * Extrinsic state: depends on the flyweight's context and is not shareable
 */
public class FlyWeightPattern {
    public static void main(String[] args) throws Exception {
        RobotFactory robotFactory = new RobotFactory();
        RobotInterfaceG shape = robotFactory.getRobotFromFactory("small");
        shape.print();

        for (int i = 0; i < 2; i++) {
            shape = robotFactory.getRobotFromFactory("small");
            shape.print();
        }

        int distinctRobots = robotFactory.totalObjectsCreate();
        System.out.println("\nDistinct Robot objects created till now = " + distinctRobots + "\n");

        for (int i = 0; i < 5; i++) {
            shape = robotFactory.getRobotFromFactory("large");
            shape.print();
        }

        distinctRobots = robotFactory.totalObjectsCreate();
        System.out.println("\nFinally no. of distinct Robot objects created " + distinctRobots);
    }
}
