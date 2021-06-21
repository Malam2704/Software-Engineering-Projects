package assignmentThree;

public class Intersection{
    protected TrafficLight nsLight;
    protected TrafficLight ewLight;

    public Intersection(){
        this.nsLight = new TrafficLight(this, "NSLight");
        this.ewLight = new TrafficLight(this, "EWLight");
    }

    public void driveThrough(Vehicle vehicle){
        Direction dir = vehicle.getDirection();
        if(dir == Direction.NORTH || dir == Direction.SOUTH){
            if(nsLight.getCurrentColor() != LightColor.GREEN){
                // System.out.println(vehicle + " is driving through");
                // break;
                nsLight.passingVehicle = vehicle;
                try{
                    nsLight.passingVehicle.wait();
                }catch(InterruptedException j){}
            }
            System.out.println(vehicle + " is driving through");
        }else if(dir == Direction.EAST || dir == Direction.WEST){
            System.out.println(vehicle.getId() + " is getting ready to cross");
            if(nsLight.getCurrentColor() != LightColor.GREEN){
                // System.out.println(vehicle + " is driving through");
                // break;
                nsLight.passingVehicle = vehicle;
                try{
                    nsLight.passingVehicle.wait();
                }catch(InterruptedException j){}
            }
            System.out.println(vehicle + " is driving through");
            // while(true){
            //     try{
            //         vehicle.wait();
            //     }catch(InterruptedException jException){}
            //     if(ewLight.getCurrentColor() == LightColor.GREEN){
            //         System.out.println(vehicle + " is driving through");
            //         break;
            //     }
            // }
        }
    }
}
