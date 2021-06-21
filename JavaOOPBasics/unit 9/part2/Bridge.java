package part2;

public class Bridge {
    // field to check fi the bridge is empty.
    protected static boolean emptyBridge = true;
    // number fo people that ahve walked the bridge not inclu
    // uding the troll
    protected static int bridgeWalkers = 0;
    // Waittime to allow for the people to arrive at the bridge.
    // And time for the printing.
    protected static int waitTime = 2000;

    // getters and setters
    public static boolean getEmptyBridge(){
        return emptyBridge;
    }public static int getWaitTime() {
        return waitTime;
    }
    // Waititme is increased based on 
    // the Woolie's cross time and the number of people
    // waiting to walk the bridge after they enter.
    public static void increaseWaitTime(Woolie j) {
        waitTime += (j.getCrossTime()*1000) + (bridgeWalkers * 1000);
    }

    // When asked to enter the bridge it adds to the bridge
    // walkers and turns the empty bridge full.
    public static void enterBridge(){
        bridgeWalkers ++;
        if(emptyBridge){
            emptyBridge = false;
        }
    }

    // turns bridge emtpy when the woolie wlaks out.
    public static void leaveBridge(){
        if(!emptyBridge){
            emptyBridge = true;
        }
    }

}
