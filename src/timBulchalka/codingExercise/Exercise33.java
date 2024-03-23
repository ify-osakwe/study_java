package timBulchalka.codingExercise;

public class Exercise33 {
    public static void main(String[] args) {
        Point33 first = new Point33(6, 5);
        Point33 second = new Point33(3, 1);
        System.out.println("distance(0,0)= " + first.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        Point33 point = new Point33();
        System.out.println("distance()= " + point.distance());
    }
}

class Point33 {
    private int x;
    private int y;

    public Point33() {
    }

    public Point33(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Method to calculate distance between two points
     * To find a distance between points A(xA,yA) and B(xB,yB), we use the formula:
     * d(A,B)=√ (xB − xA) * (xB - xA) + (yB − yA) * (yB - yA)
     * Where √ represents square root.
     */
    public double distance(Point33 anotherPoint) {
        int xDiff = this.x - anotherPoint.getX();
        int yDiff = this.y - anotherPoint.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Method to calculate distance between two points specified by coordinates
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
