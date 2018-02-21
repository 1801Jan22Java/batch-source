function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function seeOneInfo(){
    if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		if (res) {
            var table = document.getElementById("empTableBody");
            res.forEach(element => {
                table.appendChild(element);
            });
		}
	} else {
		window.location = "http://localhost:8079:Project1_Reimbursement/employee_home.html";
	}
};

window.onload(sendAjaxGet())