// A dynamic array is a specialized array data structure that doesn't have a fixed size and can resize dynamically to accomodate more elements.

package datastructures;

public class DynamicArrayImplementation {
    public static void main(String[] args) {
        CustomDynamicArray cda = new CustomDynamicArray();

        // Test isEmpty() on a new array
        System.out.println("Is empty: " + cda.isEmpty()); // Expected: true

        // Test add() and toString()
        cda.add(1);
        cda.add(2);
        cda.add(3);
        System.out.println("Array after adding elements: " + cda.toString()); // Expected: 1, 2, 3

        // Test size()
        System.out.println("Size: " + cda.size()); // Expected: 3

        // Test get()
        System.out.println("Element at index 1: " + cda.get(1)); // Expected: 2

        // Test contains()
        System.out.println("Contains 2: " + cda.contains(2)); // Expected: true
        System.out.println("Contains 4: " + cda.contains(4)); // Expected: false

        // Test indexOf()
        System.out.println("Index of 3: " + cda.indexOf(3)); // Expected: 2
        System.out.println("Index of 4: " + cda.indexOf(4)); // Expected: -1

        // Test remove()
        cda.remove();
        System.out.println("Array after removing last element: " + cda.toString()); // Expected: 1, 2

        // Test addAt()
        cda.addAt(1, 4);
        System.out.println("Array after adding 4 at index 1: " + cda.toString()); // Expected: 1, 4, 2

        // Test removeAt()
        cda.removeAt(1);
        System.out.println("Array after removing element at index 1: " + cda.toString()); // Expected: 1, 2

        // Test resizing
        for (int i = 4; i <= 15; i++) {
            cda.add(i);
        }
        System.out.println("Array after adding more elements: " + cda.toString()); // Expected: 1, 2, 4, 5, ..., 15
        System.out.println("Size after resizing: " + cda.size()); // Expected: 14
    }
}

// TODO: Change the implementation later to include generics so that the dynamic
// array can store any kinds of similar elements. Also include exception
// handling.
final class CustomDynamicArray {
    private int capacity;
    private int[] arr;
    private int nextIndexToStoreAt;

    // Constructors
    public CustomDynamicArray() {
        capacity = 10; // This is the default capacity that is set if no custom capacity is given
        arr = new int[capacity];
        nextIndexToStoreAt = 0;
    }

    // Parameterized constructor
    public CustomDynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        nextIndexToStoreAt = 0;
    }

    // Methods
    // Helper methods
    private boolean resize() {
        this.capacity *= 2;
        int[] new_arr = new int[capacity];

        // Copying old array to new array
        for (int i = 0; i < nextIndexToStoreAt; i++) {
            new_arr[i] = arr[i];
        }

        arr = new_arr;
        // Once the reference of arr is changed to new_arr, the old array will
        // automatically be garbage collected as no reference will be available for the
        // old array

        return true;
    }

    // Standard methods
    public int size() {
        return nextIndexToStoreAt;
    }

    public boolean isEmpty() {
        return nextIndexToStoreAt == 0;
    }

    // Reading
    public int get(int index) {
        if (index < 0 || index >= nextIndexToStoreAt) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nextIndexToStoreAt);
        }

        return arr[index];
    }

    public boolean contains(int value) {
        for (int idx = 0; idx < nextIndexToStoreAt; idx++) {
            if (arr[idx] == value) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(int value) {
        for (int idx = 0; idx < nextIndexToStoreAt; idx++) {
            if (arr[idx] == value) {
                return idx;
            }
        }

        return -1;
    }

    // Writing
    public boolean add(int value) {
        // Check if array has reached capacity and if yes, resize
        if (nextIndexToStoreAt == capacity) {
            boolean isResizeSuccessful = resize();

            if (isResizeSuccessful) {
                arr[nextIndexToStoreAt++] = value;
            }

            return isResizeSuccessful;
        }

        // Else just insert at the next index and increment nextIndexToStoreAt
        arr[nextIndexToStoreAt++] = value;

        return true;
    }

    private boolean addElementAtIndex(int index, int value) {
        if (index >= nextIndexToStoreAt || index < 0) {
            return false;
        }

        for (int i = nextIndexToStoreAt - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = value;

        nextIndexToStoreAt++;

        return true;
    }

    public boolean addAt(int index, int value) {
        if (nextIndexToStoreAt == capacity) {
            return resize() && addElementAtIndex(index, value);
        }

        return addElementAtIndex(index, value);
    }

    // Deleting
    public boolean remove() {
        // First decrement the nextIndexToStoreAt, and then reset the value at that
        // index to 0
        arr[--nextIndexToStoreAt] = 0;

        return true;
    }

    public boolean removeAt(int index) {
        if (index >= nextIndexToStoreAt || index < 0) {
            return false;
        }

        for (int i = index; i < nextIndexToStoreAt - 1; i++) {
            arr[i] = arr[i + 1];
        }

        nextIndexToStoreAt--;
        arr[nextIndexToStoreAt] = 0;

        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "No elements!";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nextIndexToStoreAt; i++) {
            sb.append(String.valueOf(arr[i]));

            if (i != nextIndexToStoreAt - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}