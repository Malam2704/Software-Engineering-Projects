package activities;

import java.time.Year;
import java.util.Random;

import javax.management.ObjectName;

import jdk.incubator.jpackage.main.Main;

public class Year{
    // add a field to store the year number
    private final int year;
    public static final int DAYS_IN_A_YEAR = 365; 
    public static final Random RNG = new Random(1);/*the seed is the parameter*/
    // add a constructor to set the year number
    public Year(int year){
        this.year = year;
    }
    // add an accessor toget the year number
    /*
    Returns number of days int eh specified year

    @param is the year integer user entered
    */
    public static int DaysinaYear(int year) {
        if(year % 400 == 0){
            return DAYS_IN_A_YEAR + 1;
        } else if(year %4 == 0 && year %100 != 0){
            return DAYS_IN_A_YEAR +1;
        }else{
            return DAYS_IN_A_YEAR;
        }
    }

    public static int[] parseYears(String yearString){
        String trimmed = yearString.trim();
        String[] tokens = tokens = trimmed.split(" ");
        Year[] years = new Year[tokens.length];
        for (int i=0; i<tokens.length; i++){
            int YearNumber = Integer.parseInt(tokens[i]);
        }
    } 

    public static int RandomYear(int min, int max){
        int Upperbound = max - min + 1;

        int  number = RNG.nextInt(Upperbound);

        return number + min;
    }

    // add a number of days in a year to return the
    // number of days in the year with the specified number
    public getYearNumber(){
        return this.year;
    }
    public getNumberDays(){
        return DaysinaYear(this.year);
    }

    @Override
    public String toString(){
        return ("year: " + this.year
                + "days in the year: " + DaysinaYear(this.year))
    }

    @Override
    public boolean equals(Object their){
        if(their instanceof Year){
            return (this.year == their.year);
        }else{
            System.err.println("Same type needed!");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("1900: " + DaysinaYear(1900));

        Year y1900 = new Year(1900);

        System.out.println(y1900);
    }
}
