
/*1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/

function getUSA(){
	var spans = document.getElementsByTagName("span");
	for (var i = 0; i < spans.length; i++) {
		if (spans[i].dataset != undefined ) {

			if (spans[i].dataset.customattr == "USA")
			{
				console.log(spans[i].innerHTML);
			}
		}
	}
}


/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
	var entries = document.getElementsByTagName("tr");

	var children;
	for (var i = 0; i < entries.length; i++ ) {
		children = entries[i].children;	

		if (children[1].innerHTML == "Sales") {
			console.log(children[0].innerHTML);
		}
	}
}

/*
Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/

function getAnchorChildren() {
	var anchors = document.getElementsByTagName("a");

	var chidren;

	for (var i = 0; i < anchors.length; i++) {
		children = anchors[i].children;

		for (var j = 0; j < children.length; j++){
			if (children[j].tagName == "SPAN") {
				console.log(children[j].innerHTML);
			}
		}
	}

}

/*
4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.

Print the value and the contents.
*/

function getSkills() {
	var skills = document.getElementsByName("skills");
	var children = skills[0].children;
	for (var i = 0; i < children.length; i++) {
		if (children[i].hasAttribute("selected")) {
			console.log(children[i].innerHTML);
		}
	}
}

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
*/

function getCustomAttribute() {
	var elements = document.body.getElementsByTagName("*");
	for (var i = 0; i < elements.length; i++) {

		if (elements[i].dataset.customattr != undefined) {
			console.log(elements[i]);
		}
	}
}

/*
6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>


Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element
*/

function addNum1Num2(){
	var n1 = parseInt(document.getElementById("num1").value);
	var n2 = parseInt(document.getElementById("num2").value);
	var sumSpan = document.getElementById("sum");
	if (isNaN(n1) || isNaN(n2)) {
		sumSpan.innerHTML = "Cannot add";
	}else {
		sumSpan.innerHTML = (n1 + n2);
	}
};

window.onload = function(){
	document.getElementById("num1").addEventListener("change", addNum1Num2);
	document.getElementById("num2").addEventListener("change", addNum1Num2);
};

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/

function checkSkills(event){

	alert("Are you sure " + event.srcElement.value + " is one of your skills?");

};

/*
8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
*/

function changeColor(event){
	
	var currColor = document.body.style.backgroundColor;
	var nextColor = event.srcElement.value;

	document.body.style.backgroundColor = nextColor;

	alert("So you like " + nextColor + " more than " + currColor + " now?");


}

/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/

function hideOrShow(event) {

	var opacity = event.srcElement.style.opacity;

	if (opacity == 1) {
		event.srcElement.style.opacity = 0;
	} else{
		event.srcElement.style.opacity = 1;
	}

}

/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.

*/

function setTime() {
	var clock = document.getElementById("currentTime");
	var timeString = "";
	var date = new Date();
	timeString = date.toLocaleTimeString(); 
	clock.innerHTML = timeString;

}

var toggle = setInterval(function(){
	setTime();
},1000);

/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/

function stopTimer() {
	var hw = document.getElementById("helloWorld");
	var letters = "0123456789ABCDEF";
	var color = "#";
	for (var i = 0; i < 6; i++) {
	  color += letters[Math.floor(Math.random() * 16)];
	}
	hw.style.color = color;
}

function startTimer(event) {
	setTimeout(stopTimer, 3000);
}

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/

function walkTheDom(node, func) {
	if(!node) {
		return;
	}

	func(node);

	walkTheDom(node.firstChild, func);
	
	walkTheDom(node.nextSibling, func);

	
};



window.onload = function(){
	document.getElementById("num1").addEventListener("change", addNum1Num2);
	document.getElementById("num2").addEventListener("change", addNum1Num2);
	var skill = document.getElementsByName("skills")[0];
	skill.addEventListener("change", checkSkills);

	var colors = document.getElementsByName("favoriteColor");
	document.body.style.backgroundColor = "white";
	for (var i = 0; i < colors.length; i++) {
		colors[i].addEventListener("change", changeColor);
	}

	var employees = document.getElementsByClassName("empName");
	for (var i = 0; i < employees.length; i++) {
		employees[i].addEventListener("mouseover", hideOrShow);
		employees[i].style.opacity = 1;
	}

	var hw = document.getElementById("helloWorld");
	hw.addEventListener("click", startTimer);
	
};