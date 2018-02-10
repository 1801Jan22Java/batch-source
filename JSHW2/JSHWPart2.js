window.onload = function(){
    getUSA();
    getPeopleInSales();
    getAnchorChildren();
    getSkills();
    getCustomAttribute();
    document.getElementById('num1').addEventListener('change', onChangeEventListener, false);
    document.getElementById('num2').addEventListener('change', onChangeEventListener, false);
    document.querySelector('[name = skills]').addEventListener('change', skillsEvent, false);
    favoriteColorEvent();
    showAndHideEvent();
    showCurrentTime();
    textRandomColor();
    walkTheDOM(document.body, counter);

}
// 1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
function getUSA() {
    console.log(document.querySelector('[data-customAttr=USA]').innerHTML);
}

//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
function getPeopleInSales(){
    var salesPeople = document.getElementsByClassName('empName');
    for(var i = 0; i < salesPeople.length; i++){
        if(salesPeople[i].parentElement.childNodes[3].innerHTML == 'Sales'){
            console.log(salesPeople[i].innerHTML);
        }
    }
}

//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren(){
    var allAnchors = document.getElementsByTagName('a');
    for(var i = 0; i < allAnchors.length; i++){
        if(allAnchors[i].childNodes[1]){
            console.log(allAnchors[i].childNodes[1].innerHTML);
        }
    }
}

//4. Hobbies
//Define function
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getSkills(){
    var skills = document.querySelector('[name = skills]');
    for (var i = 0; i < skills.length; i++){
        if(skills[i].hasAttribute('selected')){
            console.log("The attribute value is: " + skills[i].getAttribute('value') +
            " and the content is " + skills[i].innerHTML);
        }
    }
}

//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
function getCustomAttribute(){
    var customAttribute = document.querySelectorAll('[data-customAttr]');
    for(var i = 0; i < customAttribute.length; i++){
        console.log("The attribute value of data-customAttr is: " + customAttribute[i].getAttribute('data-customAttr') +
        " and the element that has the attribute is:" + customAttribute[i].tagName);
    }
}

//6.Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
function onChangeEventListener(){
    var num1 = parseInt(document.getElementById('num1').value)
    var num2 = parseInt(document.getElementById('num2').value)
    var result = num1 + num2;
    if(!(num1 + num2)){
        result = "Cannot add";
    }
    document.getElementById('sum').innerHTML= result;
}

//7. Skills Event
//NOTE:Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
function skillsEvent(event){
    var selectedValue = document.querySelector('[name=skills]')
    alert("Are you sure " + selectedValue[selectedValue.selectedIndex].value + " is one of your skills?");
}

//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons)
//the newly selected favoriteColor
function favoriteColorEvent(){
    //add event listener in function
    var originalColor = "white";
    var radioButton = document.querySelectorAll('[name = favoriteColor]');
    for(var i = 0; i < radioButton.length; i++){
        radioButton[i].addEventListener('click',function(){
            alert("So you like " + this.value + " more than " + originalColor + " now?");
            document.getElementById('firstForm').style.backgroundColor = this.value;
            originalColor = this.value;
        },false);
    }
}

//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//Hide the name if shown.
//Show the name if hidden.
function showAndHideEvent(){
    var empNames = document.getElementsByClassName('empName');
    var empNameValue;
    for(var i = 0; i < empNames.length; i++){
        empNames[i].addEventListener('mouseover', function(){
            empNameValue = this.innerHTML;
            this.innerHTML = "";
        }, false);
        empNames[i].addEventListener('mouseout', function(){
            this.innerHTML = empNameValue;
        }, false);
    }
}

//10. Current Time
//Regarding this element:
//<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
var toggle = setInterval(function(){
    showCurrentTime();
},1000)

function showCurrentTime(){
    var timeID = document.getElementById('currentTime');
    var hours = new Date().getHours();
    var minutes = new Date().getMinutes();
    var seconds = new Date().getSeconds();
    var AmPm = hours < 12 ? 'am' : 'pm';
    hours = hours % 12;
    hours = hours ? hours : 12;
    minutes = minutes < 10 ? '0' + minutes : minutes;
    seconds = seconds < 10 ? '0' + seconds : seconds;
    var currTime = hours + ":" + minutes + ":" + seconds + " " + AmPm;
    timeID.innerHTML = currTime;
    timeID.addEventListener('change', function(){
        this.innerHTML = currTime;
    }, false);
}

//11. Delay
//Regarding this element:
//<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.

function textRandomColor(){
    var helloWorldDiv = document.getElementById('helloWorld');
    helloWorldDiv.addEventListener('click', function(){
        setTimeout(function(){
            helloWorldDiv.style.backgroundColor = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
        }, 3000);
    },false);
}

//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM.
//Use recursion.
//On each node, call func(node).
var count = 0;
function walkTheDOM(node, func){
    for(var i = 0; i < node.childNodes.length; i++){
        counter(node.childNodes[i]);
        walkTheDOM(node.childNodes[i], counter);
        console.log(count);
    }
}

function counter(node){
    count++;
}
