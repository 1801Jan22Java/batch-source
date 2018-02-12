window.onload = function(){
	var operands = document.getElementsByClassName("operand");
	var operators = document.getElementById("operator");
	var result = document.getElementsByName("result")[0];
	
	operands[0].addEventListener("change", doMath);
	operands[1].addEventListener("change", doMath);
	operators.addEventListener("input", doMath);
	
	function doMath(event){
		if( Number(operands[0].value) && Number(operands[1].value) && operators[operators.selectedIndex].innerHTML !== 'not'){
			var lOperand = parseInt(operands[0].value);
			var rOperand = parseInt(operands[1].value);
			var operator = operators[operators.selectedIndex].innerHTML;
			var endResult;
			
			if(operator === '+'){
				endResult = lOperand + rOperand;
			}else if(operator === '-'){
				endResult = lOperand - rOperand;
			}else if(operator === '*'){
				endResult = lOperand * rOperand;
			}else if(operator === '/'){
				endResult = lOperand / rOperand;
			}
			
			result.innerHTML = endResult;
			
		}else{
			
			result.innerHTML = "That is not a valid operation!";
		
		}
	}
}