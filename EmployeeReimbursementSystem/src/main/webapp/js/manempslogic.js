/**
 * 
 */

window.onload = getAjax("AllEmployeesServlet", allEmpsFunction);
    
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

function allEmpsFunction(xhttp){
    var jsonResponse = JSON.parse(xhttp.responseText);
  
    //Grabbing all employees and putting them into a table
    if (jsonResponse.length>0){
    	for (var i = 0; i < jsonResponse.length; i++){
    		var cont = document.createElement("div");
    		cont.classList.add("container");
    		var tabl1 = document.createElement("table");
    		tabl1.classList.add("table", "table-bordered");
    		var tr1 = document.createElement("tr");
    		tr1.classList.add("warning", "boldtext");
    		tr1.setAttribute("id", "employeeInfo");
    		var th1 = document.createElement("th")
    		th1.innerHTML = i+1+". ID";
    		var th2 = document.createElement("th")
    		th2.innerHTML = "Account";
    		var th3 = document.createElement("th")
    		th3.innerHTML = "Password";
    		var tr2 = document.createElement("tr");
    		tr2.classList.add("success", "gentletext");
    		tr2.setAttribute("id", "employeeStuff1")
    		var td1 = document.createElement("td");
    		td1.innerHTML = jsonResponse[i].employeeID;
    		var td2 = document.createElement("td");
    		td2.innerHTML = jsonResponse[i].account;
    		var td3 = document.createElement("td");
    		td3.innerHTML = jsonResponse[i].password;
    		var tr3 = document.createElement("tr");
    		tr3.classList.add("warning", "boldtext");
    		tr3.setAttribute("id", "employeeInfo");
    		var th4 = document.createElement("th");
    		th4.innerHTML = "First Name";
    		var th5 = document.createElement("th");
    		th5.innerHTML = "Last Name";
    		var th6 = document.createElement("th");
    		th6.innerHTML = "E-mail";
    		var tr4 = document.createElement("tr");
    		tr4.classList.add("success", "gentletext");
    		tr4.setAttribute("id", "employeeStuff2");
    		var td4 = document.createElement("td");
    		td4.innerHTML = jsonResponse[i].fName;
    		var td5 = document.createElement("td");
    		td5.innerHTML = jsonResponse[i].lName;;
    		var td6 = document.createElement("td");
    		td6.innerHTML = jsonResponse[i].email;
    		tr1.appendChild(th1);
    		tr1.appendChild(th2);
    		tr1.appendChild(th3);
    		tr2.appendChild(td1);
    		tr2.appendChild(td2);
    		tr2.appendChild(td3);
    		tr3.appendChild(th4);
    		tr3.appendChild(th5);
    		tr3.appendChild(th6);
    		tr4.appendChild(td4);
    		tr4.appendChild(td5);
    		tr4.appendChild(td6);
    		tabl1.appendChild(tr1);
    		tabl1.appendChild(tr2);
    		tabl1.appendChild(tr3);
    		tabl1.appendChild(tr4);
    		cont.appendChild(tabl1);
    		document.body.appendChild(cont);
    		console.log("awesome");
    	}
    }
}





