



/**
----------------------------------------------------------------------------------

PART II


Part II will focus on Javascript's ability to manipulate the DOM.

Use the provided HTML page.

Put your Javascript in the provided -script- element at the bottom of the page.

Please put the question itself as a comment above each answer.

Due 5pm, Monday, February 12 in your branch. 

-----------------------------------------------------------------------------------

1. USA
Define function getUSA()

Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
	console.log("Q1 : Where is 'USA'? :" +
		document.getElementsByTagName('span')[1].getAttribute("data-customAttr"));
}
getUSA(); // execution
/*  

2. Sales

Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
	var i; // start from 1,  fixed '1' for checking if it's sale or not 
	var depts = document.getElementsByTagName('tr') // [1].cells[1].textContent; // get 'department'

	// doesn't need to check the first tr
	for (i = 1; i < depts.length; i++) {
		//console.log(depts[i].cells[1].textContent);		// all second td
		if (depts[i].cells[1].textContent == "Sales") {
			console.log("Q2: Sales Dept's employee: " + depts[i].cells[0].textContent); // all emp name	
		}
	}
}
getPeopleInSales();
/*  

3. Click Here
Define function getAnchorChildren()
Find all anchor elements (<a>) with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren() {
	var tagA = document.getElementsByTagName('a');
	for (var i = 0; i < tagA.length; i++) {
		if (tagA[i].querySelector('span') != null) {
			console.log("Q3 : " + tagA[i].querySelector('span').textContent);
		}
	}

}
getAnchorChildren();
/*
  

4. Hobbies

Define function getSkills()
Find all checked options in the 'skills' select element.

Print the value and the contents.

var sel = document.getElementById("box1");
var text= sel.options[sel.selectedIndex].text;
var selector = document.getElementById('id_of_select');
    var value = selector[selector.selectedIndex].value;
*/
function getSkills() {
	var skills = document.getElementsByName("skills")[0] // .options[2].getAttribute("selected")
	for (var i = 0; i < skills.length; i++) {
		if (skills.options[i].getAttribute("selected") == "selected") {
			console.log("Q4: selected option:" + skills.options[i].textContent);
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
function getCustomAttribute() {
	var allAttr = document.querySelectorAll("[data-customAttr]");
	for (var i = 0; i < allAttr.length; i++) {
		console.log("Q5/ " + i + " / " + allAttr[i].getAttribute("data-customAttr"));
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
document.getElementById("num1").addEventListener("change", sumNums);
document.getElementById("num2").addEventListener("change", sumNums);

function sumNums() {
	var num1 = parseInt(document.getElementById("num1").value);
	var num2 = parseInt(document.getElementById("num2").value);
	if (!isNaN(num1) && !isNaN(num2)) {
		sum = num1 + num2;
	} else {
		sum = "Cannot add";
	}
	event.stopPropagation();
	document.getElementById("sum").innerHTML = sum
}

/*


7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/
function detectSkillChange() {
	var skills = document.querySelector('[name=skills]');
	console.log("Are you sure " + skills[skills.selectedIndex].text + " is one of your skills?");
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

function favoriteColorEvent() {
	var originalColor = "white";
	var colors = document.getElementsByName('favoriteColor');

	for (var i = 0; i < colors.length; i++) {
		colors[i].addEventListener('click', function() {
			alert("So you like " + this.value + " more than " + originalColor + " now?");
			document.getElementById('firstForm').style.backgroundColor = this.value;
			originalColor = this.value;
		}, false);
	}
}
favoriteColorEvent();
/*

9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
Hide the name if shown.
	Show the name if hidden.
*/
function showAndHideListener(event) {
	var theTd = event.target;
	if (theTd.innerHTML) { //if name text exist
		//var tdIndex = parseInt(theTd.parentNode.rowIndex);  // first, save it 
		var empName = theTd.innerHTML; // first, save name 
		theTd.setAttribute('empName', empName); // and put as new attribute
		theTd.innerHTML = ""; // second, make it empty
	} else { //if name doesn't exist
		var savedName = theTd.getAttribute("empName"); //first, get name saved in attribute 'empName'
		theTd.innerHTML = savedName; // and fill up the name!
	}
}
window.onload = function() {
	var empNames = document.getElementsByClassName('empName'); // td들임.
	for (var i = 0; i < empNames.length; i++) {
		empNames[i].addEventListener('mouseover', showAndHideListener, false);
	}
}

/*




10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
var toggle = setInterval(function() {
	showCurrentTime();		// every second it runs showCurrentTime()
}, 1000)

function showCurrentTime() {
	var timeID = document.getElementById('currentTime');
	var hours = new Date().getHours();
	var minutes = new Date().getMinutes();
	var seconds = new Date().getSeconds();
	
	var AmPm = hours >= 12 ? 'pm' : 'am';
	hours = hours % 12;
	hours = hours ? hours : 12;
	minutes = minutes < 10 ? '0' + minutes : minutes;
	seconds = seconds < 10 ? '0' + seconds : seconds;
	var currTime = hours + ":" + minutes + ":" + seconds + " " + AmPm;
	timeID.innerHTML = currTime;  // inserting a time one time.
}


/*
11. Delay
Regarding this element:
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
 */
function changeToRandomColor(event){
        setTimeout(function(){
            event.target.style.backgroundColor = '#'+Math.random().toString(16).substr(-6);
        }, 3000);
}
window.onload= function(){
	var helloWorldDiv = document.getElementById('helloWorld');
	helloWorldDiv.addEventListener('click', changeToRandomColor ,false);
}


/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).
*/
/*function walkTheDOM(node, func){
	var all = document.getElementsByTagName("*");
 	
	var count = 0;
	for (var i=0 ; i < all.length ; i++) {
		count ++;
		// Do something with the element here
	}
	//console.log(count);
}

*/
 