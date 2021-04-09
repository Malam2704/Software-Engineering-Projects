package activities;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an array big enough to hld atleast 5 values
        Object[] my_array = new Object[5];
        // try to set the value at every index in the array to some different
        // type, e.g, String, Ship, int, boolean, Year
        my_array[0] = 1;
        my_array[1] = "foo";
        // Use Arrays.toStrign to pritn it out
        System.out.println(Arrays.toString(my_array));
    }
}
