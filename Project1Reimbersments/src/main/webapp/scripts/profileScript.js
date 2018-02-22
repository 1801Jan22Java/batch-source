function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	console.log(xhr);
	xhr.send();
};

function populateUser(xhr) {
	if (xhr.responseText) {
		//document.getElementById("Id").innerHTML = xhr.responseText;
		//cosole.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		if (res.employeeId) {
			//document.getElementById("Id").innerHTML = xhr.responseText;
			//document.getElementById("Id").innerHTML = "you are logged in as employee number: "+ res.employeeId;
			document.getElementById("Name").innerHTML = "Welcome "+ res.firstName+"!";
			document.getElementById("email").innerHTML = res.email;
			document.getElementsByTagName("title")[0].innerHTML = res.firstName+" "+ res.lastName;	
			//var reqTable = document.getElementById("Requests");
		}
			
			
	} else {
		window.location = "http://localhost:8084/Project1Reimbersments/loginPage";
	}
}
function readURL(input) {

	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      $('#blah').attr('src', e.target.result);
	    }

	    reader.readAsDataURL(input.files[0]);
	  }
	}

	$("#imgInp").change(function() {
	  readURL(this);
	});
window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project1Reimbersments/Session", populateUser);
}