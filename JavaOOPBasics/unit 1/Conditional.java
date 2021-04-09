public class Conditional {
    public static void evenlydivisible(int n) {
        if (n % 2 == 0){
            System.out.println("n is even");
        } else if(n % 3 == 0){
            System.out.println("n is divisible by 3");
        } else if(n % 5 == 0){
            System.out.println("n is divisible by 5");
        } else {
            System.out.println("n is odd but not divisble by 3 or 5");
        }
        return;
    }

    public static void main(String[] args) {
        evenlydivisible(7);
    }
}
