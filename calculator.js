window.addEventListener("load", function () {
    var calculate = document.getElementById("calculate");

    function checkNaN(val1, val2) {
        if (isNaN(val1) || isNaN(val2)) {
            return true;
        }
        return false;
    }

    function add() {
        var num1 = parseFloat(document.getElementById("num1").value);
        var num2 = parseFloat(document.getElementById("num2").value);
        if (checkNaN(num1, num2)) {
            document.getElementById("output").textContent = "Cannot calculate."
        } else {

            document.getElementById("output").textContent = num1 + num2;
        }
    }
    function sub() {
        var num1 = parseFloat(document.getElementById("num1").value);
        var num2 = parseFloat(document.getElementById("num2").value);
        if (checkNaN(num1, num2)) {
            document.getElementById("output").textContent = "Cannot calculate."
        } else {

            document.getElementById("output").textContent = num1 - num2;
        }
    }
    function div() {
        var num1 = parseFloat(document.getElementById("num1").value);
        var num2 = parseFloat(document.getElementById("num2").value);
        if (checkNaN(num1, num2)) {
            document.getElementById("output").textContent = "Cannot calculate."
        } else {
            if (num2 == 0) {
                document.getElementById("output").textContent = "Cannot divide by 0"
                return 0;
            }
            document.getElementById("output").textContent = num1 / num2;
        }

    }
    function mul() {
        var num1 = parseFloat(document.getElementById("num1").value);
        var num2 = parseFloat(document.getElementById("num2").value);
        if (checkNaN(num1, num2)) {
            document.getElementById("output").textContent = "Cannot calculate."
        } else {

            document.getElementById("output").textContent = num1 * num2;
        }
    }

    document.getElementById("add").addEventListener("click", add);
    document.getElementById("subtract").addEventListener("click", sub);
    document.getElementById("multiply").addEventListener("click", mul);
    document.getElementById("divide").addEventListener("click", div);
})


