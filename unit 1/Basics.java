public class Basics {
    public static boolean Multiples(int n) {
        if (n % 3 == 0 && n % 7 == 0){
            return false;
        } else if(n % 3 == 0){
            return true;
        } else if(n % 7 == 0){
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        for(int j = 0; j <= 100; j++){
            System.out.println("The number " + j + " is " + Multiples(j));
        }
    }
}
