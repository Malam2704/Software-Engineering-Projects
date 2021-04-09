package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.graalvm.compiler.lir.aarch64.AArch64AtomicMove.CompareAndSwapOp;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(String firstname, String lastName,double gpa){
        this.firstName = firstname;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    // Get the code for this, 1:26 probs 1h on video
    @Override
    public int compareTo(Student o) {
        return firstName.compareTo(o.firstName);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    public static void main(String[] args) {
        List<Student> myStudents = new ArrayList<>();
        myStudents.add(new Student("Mohammed", "Alam",4.0));
        myStudents.add(new Student("Stephan-Karl", "Karlsson",3.93));
        myStudents.add(new Student("George", "Georgeson",3.5));
        myStudents.add(new Student("Tim", "Johnson",3.6));


        // myStudents.sort(new Comparator<Student>(){
        //     @Override
        //     public int compare(Student o1, Student o2) {
        //         return o1.getLastName().compareTo(o2.getLastName());
        //     }
        // });

        // Multi Line Lambda - Lamba I
        // myStudents.sort((Student o1, Student o2) -> {
        //     // This sorts string by alphabetical order,
        //     // compart o2 to o1 for a reversed list, or negate it.
        //     return -(o1.getLastName().compareTo(o2.getLastName()));
        // });

        // One Line Lambda - Lambda II
        // myStudents.sort((Student o1, Student o2) 
        //         -> -(o1.getLastName().compareTo(o2.getLastName())));

        // Lambda III
        myStudents.sort((o1,o2) -> o1.compareTo(o2));
        for(Student stu: myStudents){
            System.out.println(stu.getFirstName() + " " + stu.getLastName());
        }

        // Lambda III p2
        // myStudents.sort(Student::compareTo);

        // Prints all of the studnets in the list
        // for(Student stu: myStudents){
        //     System.out.println(stu.getFirstName() + " " + stu.getLastName());
        // }

        // ---------------------------------------------------------
        //                                 Streams

        // Printing with streams
        System.out.println("-----------------");
        System.out.println("Printing Example: ");
        myStudents.stream().forEach(stu -> System.out.println(stu.getFirstName() + " " + stu.getLastName()));;
    
        // Filtering with Streams
        System.out.println("-----------------");
        System.out.println("Filtering Example: ");
        myStudents.stream().filter(stu -> stu.getGpa() >= 3.8).forEach(System.out::println);
    }
}
