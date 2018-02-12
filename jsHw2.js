
window.onload = function(){
	getUSA();
	getPeopleInSales();
	getAnchorChildren();
	getSkills();
	getCustomAttribute();
	sumEvent();
	skillsEvent();
	colorEvent();
	showEvent();
	currentTime();
	delayHello();
	walkTheDOM(document.documentElement);
}
/*
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/
getUSA = function(){
	var usaElement = document.querySelectorAll("[data-customAttr='USA']");
	usaText = usaElement[0].innerHTML;
	for(var i = 0; i < usaElement.length; i++){
		console.log(usaElement[i].innerHTML);
	}
}
/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/
getPeopleInSales = function(){
	var trList = document.getElementsByTagName("tr");
	for(var i = 1; i < trList.length; i++){
		var name = trList[i].getElementsByTagName("td")[0];
		var dept = trList[i].getElementsByTagName("td")[1];
		if(dept.innerHTML === 'Sales'){
			console.log(name.innerHTML);
		}
	}
}
/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/
getAnchorChildren = function(){
	var anchorChildren = document.getElementsByTagName("a");
	for( var i = 0; i < anchorChildren.length; i++){
		var spans = anchorChildren[i].getElementsByTagName("span");
		for( var j = 0; j < spans.length; j++){
			console.log(spans[j].innerHTML);
		}
	}
}
/*
4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.

I was only getting one element to print, so I changed the HTML a little by adding a multiple
tag to the select element.
*/
getSkills = function(){
	var hobbies = document.getElementsByName("hobbies")[0];
	for( var i = 0; i < hobbies.length; i++){
		var hobby = hobbies[i];
		if(hobby.selected){
			console.log(hobby.value + ", " + hobby.innerHTML);
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
getCustomAttribute = function(){
	var customs = document.querySelectorAll("[data-customAttr]");
	for(var i = 0; i < customs.length; i++){
		console.log('Value: ' + customs[i].value + ', InnerHTML: ' + customs[i].innerHTML + ', Element: ' + customs[i]);
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
sumEvent = function(){
	var numbers = document.getElementsByClassName("nums");
	for(var i = 0; i < numbers.length; i++){
		numbers[i].addEventListener("change", addNumbers);
	}
	
	function addNumbers(event){
		var sumSpan = document.getElementById('sum');
		if(Number(numbers[0].value) && Number(numbers[1].value)){
			sumSpan.innerHTML = parseInt(numbers[0].value) + parseInt(numbers[1].value);
		}else{
			sumSpan.innerHTML = "Cannot add";
		}
	}
}
/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
skillsEvent = function(){
	var skills = document.getElementsByName("skills")[0];
	skills.addEventListener("input", skillAlert);
	
	function skillAlert(event){
		alert('Are you sure ' + this.options[this.selectedIndex].innerHTML + ' is one of your skills?');
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

It doesn't appear like I can change the background color of the radio buttons.
I think if I were to do both the HTML and Javascript, I would wrap each button
in a div with a specific name and color that. For now, I print out the elements
to console, even though it appears as if it lags behind for some reason.
*/
colorEvent = function(){
	var oldValue;
	var colors = document.getElementsByName('favoriteColor');
	for(var i = 0; i < colors.length; i++){
		colors[i].addEventListener('change', colorMyRadio);
	}
	
	function colorMyRadio(event){
		if(!oldValue){
			alert('Your new favorite color is ' + this.value);
		}else{
			alert("The color " + this.value + " is in, " + oldValue + " is out.");
		}
		
		for(var j = 0; j < colors.length; j++){
			colors[j].style.backgroundColor = this.value;
		}
		
		oldValue = this.value;
	}
}
/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
showEvent = function(){
	var employees = document.getElementsByClassName("empName");
	
	for( var i = 0; i < employees.length; i++){
		employees[i].style.opacity = "1";
		employees[i].addEventListener('mouseout', flipVisible);
	}
	
	function flipVisible(event){
		if(this.style.opacity == "1"){
			this.style.opacity = "0";
		}else if(this.style.opacity == "0"){
			this.style.opacity = "1";
		}
	}
}
/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
currentTime = function(){
	function updateClock(){
		var currDate = new Date();
		var hours = currDate.getHours() == 0 ? 12 : currDate.getHours() % 12;
		var minutes = currDate.getMinutes();
		var seconds = currDate.getSeconds();
		var amPM = hours > 12 ? 'PM' : 'AM';
		
		document.getElementById("currentTime").innerHTML = hours + ":" + ('0' + minutes).slice(-2) + ":" + seconds + " " + amPM;
	
		setTimeout(updateClock, 1000);
	}
	
	updateClock();
}
/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/
delayHello = function(){
	var helloWorldEle = document.getElementById("helloWorld");
	helloWorldEle.addEventListener("click", delayedChange);
	
	function delayedChange(event){
		setTimeout(randomColor, 3000);
	}
	
	randomColor = function(){
		var red = Math.floor(Math.random() * 256);
		var green = Math.floor(Math.random() * 256);
		var blue = Math.floor(Math.random() * 256);
		
		var randomCol = "rgb(" + red + "," + green + "," + blue + ")";
		
		helloWorldEle.style.color = randomCol;
	}
}
/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
walkTheDOM = function(node){
	console.log(node);
	for( var i = 0; i < node.childNodes.length; i++){
		walkTheDOM(node.childNodes[i]);
	}
}