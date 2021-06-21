import basics
import factor

def BasicMaker():
    num1 = input("Enter number 1: ")
    num2 = input("Enter number 2: ")
    print("Addition: " + num1 + " + " + num2 + " = " + basics.Add(num1,num2))
    print("Subtraction: " + num1 + " - " + num2 + " = " + basics.Subtract(num1,num2))
    print("Multiplication: " + num1 + " x " + num2 + " = " + basics.Multiply(num1,num2))
    print("Division: " + num1 + " / " + num2 + " = " + basics.Divide(num1,num2))

def Welcome():
    print("Welcome To Moahmmeds Calculator")
    print("Here are the basic functions you need for Discrete Math, and Calculus")
    print("1 - Basic Arithmetic")
    print("2 - Factor a Trinomial")
    print("3 - Sum of a series")
    answer = int(input("What will you choose: "))
    if (answer) == 1:
        BasicMaker()
    elif answer == 2:
        function = input("Enter your function: ")
        print(factor.Factor(function))
    elif answer == 3:
        

def main():
    print("Welcome the the Math-Calculus Calculator, where we solve all of your calculus needs")
    print("REMEMBER TO SPACE OUT YOUR OPERATIONS e.g. x^2 - 5x + 4")
    Welcome()
    #print(basics.Add(5,6))
    #print(factor.Factor("x^2 - 5x + 4"))

if __name__ == "__main__":
    main()