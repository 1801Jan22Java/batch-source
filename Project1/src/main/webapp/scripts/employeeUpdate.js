/**
 * 
 */
function sendAjaxPost(url,func){
	//step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	xhr.onreadystatechange = function(){
		// console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	//step 3: prepare request
	xhr.open("POST",url,true);
	//step 4: send request
	xhr.send();
};

var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

function getEmployeeNameJob(xhr) {
	var res = JSON.parse(xhr.responseText);
	var html = res.fname + ' ' + res.lname;
	document.getElementById("empName").innerHTML = html;
	document.getElementById("empJob").innerHTML = res.job;
}

window.onload = function(){
	sendAjaxPost("empInfo.txt", getEmployeeNameJob);
};