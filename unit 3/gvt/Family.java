package gvt;

public class Family {
    public static void printParent(Parent parent) {
        System.out.println("Printing the parents");
        System.out.println(" " + parent.toString());
        System.out.println(" " + parent.getName());
    }

    public static void printChild(Child parent) {
        System.out.println("Printing the parents");
        System.out.println(" " + parent.toString());
        System.out.println(" " + parent.getName());
        System.out.println(" " + parent.getAge());
    }

    public static void main(String[] args) {
        Parent p1 = new Parent("Anakin");
        Child c1 = new Child("Luke",19);

        printParent(p1);
        printParent(c1);

        // Parents do not get the extra shit in the CHild's class
        // SO everythign you do in the child only, cannot work for
        // the parent
        // printChild(p1);
        printChild(c1);

        Parent p2 = c1;
        printParent(p2);

    }
}
