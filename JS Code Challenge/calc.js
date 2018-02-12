


function add() {
	var num1 = parseInt(document.getElementById("num1").value);
	var num2 = parseInt(document.getElementById("num2").value);
	var div = document.getElementById("ans");

	if (isNaN(num1) || isNaN(num2)) {
		div.innerHTML = "One entry is not a number";
		div.style.backgroundColor = "red";
	} else {
		div.innerHTML = (num1 + num2);
		div.style.backgroundColor = "#90ed90";
	}
}

function sub() {
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value
	var div = document.getElementById("ans");

	if (isNaN(num1) || isNaN(num2)) {
		div.innerHTML = "One entry is not a number";
		div.style.backgroundColor = "red";
	} else {
		div.innerHTML = (num1 - num2);
		div.style.backgroundColor = "#90ed90";
	}
}

function mult() {
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value
	var div = document.getElementById("ans");

	if (isNaN(num1) || isNaN(num2)) {
		div.innerHTML = "One entry is not a number";
		div.style.backgroundColor = "red";
	} else {
		div.innerHTML = (num1 * num2);
		div.style.backgroundColor = "#90ed90";
	}
}

function divide() {
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value
	var div = document.getElementById("ans");

	if (isNaN(num1) || isNaN(num2)) {
		div.innerHTML = "One entry is not a number";
		div.style.backgroundColor = "red";
	} else if (num2 === 0) {
		div.innerHTML = "Cannot divide by zero";
		div.style.backgroundColor = "red";
	}else {
		div.innerHTML = (num1 / num2);
		div.style.backgroundColor = "#90ed90";
	}
}



window.onload = function() {
	
	var button = document.getElementById("add");
	button.addEventListener("click", add);

	button = document.getElementById("sub");
	button.addEventListener("click", sub);

	button = document.getElementById("division");
	button.addEventListener("click", divide);

	button = document.getElementById("mult");
	button.addEventListener("click", mult);

}