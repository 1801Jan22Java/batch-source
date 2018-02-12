/*----------------------------------------------------------------------------------

PART II


Part II will focus on Javascript's ability to manipulate the DOM.

Use the provided HTML page.

Put your Javascript in the provided <script> element at the bottom of the page.

Please put the question itself as a comment above each answer.

Due 5pm, Monday, February 12 in your branch.

-----------------------------------------------------------------------------------*/

window.onload = function() {

/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/

function getUSA() {
	console.log(document.querySelector(" span[data-customAttr]"));
}

getUSA();

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/

function getPeopleInSales() {
	var employees = document.getElementsByClassName("empName");
	for (var i = 0; i < employees.length; i++) {
		var parent = employees[i].parentNode;
		var children = parent.childNodes;
		if(children[3].innerHTML == "Sales"){
			console.log(employees[i].innerHTML);
		}
	}
}

getPeopleInSales();
/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/

function getAnchorChildren() {
	var anchors = document.getElementsByTagName("a");
	for(var i = 0; i < anchors.length; i++) {
		var children = anchors[i].childNodes;
		for(var j = 0; j < children.length; j++) {
			if (children[j].nodeName == "SPAN") {
				console.log(children[j].innerHTML);
			}

		}

	}
}

getAnchorChildren();

/*
4. Hobbies

Define function getSkills()
Find all checked options in the 'skills' select element.

Print the value and the contents.
*/

function getSkills() {
	var skills = document.getElementsByName("skills");
	var arr_skills = skills[0].childNodes;
	for(var i = 0; i < arr_skills.length; i++) {
		if(arr_skills[i].nodeName =="OPTION") {
			console.log(arr_skills[i].value);
		}
	}
}
getSkills();

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
*/

function getCustomAttribute(){
	var elements = (document.querySelectorAll("[data-customAttr]"));
	for (var i = 0; i<elements.length; i++) {
		console.log(elements[i].getAttribute("data-customAttr"));
		console.log(elements[i]);
	}
}
getCustomAttribute();

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



document.getElementById("num2").addEventListener("change",onChangeEventHandler);
function onChangeEventHandler(event){

	var n1 = parseInt(document.getElementById("num1").value);
	var n2 = parseInt(document.getElementById("num2").value);
	var result = "";
	if (isNaN(n1) || isNaN(n2)) {
		result = "Cannot add";
	}
	else {
		result = (n1 + n2);
	}

	document.getElementById("sum").innerHTML = result;
	console.log(result);

}

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:

"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
document.getElementsByName("skills")[0].addEventListener("change",cssAlert);
function cssAlert() {
	alert("Are you sure " + document.getElementsByName("skills")[0].value + " is one of your skills?");

}

}


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

document.getElementsByName("favoriteColor").forEach(function(elem) {
    elem.addEventListener("change",favoriteColorChange);
});

function favoriteColorChange(event) {
	var prev = event.target.parentNode.style.backgroundColor;
	if (prev == "") {
		prev = "white";
	}

	event.target.parentNode.style.backgroundColor = event.target.value;
	alert("So you like " + event.target.value + " more than " + prev + " now?");

}

/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:

Hide the name if shown.
	Show the name if hidden.
*/
var elements = document.getElementsByClassName("empName");
for(var i = 0; i <elements.length; i++) {
	console.log(elements[i]);
	elements[i].addEventListener("mouseover",mouseOverHandler);
}

function mouseOverHandler(event) {
	if (event.target.style.opacity == "") {
		event.target.style.opacity = 1.0;
	}

	if (event.target.style.opacity == 0.0) {
		event.target.style.opacity = 1.0;
	} else {
		event.target.style.opacity = 0.0;
	}
}

/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/

var time = setInterval(function(){
	var d = new Date();
	document.getElementById("currentTime").innerHTML = d.toLocaleTimeString();
},500);

/*
11. Delay
Regarding this element:

<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/

document.getElementById("helloWorld").addEventListener("click",delayColorChange);

function delayColorChange(event) {

	setTimeout(function() {
		console.log("changed color");
		event.target.style.color = getRandomColor();
	},3000);
}

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
}
/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM.
Use recursion.

On each node, call func(node).
*/

function walkTheDOM(node,val,func) {

	var children = node.childNodes;
	if (children.length == 0) {
		return val + 1;
	}
	for (var i = 0; i < children.length; i++) {
		val = func(children[i],val,walkTheDOM);
	}

	return val + 1;

}

console.log(walkTheDOM(document,0,walkTheDOM));
