package learning;

interface Animal {
    int age = 10;

    // public abstract methods
    void makeNoise();
    void eat();
    void roam();
}

class Lion implements Animal {
    private static String color;

    static {
        color = "Yellow"; 
    }

    @Override
    public void makeNoise() {
        System.out.println("Lion makes noise");
    }

    @Override
    public void eat() {
        System.out.println("Lion eats meat");
    }

    @Override
    public void roam() {
        System.out.println(color + " colored lion of age " + age + " roams in savannah");
    }
}

public class InterfacesTestDrive {
    public static void main(String[] args) {
        Lion lion = new Lion();

        // Interface variables are static and final by default. That is why we can access them directly using the object name.
        System.out.println(Lion.age);

        lion.makeNoise();
        lion.eat();
        lion.roam();
    }
}
