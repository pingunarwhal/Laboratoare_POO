package task3;
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

    // TODO: Generate erequals() and hashCode() methods


    public boolean equals(CandyBox o) {
        if (this == o)
            return true;
        return this.flavour.equals(o.flavour) && this.origin.equals(o.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavour, origin);
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

class ChocAmor extends CandyBox {
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

        // TODO: Uncomment the code after implementing the task.

        CandyBox candyBox = new CandyBox(flavor, origin);
        CandyBox candyBoxCopy = new CandyBox(flavor, origin);
        CandyBox candyBox2 = new CandyBox("vanilla", "Belgium");

        Lindt lindtBox = new Lindt();
        Lindt lindtBoxCopy = new Lindt("sugar-free", "Switzerland", 0.0f, 0.0f, 0.0f);
        Lindt lindtBox2 = new Lindt("vanilla", "Belgium", 2.0f, 2.0f, 4.0f);

        System.out.println(candyBox.equals(candyBoxCopy));
        System.out.println(candyBox.equals(candyBox2));

        System.out.println(lindtBox.equals(lindtBoxCopy));
        System.out.println(lindtBox.equals(lindtBox2));
    }
}