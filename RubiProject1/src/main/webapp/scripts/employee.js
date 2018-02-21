/**************/
/** AJAX GET **/
/**************/
 function sendAjaxGet(url, func) {
 	var xhr = new XMLHttpRequest() 
 			|| new ActiveXObject("Microsoft.HTTPRequest");
 	xhr.onreadystatechange = function() {
 		if(this.readyState == 4 && this.status == 200) {
 			func(this);
 		}
 	};
 	xhr.open('GET', url, true);
 	xhr.send();
 };

 function populateUser(xhr) {
 	let userObj = JSON.parse(xhr.responseText);
 	if(xhr.responseText) {
	 	document.getElementById("profileName").innerHTML = userObj.firstName + " " + userObj.lastName;
	 	document.getElementById("profileEmpId").innerHTML = userObj.employeeId;
	 	document.getElementById("profileEmail").innerHTML = userObj.email;
	 	if(userObj.username){
	 		document.getElementById("profileUsername").innerHTML = userObj.username;
	 	} else {
	 		document.getElementById("profileUsername").innerHTML = 'you have none';
	 	}
	 
	 } else {
	 		window.location = "http://localhost:8084/RubiProject1/login";
	 }
 }

/************************/
/** File adding script **/
/************************/
var bar = document.getElementById('js-progressbar');

UIkit.upload('.js-upload', {

    url: '',
    multiple: true,

    beforeSend: function () {
        console.log('beforeSend', arguments);
    },
    beforeAll: function () {
        console.log('beforeAll', arguments);
    },
    load: function () {
        console.log('load', arguments);
    },
    error: function () {
        console.log('error', arguments);
    },
    complete: function () {
        console.log('complete', arguments);
    },

    loadStart: function (e) {
        console.log('loadStart', arguments);

        bar.removeAttribute('hidden');
        bar.max = e.total;
        bar.value = e.loaded;
    },

    progress: function (e) {
        console.log('progress', arguments);

        bar.max = e.total;
        bar.value = e.loaded;
    },

    loadEnd: function (e) {
        console.log('loadEnd', arguments);

        bar.max = e.total;
        bar.value = e.loaded;
    },

    completeAll: function () {
        console.log('completeAll', arguments);

        setTimeout(function () {
            bar.setAttribute('hidden', 'hidden');
        }, 1000);

        alert('Upload Completed');
    }
});

/********************************/
/** employee home page scripts **/
/********************************/
function populateUserPending(xhr) {
	let listUserPending = JSON.parse(xhr.responseText);
	if(xhr.responseText) {
		// console.log(res);
		// console.log(res[0]);
	    let userPendingTableDiv = document.getElementById("user-pending-req");
	    let table = document.createElement('table');
	    table.className = 'table table-hover';
	    let tableBody = document.createElement('tbody');

	    // table.border = '1'
	    table.appendChild(tableBody);

		// int reqId, String reqName, double amount, int employeeId, String reqStatus, String receipt,
		// int modByManagerId
	    let heading = new Array();
	    heading[0] = "Request ID";
	    heading[1] = "Request Description";
	    heading[2] = "Amount";
	    heading[3] = "Employee ID";
	    heading[4] = "Request Status";
	    heading[5] = "Receipt";
	    heading[6] = "Checked By Manager ID"

	    let stock = new Array();
	    for(let i = 0; i < listUserPending.length; i++) {
	    	stock[i] = new Array(listUserPending[i].reqId, listUserPending[i].reqName, listUserPending[i].amount, listUserPending[i].employeeId, listUserPending[i].reqStatus, listUserPending[i].receipt, listUserPending[i].modByManagerId);
	    }

	    //TABLE COLUMNS
	    let tr = document.createElement('tr');
	    tableBody.appendChild(tr);
	    for (i = 0; i < heading.length; i++) {
	        let th = document.createElement('th')
	        th.width = '75';
	        th.appendChild(document.createTextNode(heading[i]));
	        tr.appendChild(th);
	    }

	    //TABLE ROWS
	    for (i = 0; i < stock.length; i++) {
	        let tr = document.createElement('tr');
	        for (j = 0; j < stock[i].length; j++) {
	            let td = document.createElement('td')
	            td.appendChild(document.createTextNode(stock[i][j]));
	            tr.appendChild(td)
	        }
	        tableBody.appendChild(tr);
	    }  

	    userPendingTableDiv.appendChild(table);

	} else {
		document.getElementById("noPending").innerHTML = 'You have no pending request';
	}
}

function populateUserResolved(xhr) {
	let listUserResolved = JSON.parse(xhr.responseText);
	if(xhr.responseText) {
		// console.log(listUserResolved);
		// console.log(listUserResolved[0]);
	    let userResolvedTableDiv = document.getElementById("user-resolved-req");
	    let table = document.createElement('table');
	    table.className = 'table table-hover';
	    let tableBody = document.createElement('tbody');

	    // table.border = '1'
	    table.appendChild(tableBody);

		// int reqId, String reqName, double amount, int employeeId, String reqStatus, String receipt,
		// int modByManagerId
	    let heading = new Array();
	    heading[0] = "Request ID";
	    heading[1] = "Request Description";
	    heading[2] = "Amount";
	    heading[3] = "Employee ID";
	    heading[4] = "Request Status";
	    heading[5] = "Receipt";
	    heading[6] = "Checked By Manager ID"

	    let stock = new Array();
	    for(let i = 0; i < listUserResolved.length; i++) {
	    	stock[i] = new Array(listUserResolved[i].reqId, listUserResolved[i].reqName, listUserResolved[i].amount, listUserResolved[i].employeeId, listUserResolved[i].reqStatus, listUserResolved[i].receipt, listUserResolved[i].modByManagerId);
	    }

	    //TABLE COLUMNS
	    let tr = document.createElement('tr');
	    tableBody.appendChild(tr);
	    for (i = 0; i < heading.length; i++) {
	        let th = document.createElement('th')
	        th.width = '75';
	        th.appendChild(document.createTextNode(heading[i]));
	        tr.appendChild(th);
	    }

	    //TABLE ROWS
	    for (i = 0; i < stock.length; i++) {
	        let tr = document.createElement('tr');
	        for (j = 0; j < stock[i].length; j++) {
	            let td = document.createElement('td')
	            td.appendChild(document.createTextNode(stock[i][j]));
	            tr.appendChild(td)
	        }
	        tableBody.appendChild(tr);
	    }  
	    userResolvedTableDiv.appendChild(table);

	} else {
		document.getElementById("noResolved").innerHTML = 'You have no resolved request';
	}
}

 window.onload = function() {
 	sendAjaxGet("http://localhost:8084/RubiProject1/session", populateUser);
 	sendAjaxGet("http://localhost:8084/RubiProject1/getmypending", populateUserPending );
 	sendAjaxGet("http://localhost:8084/RubiProject1/getmyresolved", populateUserResolved);
 }