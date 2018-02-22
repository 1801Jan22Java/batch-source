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

function seeOneInfo(xhr){
    if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res) {
            var table = document.getElementById("empTableBody");
            var row = document.createElement("tr");
            res.tableValues.forEach(function(element) {
            	
            	var col = document.createElement("td");
            	col.innerHTML=element;
            	row.appendChild(col);
                
            });
            table.appendChild(row);
		}
		console.log(table);
	} else {
		window.location = "http://localhost:8080:ProjectNo1/employee_info.html";
	}
};

window.onload = function () {
	sendAjaxGet("../employee_info", seeOneInfo);
};
