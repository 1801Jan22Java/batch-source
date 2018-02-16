function checkPassword(passwordBox) {
	//var passwordBox = document.getElementById("exampleInputPassword1");
	if (passwordBox.value == "password") {
		passwordBox.style.backgroundColor = "green";
	} else {
		passwordBox.style.backgroundColor = "red";
	}
}

var site = '{"authors": ["Conan", "Calvin", "Jeff"], "actors": ["Tom Hanks", "Brad Pitt"], "genres": ["Drama", "Action", "Comedy"]}';

var siteObjects = JSON.parse(site);
window.onload = function(){
	console.log(siteObjects);
}

