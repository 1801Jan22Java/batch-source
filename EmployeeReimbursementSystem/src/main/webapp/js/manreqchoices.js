/**
 * 
 */

window.onload = getAjax("AllRequestsServlet", manFunction);

document.getElementById("aok").addEventListener("click",determineReq);
document.getElementById("nope").addEventListener("click",determineReq);
document.getElementById("tellmemore").addEventListener("click",determineReq);
    
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

    
    function manFunction(xhttp){
        jsonResponse = JSON.parse(xhttp.responseText);
        console.log(jsonResponse);
        tableParse();
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
    	console.log("nice");
    	if (reqID == -1)
    		return;
    	decVal = 5;
    	if (event.target.id == "aok"){
    			decVal = 6;
    		}
    	else if (event.target.id == "tellmemore"){
    			decVal = 3;
    		}
    	console.log(decVal);
    	getAjax("DecideRequestServlet?decVal="+decVal+"&reqID="+reqID, decideFunction);
    }
    
    function decideFunction(xhttp){
    	console.log("wow");
        //jsonResponse = JSON.parse(xhttp.responseText);
        //console.log(jsonResponse);
    }
    
    function tableParse(){
    	reqID = -1;
        if (jsonResponse.length>0){
        	for (var i = 0; i < jsonResponse.length; i++){
        		if (jsonResponse[i].statusID < 4){
        		reqID = jsonResponse[i].requestID;;	
        		console.log("rawr");
            	var cont = document.getElementById("unfinishedreqs");
            	var tabl1 = document.getElementById("tabneed");
        		var tr1 = document.createElement("tr");
        		tr1.classList.add("warning", "boldtext");
        		tr1.setAttribute("id", "employeeInfo");
        		var th1 = document.createElement("th")
        		th1.innerHTML = "Request ID";
        		var th2 = document.createElement("th")
        		th2.innerHTML = "Employee ID";
        		var th3 = document.createElement("th")
        		th3.innerHTML = "Request Amount";
        		var tr2 = document.createElement("tr");
        		tr2.classList.add("success", "gentletext");
        		tr2.setAttribute("id", "employeeStuff1")
        		var td1 = document.createElement("td");
        		td1.innerHTML = jsonResponse[i].requestID;
        		var td2 = document.createElement("td");
        		td2.innerHTML = jsonResponse[i].empID;
        		var td3 = document.createElement("td");
        		td3.innerHTML = "$" + jsonResponse[i].amount;
        		var tr3 = document.createElement("tr");
        		tr3.classList.add("warning", "boldtext");
        		tr3.setAttribute("id", "employeeInfo");
        		var th4 = document.createElement("th");
        		th4.innerHTML = "Category";
        		var th5 = document.createElement("th");
        		th5.innerHTML = "Submit Date";
        		var th6 = document.createElement("th");
        		th6.innerHTML = "Description";
        		var tr4 = document.createElement("tr");
        		tr4.classList.add("success", "gentletext");
        		tr4.setAttribute("id", "employeeStuff2");
        		var td4 = document.createElement("td");
        		var catType = jsonResponse[i].typeID;
        		var catFinal = "Unknown"
        		if (catType == 11)
        			catFinal = "Business";
        		else if (catType == 12)
        			catFinal = "Travel";
        		else if (catType == 13)
        			catFinal = "Housing";
        		else if (catType == 14)
        			catFinal = "Education";
        		else if (catType == 15)
        			catFinal = "Hiring";
        		else if (catType == 16)
        			catFinal = "Inventory";
        		else if (catType == 17)
        			catFinal = "Food";
        		else if (catType == 18)
        			catFinal = "Personal";
        		else if (catType == 19)
        			catFinal = "Insurance";
        		else if (catType == 20)
        			catFinal = "Entertainment";
        		else if (catType == 21)
        			catFinal = "Miscellaneous";
        		td4.innerHTML = catFinal;
        		var subDateDay = jsonResponse[i].submitDate;
        		var subDate = " " + subDateDay.month + " " + subDateDay.dayOfMonth +
        		", " + subDateDay.year;
        		var td5 = document.createElement("td");
        		td5.innerHTML = subDate;
        		var td6 = document.createElement("td");
        		td6.innerHTML = jsonResponse[i].description;
        		var tr5 = document.createElement("tr");
        		tr5.classList.add("warning", "boldtext");
        		tr5.setAttribute("id", "employeeInfo");
        		var th7 = document.createElement("th");
        		th7.innerHTML = "Manager ID";
        		var th8 = document.createElement("th");
        		th8.innerHTML = "Status Dat";
        		var th9 = document.createElement("th");
        		th9.innerHTML = "Current Status";
        		var tr6 = document.createElement("tr");
        		tr6.classList.add("success", "gentletext");
        		tr6.setAttribute("id", "employeeStuff2");
        		var td7 = document.createElement("td");
        		td7.innerHTML = jsonResponse[i].manID;
        		var td8 = document.createElement("td");
        		var statDateDay = jsonResponse[i].statusDate;
        		var statDate = " " + statDateDay.month + " " + statDateDay.dayOfMonth +
        		", " + statDateDay.year;
        		td8.innerHTML = statDate;
        		var td9 = document.createElement("td");
        		var statusNow = jsonResponse[i].statusID;
        		var statNow = "Error Unknown";
        		if (statusNow == 1)
        			statNow = "Submitted";
        		else if (statusNow == 2)
        			statNow = "Pending";
        		else if (statusNow == 3)
        			statNow = "More Info Required";
        		else if (statusNow == 4)
        			statNow = "Cancelled";
        		else if (statusNow == 5)
        			statNow = "Declined";
        		else if (statusNow == 6)
        			statNow = "Approved";
        		td9.innerHTML = statNow;
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
        		tr5.appendChild(th7);
        		tr5.appendChild(th8);
        		tr5.appendChild(th9);
        		tr6.appendChild(td7);
        		tr6.appendChild(td8);
        		tr6.appendChild(td9);  		
        		tabl1.appendChild(tr1);
        		tabl1.appendChild(tr2);
        		tabl1.appendChild(tr3);
        		tabl1.appendChild(tr4);
        		tabl1.appendChild(tr5);
        		tabl1.appendChild(tr6);
        		cont.appendChild(tabl1);
        		//document.body.appendChild(cont);
        		console.log("coolacity pow");
        		return;
        		}
        	}
        }
    }
    