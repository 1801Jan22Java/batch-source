
function submit_button() {
	let submit_button1 = document.getElementById("FormSubmit");
	let submit_button1_value = submit_button1.getAttribute("type").valueOf()
	if (submit_button1_value == "hidden") {
		submit_button1.setAttribute("type", "submit");
	}
}
document.getElementById("UpdateUsername").addEventListener("click", function(e) {
	document.getElementById("UpdateUsernameForm").setAttribute("type", "text");
	submit_button();

}, false)

document.getElementById("UpdatePassword").addEventListener("click", function(e) {
	document.getElementById("UpdatePasswordForm").setAttribute("type", "text");
	submit_button();
}, false)

document.getElementById("UpdateEmail").addEventListener("click", function(e) {
	document.getElementById("UpdateEmailForm").setAttribute("type", "text");
	submit_button();
}, false)
