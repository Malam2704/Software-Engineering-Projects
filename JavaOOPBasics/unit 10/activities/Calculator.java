package activities;

import java.rmi.server.Operation;
import java.util.Scanner;

public class Calculator {
    
    public interface Operation{
        public double execute(double left, double right);
    }

    public static Operation getOperation(String op){
        if(op.equals("+")){
            return new Operation(){
                @Override
                public double execute(double left, double right) {
                    // TODO Auto-generated method stub
                    return left +right;
                }
            };
        }else if(op.equals("-")){
            return (left, right) -> (left - right);
        }else if(op.equals("*")){
            return (left, right) -> (left * right);
        }else if(op.equals("/")){
            return (left, right) -> (left / right);
        }else if(op.equals("^")){
            return (left, right) -> Math.pow(left, right);
        }else{
            throw new UnsupportedOperationException("Unsupported operation" + op);
        }
    }

    public static void main(String[] args) {
        // prompt the user to enter an expression, e.g. 4 + 5
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter in an expression");
        double left = scanner.nextDouble();
        String operand = scanner.next();
        double right = scanner.nextDouble();
        // call the getOperation() method to get the operation
        Operation operation = getOperation(operand);
        double result = operation.execute(left, right);
        // execute the operation
        // print the result
        System.out.println(result);

        scanner.close();
    }

}
