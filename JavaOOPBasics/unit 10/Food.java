public class Food{
    // simple class with name and servings
	private String name;
	private int servings;

    public Food(String name, int servings){
        this.name = name;
        this.servings = servings;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return servings + " servings of " + name;
    }
}

