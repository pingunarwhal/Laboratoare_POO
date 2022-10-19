package task1;

import java.util.*;

class Complex {

    private int real;
    private int imaginary;

    // TODO: Add constructors

    public Complex(int pReal, int pImg) {
        real = pReal;
        imaginary = pImg;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(Complex obj) {
        this.real = obj.real;
        this.imaginary = obj.imaginary;
    }

    // TODO: Add getters and setters

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }


    // TODO: Add addWithComplex

    void addWithComplex(Complex addMe) {
        this.real += addMe.real;
        this.imaginary += addMe.imaginary;
    }

    // TODO: Add showNumber

    void showNumber() {
        if (this.imaginary < 0) {
            System.out.println(this.real + " - i * " + Math.abs(this.imaginary));
        } else if (this.imaginary > 0) {
            System.out.println(this.real + " + i * " + Math.abs(this.imaginary));
        } else if (this.imaginary == 0) {
            System.out.println(this.real);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int real = scanner.nextInt();
        int imaginary = scanner.nextInt();

        // TODO: Uncomment the code after implementing the task.

        System.out.println("Constructors test:\n");

        Complex c1 = new Complex(real, imaginary);
        c1.showNumber();

        Complex c2 = new Complex(c1);
        c2.showNumber();

        Complex c3 = new Complex();
        c3.showNumber();

        System.out.println("\nAddWithComplex test:\n");

        c1.addWithComplex(c2);
        c1.showNumber();

        c2.addWithComplex(c3);
        c2.showNumber();

        System.out.println("\nGetters and setters test:\n");

        System.out.println(c3.getReal() + " " + c3.getImaginary());
        c3.setReal(6);
        c3.setImaginary(-4);
        System.out.println(c3.getReal() + " " + c3.getImaginary());
    }
}