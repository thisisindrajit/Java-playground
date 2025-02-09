package learning;
import java.util.*;

abstract class Animal {
    // instance variables
    private String picture;
    private String food;
    private boolean hunger;
    private List<int[]> boundaries;
    private int[] location;

    // abstract methods (Can be written in both ways)
    // An abstract method must always be overridden by the concrete class that is inheriting it.
    public abstract void makeNoise();
    abstract public void eat();
    abstract public void roam();

    // concrete methods
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}

abstract class Feline extends Animal {
    // method overriding
    final public void roam() {
        System.out.println("Feline is roaming");
    }
}

class Lion extends Feline {
    // method overriding
    public void makeNoise() {
        System.out.println("Lion is making noise");
    }

    public void eat() {
        System.out.println("Lion is eating");
    }

    // The roam method cannot be overridden because it is final in the parent class.
}

public class InheritanceTestDrive {
    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.makeNoise();
        lion.eat();
        lion.roam();
        lion.sleep();

        Object obj = new Lion();
        // obj.makeNoise() // This will throw an error because the reference type is Object and the Object class doesn't have the eat() method.

        if(obj instanceof Lion) {
            Lion yesItsLion = (Lion) obj; // Casting it to Lion
            yesItsLion.makeNoise();
        }
    }
}

