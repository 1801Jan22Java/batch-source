window.onload = function(){
	
	var operand1=document.getElementById("operand1");
	var operand2 = document.getElementById("operand2");
	var add= document.getElementById("addButton");
	var subtract = document.getElementById("subButton");
	var multiply = document.getElementById("multButton");
	var divide = document.getElementById("divideButton");
	var mod = document.getElementById("modButton");
	var resultStr="";
	var num1=0;
	var num2=0;
	var outcome=0;
	function getOperand1(){
		operand1.onchange=function()
		{
			num1=parseFloat(operand1.value);
			console.log(operand1.value);
			//alert("operand entered");
		}
	}
	function getOperand2(){
		operand2.onchange=function()
		{
			num2=parseFloat(operand2.value);
			console.log(operand2.value);
			//alert("operand entered");
		}
	}
	
	add.addEventListener("click",function () {
		outcome=num1+num2;
		if(isNaN(outcome)){
			alert("Did you remember to enter a number?");
		}
		else{
		console.log(outcome);
		resultStr= num1 + " + " +num2 + " is "+ outcome;
		alert(resultStr);
		}
	});
	subtract.addEventListener("click",function () {
		if(isNaN(outcome)){
			alert("Did you remember to enter a number?");
		}
		else{
		outcome=num1-num2;
		console.log(outcome);
		 resultStr= num1 + " - " +num2 + " is "+ outcome;
		alert(resultStr);
		}
	});
	multiply.addEventListener("click",function () {
		outcome=num1*num2;
		console.log(outcome);
		 resultStr= num1 + " * " +num2 + " is "+ outcome;
		alert(resultStr);
	});
	divide.addEventListener("click",function () {
		outcome=num1/num2;
		if(isNaN(outcome)){
			alert("Did you remember to enter a number?");
		}
		else{
		
		console.log(outcome);
		 resultStr= num1 + " / " +num2 + " is "+ outcome;
		alert(resultStr);
		}
	});
	mod.addEventListener("click",function () {
		outcome=num1%num2;
		if(isNaN(outcome)){
			alert("Did you remember to enter a number?");
		}
		else{
		
		console.log(outcome);
		 resultStr= "The remainder of " + num1 + " / " +num2 + " is "+ outcome;
		alert(resultStr);
		}
	});
	getOperand1();
	getOperand2();
	
}