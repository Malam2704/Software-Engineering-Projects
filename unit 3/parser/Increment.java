package parser;

public class Increment extends Expression {
    private final Expression operand;
    
    public Increment(Expression operand){
        this.operand = operand;
    }

    @Override
    public double evaluate(){
        double result = operand.evaluate();
        return result = result + 1;
    }

    @Override
    public String toString() {
        return "++ " + operand;
    }

    public static void main(String[] args) {
        Expression expression = new Increment(new Constant(5.5));
        System.out.println(expression);
        System.out.println(expression.evaluate());
    }
}
