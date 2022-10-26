package task2;

import java.util.*;

class CandyBox {
    // TODO[0]: Add fields

    private String flavour;

    private String origin;

    // TODO[1]: Constructor without parameters which initialize all the fields

    public CandyBox() {
        this.flavour = "sugar-free";
        this.origin = "Switzerland";
    }

    // TODO[2]: Constructor with parameters

    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }

    // TODO[3]: Add getVolume() method

    public float getVolume() {
        return 0;
    }

    // TODO[4]: Generate toString() method - "The [origin] [flavor] chocolate"

    @Override
    public String toString() {
        return "The " + this.origin + " " + this.flavour + " chocolate";
    }

    // TODO[0]: Add getters and setters


    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

class Lindt extends CandyBox {
    // TODO[0]: Add fields

    private float length;

    private float width;

    private float height;

    // TODO[1]: Constructor without parameters

    public Lindt() {
        this.length = 0;
        this.height = 0;
        this.width = 0;
    }

    // TODO[2]: Constructor which initialize all fields (using super keyword)

    public Lindt(String flavour, String origin, float length, float width, float height) {
        super(flavour, origin);
        this.width = width;
        this.length = length;
        this.height = height;
    }

    // TODO[3]: Override getVolume() method

    @Override
    public float getVolume() {
        return this.height * this.length * this.width;
    }

    // TODO[4]: Override toString() method - "The [origin] [flavor] has volume [volume]"

    @Override
    public String toString() {
        return "Lindt: " + super.toString() + " has volume " + this.getVolume();
    }

    // TODO[0]: Add getters and setters


    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Baravelli extends CandyBox {
    // TODO[0]: Add fields

    private float radius;

    private float height;

    // TODO[1]: Constructor without parameters

    public Baravelli() {
        this.radius = 0;
        this.height = 0;
    }

    // TODO[2]: Constructor which initialize all fields (using super keyword)

    public Baravelli(String flavour, String origin, float radius, float height) {
        super(flavour, origin);
        this.radius = radius;
        this.height = height;
    }

    // TODO[3]: Override getVolume() method

    @Override
    public float getVolume() {
        return this.height * this.radius * this.radius * (float)Math.PI;
    }

    // TODO[4]: Override toString() method - "The [origin] [flavor] has volume [volume]"

    @Override
    public String toString() {
        return "Baravelli: " + super.toString() + " has volume " + this.getVolume();
    }

    // TODO[0]: Add getters and setters

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class ChocAmor extends CandyBox{
    // TODO[0]: Add fields

    private float length;

    // TODO[1]: Constructor without parameters

    public ChocAmor() {
        this.length = 0;
    }

    // TODO[2]: Constructor which initialize all fields (using super keyword)

    public ChocAmor(String flavour, String origin, float length) {
        super(flavour, origin);
        this.length = length;
    }

    // TODO[3]: Override getVolume() method

    @Override
    public float getVolume() {
        return this.length * this.length * this.length;
    }

    // TODO[4]: Override toString() method - "The [origin] [flavor] has volume [volume]"

    @Override
    public String toString() {
        return "ChocAmor: " + super.toString() + " has volume " + this.getVolume();
    }

    // TODO[0]: Add getters and setters

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flavor = scanner.next();
        String origin = scanner.next();
        float length = scanner.nextFloat();
        float width = scanner.nextFloat();
        float height = scanner.nextFloat();
        float radius = scanner.nextFloat();

        // TODO: Uncomment the code after implementing the task.

        Lindt lindtBoxDefault = new Lindt();
        Lindt lindtCandyBox = new Lindt(flavor, origin, length, width, height);
        Baravelli baravelliCandyBox = new Baravelli(flavor, origin, radius, height);
        ChocAmor chocAmorCandyBox = new ChocAmor(flavor, origin, length);

        System.out.println(lindtBoxDefault);
        System.out.println(lindtCandyBox);
        System.out.println(baravelliCandyBox);
        System.out.println(chocAmorCandyBox);
    }
}