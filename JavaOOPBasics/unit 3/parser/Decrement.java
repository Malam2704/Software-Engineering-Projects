package parser;

public class Decrement extends Expression {
    private final Expression operand;
    
    public Decrement(Expression operand){
        this.operand = operand;
    }

    @Override
    public double evaluate(){
        double result = operand.evaluate();
        return result = result - 1;
    }

    @Override
    public String toString() {
        return "-- " + operand;
    }

    public static void main(String[] args) {
        Expression expression = new Decrement(new Constant(5.5));
        System.out.println(expression);
        System.out.println(expression.evaluate());
    }
}
