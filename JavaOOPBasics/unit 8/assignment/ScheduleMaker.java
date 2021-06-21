// Mohammed Alam, Assignment 8.1
/*
Well for thsi assignment I ahd to create two taks
One wa screate a greedy algorithm to make a schedule out of the
created courses. And the other implementation would be the
using the Dijkstra's algorithm to make a word through connections
*/
package assignment;

import java.util.ArrayList;
import java.util.List;

public class ScheduleMaker {
    /*
    Greedy Algorithm:
        Since it's a greedy algorithm,
        It's going to pick the best option
        form all the given next choices, in the bigger picture
        it's not goping to use a combination of all the courses
        so it's not very optimal.

        Other than that I will just go through the entire
        list and make an arrayList of the courses, and that list will
        be sorted by starting time, then the next index
        will be the course that starts when the previosu index class
        ends

        Array List being made
        var for lowest time for the first class beign made
        for loop for going from the entire list
            if the course's start time is lower, then add it
            to index 0, and set start time to lower
            else if, the courses start time equals the last
            index class's end time, add it to the list
        return the list    

        Edit: My original plan wasn't going to work
        So I made it easier by adding 2 for loops,
        which finds the lowest, then goes through the list
        to find whichc courses would match up with the starts and
        end to my schedule.
    */


    public static List<Course> makeSchedule(List<Course> myCourses){
        // Makes a list, and an integer for the lowest
        // timedefaulted to a value that can't exist
        List<Course> aList = new ArrayList<>();
        int lowest = 100;
        // for loop to go through all the courses
        // and adds the course if it's lower than the lowest
        // time, then sets the lowest time to that course's time
        for(Course c:myCourses){
            if(c.getStart() < lowest){
                lowest = c.getStart();
                // Then it will add the course to the first index
                // and take out the other courses, whcih are no long
                // -er the lowest
                aList.add(0, c);
                if(aList.size() >= 2){
                    aList.remove(1);
                }
            }
        }

        // The second for loop which checks if the course's
        // start time match with the end time of the last index
        // if so adds it to the class, and goes on.
        for(Course a : myCourses){
            if(a.getStart() >= aList.get(aList.size() - 1).getEnd() ){
                aList.add(a);
            }
        }
        // returns the new courses list
        return aList;
    }

    // Main method
    public static void main(String[] args) {
        List<Course> myCourses = Course.exampleCourses();
        System.out.println(makeSchedule(myCourses));
    }
}
