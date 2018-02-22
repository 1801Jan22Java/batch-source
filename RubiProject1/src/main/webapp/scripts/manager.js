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
	 	document.getElementById('profileName').innerHTML = userObj.firstName + " " + userObj.lastName;
	 	document.getElementById('profileEmpId').innerHTML = userObj.employeeId;
	 	document.getElementById('profileEmail').innerHTML = userObj.email;
	 	if(userObj.username){
	 		document.getElementById('profileUsername').innerHTML = userObj.username;
	 	} else {
	 		document.getElementById('profileUsername').innerHTML = 'you have none';
	 	}
	 
	 } else {
	 		window.location = 'http://localhost:8084/RubiProject1/login';
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

/*******************************/
/** manager home page scripts **/
/*******************************/
function populateAllPending(xhr) {
	let listAllPending = JSON.parse(xhr.responseText);
	if(xhr.responseText) {
		// console.log(res);
		// console.log(res[0]);
	    let allPendingTableDiv = document.getElementById('allPending-req');
	    let table = document.createElement('table');
	    table.className = 'table table-hover';
	    let tableBody = document.createElement('tbody');

	    // table.border = '1'
	    table.appendChild(tableBody);

		// int reqId, String reqName, double amount, int employeeId, String reqStatus, String receipt,
		// int modByManagerId
	    let heading = new Array();
	    heading[0] = 'Request ID';
	    heading[1] = 'Request Description';
	    heading[2] = 'Amount';
	    heading[3] = 'Employee ID';
	    heading[4] = 'Request Status';
	    heading[5] = 'Receipt';
	    heading[6] = 'Checked By Manager ID';
	    heading[7] = 'Approve/Deny';

	    let stock = new Array();
	    for(let i = 0; i < listAllPending.length; i++) {
	    	stock[i] = new Array(listAllPending[i].reqId, listAllPending[i].reqName, listAllPending[i].amount, listAllPending[i].employeeId, listAllPending[i].reqStatus, listAllPending[i].receipt, listAllPending[i].modByManagerId);
	    }

	    //TABLE COLUMNS
	    let tr = document.createElement('tr');
	    tableBody.appendChild(tr);
	    for (i = 0; i < heading.length; i++) {
	        let th = document.createElement('th')
	        th.width = '100';
	        th.appendChild(document.createTextNode(heading[i]));
	        tr.appendChild(th);
	    }

	    //TABLE ROWS
	    for (i = 0; i < stock.length; i++) {
	        let tr = document.createElement('tr');
	        /*tr.setAttribute('data-toggle', 'modal');
	        tr.setAttribute('data-id', stock[i][0]);
	        tr.setAttribute('data-target', '#orderModal');*/
	        
	        for (j = 0; j < stock[i].length; j++) {
	            let td = document.createElement('td');
	            td.appendChild(document.createTextNode(stock[i][j]));
	            tr.appendChild(td);
	        }

	        let btnstd = document.createElement('td');

	        let form1 = document.createElement('form');
	        form1.setAttribute('name', 'approveForm');
	        form1.setAttribute('action', 'approveordeny');
	        form1.setAttribute('method', 'post');

	        let input1 = document.createElement('input');
	        input1.setAttribute('type', 'hidden');
	        input1.setAttribute('name', 'approved');
	        input1.setAttribute('value', stock[i][0]);

	        let approveBtn = document.createElement('button');
	        approveBtn.innerHTML = "Approve";
	        approveBtn.setAttribute('class', 'btn btn-outline-success btn-sm');
	        approveBtn.setAttribute('type', 'submit');
	   		

	        let form2 = document.createElement('form');
	        form2.setAttribute('name', 'denyForm');
	        form2.setAttribute('action', 'approveordeny');
	        form2.setAttribute('method', 'post');

	    	let input2 = document.createElement('input');
	        input2.setAttribute('type', 'hidden');
	        input2.setAttribute('name', 'denied');
	        input2.setAttribute('value', stock[i][0]);

	        let denyBtn = document.createElement('button');
	        denyBtn.innerHTML = "Deny";
	        denyBtn.setAttribute('class', 'btn btn-outline-danger btn-sm');
	        denyBtn.setAttribute('type', 'submit');

	        form1.appendChild(input1);
	        form1.appendChild(approveBtn);

	        form2.appendChild(input2);
	        form2.appendChild(denyBtn);

	        btnstd.appendChild(form1);
	        btnstd.appendChild(form2);
	        tr.appendChild(btnstd);

	        tableBody.appendChild(tr);
	    }

	    allPendingTableDiv.appendChild(table);

	} else {
		document.getElementById("noPending").innerHTML = 'You have no pending request';
	}
}

function populateAllResolved(xhr) {
	let listAllResolved = JSON.parse(xhr.responseText);
	if(xhr.responseText) {
		// console.log(res);
		// console.log(res[0]);
	    let allResolvedTableDiv = document.getElementById('allResolved-req');
	    let table = document.createElement('table');
	    table.className = 'table table-hover';
	    let tableBody = document.createElement('tbody');

	    // table.border = '1'
	    table.appendChild(tableBody);

		// int reqId, String reqName, double amount, int employeeId, String reqStatus, String receipt,
		// int modByManagerId
	    let heading = new Array();
	    heading[0] = 'Request ID';
	    heading[1] = 'Request Description';
	    heading[2] = 'Amount';
	    heading[3] = 'Employee ID';
	    heading[4] = 'Request Status';
	    heading[5] = 'Receipt';
	    heading[6] = 'Checked By Manager ID';

	    let stock = new Array();
	    for(let i = 0; i < listAllResolved.length; i++) {
	    	stock[i] = new Array(listAllResolved[i].reqId, listAllResolved[i].reqName, listAllResolved[i].amount, listAllResolved[i].employeeId, listAllResolved[i].reqStatus, listAllResolved[i].receipt, listAllResolved[i].modByManagerId);
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
	            let td = document.createElement('td');
	            td.appendChild(document.createTextNode(stock[i][j]));
	            tr.appendChild(td);
	        }

	        tableBody.appendChild(tr);
	    }

	    allResolvedTableDiv.appendChild(table);

	} else {
		document.getElementById('noResolved').innerHTML = 'You have no resolved request';
	}
}

function populateEmployees(xhr) {
	/** employeeId, lastName, firstName, email, username, strManager, reportsTo **/
	let listAllEmployees = JSON.parse(xhr.responseText);
	if(xhr.responseText) {
		// console.log(res);
		// console.log(res[0]);
	    let allEmpTableDiv = document.getElementById('allEmployee-req');
	    let table = document.createElement('table');
	    table.className = 'table table-hover';
	    let tableBody = document.createElement('tbody');

	    // table.border = '1'
	    table.appendChild(tableBody);

		/** employeeId, lastName, firstName, email, username, strManager, reportsTo **/
	    let heading = new Array();
	    heading[0] = 'Employee ID';
	    heading[1] = 'First Name';
	    heading[2] = 'Last Name';
	    heading[3] = 'Email';
	    heading[4] = 'Username';
	    heading[5] = 'Is a manager';
	    heading[6] = 'Reports to Employee ID';

	    let stock = new Array();
	    for(let i = 0; i < listAllEmployees.length; i++) {
	    	stock[i] = new Array(listAllEmployees[i].employeeId, listAllEmployees[i].firstName, listAllEmployees[i].lastName, listAllEmployees[i].email, listAllEmployees[i].username, listAllEmployees[i].strManager, listAllEmployees[i].reportsTo);
	    }

	    //TABLE COLUMNS
	    let tr = document.createElement('tr');
	    tableBody.appendChild(tr);
	    for (i = 0; i < heading.length; i++) {
	        let th = document.createElement('th');
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
	            tr.appendChild(td);
	        }

	        tableBody.appendChild(tr);
	    }
	      
	    allEmpTableDiv.appendChild(table);

	} else {
		document.getElementById('noEmployee').innerHTML = 'You have no employees';
	}
}

 window.onload = function() {
 	sendAjaxGet('http://localhost:8084/RubiProject1/session', populateUser);
 	sendAjaxGet('http://localhost:8084/RubiProject1/getallpending', populateAllPending);
 	sendAjaxGet('http://localhost:8084/RubiProject1/getallresolved', populateAllResolved);
 	sendAjaxGet('http://localhost:8084/RubiProject1/getallemployees', populateEmployees);
 }