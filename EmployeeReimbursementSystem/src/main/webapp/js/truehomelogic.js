/**
 * 
 */

window.onload = getAjax("ManCheckServlet", manFunction);


    
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
   
    //If a manager they can go into the manager features, otherwise they are stuck
    function manFunction(xhttp){
    	var jsonResponse = JSON.parse(xhttp.responseText);
    	console.log(jsonResponse);
    	if (jsonResponse.isMan > 0){
    		document.getElementById("manTime").style.display = "block";
    	} else {
    		document.getElementById("manTime").style.display = "none";
    	}
    }
    