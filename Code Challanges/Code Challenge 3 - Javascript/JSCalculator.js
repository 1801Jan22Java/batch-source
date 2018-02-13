var x = document.forms["mathForm"]["num1"].value;
var y = document.forms["mathForm"]["num2"].value;
if ((x === "") || (y=== "")) {
    alert("Number fields must be filled out");
}

var resultP = document.getElementById("result");
var a = document.forms["mathForm"]["num1"].value;
var b = document.forms["mathForm"]["num2"].value;
var whatToDo = document.forms["mathForm"]["operation"].value;
console.log("A= "+a+" B = "+b);
var operation = document.getElementById("operation");
console.log("op is " + op);
if(whatToDo == "addition")
    document.getElementById("result").innerHTML("Result is "+ (a+b));

if(whatToDo == "subtraction")
    document.getElementById("result").innerHTML("Result is "+(a-b));

if(whatToDo == "multiplication")
    document.getElementById("result").innerHTML("Result is "+ (a*b));

if(whatToDo == "division")
    document.getElementById("result").innerHTML("Result is "+ (a / b));

if(whatToDo == "exponent")
    document.getElementById("result").innerHTML("Result is "+ Math.pow(a, b));  
