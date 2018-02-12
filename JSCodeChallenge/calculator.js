window.onload = function(){
  calculate();
}

function calculate(){
  document.getElementById("calculate_Button").addEventListener('click', function(){
    var num1 = parseInt(document.getElementById("first_num").value);
    var num2 = parseInt(document.getElementById("sec_num").value);
    var operation = document.getElementById("operation").value;
    var sum;
    if(isNaN(num1) || isNaN(num2)){
      sum = "You need to enter in some numbers."
    } else {
      switch(operation){
        case "+":
          sum = num1 + num2;
          break;
        case "-":
          sum = num1 - num2;
          break;
        case "*":
          sum = num1 * num2;
          break;
        case "/":
          sum = num1 / num2;
          break;
        default:
          sum = "Choose an operation";
          break;
      }
    }
    document.getElementById("sum").textContent = sum;
  }, false);
}
