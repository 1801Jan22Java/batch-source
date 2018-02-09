//1) 

var homework = {};

homework.USA = function(n) {
    var doc = document.getElementsByTagName("*");

    for (var i = 0; i < doc.length; i++){

        if (doc[i].childElementCount <= 0)
            if (doc[i].textContent.includes("USA")){
                console.log(doc[i].textContent);
            }

    }

}

//2)

homework.getPeopleInSales = function (n) {
    var tableElements = document.getElementsByClassName("empName");

    console.log("Sales department: ");

    for (var i = 0; i < tableElements.length; i++) {
        if (tableElements[i].nextElementSibling.textContent == "Sales"){
            console.log(tableElements[i].textContent);
        }

    }
}

//3

homework.getAnchorChildren = function (n) {
    var spans = document.getElementsByTagName("span");

    console.log(spans.length);

    for (var i = 0; i < spans.length; i++){
        if (spans[i].parentElement.tagName == "A"){
            console.log(spans[i].textContent);
        }
    }
}

//4

homework.getSkills = function (n) {
    var skills = document.getElementsByName("skills");

    for (var i = 0; i < skills.length; i++) {
        for (var j = 0; j < skills[i].childElementCount; j++){
            console.log(skills[i].children[j].textContent);
        }
    }

}

//5

homework.getCustomAttribute = function () {

    var elements = document.getElementsByTagName("*");

    for (var i = 0; i < elements.length; i++){
        if (elements[i].hasAttribute("data-customAttr")){
            console.log(elements[i].getAttribute("data-customAttr"));
        }
    }

}

//6

function getSum() {

    var textSum = 0;

    var sumElements = document.getElementsByClassName("nums");

    for (var i = 0; i < sumElements.length; i++) {
        textSum += parseInt(sumElements[i].value);
    }

    document.getElementById("sum").innerText = ( isNaN(textSum) ? "Cannot add" : textSum);
    console.log("sum: " + textSum);
};


var sumElements = document.getElementsByClassName("nums");

for (var i = 0; i < sumElements.length; i++){
    sumElements[i].onchange = getSum;
}

//7

var skills = document.getElementsByName("skills");

function OnSelect() {

    console.log("Are you sure " + event.target.children[event.target.selectedIndex].textContent + " is one of your skills?");
};

for (var i = 0; i < skills.length; i++) {
    skills[i].onchange = OnSelect;
}

//8

var favColors = document.getElementsByName("favoriteColor");
var oldColor = "white";

for (var i = 0; i < favColors.length; i++){
    favColors[i].onclick = favColorChange;
}

function favColorChange() {

    for (var i = 0; i < favColors.length; i++) {
        if (favColors[i].checked && (favColors[i].value != oldColor)) {

            console.log("So you like " + favColors[i].value + " more than you like " + oldColor + " now?");
            oldColor = favColors[i].value;
            document.body.style.backgroundColor = favColors[i].value;

        }
    }
}

//9

var emps = document.getElementsByClassName("empName");

for (var i = 0; i < emps.length; i++){
    emps[i].onmouseover = onHover;
    emps[i].style.color = "black";
}


function onHover() {
    console.log(event.target.style.visibility);
    event.target.style.color = event.target.style.color == "black" ? "white" : "black";
}

//10

//window.load = //This can be used to set it on loading the page but for the sake of the homework we wont

var toggle = setInterval(function () {

    var date = new Date();
    var clock = document.getElementById("currentTime");

    var time = (date.getHours() > 12 ? date.getHours() - 12 : date.getHours()) + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + (date.getHours() > 12 ? "PM" : "AM");
    //9:05:23 AM
    clock.textContent = time;

    console.log(time);
}, 1000);

//11

var triggerElement = document.getElementById("helloWorld");

triggerElement.onclick = onClicked;

function onClicked() {
    setTimeout(function () { triggerElement.style.color = getRandomColor() }, 3000);
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

//12

function walkTheDOM(node, func) {
    if (node == null) {//First run
        console.log("Start");
        walkTheDOM(document.documentElement, func);
    }
    else {
        func(node);
        for (var i = 0; i < node.children.length; i++) {
            walkTheDOM(node.children[i], func);
        }
    }
}

var count = 0;

function printCount(node) {
    console.log(++count);
    console.log(node);
}