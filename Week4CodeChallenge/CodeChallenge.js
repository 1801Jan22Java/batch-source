window.onload = function() {
  document.getElementById("calculate").addEventListener("click",mathOperation);

  function mathOperation() {
    var n1 = parseFloat(document.getElementById("input1").value);
  	var n2 = parseFloat(document.getElementById("input2").value);
    var op = document.getElementById("operation").value;
    console.log(op);
  	var result = "";
  	if (isNaN(n1) || isNaN(n2)) {
  		result = "Cannot add";
  	}
  	else {
  		switch(op) {
        case "division":
          result = n1/n2;
          break;
        case "multiplication":
          result = n1*n2;
          break
        case "addition":
          result = n1+n2;
          break;
        case "subtraction":
          result = n1-n2;
          break;
      }
  	}

  	document.getElementById("answer").innerHTML = result;
  }
}
