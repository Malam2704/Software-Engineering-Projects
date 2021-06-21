package graphs;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Clockwall{
    // Clock interface
    private interface Clock {
        String getTime();
    }

    public static void main(String[] args) {
        Map<String,Clock> mappo = new HashMap<>();

        // Previous attempt
        // int width = 5;
        // int height = 3;
        // v -> { width * height};
        //System.out.println((int hour, int minute) -> (hour + ":" + minute));
        
        // 4 instances of the time class where the 
        // return is essentially the call of getTime
        // I used the exmaple shown with the zoneoffset.ofHours and utc
        // zone as the int parameter.
        Clock nyc = () -> {
            LocalTime now = LocalTime.now(ZoneOffset.ofHours(-4));
            int hour = now.getHour();
            int minute = now.getMinute();
            return hour + ":" + String.format("%02d", minute);
        };
        Clock london = () -> {
            LocalTime now = LocalTime.now(ZoneOffset.ofHours(1));
            int hour = now.getHour();
            int minute = now.getMinute();
            return hour + ":" + String.format("%02d", minute);
        };
        Clock tokyo = () -> {
            LocalTime now = LocalTime.now(ZoneOffset.ofHours(9));
            int hour = now.getHour();
            int minute = now.getMinute();
            return hour + ":" + String.format("%02d", minute);
        };
        Clock dubai = () -> {
            LocalTime now = LocalTime.now(ZoneOffset.ofHours(4));
            int hour = now.getHour();
            int minute = now.getMinute();
            return hour + ":" + String.format("%02d", minute);
        };
        // System.out.println(dubai.getTime());

        // Adding to the map
        mappo.put("Dubai", dubai);
        mappo.put("New York City", nyc);
        mappo.put("London", london);
        mappo.put("Tokyo", tokyo);

        // for loop to display all the times by getting the set
        // of keys and callign get time on each of them with the map
        // combiend with a pritn statement for saying the key and it's time
        for(String j : mappo.keySet()){
            System.out.println(j + "'s time is " + mappo.get(j).getTime());
            // System.out.println(j);
        }
    }
}
