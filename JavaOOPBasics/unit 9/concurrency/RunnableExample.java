package concurrency;

public class RunnableExample implements Runnable {
    private final int id;
    public RunnableExample (int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id);
    }

    public static void main(String[] args) {
        Runnable example = new RunnableExample(1);
        Thread 
    }
}
