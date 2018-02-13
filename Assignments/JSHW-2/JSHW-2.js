 
 window.onload = function(){
 /*
    1. USA
    Define function getUSA()

    Find the html element that contains "USA".

    Print that element's contents.
    */
    var getUSA = function(){
        var elements = document.getElementsByTagName("*");
        var num = 0;
        console.log("Question 1 - USA");
        for (var n = 0; n < elements.length; n++) {
            if (elements[n].childNodes[0]) {
                if (elements[n].childNodes[0].textContent.includes("USA")) {
                    console.log(elements[n].childNodes[0]);
                }
            }
        }
        console.log("------------------");
    };

    /*
        2. Sales

        Define function getPeopleInSales()

        Print the names of all the people in the sales department.
    */

    var getPeopleInSales = function() {
        var tableElements = document.getElementsByTagName('tr');
        console.log("Question 2 - People in sales");
        for(var n = 0; n < tableElements.length; n++){
            if(tableElements[n].childNodes[3].textContent == "Sales"){
                console.log(tableElements[n].childNodes[1].textContent);
            }
        }
        
        console.log("------------------------------------");
    };

    /*
    3. Click Here

    Define function getAnchorChildren()

    Find all anchor elements with a <span> child.

    Print the contents of <span>

    */

    var getAnchorChildren = function() {
        var anchor = document.getElementsByTagName('a');
        var kiddies;
        var spans;
        var temp;
        console.log("Question 3 - Anchor's span's children");
        for(var n = 0; n < anchor.length; n++){
            kiddies = anchor[n].childNodes;
            for(var m = 0; m < kiddies.length; m++){
                if(kiddies[m].firstChild != null)
                    console.log(kiddies[m].firstChild);
            }
        }
        console.log("--------------------------------");
    };

    /*
    4. Something
    Define function getSkills()
    Find all checked options in the 'skills' select element.

    Print the value and the contents.
    */
    var getSkills = function(params) {
        console.log("Question 4 - get skills")
        var s = document.getElementsByName("skills");
        
        var skl;
        for(var n = 0; n < s.length; n++){
            var children = s[n].childNodes;
            for(var m = 0; m  < children.length; m++){
                if(children[m].nodeName == "OPTION" && children[m].getAttribute("selected") == "selected"){
                    console.log(children[m].value + " is selected");
                    console.log(children[m].textContent + " is content");
                }
            }
        }
        console.log("-----------------------------------------");
    };

    /*
        5. Custom Attribute

        Define function getCustomAttribute()

        Find all elements with "data-customAttr" attribute

        Print the value of the attribute.

        Print the element that has the attribute.
    */

    var getCustomAttribute = function(){
        var custom = document.getElementsByTagName("*");
        var attr; 
        console.log("Question 5 - custom attribute");
        for(var n = 0; n < custom.length; n++){
            attr = custom[n].getAttributeNode("data-customAttr");
            if(attr != null){
                console.log("Found element with custom attribute");
                console.log(attr.value);
                console.log(custom[n]);
            }
        }
        console.log("----------------------------------");

    };

    getUSA();
    getPeopleInSales();
    getAnchorChildren();
    getSkills();
    getCustomAttribute();
    new TimeCounter();
    var hi = document.getElementById("helloWorld");
    hi.addEventListener("onclick", function() {
        this.timer = setInterval(() => {
            this.style.color = ''+randomColors();
        }, 3000);
    });
    walkTheDOM(document.getElementsByTagName("html"), walkTheDOM);

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
function Question6 (){
    var num1 = document.getElementById("num1").nodeValue;
    var num2 = document.getElementById("num2").nodeValue;
    if((number)(num1 && num2))
        var sum = document.getElementById("sum").innerHTML=((number)(num1 + num2));
    else   
        var sum = document.getElementById("sum").innerHTML.textContent="Cannot add";
};
document.getElementById("num1").addEventListener(onchange, Question6);
document.getElementById("num2").addEventListener(onchange, Question6);

/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
    
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
function SkillsEvent () {
    var sklSelect = document.getElementsByName("skills").childNodes[selectedIndex].textContent;
    window.alert("Are you sure that "+sklSelect+" is one of your skills?");
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
function q8() {
    var colorElements = document.getElementsByName("favoriteColor");
    var oldChoice;
    for(var n = 0; n < colorElements.length; n++){
        if(colorElements[n].checked){
            oldChoice = document.getElementsByName("favoriteColor")[n].getAttribute("value");
        }
        colorElements[n].parentNode.addEventListener("change", changeColor);
    }

    function changeColor() {
        var curr = event.target;
        document.get
        for(var n = 0; n < colorElements.length; n++){
            if(colorElements[n].checked)
                newChoice = colorElements[n].value;
        }
        curr.parentNode.style.backgroundColor = newChoice;
        alert(newChoice+" is far better than that ghastly "+oldChoice);
    }
    
};

q8();
/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
    
Hide the name if shown.
    Show the name if hidden.
*/
function question9(){
    var names = {};
    var tableElements = document.getElementsByTagName('tr');
    for(var n = 1; n < tableElements.length; n++){
        //console.log(names[n]);
        tableElements[n].childNodes[1].addEventListener("mouseover", byeNames);
    }

    function byeNames(){
        var nameEle = event.target;
        if(nameEle.style.visibility === "hidden"){
            nameEle.style.visibility = "visible";
        }
        else{
            nameEle.style.visibility = "hidden";
        }
    };
    
};
question9();

/*
10. Current Time

Regarding this element:
    <h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
function TimeCounter() {
    this.num = 0;
    this.timer = setInterval(() => {
        this.num++;
        var timeTag = document.getElementById("currentTime");
        var date = new Date();
        var time = date.toLocaleTimeString();
        timeTag.innerHTML = time;
    }, 1000);
    }
//var t = new TimeCounter();


/*
11. Delay
Regarding this element:
    
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/
function question11(){
    var hello = document.getElementById("helloWorld");
    hello.addEventListener("click", randomColors);
    function randomColors() {
        var hi = event.target;
        hi.timer = setInterval(() => {
            hi.style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);
        }, 3000);
    }
};
question11();

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/

// Currently implementing a depth-first search
var nodeCount = 0;
var nodes = {};
function walkTheDOM(node, func) {
    console.log("Count of nodes is: " + nodeCount);
    if(nodes.hasChildNodes == false){
        nodes[nodeCount] = node;
        nodeCount++;
        console.log(nodeCount); 
    }

    else{
        var children = node.childNodes;
        for(var n = 0; n < children; n++){
            walkTheDOM(children[n]);
        }
    }    
};
walkTheDOM(document.getElementsByTagName("html", walkTheDOM));

