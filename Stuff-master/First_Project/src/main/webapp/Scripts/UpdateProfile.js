window.onload = function (){
	console.log("got here");
	sendAjaxGet("/First_Project/UpdateProfileTransfer", getInfo);
}
var xhr = new XMLHttpRequest()
|| new ActiveXObject("Microsoft.HTTPRequest");

function sendAjaxGet(url, func) {
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("Post", url, true);
	xhr.send();
};

function getInfo(xhr){
	console.log(xhr.responseText);
}
function submit_button() {
	let submit_button1 = document.getElementById("FormSubmit");
	let submit_button1_value = submit_button1.getAttribute("type").valueOf()
	if (submit_button1_value == "hidden") {
		submit_button1.setAttribute("type", "submit");
	}
}
document.getElementById("UpdateUsername").addEventListener("click", function(e) {
	document.getElementById("UpdateUsernameForm").setAttribute("type", "text");
	submit_button();
	

}, false)

document.getElementById("UpdatePassword").addEventListener("click", function(e) {
	document.getElementById("UpdatePasswordForm").setAttribute("type", "text");
	submit_button();
}, false)

document.getElementById("UpdateEmail").addEventListener("click", function(e) {
	document.getElementById("UpdateEmailForm").setAttribute("type", "text");
	submit_button();
}, false)


var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");
window.onload = function(){	

	function getAllPendingRequests() {
		xhr.open("Get", "/First_Project/AllPendingRequestServlet");
		xhr.send();
		xhr.onreadystatechange = PendingRequests;
	};



	function PendingRequests() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if(JSON.parse(xhr.responseText)){
			obj = JSON.parse(xhr.responseText);
			
			
			console.log(obj);
			//console.log(obj.things.length);
			//console.log(obj.Request_Id);
			//console.log(Object.keys(obj).length + " this is the size");
			var j = 0;
			var keys = [];
			var values = [];
			console.log(obj.things.length);
			for (var x = 0; x < obj.things.length; x++) {
				miniObj = obj.things[x];
				 j = 0;
				
				for (var key in miniObj) {
					if (key != undefined) {
						keys[j] = key;
					}
					//console.log(miniObj[key]);
					if (miniObj[key] != undefined) {
						
						values[j] = miniObj[key];
					}
					j++;
				}
				
				
				
				var table = document.getElementById("All_Pending");
				if (x<= 0) {
					//console.log("got here");
					var headRow = table.insertRow(-1);
					
					for (var i = 0; i <keys.length; i++) {
						var headCell = headRow.insertCell(-1);
						headCell.innerHTML = keys[i];
					}
				}
				// count is the number of things in the object need to set -6

				var headRow = table.insertRow(1);
				for (var i = 0; i < Object.keys(miniObj).length; i++) {
					var headCell = headRow.insertCell(i);
					headCell.innerHTML = values[i];
				}

				
			}
		 }
		}else{document.getElementById("All_Resolved").innerHTML = "No Completed Requests"
		}
	}
	};