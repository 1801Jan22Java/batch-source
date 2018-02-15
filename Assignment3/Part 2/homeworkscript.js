/*
PART II


Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided HTML page.
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
Due 5pm, Monday, February 12 in your branch. 
*/
window.onload = function (){
	
	
/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
 */
function getUSA(){
	console.log("Question 1");
	var usa =document.getElementsByTagName("span")[2].innerHTML;
	console.log(usa);

};
getUSA();

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/  

function getPeopleInSales()
{
	console.log("Question 2");
	//var emp = document.getElementsByTagName("tr")[1].getElementsByTagName("td")[0].innerHTML;
	//var dept = document.getElementsByTagName("tr")[1].getElementsByTagName("td")[1].innerHTML;
	//var department = document.getElementsByTagName("td");
	//console.log(emp);
	//console.log(dept);
	//console.log(department.length);
	var table = document.getElementsByClassName("empName");
	//console.log(table);
	//console.log(emp);
	//console.log(department);
	for(var i  =1;i<=table.length;i++){
		if(document.getElementsByTagName("tr")[i].getElementsByTagName("td")[1].innerHTML=="Sales")
		{
			console.log(document.getElementsByTagName("tr")[i].getElementsByTagName("td")[1].innerHTML);
			console.log(document.getElementsByTagName("tr")[i].getElementsByTagName("td")[0].innerHTML);
		}
	}
	};
getPeopleInSales();


/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
 */ 
 
 function getAnchorChildren(){
	 console.log("Question 3");
	 var anchor = document.getElementsByTagName("a");
	 //console.log(anchor);
	 //console.log(anchor.length);
	 for(var i =0;i<anchor.length;i++)
	 {
		if(anchor[i].firstElementChild!=null){
		//console.log(anchor[i].innerHTML);
		 console.log(anchor[i].firstElementChild.innerHTML);
		}
	 }
	// console.log(anchor.length);
	 
 };
 getAnchorChildren();

/*
4. Hobbies
Define function 	
Find all checked options in the 'skills' select element.

Print the value and the contents.
 */ 
 
  function getSkills(){
	 console.log("Question 4");
	 var form= document.getElementsByTagName("form");
	 var select = document.getElementsByName("skills")[0];
	// console.log(form);
	// console.log(select.length);
	// console.log(select.getElementsByTagName("option")[0].value);
	 //console.log(select.getElementsByTagName("option"));
	 var option=select.getElementsByTagName("option");
	 //console.log(option[0].selected);
	 //console.log(select.getElementsByTagName("option")[2].value);
	 for(var i = 0; i< select.length;i++)
	 {
		// console.log(option[i].value);
		// console.log(option[i].selected);
		 if (option[i].selected===true)
		 {
			console.log(option[i].value);
			console.log(option[i].innerHTML);
		 }
	 }
 };
 getSkills();
 
 /*

5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
*/

function getCustomAttributes()
{

	var search =document.getElementsByTagName("*");
	//console.log(search3.value);
	console.log("Question 5");
	//console.log(search[0]);
	//console.log(search[0].attributes[0].name);
	//console.log(search[0].attributes[0].value);
	for(var i =0;i<search.length;i++)
	{
		if(search[i].getAttribute("data-customAttr")!=null)
		{
			//console.log(search[i]);
			console.log(search[i]);
			console.log(search[i].getAttribute("data-customAttr"));
			//console.log(search[i].innerHTML);
			//console.log(search[i].tags);
		}
		
		}
		//if(search[0].attributes[0].name=="data-customattr"){
		//console.log(search[0].attributes[0].value);
		//}
	
	//console.log(customSearch);
	
};

getCustomAttributes();

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

function getTheSum(){
	console.log("Question 6");
	var nums = document.getElementsByClassName("nums");
	//console.log(nums);
	var numField1=document.getElementById("num1");
	var numField2=document.getElementById("num2");
	//var sum = document.getElementById("sum").value;
	var num1;
	var num2;
	var sum=0;
	numField1.onchange = function(){
		num1= parseInt(numField1.value);
		sum+=num1;
	//	console.log(num1);
	//	console.log(num1+sum);
	}
	numField2.onchange = function(){
		 num2 = parseInt(numField2.value);
		// sum+=num2;
		//console.log(num1+num2);
		sum=num1+num2;
		console.log(sum);
		if(isNaN(sum)){
			document.getElementById("sum").innerHTML="Cannot add";
		}
		else{
		document.getElementById("sum").innerHTML=sum;}
	}
	
	//sum=num1+num2;
	//console.log(sum);	
}

getTheSum();

/*

7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/

function showAlert(){
	console.log("question 7");
	 var select = document.getElementsByName("skills")[0];
	 select.onchange=function(){
	// console.log(form);
	// console.log(select.length);
	// console.log(select.getElementsByTagName("option")[0].value);
	 //console.log(select.getElementsByTagName("option"));
	 var option=select.getElementsByTagName("option");
	 //console.log(option[0].selected);
	 //console.log(select.getElementsByTagName("option")[2].value);
	 for(var i = 0; i< select.length;i++)
	 {
		// console.log(option[i].value);
		// console.log(option[i].selected);
		 if (option[i].selected===true)
		 {
			var selectSkill=option[i].value;
			alert("Are you sure that " + selectSkill.toUpperCase() +" is one of your skills?");
			console.log(option[i].value);
		 }
	 }
	}
}
showAlert();

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


function changeColor(){
	console.log("question 8");
	var colorSelect= document.getElementsByName("favoriteColor");
	//console.log(colorSelect[0].checked);
	console.log(colorSelect);
	//console.log(colorSelect);
	var oldColor ="white"
	for(var j =0;j<colorSelect.length;j++){
	 colorSelect[j].onclick=function(){
		for(var i =0;i<colorSelect.length;i++){
			if(colorSelect[i].checked==true){
				selectedColor =colorSelect[i].value;
				//console.log(oldColor);
				 oldColor =colorSelect[i].parentNode.style.backgroundColor;
				//console.log(select.getElementsByTagName("option")[2].value);
				//alert(selectedColor);
				var selectColor=selectedColor;
				colorSelect[i].parentNode.style.backgroundColor=selectedColor;
				alert("So you like " + selectedColor + " more than " + oldColor+" now?" );
				}	 
			}
			
			
		}
	 }
}
	

changeColor();

/*

9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/

function showHide(){
	console.log("Question 9");
	var empList = document.getElementsByClassName("empName");
	empList.onmouseover=function(){
		for(var i = 0;i<empList.length;i++){
			if(empList[i].style.visibility=="visible"){
				console.log(empList[i]);
				empList[i].style.visibility="hidden";
			}
			else{
				empList[i].style.visibility="visible";
				//console.log(empList[i]);
				}
			
		}
		}
	
} 

showHide();

/*

10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
console.log("Question 10");
function getCurrentTime(){
	//console.log(document.getElementsByTagName("h5"));
	var h5Time = document.getElementsByTagName("h5")[0]; 
	var func = function(){
	var d = new Date();
	var t = d.toLocaleTimeString("en-us");
	//console.log(h5Time);
//	h5Time.onclick=function(){
	h5Time.innerHTML=("<h5>" + t + "</h5>");
	//	console.log(h5Time);
	//}
	
}
setInterval(func,1000);
	
}
getCurrentTime();


/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/

function getRandomColorText()
{
	console.log("Question 11");
	var helloWorld = document.getElementById("helloWorld");
	var func =function(){
		console.log("Clicked");
		console.log(helloWorld);
		var randColor = Math.floor(Math.random()*16777215).toString(16);
		console.log(randColor);
		helloWorld.style.color='#'+randColor;
		console.log(helloWorld.text);
	}
	helloWorld.onclick =function(){
	setTimeout(func,3000);
	}
	console.log(helloWorld);
}
 
getRandomColorText();



/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/



function func (node){
	
	//console.log(doc);
	count++;
	var children = node.childNodes;
	//var nodeElements=node.getElementsByTagName("*");
	//console.log(nodeElements);
	//console.log(node.childNodes);
	for(var i =0;i<children.length;i++){
		func(children[i]);
	}
		//walkTheDOM(doc[i]);
	
		//console.log(doc[i]);
		//walkTheDOM(doc[i]);	
	
	
}
var node=document;
var count=0;
function walkTheDOM(func,node)
{
	console.log("Question 12");
	func(node);
}

walkTheDOM(func,node);
console.log(count);
}