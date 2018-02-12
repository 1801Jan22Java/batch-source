document.getElementById("add").addEventListener("click", add);
function add(){
	var value1 = parseFloat(document.getElementById("value1").value);
	var value2 = parseFloat(document.getElementById("value2").value);
	document.getElementById("result").innerHTML = parseFloat(value1 + value2);
};
document.getElementById("subtract").addEventListener("click", subtract);
function subtract(){
	var value1 = parseFloat(document.getElementById("value1").value);
	var value2 = parseFloat(document.getElementById("value2").value);
	document.getElementById("result").innerHTML = parseFloat(value1 - value2);
};
document.getElementById("multiply").addEventListener("click", multiply);
function multiply(){
	var value1 = parseFloat(document.getElementById("value1").value);
	var value2 = parseFloat(document.getElementById("value2").value);
	document.getElementById("result").innerHTML = parseFloat(value1 * value2);
};
document.getElementById("divide").addEventListener("click", divide);
function divide(){
	var value1 = parseFloat(document.getElementById("value1").value);
	var value2 = parseFloat(document.getElementById("value2").value);
	document.getElementById("result").innerHTML = parseFloat(value1 / value2);
};