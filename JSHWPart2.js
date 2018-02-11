
/*
1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
 */
function getUsa() {
    console.log(document.getElementsByTagName("h1")[0].getElementsByTagName("span")[1].innerHTML);
}

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
 */
function getPeopleInSales() {
    var names = document.getElementsByClassName("empName");
    for (var i = 0; i < names.length; i++) console.log(names[i].innerHTML);
}

/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
 */
function getAnchorChildren() {
    var anchors = document.getElementsByTagName("a");
    var returnedAnchors = [];

    for (var i = 0; i < anchors.length; i++) {
        var innerSpans = anchors[i].getElementsByTagName("span");
        if (innerSpans.length !== 0) {
            // If it has spans, put it in the returned array
            returnedAnchors.push(anchors[i]);
            for (var j = 0; j < innerSpans.length; j++) {
                console.log(innerSpans[j].innerHTML);
            }
        }
        innerSpans = [];
    }

    return returnedAnchors;
}


function getReqSelect () {
    var selects = document.getElementsByTagName("select");
    for (var i = 0; i < selects.length; i++) {
        var select = selects[i];
        if (select.hasAttribute("name") && select.getAttribute("name") === "skills") {
            return select;
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

    var select = getReqSelect();
    var options = select.getElementsByTagName("option");

    for (var i = 0; i < options.length; i++) {
        var option = options[i];
        if (option.hasAttribute("selected") && option.getAttribute("selected") === "selected") {
            console.log(option.getAttribute("selected")); // Printing the value
            console.log(option.innerHTML); // Printing the contents
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
    var customs = document.querySelectorAll('[data-customAttr]');

    for (var i = 0; i < customs.length; i++) {
        var custom = customs[i];
        console.log(custom.getAttribute("data-customAttr")); // Printing the value
        console.log(custom); // Printing the element that has the attribute
    }
}

/*
6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:

<input id="num1" class="nums" type="text"/>

<input id="num2" class="nums" type="text"/>

<h3>Sum: <span id="sum"></span></h3>


Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element
*/
function sumEvent() {
    document.getElementById("num1").addEventListener("change", add);
    document.getElementById("num2").addEventListener("change", add);

    function add() {
        var input1 = document.getElementById("num1");
        var input2 = document.getElementById("num2");
        var x = Number(input1.value);
        var y = Number(input2.value);

        if (!isNaN(x) && !isNaN(y)) {
            document.getElementById("sum").innerHTML = (x + y);
        } else {

            document.getElementById("sum").innerHTML = "Cannot add";
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
function skillsEvent() {
    var select = getReqSelect();
    select.addEventListener("change", inquire);

    function inquire() {
        alert("Are you sure " + select.options[select.selectedIndex].text + " is one of your skills?");
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
 */
function favoriteColorEvent() {
    var boxes = document.getElementsByTagName("input");
    var colorString = "nothing";

    function boxListener(element, val) {
        element.addEventListener("change", inquire);
        function inquire() {
            var prevString = colorString;
            colorString = val;
            alert("So you like " + colorString + " more than " + prevString + " now?");
        }
    }

    for (var i = 0; i < boxes.length; i++) {
        var box = boxes[i];
        if (box.hasAttribute("name") && box.getAttribute("name") === "favoriteColor") {
            boxListener(box, box.getAttribute("value"));
        }
    }
}

/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:

Hide the name if shown.
    Show the name if hidden.
 */
function showHideEvent() {
    var employees = document.getElementsByClassName("empName");

    function employeeListener(element) {
        element.addEventListener("mouseover", toggleHidden);
        element.addEventListener("mouseout", toggleVisible);
        function toggleVisible() {
            element.style.visibility = "visible";
        }
        function toggleHidden() {
            element.style.visibility = "hidden";
        }
    }

    for (var i = 0; i < employees.length; i++) {
        employeeListener(employees[i]);
    }
}

/*
10. Current Time

Regarding this element:
    <h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
 */
function currentTime() {
    function checkAmPm(i) {
        if (i > 12) {
            return "PM";
        }
        return "AM";
    }

    function formatTime(i) {
        if (i < 10) i = "0" + i;
        return i;
    }

    function checkHourTime(i) {
        if (i > 12) i = (i - 12);
        return i;
    }

    function displayTime() {
        var today = new Date();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        var amPm = checkAmPm(h);
        h = checkHourTime(h);
        h = formatTime(h);
        m = formatTime(m);
        s = formatTime(s);
        document.getElementById("currentTime").innerHTML =
            h + ":" + m + ":" + s + " " + amPm;
        setTimeout(displayTime, 500);
    }

    displayTime();
}

/*
11. Delay
Regarding this element:

<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
 */
function delay() {
    // random colors - taken from here:
    // http://www.paulirish.com/2009/random-hex-color-code-snippets/
    function randomColors() {
        return '#' + Math.floor(Math.random() * 16777215).toString(16);
    }

    function changeToRandom() {
        setTimeout(function () {
            var helloElement = document.getElementById("helloWorld").style.color = randomColors();
        }, 3000);
    }

    var helloElement = document.getElementById("helloWorld").addEventListener("click", changeToRandom);
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
    var children = node.childNodes;
    for (var i = 0; i < children.length; i++) {
        walkTheDOM(children[i], func);
    }
}

// window.onload = function() {

    getUsa();
    getPeopleInSales();
    console.log(getAnchorChildren());
    getSkills();
    getCustomAttribute();
    sumEvent();
    skillsEvent();
    favoriteColorEvent();
    showHideEvent();
    currentTime();
    delay();
    var count = 0;
    // walkTheDOM(document.body, function () {
    //     count += 1;
    //     console.log(count);
    // });

// };