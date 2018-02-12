window.onload = function(){

    var procedure = {};

    /********FUNCTIONS****** */
    //When a procedure is changed
    document.getElementById("procedure").onchange = function() {
        //update procedure to the index value of the selected option
        var procedures = document.getElementById("procedure");
        procedure = procedures.options[procedures.selectedIndex].value;
    };


    document.getElementById("num1").onchange = function() {
        //onchange, get the values inside num1 and num2
        //the values need to be parsed as ints since the values are displayed as strings
        //10 represents the rax, which is "the base in the mathematical numerical system"
        var val1 = parseInt(document.getElementById("num1").value, 10);
        var val2 = parseInt(document.getElementById("num2").value, 10);

        //get the element with the id display
        var display = document.getElementById("display");
        //set the display's div html to Cannot add if both or at least one of the input fields value is NaN
        if (isNaN(val1) && isNaN(val2))
        display.innerHTML = "Cannot add";
        else if (isNaN(val2) || isNaN(val1))
        display.innerHTML = "Cannot add";
        else {
            //otherwise display the appropriate result of the input values in num1 and num2
            if(procedure == "+")
                display.innerHTML = val1 + val2;
            else if(procedure == "-")
                display.innerHTML = val1 - val2;
            else if(procedure == "*")
                display.innerHTML = val1 * val2;
            else if(procedure == "/")
                display.innerHTML = val1 / val2;
        }
    };

    document.getElementById("num2").onchange = function() {
        var val1 = parseInt(document.getElementById("num1").value, 10);
        var val2 = parseInt(document.getElementById("num2").value, 10);
        var display = document.getElementById("display");
        if (isNaN(val1) && isNaN(val2))
        display.innerHTML = "Cannot add";
        else if (isNaN(val2) || isNaN(val1))
        display.innerHTML = "Cannot add";
        else {
            if(procedure == "+")
                display.innerHTML = val1 + val2;
            else if(procedure == "-")
                display.innerHTML = val1 - val2;
            else if(procedure == "*")
                display.innerHTML = val1 * val2;
            else if(procedure == "/")
                display.innerHTML = val1 / val2;
        }
    };
}