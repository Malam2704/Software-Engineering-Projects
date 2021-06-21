package chevre;

public class TrollBouncer implements Runnable{
    private ClubChevre club;

    public TrollBouncer(ClubChevre club){
        this.club = club;
    }

    @Override
    public void run() {
        while(true){
            // if the club is not fill and there is atleast one goat
            // in line, move the goat to the club
            synchronized(club){
                while(!club.isAtCapacity() && club.numberOfGoatsInLine() > 0){
                    // choose a goat at index 0
                    Goat goat = club.getGoatAtPosition(0);
                    // remove the goat form the line
                    club.removeGoatFromLine(goat);
                    // move goat to dance floor
                    club.startDancing(goat);
                    // notify the goat
                    synchronized(goat){
                        goat.notify();
                    }
                }
            }

            // if wait
            synchronized(this){
                try{
                    this.wait();
                }catch(InterruptedException j){
                    // catch
                }
            }

            
        }


    }
}
