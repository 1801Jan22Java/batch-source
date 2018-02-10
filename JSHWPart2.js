/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
 */
function getUSA() {
	var spans = document.getElementsByTagName("span");
	for (var i = 0; i < spans.length; i++) {
		if (spans[i].getAttribute("data-customAttr") == "USA") {
			console.log(spans[i].innerHTML);
		}
	}
}

/*
 * 2. Sales
 * 
 * Define function getPeopleInSales()
 * 
 * Print the names of all the people in the sales department.
 */
function getPeopleInSales() {
	var table = document.getElementsByTagName("table")[0].children[0].children;
	for (var i = 0; i < table.length; i++) {
		if (table[i].children[1].innerHTML == "Sales") {
			console.log(table[i].children[0].innerHTML);
		}
	}
}

/*
 * 3. Click Here
 * 
 * Define function getAnchorChildren()
 * 
 * Find all anchor elements with a <span> child.
 * 
 * Print the contents of <span>
 */
function getAnchorChildren() {
	var anchors = document.getElementsByTagName("a");
	console.log(anchors);
	for (var i = 0; i < anchors.length; i++) {
		if (anchors[i].children[0]) {
			console.log(anchors[i].children[0].innerHTML);
		}
	}
}

/*
 * 4. Hobbies
 * 
 * Define function getSkills()
 * 
 * Find all checked options in the 'skills' select element.
 * 
 * Print the value and the contents.
 */
function getSkills() {
	var skills = document.getElementsByName("skills")[0].children;
	console.log(skills);
	for (var i = 0; i < skills.length; i++) {
		if (skills[i].hasAttribute("selected")) {
			console.log("Value: " + skills[i].value + "  Contents: "
					+ skills[i].innerHTML);
		}
	}
}

/*
 * 5. Custom Attribute
 * 
 * Define function getCustomAttribute()
 * 
 * Find all elements with "data-customAttr" attribute
 * 
 * Print the value of the attribute.
 * 
 * Print the element that has the attribute.
 */
function getCustomAttribute() {
	var dom = document.getElementsByTagName("*");
	for (var i = 0; i < dom.length; i++) {
		if (dom[i].hasAttribute("data-customAttr")) {
			console.log("element: " + dom[i].tagName + "  value: "
					+ dom[i].getAttribute("data-customAttr"));
		}
	}
}

/*
 * 6. Sum Event
 * 
 * NOTE: Write unobtrusive Javascript
 * 
 * Regarding these elements:
 * 
 * <input id="num1" class="nums" type="text"/>
 * 
 * <input id="num2" class="nums" type="text"/>
 * 
 * <h3>Sum: span id="sum"></span></h3>
 * 
 * Define onchange event handler.
 * 
 * Add <input> element values.
 * 
 * Put the sum in the <span> element.
 * 
 * If values cannot be added, put "Cannot add" in the <span> element
 */
var nums = document.getElementsByClassName("nums");
for (var i = 0; i < nums.length; i++) {
	nums[i].addEventListener("change", function() {
		var num1 = document.getElementById("num1").value;
		var num2 = document.getElementById("num2").value;
		var sum = document.getElementById("sum");
		if (isNaN(num1) || isNaN(num2)) {
			sum.innerHTML = "cannot add";
		} else {
			sum.innerHTML = parseInt(num1) + parseInt(num2);
		}
	});
}	

/*
*7. Skills Event
*
*When user selects a skill, create an alert with a message similar to:
*    
*"Are you sure CSS is one of your skills?"
*
*NOTE: no alert should appear when user deselects a skill.
*/
var skillSelect = document.getElementsByName("skills")[0];
skillSelect.addEventListener("change", function(){
	
	alert("Are you sure "+skillSelect.value+" is one of your skills?");
		
});
	
/*
*8. Favorite Color Event
*
*NOTE: This is regarding the favoriteColor radio buttons.
*
*When a user selects a color, create an alert with a message similar to:
*    
*"So you like green more than blue now?"
*
*In this example, green is the new value and blue is the old value.
*
*Make the background color (of all favoriteColor radio buttons) 
*the newly selected favoriteColor
*/
var form = document.getElementById("firstForm");
var colors = document.getElementsByName("favoriteColor");
 form.style.backgroundColor = "white";
	for(var i=0; i<colors.length; i++){
		colors[i].addEventListener("change", changeBackground);
	}
/*
* event only works in chrome, couldn't access global event in firefox
*/
function changeBackground(event){
	var currentColor = form.style.backgroundColor;
	var nextColor = event.srcElement.value;
	form.style.backgroundColor = nextColor;
	alert("So you like "+nextColor+" more than "+currentColor+" now?");
}	

/*
*9. Show/Hide Event
*
*When user hovers over an employees name:
*    
*Hide the name if shown.
*    Show the name if hidden.
*/
var empTable = document.getElementsByClassName("empName");
	for (var i = 0; i < empTable.length; i++) {
			empTable[i].addEventListener("mouseover", showHide);
	}	

/*
*chrome only again since i'm using event
*/
function showHide(event){
	console.log(event.srcElement);
	if(event.srcElement.style.opacity == 1){
		event.srcElement.style.opacity = 0;
	}
	else{
		event.srcElement.style.opacity = 1;
	}	
}

/*
*10. Current Time
*
*Regarding this element:
*    <h5 id="currentTime"></h5>
*
*Show the current time in this element in this format: 9:05:23 AM
*
*The time should be accurate to the second without having to reload the page.
*/	
setInterval(showTime, 1000);

function showTime(){
	var currentTime = document.getElementById("currentTime");
	var time = new Date();
	currentTime.innerHTML = time.toLocaleTimeString('en-US');
}

/*
*11. Delay
*Regarding this element:
*    
*<p id="helloWorld">Hello, World!</p>
*
*Three seconds after a user clicks on this element, change the text to a random color.
*/
setInterval(changeText, 3000);

function changeText(){
	var helloWorld = document.getElementById("helloWorld");
	helloWorld.style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);
}

/*
*12. Walk the DOM
*
*Define function walkTheDOM(node, func)
*
*This function should traverse every node in the DOM. 
*Use recursion.
*
*On each node, call func(node).
*/

function walkTheDOM(node, func){
	func(node);
	node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}