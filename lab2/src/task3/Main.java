package task3;

import java.util.*;

class Point {

    float x;
    float y;

    // TODO: Add constructor.

    public Point(float xInput, float yInput) {
        this.x = xInput;
        this.y = yInput;
    }

    // TODO: Add changeCoords.

    public void changeCoords(float xInput, float yInput) {
        this.x = xInput;
        this.y = yInput;
    }

    // TODO: Add showPoint.

    public void showPoint() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

}

class Polygon {

    Point[] points;

    // TODO: Add constructors.

    public Polygon(int nrCorners) {
        points = new Point[nrCorners];
    }

    public Polygon(float[] coords) {
        this(coords.length / 2);
        int j = 0;
        for (int i = 0; i < coords.length / 2; i++) {
            this.points[i] = new Point(coords[j++], coords[j++]);
        }
    }

    // TODO: Add showPolygon.

    public void showPolygon() {
        // System.out.println(this.points.length);
        for (int i = 0; i < this.points.length; i++) {
            this.points[i].showPoint();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float x1 = scanner.nextFloat();
        float y1 = scanner.nextFloat();
        float x2 = scanner.nextFloat();
        float y2 = scanner.nextFloat();

        // TODO: Uncomment the code after implementing the task.
        Point point = new Point(x1, y1);
        point.showPoint();

        point.changeCoords(x2, y2);
        point.showPoint();

        int n = scanner.nextInt();
        float[] points = new float[n];

        for(int i = 0; i < n; i++) {
            points[i] = i;
        }

        Polygon polygon = new Polygon(points);
        System.out.println("Poligonul are urmatoarele coordonate:");
        polygon.showPolygon();

    }
}
