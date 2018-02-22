//manager
document.getElementById("approval-tab").addEventListener("click", function () {
    clearSelected("myTab2");
    this.className = "nav-link active";
    this.setAttribute("aria-selected", "true");
    document.getElementById("approval").className = "tab-pane fade show active";
})

document.getElementById("all-pending-tab").addEventListener("click", function () {
    clearSelected("myTab2");
    this.className = "nav-link active";
    this.setAttribute("aria-selected", "true");
    document.getElementById("allpending").className = "tab-pane fade show active";
})

document.getElementById("all-resolved-tab").addEventListener("click", function () {
    clearSelected("myTab2");
    this.className = "nav-link active";
    this.setAttribute("aria-selected", "true");
    document.getElementById("allresolved").className = "tab-pane fade show active";
})

document.getElementById("all-employees-tab").addEventListener("click", function () {
    clearSelected("myTab2");
    this.className = "nav-link active";
    this.setAttribute("aria-selected", "true");
    document.getElementById("allemployees").className = "tab-pane fade show active";
})
document.getElementById("employee-view-tab").addEventListener("click", function () {
    clearSelected("myTab2");
    this.className = "nav-link active";
    this.setAttribute("aria-selected", "true");
    document.getElementById("employeeview").className = "tab-pane fade show active";
})

function clearSelected(tab) {
    var tabs = document.getElementById(tab).children;
    for (var i = 0; i < tabs.length; i++) {
        if (tabs[i].children[0].getAttribute("aria-selected") == "true") {
            tabs[i].children[0].setAttribute("aria-selected", "true");
            tabs[i].children[0].className = "nav-link";
            var tabPane = document.getElementById(tabs[i].children[0].getAttribute("aria-controls"));
            tabPane.className = "tab-pane fade";
        }
    }
}


function sendAjaxGet(url, func) {
    //step 1: obtain xhr
    var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    //step 2: define onreadystatechange
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    };
    //step 3: prepare request
    xhr.open("GET", url, true);
    //step 4: send request
    xhr.send();
}


////////////////////////
//      PENDING       //
////////////////////////
function getAllPending(xhr) {
    let pending = JSON.parse(xhr.responseText);
    if (xhr.responseText) {

        let pendingTableDiv = document.getElementById("all-pending-requests");
        let pendingTable = document.createElement('table');
        pendingTable.className = 'table table-hover';
        let pendingTableBody = document.createElement('tbody');
        pendingTable.appendChild(pendingTableBody);

        //headers for table
        let headers = new Array();
        headers[0] = "Request ID";
        headers[1] = "Employee ID";
        headers[2] = "Status";
        headers[3] = "Receipt";
        headers[4] = "Approving Manager"

        let pendingRequests = new Array();
        for (let i = 0; i < pending.length; i++) {
            pendingRequests[i] = new Array(pending[i].requestId, pending[i].empId, pending[i].status, pending[i].image, pending[i].manager);
        }

        //column names
        let tr = document.createElement('tr');
        pendingTableBody.appendChild(tr);
        for (i = 0; i < headers.length; i++) {
            let th = document.createElement('th')
            th.width = '75';
            th.appendChild(document.createTextNode(headers[i]));
            tr.appendChild(th);
        }

        //values
        for (i = 0; i < pendingRequests.length; i++) {
            let tr = document.createElement('tr');
            for (j = 0; j < pendingRequests[i].length; j++) {
                let td = document.createElement('td')
                if (j == 3) {
                    var img = document.createElement("img");
                    img.setAttribute('src', pendingRequests[i][j]);
                    td.appendChild(img);
                    tr.appendChild(td);
                }
                else {
                    td.appendChild(document.createTextNode(pendingRequests[i][j]));
                    tr.appendChild(td)
                }
            }
            pendingTableBody.appendChild(tr);
        }

        pendingTableDiv.appendChild(pendingTable);


    }
    else {
        document.getElementById("all-pending-requests").innerHTML = 'No pending requests';
    }
}


////////////////////////
//      RESOLVED      //
////////////////////////
function getAllResolved(xhr) {
    let resolved = JSON.parse(xhr.responseText);

    if (xhr.responseText) {

        let resolvedTableDiv = document.getElementById("all-resolved-requests");
        let resolvedTable = document.createElement('table');
        resolvedTable.className = 'table table-hover';
        let resolvedTableBody = document.createElement('tbody');
        resolvedTable.appendChild(resolvedTableBody);

        //headers for table
        let headers = new Array();
        headers[0] = "Request ID";
        headers[1] = "Employee ID";
        headers[2] = "Status";
        headers[3] = "Receipt";
        headers[4] = "Approving Manager";

        let resolvedRequests = new Array();
        for (let i = 0; i < resolved.length; i++) {
            resolvedRequests[i] = new Array(resolved[i].requestId, resolved[i].empId, resolved[i].status, resolved[i].image, resolved[i].manager);
        }

        //column names
        let tr = document.createElement('tr');
        resolvedTableBody.appendChild(tr);
        for (i = 0; i < headers.length; i++) {
            let th = document.createElement('th')
            th.width = '75';
            th.appendChild(document.createTextNode(headers[i]));
            tr.appendChild(th);
        }

        //values
        for (i = 0; i < resolvedRequests.length; i++) {
            let tr = document.createElement('tr');
            for (j = 0; j < resolvedRequests[i].length; j++) {
                let td = document.createElement('td')
                if (j == 3) {
                    var img = document.createElement("img");
                    img.setAttribute('src', resolvedRequests[i][j]);
                    td.appendChild(img);
                    tr.appendChild(td);
                }
                else {
                    td.appendChild(document.createTextNode(resolvedRequests[i][j]));
                    tr.appendChild(td)
                }
            }
            resolvedTableBody.appendChild(tr);
        }

        resolvedTableDiv.appendChild(resolvedTable);


    }
    else {
        document.getElementById("all-resolved-requests").innerHTML = 'No resolved requests';
    }

}


////////////////////////
//    EMPLOYEE INFO   //
////////////////////////
function getAllEmployeeInfo(xhr) {
    let empInfo = JSON.parse(xhr.responseText);

    console.log(empInfo);

    let infoTableDiv = document.getElementById("info-view-all");
    let infoTable = document.createElement('table');
    infoTable.className = 'table table-hover';
    let infoTableBody = document.createElement('tbody');
    infoTable.appendChild(infoTableBody);

    //headers for table
    let headers = new Array();
    headers[0] = "Employee ID";
    headers[1] = "Username";
    headers[2] = "Password";
    headers[3] = "First Name";
    headers[4] = "Last Name";
    headers[5] = "Manager?"

    let infoView = new Array();
    for (let i = 0; i < empInfo.length; i++) {
    infoView[i] = new Array(empInfo[i].employeeId, empInfo[i].username, empInfo[i].password, empInfo[i].firstName, empInfo[i].lastName, empInfo[i].manager);
    }

    //column names
    let tr = document.createElement('tr');
    infoTableBody.appendChild(tr);
    for (i = 0; i < headers.length; i++) {
        let th = document.createElement('th')
        th.width = '75';
        th.appendChild(document.createTextNode(headers[i]));
        tr.appendChild(th);
    }

    //values
    for (i = 0; i < infoView.length; i++) {
        let tr = document.createElement('tr');
        for (j = 0; j < infoView[i].length; j++) {
            let td = document.createElement('td')

            td.appendChild(document.createTextNode(infoView[i][j]));
            tr.appendChild(td)
        }
        infoTableBody.appendChild(tr);
    }

    infoTableDiv.appendChild(infoTable);


}


window.onload = function () {
    sendAjaxGet('http://localhost:8084/Project1/allpending', getAllPending);
    sendAjaxGet('http://localhost:8084/Project1/allresolved', getAllResolved);
    sendAjaxGet('http://localhost:8084/Project1/viewallinfo', getAllEmployeeInfo);
}
