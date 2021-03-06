/* 
Mohammed Alam 3.2,
Well I have made this a defualt TOy class, abstract so I can't make a sole instance
of it, but it can extends to different types of toys such as Robots, Dolls, and Action Figures.
I have made your avg abstract class with fields accersos and mutators
*/
package toys;
import products.*;

public abstract class Toy extends Product{

    // makes the actual toy, but is used for others toys purposefullt
    public Toy(String name, double MSRP){
        super(name, MSRP);
    }

    // Abstract method that I cna't use, but will have different
    // meanings or processes in different toy classes
    public abstract String Play();
    
}
