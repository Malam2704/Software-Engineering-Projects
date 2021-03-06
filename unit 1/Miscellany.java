import java.util.Arrays;

public class Miscellany {
    public static boolean palindrome(String input){
        for( int i=0; i < input.length(); i++){
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static int[] squares(int n){
        // make an array big enoguh to hold n integers
        int[] square = new int[n];
        // set the vlaue at every index (0 to length-1) to index^2
        for(int index=0;index<n; index++) {
            int squared = index * index;
            square[index] = squared;
        }
        // return the array
        return square;
    }

    public static int[][] multiplicationTable(int rows, int cols) {
        int[][] table = new int[rows][cols];

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                table[row][col] = (row+1) * (col+1);
            }
        }

        return table;
    }

    public static void main(String[] args) {
        int[][] table = multiplicationTable(8,9);
        for (int i=0; i<8; i++) {
            int[] row = table[i];
            System.out.println(Arrays.toString(row));
        }
    }
}
