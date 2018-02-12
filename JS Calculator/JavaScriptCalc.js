//James Whitten

operation = document.getElementsByName("numbers")[0];
operation.addEventListener("change",calculate);

console.log("JS added");

function calculate(event){
	var total = 0;
	var num1 = document.getElementById("calc1").value;
	var num2 = document.getElementById("calc2").value;
	if (isNaN(num1)==true)
	{
		document.getElementById("total").innerText = "Number 1 input is not a number.";
		return;
	}
	if (isNaN(num2)==true)
	{
		document.getElementById("total").innerText = "Number 2 input is not a number.";
		return;
	}
	
	if (event.target.value == "add")
	{
		total = num1 + num2;
	}
	if (event.target.value == "sub")
	{
		total = num1 - num2;
	}
	if (event.target.value == "mult")
	{
		total = num1 * num2;
	}	
	if (event.target.value == "div")
	{
		total = num1 / num2;
	}
	
	document.getElementById("total").innerText = total;
	
}
	
	
	/*
	var nums = document.getElementsByClassName("nums");
		var sum = 0;
			
		for (var i = 0; i < nums.length; i++){
		sum += parseInt(nums[i].value);
		}
		if (isNaN(sum)==true)
		{
			document.getElementById("sum").innerText = "Cannot add";
		}
		else
		{
			document.getElementById("sum").innerText = sum;
		}
	*/