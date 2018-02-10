// Problem 1 - USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    var elements = document.getElementsByTagName("*");
    for (var i = 0; i < elements.length; i++) {
        for (var j = 0; j < elements[i].attributes.length; j++) {
            if (elements[i].attributes[j].value == "USA") {
                console.log(elements[i].innerHTML);
            }
        }
    }
}


// Problem 2 - Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
    var elements = document.getElementsByTagName("td");
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].innerHTML == "Sales") {
            console.log(elements[i].previousElementSibling.innerHTML + " is in " + elements[i].innerHTML);
        }
    }
}


// Problem 3 - Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    var elements = document.getElementsByTagName("a");
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].hasChildNodes()) {
            var elementChildren = elements[i].getElementsByTagName("span");
            for (var j = 0; j < elementChildren.length; j++) {
                console.log(elementChildren[j].innerHTML);
            }
        }
    }
}


// Problem 4 - Hobbies
// Define function 	
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getSkills() {
    var element = document.getElementsByName("skills");
    for (var j = 0; j < element.length; j++) {
        var elementChildren = element[j].getElementsByTagName("option");
        for (var i = 0; i < elementChildren.length; i++) {
            if (elementChildren[i].selected) {
                console.log(elementChildren[i].innerHTML);
            }
        }
    }
}


// Problem 5 - Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute() {
    var elements = document.getElementsByTagName("*");
    for (var i = 0; i < elements.length; i++) {
        for (var j = 0; j < elements[i].attributes.length; j++) {

            if (elements[i].attributes[j].name == "data-customattr") {
                console.log("Value: " + elements[i].attributes[j].value);
                console.log("     Element: " + elements[i].tagName);
            }
        }
    }
}


window.onload = function () {


// Problem 6 - Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

    document.getElementById("num1").addEventListener('change', getSum, false);
    document.getElementById("num2").addEventListener('change', getSum, false);

    function getSum() {
        var num1 = document.getElementById("num1").value;
        var num2 = document.getElementById("num2").value;
        if (!isNaN(num1) && !isNaN(num2)) {
            var sum = parseFloat(num1) + parseFloat(num2);
            document.getElementById("sum").innerHTML = sum;
        }
        else {
            document.getElementById("sum").innerHTML = "Cannot add";
        }
    }



// Problem 7 - Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

    document.getElementsByName("skills")[0].addEventListener('change', skillsConfirmation, false);

    function skillsConfirmation() {
        var skills = document.getElementsByName('skills');
        for (var i = 0; i < skills.length; i++) {
            var options = skills[i].getElementsByTagName('option');
            for (var j = 0; j < options.length; j++) {
                if (options[j].selected) {
                    alert("Are you sure " + options[j].innerHTML + " is one of your skills?");
                }
            }
        }
    }


    // Problem 8 - Favorite Color Event
    // NOTE: Write unobtrusive Javascript
    // NOTE: This is regarding the favoriteColor radio buttons.
    // When a user selects a color, create an alert with a message similar to:
    // "So you like green more than blue now?"
    // In this example, green is the new value and blue is the old value.
    // Make the background color (of all favoriteColor radio buttons) 
    // the newly selected favoriteColor


    var colorOptions = document.getElementsByName("favoriteColor");
    var currentColor;
    for (var n = 0; n < colorOptions.length; n++) {
        if (colorOptions[n].checked) {
            currentColor = colorOptions[n].value;
        }
    }

    for (var i = 0; i < colorOptions.length; i++) {
        colorOptions[i].addEventListener('click', colorChange, false);
    }

    function colorChange() {
        colorOptions = document.getElementsByName("favoriteColor");
        for (var i = 0; i < colorOptions.length; i++) {
            if (colorOptions[i].checked && colorOptions[i].value != currentColor) {
                for (var j = 0; j < colorOptions.length; j++) {
                    colorOptions[j].parentNode.setAttribute("style", "background-color:" + colorOptions[i].value);
                }
                alert("So you like " + colorOptions[i].value + " more than " + currentColor + "?");
                currentColor = colorOptions[i].value;

            }
        }
    }


    // Problem 9 - Show/Hide Event
    // NOTE: Write unobtrusive Javascript
    // When user hovers over an employees name:
    // Hide the name if shown.
	// Show the name if hidden.

    var employeeNames = document.getElementsByClassName("empName");
    var placeholder9;
    for (var i = 0; i < employeeNames.length; i++) {
        employeeNames[i].addEventListener('mouseover', function (event) {
            placeholder9 = this.innerHTML;
            this.innerHTML = "";
        }, false);
        employeeNames[i].addEventListener('mouseout', function (event) {
            if(this.innerHTML != placeholder9)
            this.innerHTML = placeholder9;
        }, false);
    }


    // Problem 10 - Current Time
    // Regarding this element:
	// <h5 id="currentTime"></h5>
    // Show the current time in this element in this format: 9:05:23 AM
    // The time should be accurate to the second without having to reload the page.

    var updateTime = setInterval(function() {
        displayTime();
    }, 1000);

    function displayTime() {
        var currTime = new Date();
        var amOrPm = "AM";
        var hours = currTime.getHours();
        var minutes = currTime.getMinutes();
        var seconds = currTime.getSeconds();

        if(hours > 12){
            hours -= 12;
            amOrPm = "PM";
        }
        if(minutes < 10)
            minutes = "0"+minutes;
        if(seconds < 10)
            seconds = "0"+seconds;
        document.getElementById("currentTime").innerHTML = (hours + ":" + minutes + ":" + seconds + " " + amOrPm);
    }


    // Problem 11 - Delay
    // Regarding this element:
    // <p id="helloWorld">Hello, World!</p>
    // Three seconds after a user clicks on this element, change the text to a random color.
    
    document.getElementById("helloWorld").addEventListener('click', function() {
        setTimeout(textColorChange, 3);
    });

    function textColorChange(){
        var hexLetters = "0123456789ABCDEF";
        var colorHex = "#";
        for(var i = 0; i < 6; i++){
            colorHex = colorHex + hexLetters.charAt(Math.random()*16);
        }

        document.getElementById("helloWorld").setAttribute("style", "color:"+colorHex);
    }


    // Problem 12 - 
    // Walk the DOM
    // Define function walkTheDOM(node, func)
    // This function should traverse every node in the DOM. 
    // Use recursion.
    // On each node, call func(node).


    function walkTheDOM(node, func){
        func(node);
        var children = node.getElementsByTagName("*");
        for(var i = 0; i < children.length; i++){
            walkTheDOM(children[i], func);
        }
    };

    // function printName(node){
    //     console.log(node.innerHTML);
    // };

    // walkTheDOM(document.getElementsByTagName("html")[0], printName);
}