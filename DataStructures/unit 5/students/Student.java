package students;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.print.attribute.standard.MediaSize.Other;

public class Student implements Comparable<Student>{
    private final String id;
    private String name;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return " Student{ id = " + id
            + " ,name = " + name    
            + " }";
    }

    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

    public static void main(String[] args) {
        Set<Student> stus = new HashSet<>();
        stus.add(new Student("HPDHD244", "Harry"));
        stus.add(new Student("HPDegD244", "He"));
        stus.add(new Student("HPDgege244", "Hi"));
        stus.add(new Student("HPeg44", "Ha"));
        stus.add(new Student("HPeg244", "Har"));

        for(Student s: stus){
            System.out.println(s);
        }

        System.out.println();

        // This one sorts by using comparable
        Set<Student> tresSet = new TreeSet<>();
        tresSet.add(new Student("HPDHD244", "Harry"));
        tresSet.add(new Student("HPDegD244", "He"));
        tresSet.add(new Student("HPDgege244", "Hi"));
        tresSet.add(new Student("HPeg44", "Ha"));
        tresSet.add(new Student("HPeg244", "Har"));

        for(Student s: tresSet){
            System.out.println(s);
        }

        Map<String,Student> map = new HashMap<>();
        for(Student student : stus){
            map.put(student.id, student);
        }

        Map<String,Student> treeMap = new TreeMap<>();
        for(Student student : stus){
            treeMap.put(student.id, student);
        }
    }
}
