package inner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Calendar {
    
    public enum DayOfWeek{
        MONDAY(2,"Mon"),
        TUESDAY(3,"Tue"),
        WEDNESDAY(4,"Wed"),
        THURSDAY(5,"Thu"),
        FRIDAY(6,"Fri"),
        SATURDAY(7,"Sat"),
        SUNDAY(1,"Sun");

        private int dayNumber;
        private String shortname;

        // Dictionary made so that each day is a key and another day is the value
        // of that key
        private static final Map<DayOfWeek,DayOfWeek> NEXT_DAYS = new HashMap<>();
        static{
            NEXT_DAYS.put(SUNDAY, MONDAY);
            NEXT_DAYS.put(MONDAY, TUESDAY);
            NEXT_DAYS.put(TUESDAY, WEDNESDAY);
            NEXT_DAYS.put(WEDNESDAY, THURSDAY);
            NEXT_DAYS.put(THURSDAY, FRIDAY);
            NEXT_DAYS.put(FRIDAY, SATURDAY);
            NEXT_DAYS.put(SATURDAY, SUNDAY);
        }
        private DayOfWeek(int dayNumber, String shortName){
            this.dayNumber = dayNumber;
            this.shortname = shortName;
        }

        public int getDayNumber() {
            return dayNumber;
        }
        public DayOfWeek tommorow(){
            return NEXT_DAYS.get(this);
        }
        @Override
        public String toString() {
            return shortname;
        }
    }

    public enum Month implements Iterable<DayOfWeek>{
        JANUARY(1,"Jan",31),
        FEBRUARY(2,"Feb",28),
        MARCH(3,"Mar",31),
        APRIL(4,"Apr",30),
        MAY(5,"May",31),
        JUNE(6,"Jun",30),
        JULY(7,"Jul",31),
        AUGUST(8,"Aug",31),
        SEPTEMBER(9,"Sep",30),
        OCTOBER(10,"Oct",31),
        NOVEMBER(11,"Nov",30),
        DECEMBER(12,"Dec",31);

        private int monthNumber;
        private String shortname;

        private int daysInMonth;
        private DayOfWeek startDay;

        // Dictionary made so that each day is a key and another day is the value
        // of that key
        private static final Map<Month,Month> NEXT_MONTHS = new HashMap<>();
        static{
            NEXT_MONTHS.put(JANUARY, FEBRUARY);
            NEXT_MONTHS.put(FEBRUARY,MARCH);
            NEXT_MONTHS.put(MARCH, APRIL);
            NEXT_MONTHS.put(APRIL, MAY);
            NEXT_MONTHS.put(MAY, JUNE);
            NEXT_MONTHS.put(JUNE, JULY);
            NEXT_MONTHS.put(JULY, AUGUST);
            NEXT_MONTHS.put(AUGUST, SEPTEMBER);
            NEXT_MONTHS.put(SEPTEMBER, OCTOBER);
            NEXT_MONTHS.put(OCTOBER, NOVEMBER);
            NEXT_MONTHS.put(NOVEMBER, DECEMBER);
            NEXT_MONTHS.put(DECEMBER, JANUARY);
        }

        private Month(int monthNumber, String shortName,int daysInMonth){
            this.monthNumber = monthNumber;
            this.shortname = shortName;
            this.daysInMonth = daysInMonth;
        }

        public int getMonthNumber() {
            return monthNumber;
        }
        public int getDaysInMonth() {
            return daysInMonth;
        }

        public void setStartDay(DayOfWeek startDay){
            this.startDay = startDay;
        }

        public Month nextMonth(){
            return NEXT_MONTHS.get(this);
        }

        @Override
        public String toString() {
            return shortname;
        }

        @Override
        public Iterator<DayOfWeek> iterator() {
            return new Iterator<DayOfWeek>(){
                DayOfWeek day = startDay;
                int counter = 1;

                @Override
                public boolean hasNext() {
                    // TODO Auto-generated method stub
                    return counter <= daysInMonth;
                }

                @Override
                public DayOfWeek next() {
                    // TODO Auto-generated method stub
                    counter++;
                    DayOfWeek today = this.day;
                    this.day = today.tommorow();
                    return today;
                }
                
            };
        }
    }

    public static DayOfWeek printMonth(Month month, DayOfWeek startDay){
        // return month + "\n" + 
        //     startDay.getDayNumber() + "-" + startDay +
        int dayNumber = 1;
        month.setStartDay(startDay);
        System.out.println(month);
        DayOfWeek last = null;

        DayOfWeek pad = DayOfWeek.SUNDAY;
        while(pad != startDay){
            System.out.print("       ");
            pad = pad.tommorow();
        }

        for(DayOfWeek day: month){
            last = day;
            String toPrint = dayNumber + "-" + day;
            System.out.print(String.format("%7s", toPrint));
            if(dayNumber % 7 == 0){
                System.out.println();
            }
            dayNumber++;
        }

        System.out.println();
        return last;
    }

    public static DayOfWeek printYear(int year, DayOfWeek startDay){
        Month month = Month.JANUARY;
        for(int i=0; i<12; i++){
            startDay = printMonth(month, startDay);
            System.out.println();
            startDay = startDay.tommorow();
            month = month.nextMonth();
        }

        return startDay;
    }

    public static void main(String[] args) {
        // DayOfWeek day = DayOfWeek.WEDNESDAY;
        // System.out.println(day);
        // System.out.println(day.tommorow());

        // Month current = Month.JANUARY;
        // DayOfWeek today = DayOfWeek.FRIDAY;
        // for(int i=0; i<12; i++){
        //     printMonth(current, today);
        // }

        printYear(2020, DayOfWeek.FRIDAY);
    }
}
