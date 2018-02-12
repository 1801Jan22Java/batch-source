// JavaScript source code
window.onload = function () {
    document.getElementById("num1").onchange = getSum;
    document.getElementById("num2").onchange = getSum;

    document.getElementById("buttonPlus").onclick = function () { operation = 0; getSum();};
    document.getElementById("buttonMinus").onclick = function () { operation = 1; getSum();};
    document.getElementById("buttonMult").onclick = function () { operation = 2; getSum();};
    document.getElementById("buttonDiv").onclick = function () { operation = 3; getSum();};
}

var operation = 0;

function getSum() {

    var textSum = 0.0;

    var inp1 = parseFloat(document.getElementById("num1").value);
    var inp2 = parseFloat(document.getElementById("num2").value);

    if (operation == 1) {
        textSum = inp1 - inp2;
    }
    else if (operation == 2) {
        textSum = inp1 * inp2;
    }
    else if (operation == 3) {
        textSum = inp1 / inp2;
    }
    else {
        textSum = inp1 + inp2;
    }

    document.getElementById("sum").innerText = "Result: " + (isNaN(textSum) ? "" : textSum);
    console.log("result: " + textSum);
    console.log("op: " + operation);
};