/*1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.*/
function getUSA(){
	var text = document.querySelector('[data-customAttr="USA"]').innerHTML;
	console.log(text);
};
getUSA();

/*2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.*/
function getPeopleInSales(){
	var people = document.getElementsByClassName("empName");
	for(var i=0; i<people.length; i++){
		if(people[i].nextElementSibling.innerHTML==="Sales") {
			console.log(people[i].innerHTML);
		}
	}
};
getPeopleInSales();

/*3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>*/
function getAnchorChildren(){
	var spans = document.getElementsByTagName("SPAN");
	for (var i=0; i<spans.length; i++){
		if(spans[i].parentElement.tagName==="A"){
			console.log(spans[i].innerHTML);
		}
	
	}
};
getAnchorChildren();

/*4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.

Print the value and the contents.*/
function getSkills(){
	var skills = document.getElementsByName("skills");
	for (var i=0; i<skills.length; i++){
		console.log(skills[i].options[skills[i].selectedIndex].value + " " + skills[i].options[skills[i].selectedIndex].innerHTML);
	}
};
getSkills();

/*5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.*/
function getCustomAttribute(){
	var customs = document.querySelectorAll('[data-customAttr]');
	for (var i=0; i<customs.length; i++){
		console.log(customs[i].getAttribute("data-customAttr") + " " + customs[i].tagName);
	}
};
getCustomAttribute();

/*6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>

Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element*/
document.getElementById("num1").addEventListener("change", add);
document.getElementById("num2").addEventListener("change", add);
function add(){
	var num1 = parseInt(document.getElementById("num1").value);
	var num2 = parseInt(document.getElementById("num2").value);
	var sum = num1+num2;
	if(!isNaN(num1) && !isNaN(num2)){
		document.getElementById("sum").innerHTML=(sum);
	} else {
		document.getElementById("sum").innerHTML="Cannot add";
	}
}

/*7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
var skills = document.getElementsByName("skills");
skills[0].addEventListener("change", function(){
	alert("Are you sure " + skills[0].options[skills[0].selectedIndex].innerHTML + " is one of your skills?");
});

/*8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor*/
var oldValue = "nothing";
var colorButtons = document.getElementsByName("favoriteColor");
for (var i=0; i<colorButtons.length; i++) {
	colorButtons[i].addEventListener("change", colorAlert);
}
function colorAlert(){
	for (var i=0; i<colorButtons.length; i++) {
		if(colorButtons[i].checked){
			alert("So you like " + colorButtons[i].value + " more than " + oldValue + " now?");
			oldValue = colorButtons[i].value;
			colorButtons[i].parentElement.style.backgroundColor = colorButtons[i].value;
		}
	}
};

/*9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.*/
var empNames = document.getElementsByClassName("empName");
for (var i=0; i<empNames.length; i++){
	empNames[i].addEventListener("mouseover", toggleView);
}
function toggleView(){
	if (window.getComputedStyle(this, null).getPropertyValue("opacity")==0){
		this.style.opacity=1;
	} else {
		this.style.opacity=0;
	}
};

/*10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.*/
function setTime(){
	var time = new Date();
	document.getElementById("currentTime").innerHTML=time.toLocaleTimeString();
};
setInterval(setTime, 1000);

/*11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.*/
document.getElementById("helloWorld").addEventListener("click", delayColor);
function delayColor(){
	setTimeout(setRandomColor, 3000)
};
function setRandomColor(){
	document.getElementById("helloWorld").style.backgroundColor = '#' + Math.floor(Math.random()*16777215).toString(16);
};

/*12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).*/
var count = 0;
function walktheDom(node, func){
	func(node);
	var children = node.childNodes;
	for(var i=0; i<children.length; i++){
		walktheDom(children[i], func)
	}
}
function func(node){
	count +=1;
}
var html = document.getElementsByTagName("HTML");
walktheDom(html[0], func);
console.log(count);