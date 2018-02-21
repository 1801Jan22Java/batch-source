function sendAjaxGet() {    
    // get new XHR object
    var newXHR = new XMLHttpRequest();
    
    newXHR.open( 'GET', "http://localhost:8079/Project1_Reimbursement/login.html");
    newXHR.send();
  };
window.onload(sendAjaxGet());