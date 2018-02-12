/*JavaScript Calculator
Build a calculator webpage with HTML, CSS, JavaScript, and (optional) Bootstrap. 
All logic must be performed by unobtrusive JS functions. 
The user must be able to enter two numbers and select an operation (+,-,*,/). 
User input validation (check out some features of Bootstrap forms) is a plus. 
*/

function calculate() {
	var val1 = parseFloat(document.getElementById('val1').value);
	var val2 = parseFloat(document.getElementById('val2').value);
	var oper = document.getElementById('operator').value;
	console.log(oper);
	var result;
	if(oper == '+') {
		result = val1 + val2;
	}
	else if(oper == '-') {
		result = val1 - val2;
	}
	else if(oper == '*') {
		result = val1 * val2;
	}
	else {
		result = val1 / val2;
	}

	
	document.getElementById('result').innerHTML = result;
}

document.getElementById('equals').addEventListener("click", calculate);