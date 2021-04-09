/* 
A different version of the TOy class, where I can make a robot that's default to
0 charge, and I can onyl play with it when it has jucie left
*/

package toys;

public class Robot extends Toy{
    protected int charge;
    private final String sound;

    public Robot(String name, double MSRP, String sound){
        super(name,MSRP);
        this.charge = 0;
        this.sound = sound;
    }

    public void charge() {
        if (charge < 100){
            this.charge =  100;
            System.out.println("Battery is full");
        }else{
            System.out.println("Battery is already full");
        }
    }

    public int getCharge() {
        return charge;
    }

    // Says the prewritten phrase I chose, and for each time,
    // I am playing it loses 20% battery, if the charge is below 20
    // null is returned because I can't play with it, and ti prints that it needs charge
    @Override
    public String Play() {
        if(charge >= 20){
            charge -= 20;
            return this.sound;
        }else{
            System.out.println("Charge me!");
            return null;
        }
    }

    @Override
    public String toString() {
        return ("Name: " + this.name +", Product Code: " + this.code + ", MSRP: $" + this.MSRP + ", Battery: " + this.charge +"%");
    }
}
