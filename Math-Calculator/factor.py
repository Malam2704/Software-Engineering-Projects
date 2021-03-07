def Factor(function):
    tokens = function.split(" ")
    # print(tokens)
    if(tokens[0][0] != "x"):
        tokens[-1] = str(int(tokens[-1]) * int(tokens[0][0]))

    # for i in range(int(tokens[2][0]))
    if(tokens[1] == "-"):
        number1 = -1 * int(tokens[2][0])
    else:
        number1 = int(tokens[2][0])
    if(tokens[-2] == "-"):
        number2 = -1 * int(tokens[-1])
    else:
        number2 = int(tokens[-1])

    # print(number1)
    # print(number2)
    for i in range(abs(number2)+1):
        for j in range(abs(number2) + 1):
            # print("i+j = " + str(i+j))
            # print("i*j = " + str(i*j))
            if(i + j == number1 and i * j == number2):
                ans1 = i+j
                ans2 = i*j
                return function + " factors are " + str([("x + " + str(i)),("x + " + str(j))])

def main():
    print(Factor("x^2 + 7x + 6"))

if __name__ == "__main__":
    main()