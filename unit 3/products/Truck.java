// Mohammed Alam 3.3
// Makes a truck that is used in the complex and can acarry a specififed number of products
// These products canbe laoded and unlaod
package products;

public class Truck {
    protected Product[] products;
    private final int capacity;
    protected String name;

    public Truck(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.products = new Product[capacity];
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Goes therough the entire array of items the truck currently holds
    // and checks if they are filled with products, if atleast one is none returns false
    public boolean is_full(){
        for(int i= 0; i<capacity; i++){
            if(this.products[i] != null){
                return false;
            }
        }
        return true;
    }

    // Goes in a for loop from the entire array of items, and the first emtpy spot
    //  or null that's found and replaces it with the product parameter
    public void load_truck(Product my_Product){
        if(is_full() == true){
            for(int i= 0; i<capacity; i++){
                if(this.products[i] == null){
                    this.products[i] = my_Product;
                    break;
                }
            }
        }
    }

    // Has an opposite for loop as the loading
    // and for the first product form teh back is not null
    // it will be unloaded and returned as the function
    public Product unload_truck(Product my_Product){
        for(int i= (this.capacity-1); i>-1; i--){
            if(this.products[i] != null){
                Product my_stuff = this.products[i];
                this.products[i] = my_Product;
                System.out.println("Unloading " + my_Product);
                return my_stuff;
            }
        }
    }
}
