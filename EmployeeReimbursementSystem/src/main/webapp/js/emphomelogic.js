/**
 * 
 */

window.onload = getAjax("EmployeesServlet", empFunction);

document.getElementById("editBut").addEventListener("click",determineReq);
empstatID = document.getElementById("empChange");
statChange = "passwordchange";
statVal = "-1";
empUse = "-1";
    
    function getAjax(url, myFunc ){
    var xhttp;
xhttp=new XMLHttpRequest||new ActiveXObject("Microsoft.HttpRequest");
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
      myFunc(this);
    }
  };
xhttp.open("GET", url, true);
xhttp.send();
}

function empFunction(xhttp){
    jsonResponse = JSON.parse(xhttp.responseText);
    console.log(jsonResponse);
    document.getElementById("empID").innerHTML = jsonResponse.employeeID;
    document.getElementById("empAccount").innerHTML = jsonResponse.account;
    document.getElementById("empPassword").innerHTML = jsonResponse.password;
    document.getElementById("empFirstName").innerHTML = jsonResponse.fName;
    document.getElementById("empLastName").innerHTML = jsonResponse.lName;
    document.getElementById("empEmail").innerHTML = jsonResponse.email;
}




function secondAjax(url, myFunc){
	var http;
	xhttp = new XMLHttpRequest||new ActiveXObject("Microsoft.HttpRequest");
	xhttp.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200){
			myFunc(this);
		}
	}
	xhttp.open("GET", url, true);
	xhttp.send();
}

function determineReq(){
	statVal = document.getElementById("useredittext").value;
	statChange = empstatID.value;
	empUse = jsonResponse.employeeID;
	console.log(statVal);
	console.log(statChange);
	secondAjax("EmpEditServlet?statVal="+statVal+"&statChange="+statChange+"&empUse="+empUse, decideFunction);
}

function decideFunction(xhttp){
	console.log("wow");
	empFunction(xhttp);
    //jsonResponse = JSON.parse(xhttp.responseText);
    //console.log(jsonResponse);
}
