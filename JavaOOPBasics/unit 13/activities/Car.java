package activities;

public class Car {
    private final String name;
    private final int modelNum;
    private int year;
    private int mileage;

    public Car(String name, int modelNum, int year){
        this.name = name;
        this.modelNum = modelNum;
        this.year = year;
    }

    public int getModelNum() {
        return modelNum;
    }public String getName() {
        return name;
    }public int getYear() {
        return year;
    }

    public void drive(int miles){
        mileage += miles;
    }

    @Override
    public String toString() {
        return "Car{" + name + ", " + year + ", model number of " + modelNum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            Car car = (Car)obj;
            if(this.year == car.getYear() && this.getModelNum() == car.getModelNum()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return modelNum * year;
    }

    public static void main(String[] args) {
        Car f150 = new Car("Ford F-150", 150, 2021);
        System.out.println(f150);
    }
}
