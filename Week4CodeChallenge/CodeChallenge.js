window.onload = function() {

  var toggle = setInterval(function(){
  	setColor();
  },50);

  function setColor() {
  	var x = document.getElementById("title");
  	x.style.color = getRandomColor();
  }

  function getRandomColor() {
  	  var letters = '0123456789ABCDEF';
  	  var color = '#';
  	  for (var i = 0; i < 6; i++) {
  	    color += letters[Math.floor(Math.random() * 16)];
  	  }
  	  return color;
  }

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
          result = (n1 + " / " + n2 + " = " + (n1/n2).toFixed(4));
          break;
        case "multiplication":
          result = (n1 + " x " + n2 + " = " + (n1*n2).toFixed(4));
          break
        case "addition":
          result = (n1 + " + " + n2 + " = " + (n1+n2).toFixed(4));
          break;
        case "subtraction":
          result = (n1 + " - " + n2 + " = " + (n1-n2).toFixed(4));
          break;
      }
  	}

  	document.getElementById("answer").innerHTML = result;
  }
}
