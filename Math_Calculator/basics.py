def Add(a=None,b=None):
    if(a == None): a = int(input("Enter in a number: "))
    if(b == None): b = int(input("Enter in another number: "))
    if(type(a) == type(b) and isinstance(a,int) and isinstance(b,int)):
            return a + b

def Subtract(a=None,b=None):
    if(a == None): a = int(input("Enter in a number: "))
    if(b == None): b = int(input("Enter in another number: "))
    if(type(a) == type(b) and isinstance(a,int) and isinstance(b,int)):
        return a - b

def Multiply(a=None,b=None):
    if(a == None): a = int(input("Enter in a number: "))
    if(b == None): b = int(input("Enter in another number: "))
    if(type(a) == type(b) and isinstance(a,int) and isinstance(b,int)):
        return a * b

def Divide(a=None,b=None):
    if(a == None): a = int(input("Enter in a number: "))
    if(b == None): b = int(input("Enter in another number: "))
    if(type(a) == type(b) and isinstance(a,int) and isinstance(b,int)):
        return a / b

def Mod(a=None,b=None):
    if(a == None): a = int(input("Enter in a number: "))
    if(b == None): b = int(input("Enter in another number: "))
    if(type(a) == type(b) and isinstance(a,int) and isinstance(b,int)):
        return a % b

def main():
    print("Hello")
    print(Add(4,5))
    print(Add(5))
    print(Subtract(4,5))
    print(Multiply(4,5))
    print(Divide(4,5))

    print(Add(4,5))
    print(Add(5))
    print(Subtract(4,5))
    print(Multiply(4,5))
    print(Divide())

if __name__ == "__main__":
    main()