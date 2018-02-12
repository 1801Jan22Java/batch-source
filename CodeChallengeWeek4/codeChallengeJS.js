function calculate() {
		var input1 = document.getElementById("input1").value;
		var input2 = document.getElementById("input2").value;
		var result = document.getElementById("result");
		var ops= document.getElementsByName("operators");
		var op = "";
		for(var j = 0; j<ops.length; j++){
			if(ops[j].checked){
				op = ops[j].value;
			}
		}
		if (isNaN(input1) || isNaN(input2)) {
			result.innerHTML = "cannot compute result";
		} else  if(op=="add"){
			result.innerHTML = "result: "+ (parseInt(input1) + parseInt(input2));
		} else if(op=="sub"){
			result.innerHTML = "result: "+ (parseInt(input1) - parseInt(input2));
		} else if(op=="mult"){
			result.innerHTML = "result: "+ parseInt(input1) * parseInt(input2);
		} else if(op=="div"){
			result.innerHTML = "result: "+ parseInt(input1) / parseInt(input2);
		}
	}