package learning;
// By default, class is private
public class Rough {
    private int size;
    private int weight;
    private static String staticVariable;

    // This is the static block which initializes the static variable
    static {
        staticVariable = "Static Variable";
    }

    public Rough(int size, int weight) {
        this.size = size;
        this.weight = weight;
    }

    public static void main(String[] args) {
        // Checking if float f = 3.0 and int i = 3 are equal
        float f = 3.0f;
        int i = 3;

        System.out.println(f == i); // This will return true. // Why? Because Java converts the float to int and then compares the values.

        // ---------------------------------------------------
        
        Rough p1 = new Rough(10, 20);
        Rough p2 = new Rough(10, 20);

        System.out.println(p1.equals(p2)); // This will return false

        // But why does it return false?
        // Because the default implementation of equals() method in Object class
        // compares the memory addresses of the objects, not the values of the objects.
        // So, we need to override the equals() method in our class to compare the values
        // of the objects.

        // Then how does string comparison work?
        // Strings are objects in Java. When we compare two strings using the equals() method,
        // it compares the values of the strings, not the memory addresses.
        // This is because the equals() method in the String class is overridden to compare the values
        // of the strings.

        // ---------------------------------------------------

        // String declaredButNotInitialized;

        // System.out.println(declaredButNotInitialized); // This will throw an error

        // Why does this throw an error?
        // Because the variable declaredButNotInitialized is declared but not initialized.
        // So, it doesn't have any value. So, when we try to print it, it throws an error.

        String myList[] = new String[1];
        String a = "Frog";
        String b = "Frog";

        myList[0] = a;

        System.out.println(myList[0] == a); // This will return true
        System.out.println(a.equals(myList[0])); // This will return true
        System.out.println(myList[0].equals(a)); // This will return true

        // So these two strings point to the same memory address. But why?
        // Because Java uses a concept called String Pool. When we create a string using
        // the double quotes, Java checks if the string is already present in the String Pool.
        // If it is present, it returns the reference to the string in the String Pool.
        // If it is not present, it creates a new string in the String Pool and returns the reference to it.
        // String pool is also called as String constant pool.
        System.out.println(a == b); // This will return true

        float f2 = 3.15f; // If f is not mentioned, it will be considered as double by default, which will throw an error

        System.out.println(f2);
    } 
}
