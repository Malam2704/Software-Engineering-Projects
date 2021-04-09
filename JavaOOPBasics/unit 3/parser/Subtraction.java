package parser;

public class Subtraction extends Expression{
    private final Expression operand1;
    private final Expression operand2;

    public Subtraction(Expression operand1,Expression operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public double evaluate(){
        double result1 = operand1.evaluate();
        double result2 = operand2.evaluate();

        return (result1 - result2);
    }

    @Override
    public String toString() {
        return "- " + operand1 + " " + operand2;
    }

    public static void main(String[] args) {
        Expression expression = new Subtraction(new Decrement(new Constant(6)), new Decrement(new Constant(4)));

        System.out.println(expression);
        System.out.println(expression.evaluate());
    }
}
