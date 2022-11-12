package task4;

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
        return (float) (this.height * this.radius * this.radius * Math.PI);
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

class CandyBag {
    // Add ArrayList as field "candies"

    private CandyBox[] candies;

    // Constructor which populates the array list (the default gift)

    public CandyBag() {
        Lindt lindt1 = new Lindt("cherry", "Austria", 20, 5.4f, 19.2f);
        Lindt lindt2 = new Lindt("apricot", "Austria", 20, 5.4f, 19.2f);
        Lindt lindt3 = new Lindt("strawberry", "Austria", 20, 5.4f, 19.2f);
        Baravelli baravelli1 = new Baravelli("grape", "Italy", 6.7f, 8.7f);
        ChocAmor chocAmor1 = new ChocAmor("coffee", "France", 5.5f);
        ChocAmor chocAmor2 = new ChocAmor("vanilla", "France", 5.5f);
        this.candies = new CandyBox[] {lindt1, lindt2, lindt3, baravelli1, chocAmor1, chocAmor2};
    }
    // Add getter and setter

    public CandyBox[] getCandies() {
        return candies;
    }

    public void setCandies(CandyBox[] candies) {
        this.candies = candies;
    }
}

public class Main {
    public static void main(String[] args) {

        // TODO: Uncomment the code after implementing the task.

        CandyBag presentBag = new CandyBag();

		for (int i = 0; i < presentBag.getCandies().length; i++) {
			System.out.println(presentBag.getCandies()[i]);
		}
    }
}