//James Whitten
//JavaScript Homework 2


/*	
	1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element contents

*/
	function getUSA(){
		var doc = document.getElementsByTagName("*");
		for( var i = 0; i < doc.length; i++)
		{
			//console.log(doc[i].innerHTML);
			if (doc[i].childNodes[0]){
				if (doc[i].childNodes[0].textContent.includes("USA"))
				{
				console.log(doc[i].textContent);
				}
			}
		}
	};
	
	/*
	2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/

	function getPeopleInSales(){
		var doc = document.getElementsByClassName("empName");
		for( var i = 0; i < doc.length; i++)
		{
			if (doc[i].nextElementSibling.textContent.includes("Sales"))
			{
				console.log(doc[i].textContent);
			}
			
		}
	};
	
	/*
	function getPeopleInSales()
	{
		var doc = document.getElementsByClassName("empName");
		for( var i = 0; i < doc.length; i++)
		{
			//console.log(doc[i].innerHTML);
			if (doc[i].childNodes[0]){
				console.log(doc[i].textContent);
			}
		}
	}
	*/
	


/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/

	function getAnchorChildren(){
		var doc = document.getElementsByTagName("a");
		for( var i = 0; i < doc.length; i++)
		{		
				var chi = doc[i].childNodes;
				if (chi.length > 0)
				{
				for (var j = 0; j < chi.length; j++)
					{					
						if (chi[j].nodeName=="SPAN")
						{
						console.log(chi[j].textContent);
						}
					}
				}
		}
	};
	
	/*
	4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.

Print the value and the contents.
 */
 
	

	function getSkills(){
		var doc = document.getElementsByName("skills");
		for( var i = 0; i < doc.length; i++)
		{
			//console.log(doc[i].textContent);
			var chi = doc[i].childNodes;
			for (var j = 0; j < chi.length; j++)
			{
				
				if(chi[j].nodeName=="OPTION")
				{
						if (chi[j].getAttribute("selected")=="selected")
					{
						console.log(chi[j].textContent);
					}
				}
					
		
			}
			
		}
	};
	
	/*
	5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.

*/

	function getCustomAttribute(){
		var doc = document.getElementsByTagName("*");
		for (var i = 0; i < doc.length; i++)
		{
			if (doc[i].hasAttribute("data-customAttr"))
			{
				console.log(doc[i].getAttribute("data-customAttr")+ " " + doc[i].nodeName);
			}
		
		}
	};
	
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

//document.getElementsByClassName("nums").addEventListener("change",sumEvent);
document.getElementById("num1").addEventListener("change",sumEvent);
document.getElementById("num2").addEventListener("change",sumEvent);

	function sumEvent(event){	
		var nums = document.getElementsByClassName("nums");
		var sum = 0;
			
		for (var i = 0; i < nums.length; i++){
		sum += parseInt(nums[i].value);
		}
		if (isNaN(sum)==true)
		{
			document.getElementById("sum").innerText = "Cannot add";
		}
		else
		{
			document.getElementById("sum").innerText = sum;
		}
		//console.log(sum);
		

	};

	/*
	7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/

theBall = document.getElementsByName("skills")[0];
theBall.addEventListener("change",alertSkill);



	function alertSkill(event){
		
		alert("Are you sure " + event.target.value + " is one of your skills?");
		
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


colorChoice = "";
for (var i = 0; i < document.getElementsByName("favoriteColor").length; i++){
	console.log(document.getElementsByName("favoriteColor")[i]);
	document.getElementsByName("favoriteColor")[i].addEventListener("change",colorChange);
}


	function colorChange(event){
		if (colorChoice == "" || colorChoice == undefined)
		{
			colorChoice = event.target.value;
		}
		alert("So you like " + event.target.value + " more than " + colorChoice + " now?");
		
		colorChoice = event.target.value;
		
		for (var i = 0; i < document.getElementsByName("favoriteColor").length; i++){
			document.getElementsByName("favoriteColor")[i].parentNode.style.backgroundColor=colorChoice;
		}
		
		//console.log(event.value);
	};

/*	
9. Show/Hide Event


NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.

*/
docu = document.getElementsByClassName("empName");

for (var i = 0; i < document.getElementsByClassName("empName").length; i++)
	document.getElementsByClassName("empName")[i].addEventListener("mouseover",ninja);

	function ninja(event){
		console.log(event.target);
		var cool = event.target;
		if (event.target.style.opacity ==1)
		{
			event.target.style.opacity = 0;
		}
		else
		{
			event.target.style.opacity = 1;
		}
		console.log(cool.style.display);
	};

/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.

*/

window.onload = function(){setInterval(timeUpdate, 500);};

function timeUpdate(){
	document.getElementById("currentTime").textContent = Date.now();
	var ampm = "AM";
	var today = new Date();
	var h = today.getHours();
	var filler = "";
	var filler2 = "";
	if (h > 11)
	{
		h = h -12;
		ampm ="PM";
	}
	var m = today.getMinutes();
	if (m < 10){
		filler = "0";
	}
	var s = today.getSeconds();
	if (s < 10){
		filler2 = "0";
	}
	document.getElementById("currentTime").textContent = h + ":" + filler + m + ":" + filler2 + s + " " + ampm;
		setInterval(timeUpdate, 1000);
	};

	/*
11.Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/

document.getElementById("helloWorld").addEventListener("click",funkyColor);
function funkyColor(event){

	setTimeout(function () { 
		var colorFinal = '#'+Math.floor(Math.random()*16777215).toString(16);
	   event.target.style.color=colorFinal;
    }, 3000);
	
};

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/

//walkTheDOM(document.body.parentNode, walkTheDOM);

function walkTheDOM(node, func){
	
	console.log(node.nodeName);
	
	if (node.hasChildNodes()){
		var chi = node.childNodes;
		for (var i = 0; i < chi.length; i++)
		{
			node = chi[i];
			walkTheDOM(node, walkTheDOM);
		}
			
	} 
	
};


	





