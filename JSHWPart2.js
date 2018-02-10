/**********************
 * Author: Calvin Milliron
 * JavaScript Homework Part 2
 * JSHWPart2.js
 **********************/


/**********************
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 **********************/

function getUSA() {
  // Iterate through all elements of the document
  var all = document.getElementsByTagName("*");
  for (var i = 0; i < all.length; i++) {
    if (all[i].childNodes[0]) {
      // If this element's immediate child node (Text node) includes "USA" print it
      if (all[i].childNodes[0].textContent.includes("USA")) {
        console.log(all[i].childNodes[0].textContent);
      }
    }
  }
}

/**********************
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 **********************/

function getPeopleInSales() {
  // Iterate through all elements with a class name of "empName"
  var employees = document.getElementsByClassName("empName");
  for (var i = 0; i < employees.length; i++) {
    // If they are in the sales department the nextElementSibling will only contain the text "Sales"
    // Accessing nextSibling will only return text nodes
    if (employees[i].nextElementSibling.textContent == "Sales"){
      console.log(employees[i].textContent);
    }
  }
}

/**********************
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 **********************/

function getAnchorChildren() {
  // Iterate through all anchor elements
  var anchors = document.getElementsByTagName("a");
  var count = 0;
  for (var i = 0; i < anchors.length; i++) {
    // Iterate through all child nodes of this anchor element
    for (var j = 0; j < anchors[i].childNodes.length; j++) {
      // If the nodeName of this child is "SPAN" then print content
      if (anchors[i].childNodes[j].nodeName == "SPAN") {
        console.log(anchors[i].childNodes[j].textContent);
      }
    }
  }
}


/**********************
 * 4. Hobbies
 * Define function getSkills()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 **********************/

function getSkills() {
  // Iterate through all elements with the name of "skills"
  var skillElements = document.getElementsByName("skills");
  for (var i = 0; i < skillElements.length; i++) {
    // Iterate through all the child nodes of this element
    var skills = skillElements[i].childNodes;
    for (var j = 0; j < skills.length; j++) {
      // If this child is an "OPTION" and its selected attribute is "selected" print value and content
      // Accessing node.selected will only return true for the single element that ends up selected in the rendered web page regaurdless of how many elements have that attribute
      if (skills[j].nodeName == "OPTION" && skills[j].getAttribute("selected") == "selected") {
        console.log("value = " + skills[j].value + " \tcontent = " + skills[j].textContent);
      }
    }
  }
}

/**********************
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 **********************/

function getCustomAttribute() {
  // Iterate through all the elements of the document
  var all = document.getElementsByTagName("*");
  for (var i = 0; i < all.length; i++) {
    // If this element hass an attribute called "data-customAttr", print the element and the attribute
    // Assuming, printing the element means printing its nodeName
    if (all[i].getAttribute("data-customAttr")) {
      console.log(all[i].nodeName + " = " + all[i].getAttribute("data-customAttr"));
    }
  }
}

/**********************
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript (NOT INLINE)
 * Regarding these elements:
 * <input id="num1" class="nums" type="text"/>
 * <input id="num2" class="nums" type="text"/>
 * <h3>Sum: span id="sum"></span></h3>
 * 
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 **********************/

// Add onchange event to all elements with the "nums" class name
var numberElementsByClass = document.getElementsByClassName("nums");
for (var i = 0; i < numberElementsByClass.length; i++) {
  numberElementsByClass[i].onchange = function() { add(this, "sum"); };
}

function add(e, destination) {
  var total = 0;
  var success = true;
  var final = document.getElementById(destination);
  var fields = document.getElementsByClassName(e.className);
  // Iterate through all the elements with the provided class name
  for (var i = 0; i < fields.length; i++) {
    var numValue = parseFloat(fields[i].value);
    // If there is no value or if the parsed value is not a number in one of the elements show cannot add
    if (!fields[i].value || isNaN(numValue)) {
      final.innerHTML = "Cannot add";
      success = false;
    // If all the elements have numbers to add together, add them together and show the sum
    } else  {
      total +=  numValue;
    }
  }
  if (success) {
    final.innerHTML = total;
  }
}

/**********************
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript (NOT INLINE)
 * When user selects a skill, create an alert with a message similar to:
 * "Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 **********************/

// Add the onchange event to all elements with the name "skills"
var skillElementsByName = document.getElementsByName("skills");
for (var i = 0; i < skillElementsByName.length; i++) {
  skillElementsByName[i].onchange = function() { selectSkill(this); };
}

// when the skill element is changed, show the content of the selection in an alert
function selectSkill(e) {
  alert("Are you sure " + e.options[e.selectedIndex].childNodes[0].textContent + " is one of your skills?");
}

/**********************
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript (NOT INLINE)
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * "So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) 
 * the newly selected favoriteColor
 **********************/

// initialize the first color to "Nothing
var currentlySelectedFavoriteColor = "Nothing";
// Add the onchange event to all elements with the name "favoriteColor"
var favoriteColorElementsByName = document.getElementsByName("favoriteColor");
for (var i = 0; i < favoriteColorElementsByName.length; i++) {
  favoriteColorElementsByName[i].onchange = function() { selectColor(this); };
}

function selectColor(e) {
  // If this element is selected
  if(e.checked) {
    // Save the previous color to temp
    var temp = currentlySelectedFavoriteColor;
    // Save the new color to currentlySelectedFavoriteColor
    currentlySelectedFavoriteColor = e.nextSibling.textContent;
    // Change the background to the new color
    e.parentElement.style.backgroundColor = e.value;
    // Show an alert with the new color
    alert("So, you like " + currentlySelectedFavoriteColor + " more than " + temp + " now.");
  }
}

/**********************
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript (NOT INLINE)
 * When user hovers over an employees name:
 * Hide the name if shown.
 * Show the name if hidden.
 **********************/

// Add the onmouseover event to all elements with the class name "empName"
var employeeElementsByClass = document.getElementsByClassName("empName");
for (var i = 0; i < employeeElementsByClass.length; i++) {
  employeeElementsByClass[i].onmouseover = function() { hideOrShow(this); };
}

// If the opacity of the element is fully opaque, make it transparent
// otherwise, make it opaque
function hideOrShow(e) {
  if (e.style.opacity == 1) {
    e.style.opacity = 0;
  } else {
    e.style.opacity = 1;
  }
}

/**********************
 * 10. Current Time
 * Regarding this element:
 * <h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 **********************/


function updateTime() {
  var now = new Date();
  // if the hour is more than 12 subtract 12 and change to PM
  var hours = now.getHours();
  var ampm = "AM";
  if (hours > 12) { 
    hours -= 12; 
    ampm = "PM"; 
  }
  // if the minutes or seconds is single digit, add a zero
  var seconds = now.getSeconds();
  if (seconds < 10) { 
    seconds = "0" + seconds; 
  }
  var minutes = now.getMinutes();
  if (minutes < 10) { 
    minutes = "0" + minutes; 
  }
  document.getElementById("currentTime").innerHTML = hours + ":" + minutes + ":" + seconds + " " + ampm;
}
// Update time every second
setInterval(updateTime, 1000);

/**********************
 * 11. Delay
 * Regarding this element:
 * <p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 **********************/


function changeColor(e) {
  // Make a hex array
  var hexes = [0,1,2,3,4,5,6,7,8,9,"A","B","C","D","E","F"];
  var newColor = "#";
  var exclusiveMax = 16;
  var inclusiveMin = 0;
  // Find 6 random numbers from 0 to 15 to match an index in the hex array
  for (var i = 0; i < 6; i++) {
    newColor = newColor + hexes[Math.floor(Math.random() * (exclusiveMax - inclusiveMin))];
  }
  e.style.color = newColor;
}

document.getElementById("helloWorld").onclick = function() { setTimeout(changeColor, 3000, this); };

/**********************
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. 
 * Use recursion.
 * On each node, call func(node).
 **********************/

// traverses 270 element and text nodes starting at <html>
var totalNodesTraversed = 0;
function walkTheDOM(node, func) {
  totalNodesTraversed++;
  // If this element has a child node, send it to the func
  if (node.childNodes[0]) {
    func(node.childNodes[0], walkTheDOM);
  // If the element has no child, but has a nextSibling, send that to the func
  } else if (node.nextSibling) {
    func(node.nextSibling, walkTheDOM);
  // If the element has no child, and no nextSibling, check to see if its parent has a nextSibling
  } else{
    // As long as its parent has no nextSibling, assign the parent to the variable and try again
    while(!node.parentElement.nextSibling) {
      // If there are no children or siblings and the parent element is <html> break
      if (node.parentElement == document.body.parentElement) {
        break;
      } else {
        node = node.parentElement;
      }
    }
    // As long as the parent element is not <html> continue
    if (node.parentElement != document.body.parentElement) {
      func(node.parentElement.nextSibling, walkTheDOM);
    }
  }
}


window.onload = function(){
  walkTheDOM(document.body.parentElement, walkTheDOM)
  console.log(totalNodesTraversed + " nodes traversed.");
}
