package ritclass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class RITClassTest {
    // This test just checks if the regualr comparable is in okay use.
    @Test
    public void testMyClasses(){
        RITClass aClass = new RITClass("MATH 182 08");
        RITClass bClass = new RITClass("SWEN 124 05");
        RITClass cClass = new RITClass("MATH 190 02");
        RITClass dClass = new RITClass("ISTE 240 02");
        RITClass eClass = new RITClass("PHIL 103 01");
        RITClass[] classes =  new RITClass[5];
        classes[0] = aClass;
        classes[1] = bClass;
        classes[2] = cClass;
        classes[3] = dClass;
        classes[4] = eClass;
        Arrays.sort(classes);

        String classesString = "[ISTE 240-2, MATH 182-8, MATH 190-2, PHIL 103-1, SWEN 124-5]";

        assertEquals(classesString, Arrays.toString(classes));
    }

    //This test checks if the constructor worked.
    @Test
    public void testMyClassNum(){
        RITClass aClass = new RITClass("MATH 182 08");

        String department = aClass.getDepartment();
        int courseNumber = aClass.getCourseNumber();
        int courseSection = aClass.getSection();
        
        assertEquals(department, "MATH");
        assertEquals(courseNumber, 182);
        assertEquals(courseSection, 8);
    }

    // This just makes a new Comparator, so that the order is coruse number
    // and asserts the stirng is doen correctly, mine is, but don't know why it's not 
    // running correctly.
    @Test
    public void setTest(){
        RITClass aClass = new RITClass("MATH 182 08");
        RITClass bClass = new RITClass("SWEN 124 05");
        RITClass cClass = new RITClass("MATH 190 02");
        RITClass dClass = new RITClass("ISTE 240 02");
        RITClass eClass = new RITClass("PHIL 103 01");

        Comparator<RITClass> myComparator = new Comparator<RITClass>(){
            @Override
            public int compare(RITClass o1, RITClass o2) {
                return o1.getCourseNumber() - o2.getCourseNumber();
            }
        };
        TreeSet<RITClass> mySet = new TreeSet<>(myComparator);
        mySet.add(aClass);
        mySet.add(bClass);
        mySet.add(cClass);
        mySet.add(dClass);
        mySet.add(eClass);
        //System.out.println(Arrays.toString(Arrays.from(mySet)));
        System.out.println(mySet);
        assertEquals(mySet, "[PHIL 103-1, SWEN 124-5, MATH 182-8, MATH 190-2, ISTE 240-2]");
    }
}
