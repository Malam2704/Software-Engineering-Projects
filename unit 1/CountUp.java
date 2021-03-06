public class CountUp {
    
    public static int CountWhile(int n) {
        int sum = 0;
        int count = 0;
        while (count <= n) {
            System.out.println(count);
            sum += count;
            count++;
        }
        return sum;
    }

    public static int CountFor(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountWhile(7);
        CountFor(7);
    }
}
