public class Printer extends Thread {
    private final String string;

    public Printer(String string){
        this.string = string;
    }

    @Override
    public void run() {
        for(char c : this.string){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Printer thread = new Printer("s");
        thread.start();
    }
}
