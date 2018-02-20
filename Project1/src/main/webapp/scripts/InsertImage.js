/**
 *
 */

function sendAjaxPost(url) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	var file = document.getElementById("image").files[0];
    var new_url = url + "?value=" + document.getElementById("value").value;
	xhr.open("POST",new_url);

	xhr.onreadystatechange = function() {
	    if(xhr.readyState == 4 && xhr.status == 200) {
	    	alert("Reimbursement successfully submitted");
	    }
	    else if (xhr.status != 200){
	    	alert("Something went wrong, please try again");
	    }
	    location.reload(true);
	}
	if (file) {
		xhr.send(file);
	}
	else {
		return;
	}


}

window.onload = function() {
	document.getElementById("submitbutton").addEventListener("click",function(){
		sendAjaxPost("http://localhost:8084/Project1/submitreimbursement")
	});
}
