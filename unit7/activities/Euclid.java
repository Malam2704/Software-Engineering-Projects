package activities;

public class Euclid {
    public static int gcd(int a, int b){
        // if A > b then A = A -B
        // vice versa for B
        while(a != b){
            if(a>b){
                a = a - b;
            }else{
                b = b - a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(100, 45));
        System.out.println(gcd(13, 111));
    }
}
