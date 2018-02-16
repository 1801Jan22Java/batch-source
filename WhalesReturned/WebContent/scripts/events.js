// JavaScript source code

window.onload = function () {
    var usernameField = document.getElementById("email");
    var passwordField = document.getElementById("pwd");

    var submitButton = document.getElementById("submitButton");

    submitButton.onclick = function submitLogin() {
        var usernameText = usernameField.value;
        var passwordText = passwordField.value;

        var alerts = document.getElementsByClassName("alert");
        for (var i = 0; i < alerts.length; i++){
            alerts[i].remove();
        }

        if (passwordText.length < 5) {
            var warnDiv = document.getElementById("warningDiv");

            var newAlert = document.createElement("div");
            newAlert.setAttribute("class", "alert alert-danger");
            newAlert.setAttribute("id", "alert");
            newAlert.innerText = "Error! Password must be at least 5 characters!";
            warnDiv.appendChild(newAlert);

            console.log(passwordText.length);
        }
        else {
            var warnDiv = document.getElementById("warningDiv");

            var newAlert = document.createElement("div");
            newAlert.setAttribute("class", "alert alert-success");
            newAlert.setAttribute("id", "alert");
            newAlert.innerText = "Success! Email has been successfully hacked!";
            warnDiv.appendChild(newAlert);
        }
    }

}