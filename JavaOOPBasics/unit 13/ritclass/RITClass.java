// Mohammed Alam, assignment 13.1, several activites representing units 1-6
// Well, this was hard, but we made activities with comparactors, sets, polymorphism
// and bianry search trees.
package ritclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class RITClass implements Comparable<RITClass>{
    // fields
    private String department;
    private int section;
    private int courseNumber;
    
    // constructors
    public RITClass(String courseCode){
        String[] tokens = courseCode.split(" |\\-");
        this.department = tokens[0];
        this.courseNumber = Integer.parseInt(tokens[1]);
        this.section = Integer.parseInt(tokens[2]);
    }

    // getters
    public int getCourseNumber() {
        return courseNumber;
    }public String getDepartment() {
        return department;
    }public int getSection() {
        return section;
    }

    // stirng and compare to methods
    @Override
    public String toString() {
        return department + " " + courseNumber +"-" + section;
    }

    // method for comapring the names in order.
    @Override
    public int compareTo(RITClass o) {
        // Return < 0 if this comes before o
        // return == 0 if is equal to o
        // return > 0 if this come after o
        return this.department.toLowerCase().compareTo(o.department.toLowerCase());
    }

    public static void main(String[] args) {
        RITClass aClass = new RITClass("MATH 182 08");
        RITClass bClass = new RITClass("SWEN 124 05");
        RITClass cClass = new RITClass("MATH 190 02");
        RITClass dClass = new RITClass("ISTE 240 02");
        RITClass eClass = new RITClass("PHIL 103 01");
        List<RITClass> classes = new ArrayList<>();
        classes.add(aClass);
        classes.add(bClass);
        classes.add(cClass);
        classes.add(dClass);
        classes.add(eClass);
        Collections.sort(classes);

        // for(RITClass class : classes){
        //     System.out.println(class);
        // }
        for (RITClass ritClass : classes) {
            System.out.println(ritClass);
        }
    }
}