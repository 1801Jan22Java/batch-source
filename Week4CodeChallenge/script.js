var changeToWhite = function () {
    var boxes = document.getElementsByClassName("operands");
    boxes[0].style.backgroundColor = "white";
    boxes[1].style.backgroundColor = "white";
}

var changeToRed = function () {
    var boxes = document.getElementsByClassName("operands");
    boxes[0].style.backgroundColor = "red";
    boxes[1].style.backgroundColor = "red";
}

var addition = function () {
    var result = document.getElementById("result");
    var boxes = document.getElementsByClassName("operands");
    var x = parseInt(boxes[0].value);
    var y = parseInt(boxes[1].value);
    if (!isNaN(x) && !isNaN(y)) {
        result.innerHTML = (x + y);
        changeToWhite();
    } else {
        result.innerHTML = "Cannot add";
        changeToRed();
    }
}

var subtraction = function () {
    var result = document.getElementById("result");
    var boxes = document.getElementsByClassName("operands");
    var x = parseInt(boxes[0].value);
    var y = parseInt(boxes[1].value);
    if (!isNaN(x) && !isNaN(y)) {
        result.innerHTML = (x - y);
        changeToWhite();
    } else {
        result.innerHTML = "Cannot subtract";
        changeToRed();
    }
}

var multiplication = function () {
    var result = document.getElementById("result");
    var boxes = document.getElementsByClassName("operands");
    var x = parseInt(boxes[0].value);
    var y = parseInt(boxes[1].value);
    if (!isNaN(x) && !isNaN(y)) {
        result.innerHTML = (x * y);
        changeToWhite();
    } else {
        result.innerHTML = "Cannot multiply";
        changeToRed();
    }
}

var division = function () {
    var result = document.getElementById("result");
    var boxes = document.getElementsByClassName("operands");
    var x = parseInt(boxes[0].value);
    var y = parseInt(boxes[1].value);
    if (!isNaN(x) && !isNaN(y)) {
        result.innerHTML = (x / y);
        changeToWhite();
    } else {
        result.innerHTML = "Cannot divide";
        changeToRed();
    }
}

window.onload = function () {

    document.getElementById("addition").onclick = addition;
    document.getElementById("subtraction").onclick = subtraction;
    document.getElementById("multiplication").onclick = multiplication;
    document.getElementById("division").onclick = division;

}