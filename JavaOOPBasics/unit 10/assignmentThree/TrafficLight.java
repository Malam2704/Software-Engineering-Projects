package assignmentThree;

public class TrafficLight implements Runnable{
    private String name;
    private LightColor currentColor;
    private Intersection intersection;
    protected Vehicle passingVehicle;
    
    public TrafficLight(Intersection insec, String name){
        this.currentColor = LightColor.RED;
        this.intersection = insec;
        this.name = name;
    }

    public LightColor getCurrentColor() {
        return currentColor;
    }public Intersection getIntersection() {
        return intersection;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(this + " is Red");
                Thread.sleep(1000);
                this.currentColor = LightColor.GREEN;
                System.out.println(this + " is now Green");
                synchronized(passingVehicle) {
                    this.notifyAll();
                }
                Thread.sleep(5000);
                this.currentColor = LightColor.YELLOW;
                System.out.println(this + " is now Yellow");
                Thread.sleep(2000);
                this.currentColor = LightColor.RED;
                System.out.println(this + " is now Red");
                this.wait();
            } catch (InterruptedException j){
                System.err.println("It be like that sometimes!");
            }
	    }
	}

    
}
