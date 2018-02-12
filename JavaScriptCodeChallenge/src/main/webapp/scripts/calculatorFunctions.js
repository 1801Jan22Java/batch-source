/**
 * 
 */
		function add(input1, input2) {
			var message = document.getElementById("answer");
			message.innerHTML = "Enter inputs";
			try {
				if (!input1 || !input2) throw "Invalid number fields";					
				if (isNaN(input1) || isNaN(input2)) throw "Invalid number fields";		
				message.innerHTML = Number(input1) + Number(input2);
			} catch (err) {
				message.innerHTML = err;
			}
		};
		
		function subtract(input1, input2) {
			var message = document.getElementById("answer");
			message.innerHTML = "Enter inputs";
			try {
				if (!input1 || !input2) throw "Invalid number fields";					
				if (isNaN(input1) || isNaN(input2)) throw "Invalid number fields";		
				message.innerHTML = Number(input1) - Number(input2);
			} catch (err) {
				message.innerHTML = err;
			}
		};
		
		function multiply(input1, input2) {
			var message = document.getElementById("answer");
			message.innerHTML = "Enter inputs";
			try {
				if (!input1 || !input2) throw "Invalid number fields";					
				if (isNaN(input1) || isNaN(input2)) throw "Invalid number fields";		
				message.innerHTML = Number(input1) * Number(input2);
			} catch (err) {
				message.innerHTML = err;
			}
		};
		
		function divide(input1, input2) {
			var message = document.getElementById("answer");
			message.innerHTML = "Enter inputs";
			try {
				if (!input1 || !input2) throw "Invalid number fields";					
				if (isNaN(input1) || isNaN(input2)) throw "Invalid number fields";
				if (input2 === 0) throw "Invalid number fields";
				message.innerHTML = Number(input1) / Number(input2);
			} catch (err) {
				message.innerHTML = err;
			}
		};
		
		document.getElementById("addButton").addEventListener("click", function() {
			var x = document.getElementById("number1").value;
			add(document.getElementById("number1").value, document.getElementById("number2").value);
		});
		
		document.getElementById("subtractButton").addEventListener("click", function() {
			subtract(document.getElementById("number1").value, document.getElementById("number2").value);
		});
		
		document.getElementById("multiplyButton").addEventListener("click", function() {
			multiply(document.getElementById("number1").value, document.getElementById("number2").value);
		});
		
		document.getElementById("divideButton").addEventListener("click", function() {
			divide(document.getElementById("number1").value, document.getElementById("number2").value);
		});