/*PART II


Part II will focus on Javascript's ability to manipulate the DOM.

Use the provided HTML page.

Put your Javascript in the provided <script> element at the bottom of the page.

Please put the question itself as a comment above each answer.

Due 5pm, Monday, February 12 in your branch. 

-----------------------------------------------------------------------------------
*/

/*1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.*/

function getUSA(){
    var elem = document.querySelector("span[data-customAttr=USA]");
    console.log(elem);
    
}

  

/*2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.*/
function getPeopleInSales(){
    var emplist = document.getElementsByClassName("empName");
    var i ;
    for(i=0; i<emplist.length;i++){
        if (emplist[i].nextElementSibling.textContent=="Sales"){
            console.log(emplist[i]);
        }
    }
}

/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
*/  
function getAnchorChildren(){
    var anchor = document.getElementsByTagName("a");
    for(var i=0; i<anchor.length; i++){
        var sp = anchor[i].getElementsByTagName("span");
        for(var j=0; j<sp.length; j++){
           console.log(sp[j].textContent);
       } 
    }
}

/*
4. Hobbies
Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents
*/

function getSkills(){
    var skill = document.getElementsByName("skills");
    for (var i=0; i<skill.length; i++){
        var children = skill[i].childNodes;
        for(var j=0; j<children.length; j++){
            console.log(children[j].textContent)
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
function getCustomAttribute(){
    var custom = document.querySelectorAll("data-customAttr");
    for(var i=0; i<custom.length;i++){
        console.log(custom[i]);
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
var a = document.getElementById("num1");
var b = document.getElementById("num2");
function addEvent() {
    var val1 = a.value;
    var val2 = b.value;
    var answer = (parseInt(val1) + parseInt(val2))
    var sum = document.getElementById("sum");
    if (!isNaN(answer)) {
        sum.textContent = answer;
    } else {
        sum.textContent = "Cannot add";
    }
}
num1.addEventListener("change", addEvent, false);
num2.addEventListener("change", addEvent, false);


/*7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.*/
    var skillList = document.getElementsByTagName("select");
    var skill;
    for (var i = 0; i < skillList.length; i++) {
        if (skillList[i].name == "skills") {
            skill = skillList[i];
        }
    }
    skill.addEventListener("change", function () {
        var text = skill.options[skill.selectedIndex].text;
        alert("Are you sure " + text + " is one of your skills?");
    })


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
    elem.addEventListener("change",backgroundColorChange);
});

function backgroundColorChange(event) {
    var prev = document.body.style.backgroundColor;
    if (prev == "") {
        prev = "white";
    }
    console.log(event.target);
    document.body.style.backgroundColor = event.target.value;
    alert("So you like " + event.target.value + " more than " + prev + " now?");
	
}


/*9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.*/

empList = document.getElementsByClassName("empName");

for (var i = 0; i < document.getElementsByClassName("empName").length; i++)
document.getElementsByClassName("empName")[i].addEventListener("mouseover",hideEmployeeName);

function hideEmployeeName(event){
    console.log(event.target);
    var e = event.target;
    if (event.target.style.opacity ==1)
    {
        event.target.style.opacity = 0;
    }
    else
    {
        event.target.style.opacity = 1;
    }
    console.log(e.style.display);
};


/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
function displayCurrentTime() {
    var date = new Date();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var seconds = date.getSeconds();
    var zeroSec;
    if (seconds < 10) {
        zeroSec = "0" + seconds;
    } else {
        zeroSec = seconds;
    }
    var zeroMin
    if (minute < 10) {
        zeroMin = "0" + minute;
    } else {
        zeroMin = minute;
    }
    var regTime;
    var ampm;
    if (hour > 12) {
        regTime = hour % 12;
        ampm = "PM"
    } else {
        regTime = hour;
        ampm = "AM"
    }
    document.getElementById("currentTime").innerHTML = regTime + ":" + zeroMin + ":" + zeroSec + " " + ampm;
}
setInterval(displayCurrentTime, 1000);


/*11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.*/
var hello = document.getElementById("helloWorld");
        hello.onclick = function () {
            function randomColor() {
                var hexValues = ["1","2","3","4","5","6","7","8","9", "a","b","c","d","e","f"];
                var colour;
                for (var i = 0; i < 6; i++) {
                    var rand = (Math.floor(Math.random() * 16));
                    colour = colour + hexValues[rand];
                }
                hello.style.color = colour;
            }
            setTimeout(randomColor, 3000);
        }

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}



