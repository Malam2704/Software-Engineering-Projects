package chevre;
import java.util.ArrayList;
import java.util.List;

import chevre.ClubChevre;
import chevre.Goat;

public class Main {
    public static void main(String[] args) {
        ClubChevre club = new ClubChevre();
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<20; i++){
            Goat goat = new Goat(club);
            Thread thread =  new Thread(goat);
            thread.start();
        }

        TrollBouncer troll = new TrollBouncer(club);
        Thread thread = new Thread(troll);
        thread.start();
    }

}
