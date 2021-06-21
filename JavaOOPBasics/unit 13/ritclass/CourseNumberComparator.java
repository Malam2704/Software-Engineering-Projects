package ritclass;

import java.util.Comparator;

public class CourseNumberComparator implements Comparator<RITClass> {
    public int compare(RITClass o1, RITClass o2) {
        return o1.getCourseNumber() - o2.getCourseNumber();
    };
}
