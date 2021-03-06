package parser;

public class Constant extends Expression{
    private final double value;

    public Constant(double value){
        this.value = value;
    }

    @Override
    public double evaluate(){
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public static void main(String[] args) {
        Expression expression = new Constant(3.14159);
        System.out.println(expression);
        System.out.println(expression.evaluate());
    }
}
