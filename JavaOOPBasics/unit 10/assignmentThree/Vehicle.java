package assignmentThree;

public class Vehicle implements Runnable{
    private int id;
    private Direction direction;
    private Intersection intersection;

    public Vehicle(int id, Direction d, Intersection insec){
        this.id = id;
        this.direction = d;
        this.intersection = insec;
    }   

    public Direction getDirection() {
        return direction;
    }public int getId() {
        return id;
    }public Intersection getIntersection() {
        return intersection;
    }

    public void stopping(){
        try{
            this.wait();
        }catch(InterruptedException jException){}
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        intersection.driveThrough(this);
    }
    
}
