package gvt;

public class Child extends Parent{
    public int age;

    public Child(String name, int age){
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Child{name=" + this.name + " age=" + this.age + "}";
    }
}
