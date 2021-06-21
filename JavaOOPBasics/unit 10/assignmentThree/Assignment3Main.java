package assignmentThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment3Main {
    public static void main(String[] args) {
        Intersection insec = new Intersection();
        // TrafficLight nsLight = new TrafficLight(insec);
        // TrafficLight ewLight = new TrafficLight(insec);
        List<Thread> vehicleThreads = new ArrayList<>();
        Random RNG = new Random();

        //Thread insecThread = new Thread(insec);
        Thread nsThread = new Thread(insec.nsLight);
        Thread ewThread = new Thread(insec.ewLight);
        nsThread.start();
        ewThread.start();
        //insecThread.start();

        for(int i=1; i<101; i++){
            int enumNum = RNG.nextInt(3);
            Direction d = null;
            if(enumNum == 0){
                d = Direction.EAST;
            }else if(enumNum == 1){
                d = Direction.EAST;
            }else if(enumNum == 2){
                d = Direction.EAST;
            }else if(enumNum == 3){
                d = Direction.EAST;
            }
            Vehicle caro = new Vehicle(i, d, insec);
            Thread cThread =  new Thread(caro);
            vehicleThreads.add(cThread);
            cThread.start();
        }
    }
}
