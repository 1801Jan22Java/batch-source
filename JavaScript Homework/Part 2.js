/*
 *
 */

window.onload = function () {
    //For Problem 7
    //document.getElementsByName("skills")[0].setAttribute("onchange", "skillsConfirmation()");

    //For Problem 8

}

//Problem 1
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

//Problem 2
function getPeopleInSales() {
    var elements = document.getElementsByTagName("td");
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].innerHTML == "Sales") {
            console.log(elements[i].previousElementSibling.innerHTML + " is in " + elements[i].innerHTML);
        }
    }
}

//Problem 3
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

//Problem 4
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

//Problem 5

function getCustomAttribute() {
    var elements = document.getElementsByTagName("*");
    for (var i = 0; i < elements.length; i++) {
        for (var j = 0; j < elements[i].attributes.length; j++) {

            if (elements[i].attributes[j].name == "data-customattr") {
                console.log(elements[i].attributes[j].value + " " + elements[i].tagName);
            }
        }
    }
}

//Problem 6

function getSum() {
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    if (!isNaN(num1) && !isNaN(num2)) {
        var sum = parseInt(num1) + parseInt(num2);
        document.getElementById("sum").innerHTML = sum;
    }
    else {
        console.log("Cannot add");
    }
}


window.onload = function () {

    //Problem 7
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


    //Problem 8

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


    //Problem 9

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


    //Problem 10

    var updateTime = setInterval(function() {
        displayTime();
    }, 1000);

    function displayTime() {
        var currTime = new Date();
        document.getElementById("currentTime").innerHTML = (currTime.getHours() + ":" + currTime.getMinutes() + ":" + currTime.getSeconds());
    }


    //Problem 11

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


    //Problem 12

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