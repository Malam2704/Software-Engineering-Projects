var currentNum = 0;
var firstNum = 0;
var secondNum = 0;
var currentOperand;

// Clearing the calculator, renamed clearCalc() from clear(),
// because clearCalc() is another js function
function clearCalc(){
    currentNum = 0;
    firstNum = 0;
    document.getElementById("numbersArea").innerHTML = "";
}

// Inputting severl numbers on the calc
function enterNum(value){
    var textSoFar = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = textSoFar + value;
    currentNum = textSoFar + value;
}

// One function for each operand, sets firNum var to whatever is on
// the numbersArea, then clears numbersArea, settignt he way for the next operand
// and sets the currentOperand to +,-,*, or /
function addNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "+";
}
function subNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "-";
}
function mulNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "*";
}
function divNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "/";
}
function powNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "^";
}
function modNum(){
    firstNum = document.getElementById("numbersArea").innerHTML;
    document.getElementById("numbersArea").innerHTML = "";
    currentOperand = "MOD";
}

// When the enter key is pressed, checks what the current operand is,
// and sets the numbersArea innerHTML to whatever the equation is.
function calcEnter(){
    secondNum = document.getElementById("numbersArea").innerHTML;
    if(currentOperand == "+"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) + parseFloat(secondNum);
    }else if(currentOperand == "-"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) - parseFloat(secondNum);
    }else if(currentOperand == "*"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) * parseFloat(secondNum);
    }else if(currentOperand == "/"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) / parseFloat(secondNum);
    }else if(currentOperand == "^"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) ** parseFloat(secondNum);
    }else if(currentOperand == "MOD"){
        document.getElementById("numbersArea").innerHTML = parseFloat(firstNum) % parseFloat(secondNum);
    }
}