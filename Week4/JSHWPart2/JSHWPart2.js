//ERIC CARPIZO
window.onload = function() {

    /*********************** PROBLEM 1 ********************************* 
    1. USA
    Define function getUSA()
    Find the html element that contains "USA".
    Print that element's contents.
    */
    function getUSA() {
        //var sumDiv = document.getElementById("currentTime").parentNode.nextSibling.nextSibling.childNodes[1].childNodes[3].textContent;
        //console.log(sumDiv);

        //get all the elements
        var elements = document.body.getElementsByTagName("*");
        //iterate through the elements
        for (var i = 0; i < elements.length; i++) {
            //if the first child exists and the text inside it is USA
            if (elements[i].childNodes[0] && elements[i].childNodes[0].textContent.includes("USA")) {
                //print the elements contents.
                console.log(elements[i].childNodes[0].textContent);
            }
        }
    }
    getUSA();

    /*********************** PROBLEM 2 ********************************* 
     2. Sales
    Define function getPeopleInSales()
    Print the names of all the people in the sales department.
    */
    function getPeopleInSales() {
        //get all elements with the class name empName
        var names = document.getElementsByClassName("empName");
        //iterate through the elements
        for (var i = 0; i < names.length; i++) {
            //if the department is Sales
            if (names[i].nextElementSibling.textContent === "Sales")
            //print the employee's name
                console.log(names[i].textContent);
        }
    }
    getPeopleInSales();

    /*********************** PROBLEM 3 *********************************
    3. Click Here
    Define function getAnchorChildren()
    Find all anchor elements with a <span> child.
    Print the contents of <span>
    */
    function getAnchorChildren() {
        //get all the anchors
        var anchors = document.getElementsByTagName('a');
        //iterate through the anchors
        for (var i = 0; i < anchors.length; i++) {
            //check if the element is an anchor
            if (anchors[i].nodeName == "A") {
                var children = anchors[i].childNodes;
                //iterate through that anchors children
                for (var j = 0; j < children.length; j++) {
                    //if one of those children contains a span
                    if (children[j].nodeName == "SPAN")
                    //print that child
                        console.log(children[j].textContent);
                }
            }
        }
    }
    getAnchorChildren();

    /*********************** PROBLEM 4 ********************************* 
    4. Hobbies
    Define function getSkills()
    Find all checked options in the 'skills' select element.
    Print the value and the contents.
    */
    function getSkills() {
        //get all the options in the select skills 
        var skills = document.getElementsByName('skills');
        //iterate through the options
        for (var i = 0; i < skills.length; i++) {
            //for each options childNodes
            var children = skills[i].childNodes;
            //iterate through them
            for (var j = 0; j < children.length; j++) {
                //if the child node is an option and it has the attribute "selected"
                if (children[j].nodeName == "OPTION" && children[j].getAttribute("selected") == "selected") {
                    //print its value and text to the console.
                    console.log("Value: " + children[j].value + ", Content: " + children[j].text);
                }
            }
        }
    }
    getSkills();

    /*********************** PROBLEM 5 ********************************* 
    5. Custom Attribute
    Define function getCustomAttribute()
    Find all elements with "data-customAttr" attribute
    Print the value of the attribute.
    Print the element that has the attribute.
    */
    function getCustomAttribute() {
        var elements = document.getElementsByTagName("*");
        for (var i = 0; i < elements.length; i++) {
            //is an element has an attribute matching data-customAttr
            if (elements[i].hasAttribute("data-customAttr")) {
                var result = elements[i];
                //print the elements value and the element it is contained in
                console.log("Value: " + result.getAttribute("data-customAttr") + ", Element: " + result.parentNode.nodeName);
            }
        }
    }
    getCustomAttribute();

    /*********************** PROBLEM 6 ********************************* 
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
    document.getElementById("num1").onchange = function() {
        //onchange, get the values inside num1 and num2
        //the values need to be parsed as ints since the values are displayed as strings
        //10 represents the rax, which is "the base in the mathematical numerical system"
        var val1 = parseInt(document.getElementById("num1").value, 10);
        var val2 = parseInt(document.getElementById("num2").value, 10);

        //get the element with the id sum
        var sum = document.getElementById("sum");
        //set sum's div html to Cannot add if both or at least one of the input fields value is NaN
        if (isNaN(val1) && isNaN(val2))
            sum.innerHTML = "Cannot add";
        else if (isNaN(val2) || isNaN(val1))
            sum.innerHTML = "Cannot add";
        else {
            //otherwise display the sum of the input values in num1 and num2
            sum.innerHTML = val1 + val2;
        }
    };

    //same as above
    document.getElementById("num2").onchange = function() {
        var val1 = parseInt(document.getElementById("num1").value, 10);
        var val2 = parseInt(document.getElementById("num2").value, 10);
        var sum = document.getElementById("sum");
        if (isNaN(val1) && isNaN(val2))
            sum.innerHTML = "Cannot add";
        else if (isNaN(val2) || isNaN(val1))
            sum.innerHTML = "Cannot add";
        else {
            sum.innerHTML = val1 + val2;
        }
    };

    /*********************** PROBLEM 7 ********************************* 
    7. Skills Event
    NOTE: Write unobtrusive Javascript
    When user selects a skill, create an alert with a message similar to:
    "Are you sure CSS is one of your skills?"
    NOTE: no alert should appear when user deselects a skill.
    */
    //add an onchange event to the drop down menu with the name skills.
    document.getElementsByName("skills")[0].onchange = function() {
        //after a selection is made, alert the user.
        if (this.selectedIndex >= 0)
            alert("Are you sure CSS is one of your skills?");
    };



    /*********************** PROBLEM 8 ********************************* 
    8. Favorite Color Event
    NOTE: Write unobtrusive Javascript
    NOTE: This is regarding the favoriteColor radio buttons.
    When a user selects a color, create an alert with a message similar to: 
    "So you like green more than blue now?"
    In this example, green is the new value and blue is the old value.
    Make the background color (of all favoriteColor radio buttons) 
    the newly selected favoriteColor
    */
    //get all the colors.
    var colors = document.getElementsByName("favoriteColor");
    var curr = {};
    //initial value to be displayed when the user first picks a color radio button
    var last = "liking no color";

    //iterate through the colors
    for(var i = 0; i < colors.length; i++){
        //to each color, add a change event listener, which will execute a function called changeDiv
        colors[i].addEventListener("change", changeDiv, false); 
    }

    function changeDiv() {
        //the current div is the div that is the target of this event listener
        var currDiv = event.target;
        //update the current color by the value of the current div's value
        curr = currDiv.value;
        alert("So you like " + curr + " more than " + last + " now?");
        //change the color of this div's parent div's background
        currDiv.parentNode.style.backgroundColor = curr;
        //update the last color to this current color for the next change.
        last = curr;
    };

    /*********************** PROBLEM 9 ********************************* 
    9. Show/Hide Event
    NOTE: Write unobtrusive Javascript
    When user hovers over an employees name:
    Hide the name if shown.
    Show the name if hidden.
    */
    //get all the elements that contain the class empName
    var employees = document.getElementsByClassName("empName");
    //iterate through the elements
    for (var i = 0; i < employees.length; i++) {
        //set the color of the current element to black
        //since the color is "" by default
        employees[i].style.color = "black";
        //add an event listener to each element
        //the type is mouseover for addEventListeners vs the onmouseover for shorthand
        //don't add parenthesis to the function you are calling, in this case,
        //it is changeColor.
        employees[i].addEventListener("mouseover", changeColor, false);
    }

    function changeColor() {
        //event.target is the object that is calling this function
        //in this case, it is employees[i], so the current index in the list of elements
        var employee = event.target;
        //if its text color is black, make it white.
        //if white, then black
        if (employee.style.color == "black") {
            employee.style.color = "white";
        } else if (employee.style.color == "white") {
            employee.style.color = "black";
        }
    }

    /*********************** PROBLEM 10 ********************************* 
    10. Current Time
    Regarding this element:
        <h5 id="currentTime"></h5>
    Show the current time in this element in this format: 9:05:23 AM
    The time should be accurate to the second without having to reload the page.
    */
    function currTime() {
        //save the div that we will be updating
        var timeDisplay = document.getElementById("currentTime");
        //create a new date object
        var today = new Date();
        //get the corresponding values from today's date
        var hours = today.getHours();
        var minutes = today.getMinutes();
        var seconds = today.getSeconds();
        //determine AM or PM.
        //hours is in a 24 hours. PM is > 12, AM <=12
        var amPM = hours <= 12 ? "AM" : "PM";
        //to format the hours, use %12
        hours %= 12;

        //format minutes and seconds if they are less than 10
        if (minutes < 10)
            minutes = "0" + minutes;
        if (seconds < 10)
            seconds = "0" + seconds;

        //update the display.
        timeDisplay.innerHTML = hours + ":" + minutes + ":" + seconds + " " + amPM;

        //refresh every 900 milliseconds
        setTimeout(function() {
            currTime();
        }, 900);
    }
    currTime();


    /*********************** PROBLEM 11 ********************************* 
    11. Delay
    Regarding this element:
    <p id="helloWorld">Hello, World!</p>
    Three seconds after a user clicks on this element, change the text to a random color.
    */
    document.getElementById("helloWorld").onclick = function() {
        //the possible values for a hex number
        var values = '0123456789ABCDEF';
        //will be appending 6 random values to the actual color. Hex starts with a # sign.
        var actualColor = '#';
        //append the 6 values.
        //Number is chosen by selecting a random number using the Math.random() function
        //Using Math.floor() returns the largest number greater than or equal to the random number
        //So 5.05 -> 5.
        //and then we multiply that number by 16 to get one of the 16 possible values.
        for (var i = 0; i < 6; i++)
            actualColor += values[Math.floor(Math.random() * 16)];

        //update the color of the hellowWorld text after 3000ms or 3s after it is clicked
        setTimeout(function() {
            document.getElementById("helloWorld").style.color = actualColor;
        }, 3000);
    };

    /*********************** PROBLEM 12 ********************************* 
    12. Walk the DOM
    Define function walkTheDOM(node, func)
    This function should traverse every node in the DOM. 
    Use recursion.
    On each node, call func(node).
    */

    //if you console log count, should be 275 nodes
    //for some reason, == doesn't work as well as ===
    //I think there needs to be a check for type equality rather than value
    var count = 0;

    function walkTheDOM(node, func) {
        //if the current node doesn't exist
        if (node === false) {
            //exit
            return false;
        }
        //update the current node to its firstChild
        node = node.firstChild;
        //iterate through the node if it exists
        while (node != null) {
            //if the current node does not have anymore children
            if (walkTheDOM(node, func) === false) {
                return false;
            }
            //update the node to its nextSibling
            node = node.nextSibling;
        }
    }
    walkTheDOM(document.getElementsByTagName("html")[0]);
}