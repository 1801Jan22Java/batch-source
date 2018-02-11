window.onload = function()
{
	//1
	//getUSA();
	//2
	//getPeopleInSales();
	//3
	//getAnchorChildren();
	//4
	//getSkills();
	//5
	//getCustomAttribute();
	//6
	 //onchange();
	//7
	//onSkillSelect();
	//8
	//favoriteColor();'
	//9
	//hideEmps();
	//10
	while(true)
		{
			document.getElementById("currentTime").innerHTML = formatAMPM();
		}
}
/**
 * 1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
  
*/
var getUSA = function (){
	var USA ;
	var x = document.getElementsByTagName("SPAN");
	for( var i = 0; i < x.length-1; i++)
	{
		//console.log(x[i]);
		if(x[i].textContent == ("USA"))
			USA=x[i];
	}
	console.log(USA);
};
/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
*/
var getPeopleInSales = function()
{
	var emps = "";
	console.log(emps);
	var x = document.getElementsByClassName("empName");
	for( var i = 0; i < x.length; i++)
	{
		//console.log(x[i]);
		var y =x[i].parentElement.children[1];
		//console.log(y);
		if(y.textContent=="Sales")
		{
			emps+=x[i].textContent+" ";
		}
		
	}
	console.log(emps);
}
/*

3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/
var getAnchorChildren = function(){
	Anchors = document.getElementsByTagName("a");
	//console.log(Anchors);
	var AnchorsWithKids =[];
	for(var i =0; i < Anchors.length; i++){
		var akids = Anchors[i].children;
		//console.log(akids);
		for(var j = 0; j<akids.length; j++){
			//console.log(akids[j].tagName);
			if(akids[j].tagName == "SPAN")
				{
					//AnchorsWithKids[i]= Anchors[i];
					//break;
					console.log(akids[j].textContent);
				}
		}
	}
}
/*
4. Hobbies
Define function  getSkills()
Find all checked options in the 'skills' select element.

Print the value and the contents.
 */
var getSkills = function()
{
	var SkillsSelect = document.getElementsByName("skills");
	var SkillsOptions = SkillsSelect[0].children;
	//console.log(SkillsOptions);
	var count = 0;
	for(var i = 0; i < SkillsOptions.length; i++)
		{
			if(SkillsOptions[i].selected==true)
			{
				console.log(SkillsOptions[i].value+" "+SkillsOptions[i].textContent);
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
var getCustomAttribute = function(){
	var allElements = document.getElementsByTagName('*');
	//console.log(allElements[1].tagName);
	for(var i =0; i< allElements.length; i++)
		{
			//console.log(allElements[i]);
			if(allElements[i].hasAttribute("data-customAttr"))
				{
					console.log(allElements[i])
					console.log(allElements[i].getAttribute("data-customAttr"))
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
var nums = document.getElementsByClassName("nums");
var sum = document.getElementById("sum");
var para = document.createElement("p");
sum.appendChild(para);
//console.log(sum.children[0]);
var onchange = function(){
	num1 = nums[0].value;
	num2 = nums[1].value;
	var output;
	
	output = parseInt(num1)+parseInt(num2);
	if(output){
		sum.children[0].textContent = output;
	}
	else{
		sum.children[0].textContent = "Cannot add";
	}
}
nums[1].addEventListener("onchange", onchange);
//console.log(nums[1]);
/*

7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
var skillSelect = document.getElementsByName("skills")[0];
var onSkillSelect = function(){
	//find the selected skills
	var skills = skillSelect.children;
	var selectedSkill;
	for(var i =0; i< skills.length; i++)
		{
			//console.log(skills[i].value);
			if(skills[i].selected == true)
				{
					selectedSkill = skills[i].value;
				}
		}
	alert("are you sure "+selectedSkill+" is one of your skills?");
}
//console.log(nums[1]);
//console.log(skillSelect);
for(var i =0 ; i<skillSelect.children.length; i++){
	skillSelect.children[i].addEventListener("onselect", onSkillSelect);
	//console.log(skillSelect.children[i]	);
}
//skillSelect.addEventListener("onchange", onSkillSelect);
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
var buttons = document.getElementsByName("favoriteColor");
var oldColor = '';
var favoriteColor = function(e){
	if(oldColor){
		alert("So you like "+e.value+" more than "+oldColor+"?")
	}
	oldColor = e.value;
	console.log(oldColor)
	for(var k = 0; k < buttons.length; k++){
		buttons[k].setAttribute("style", "background-color: "+oldColor);
	}

}
for(var k = 0; k < buttons.length; k++){
	buttons[k].onclick=favoriteColor(buttons[k]);
	//console.log("hi");
}

/*

9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
function hideEmps(x) {
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
//Find the employees
emps = document.getElementsByClassName("empName");
console.log(emps);
for( var i = 0; i< emps.length; i++){
	emps[i].addEventListener("onmouseover",hideEmps(emps[1]));
	//console.log("wat");
}
/*

10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
function formatAMPM() {
    var date = new Date();
    var hours = date.getHours();
    var days = date.getDay(); 
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = date + ' ' + hours + ':' + minutes + ' ' + ampm;
    return strTime;
}

/*

11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).

 */