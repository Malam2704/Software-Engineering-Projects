// Mohammed Alam, 9.1
// So for this one there are various assignments
// 3 of them one with inner classes, one wiht lambdas,
// and one with anonymous classes. I mixed up our 
// pet classes.
import java.util.Arrays;

public abstract class Pet{
    // Fields
    private String name;
    private String phrase;
    private int age;

    // private class Cat extends Pet{

    //     public Cat(String name,String sentence, int age){
    //         super(name, sentence, age);
    //     }
    //     public Cat(String name,String sentence){
    //         super(name, sentence);
    //     }
    
    //     @Override
    //     public String speak() {
    //         return "Meow";
    //     }
        
    // }

    // protected Dog{

    //     public Dog(String name,String sentence, int age){
    //         super(name, sentence, age);
    //     }
    //     public Dog(String name,String sentence){
    //         super(name, sentence);
    //     }
    
    //     @Override
    //     public String speak() {
    //         return "Woof Woof";
    //     }
        
    // }

    // private class Turtle extends Pet {

    //     public Turtle(String name,String sentence, int age){
    //         super(name, sentence, age);
    //     }
    //     public Turtle(String name,String sentence){
    //         super(name, sentence);
    //     }
    
    //     @Override
    //     public String speak() {
    //         return "Mwahh, El Tortuga";
    //     }   
    // }

    // two different contsturctors for age.
    protected Pet(String name,String sentence, int age){
        this.name = name;
        this.phrase = sentence;
        this.age = age;
    }
    protected Pet(String name ,String sentence){
        this.name = name;
        this.phrase = sentence;
        this.age = 0;
    }

    // getters
    public int getAge() {
        return age;
    }
    public String getPhrase() {
        return phrase;
    }
    public String getName() {
        return name;
    }

    // stirng with name and age
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    // different for each pet, but says a phrase.
    public abstract String speak();

    public static void main(String[] args) {
        Pet[] myPets = new Pet[3];
        // myPets[0] = Pet.Dog();
        // myPets[1] = new Cat("Rufus","I am a dog");
        // myPets[2] = new Turtle("Mitch","I am a Turtle");
        // System.out.println(Arrays.toString(myPets));
        Pet doggo =  new Pet("Rufus","I am a dog"){
            @Override
            public String speak() {
                return this.getPhrase();
            }
        };
        Pet cat =  new Pet("Josie","Meow"){
            @Override
            public String speak() {
                return this.getPhrase();
            }
        };
        Pet turtle =  new Pet("Mitch","Mwahh"){
            @Override
            public String speak() {
                return this.getPhrase();
            }
        };

        // Prints the pet instacne, and a for loop for the speaking
        // function for the Pets.
        System.out.println(doggo);
        System.out.println(cat);
        System.out.println(turtle);
        myPets[0] = doggo;
        myPets[1] = cat;
        myPets[2] = turtle;
        System.out.println(Arrays.toString(myPets));
        for (Pet pet : myPets) {
            System.out.println(pet.speak());
        }
    }
}
