/*----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.

Use the provided HTML page.
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
Due 5pm, Monday, February 12 in your branch. 
-----------------------------------------------------------------------------------*/
function testMe() {
	console.log("testMe is working");
}
/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
	var something = document.getElementsByTagName('span');
	console.log(something[2].innerHTML);
}

/*2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.*/
function getPeopleInSales() {
	console.log('People in sales are: ');
	var something1 = document.getElementsByTagName('td');
	// console.log(something1);
	for (var i = 0; i < something1.length; i++) {
		// console.log(something1[i].innerHTML);
		if(something1[i].innerHTML == 'Sales') {
			console.log(something1[i - 1].innerHTML);
		}
	}
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren() {
	var something2 = document.getElementsByTagName('span');
	// console.log(something2);
	// console.log(something2[3].parentNode.nodeName);
	for (var i = 0; i < something2.length; i++) {
		if(something2[i].parentNode.nodeName == 'A') {
			console.log('Span with ' + something2[i].innerHTML + ' has an anchorParent');
		}
	}

}

/*
4. Hobbies
Define function getSkills()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
function getSkills() {
	something3 = document.getElementsByName('skills')[0].children;
	//console.log(something3);
	
	for (var i = 0; i < something3.length; i++) {
		if (something3[i].hasAttribute('selected')) {
			console.log(something3[i].value);
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
	something4 = document.body.getElementsByTagName('*');
	console.log(something4);
	
	for(var i = 0; i < something4.length; i++) {
		if(something4[i].hasAttribute('data-customAttr')) {
			console.log(something4[i].getAttribute('data-customAttr') + " : " + something4[i].nodeName);
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


/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/


/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor*/


/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:	
Hide the name if shown.
	Show the name if hidden.
*/


/*10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/


/*
11. Delay
Regarding this element:
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).*/



