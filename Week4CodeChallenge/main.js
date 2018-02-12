
document.getElementById("num1").onchange = function() { react(); };
document.getElementById("num2").onchange = function() { react(); };
document.getElementById("operation").onchange = function() { react(); };

function react() {
  var val1 = parseFloat(document.getElementById("num1").value);
  var val2 = parseFloat(document.getElementById("num2").value);
  var operation = document.getElementById("operation");
  
  if (num1.value && !isNaN(val1) && num2.value && !isNaN(val2)) {
    if (operation.value == "divide" && val2 == 0) {
      document.getElementById("result").style.color = "red";
      document.getElementById("result").value = "Don't divide by zero!";
    } else {
      document.getElementById("result").style.color = "black";
      document.getElementById("result").value = "";
      var result = 0;
      console.log(operation.options[operation.selectedIndex].value);
      switch(operation.options[operation.selectedIndex].value) {
        case "add":
          result = add(val1, val2);
          break;
        case "subtract":
          result = subtract(val1, val2);
          break;
        case "multiply":
          result = multiply(val1, val2);
          break;
        case "divide":
          result = divide(val1, val2);
          break;
      }
      document.getElementById("result").value = result;
    }
  }
}

function add(val1, val2) {
  return val1 + val2;
}

function subtract(val1, val2) {
  return val1 - val2;
}

function multiply(val1, val2) {
  return val1 * val2;
}

function divide(val1, val2) {
  return val1 / val2;
}