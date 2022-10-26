package task1;

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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flavor = scanner.next();
        String origin = scanner.next();

        // TODO: Uncomment the code after implementing the task.


        CandyBox candyBoxDefault = new CandyBox();
        CandyBox candyBox = new CandyBox(flavor, origin);

        System.out.println("Constructor with no parameters test:");
        System.out.println(candyBoxDefault + "\n");

        System.out.println("Constructor with parameters test:");
        System.out.println(candyBox + "\n");

        System.out.println("getVolume() test:");
        System.out.println(candyBox + " has volume " + candyBox.getVolume());

    }
}