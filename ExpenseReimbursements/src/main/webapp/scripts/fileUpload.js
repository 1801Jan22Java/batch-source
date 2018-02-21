/**
 * 
 */


window.onload = function(){
	document.getElementById("submit").addEventListener('click', function(){
		sendAjaxPost("/ExpenseReimbursements/processRequest")
	})
}