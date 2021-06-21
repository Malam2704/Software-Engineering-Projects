package chevre;

public class Goat implements Runnable{
    private ClubChevre club;
    private String name;
    private int coolness;
    private int stamina;

    public Goat(ClubChevre club){
        this.club = club;
        this.name = Utils.makeGoatName();
        this.coolness = Utils.getRandomNumber(1, 100);
        this.stamina = Utils.getRandomNumber(5, 10);
    }

    public int getCoolness() {
        return coolness;
    }public String getName() {
        return name;
    }public int getStamina() {
        return stamina;
    }

    @Override
    public void run() {
        synchronized(club){
            System.out.println(name + " is getting in line S" + 
                club.numberOfGoatsInLine() + " other goats.");
            // get into line outside the club
            club.getInLine(this);
        }
        
        // wait to be picked by the troll
        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // catch
            }
        }

        System.out.println(name + " has been picked by the troll!");
    
        for(int i=0; i<stamina; i++){
            System.out.println(name + " is dancing the ngiht away!");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException j){
                // squash
            }
        }

        // goat stop danicng, thread saflet
        // notfy the troll a spot ahs opened up
        System.out.println(name + " has stopped dancing and headed hoemf ro teh night");
        synchronized(club){
            club.startDancing(this);
            club.notify();
        }
    }

    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        Goat goat = new Goat(club);
        Thread thread =  new Thread(goat);
    }
}
