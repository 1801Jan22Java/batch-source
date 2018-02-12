/**
 * 
 */
window.onload = function()
{
	//find nums + opperand
	var num1 = document.getElementById("num1"); 
	var num2 = document.getElementById("num2"); 
	var answer = document.getElementById("answer"); 
	var message = document.getElementById("message");
	num2.addEventListener("onchange", onchange);
};
var onchange = function(event){
	var opp = document.getElementById("opperand").value;
	var ans;
	switch(opp){
	case "add":
		ans = parseInt(num1.value)+parseInt(num2.value);
		break;
	case "sub":
		ans = parseInt(num1.value)-parseInt(num2.value);
		break;
	
	case "multi":
		ans = parseInt(num1.value)*parseInt(num2.value);
		break;
	case "div":
		ans = parseInt(num1.value)/parseInt(num2.value);
		break;
	}
	if(ans)
	{
		answer.textContent = ans;
		message.textContent = "Calc ya later!!!";
	}
};