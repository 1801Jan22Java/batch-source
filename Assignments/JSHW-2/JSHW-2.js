 /*
        1. USA
        Define function getUSA()

        Find the html element that contains "USA".

        Print that element's contents.
        */
        var getUSA = function(){
            var elements = document.getElementsByTagName("*");
            var num = 0;
            for (var n = 0; n < elements.length; n++) {
                if (elements[n].childNodes[0]) {
                    if (elements[n].childNodes[0].textContent.includes("USA")) {
                        num++;
                        console.log(elements[n].childNodes[0]);
                    }
                }
            }
            console.log(num);
        };

        /*
            2. Sales

            Define function getPeopleInSales()

            Print the names of all the people in the sales department.
        */

        var getPeopleInSales = function() {
            var salespeople;
            var count = 0;
            var tableElements = document.getElementsByTagName("TABLE").childNodes;
            for(var n = 0; n < tableElements.length; n++){
                if(tableElements[n].childNodes[1].textContent == 'Sales'){
                    salespeople[count] = tableElements[n].childNodes[0];
                    count++;
                }
            }
            for(var i = 0; i< tableElements.length; i++){
                console.log(salespeople[n]);
            }
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
            for(var n = 0; n < anchor.length; n++){
                kiddies = anchor[n].childNodes;
                for(var m = 0; m < kiddies.length; m++){
                    console.log.getElementsByTagName('SPAN').textContent;
                }
            }
            
        };

        /*
        4. Something
        Define function getSkills()
        Find all checked options in the 'skills' select element.

        Print the value and the contents.
        */
        var getSkills = function(params) {
            var skillz = document.getElementsByName("SKILLS").values;
            console.log(skills);

        };

        /*
            5. Custom Attribute

            Define function getCustomAttribute()

            Find all elements with "data-customAttr" attribute

            Print the value of the attribute.

            Print the element that has the attribute.
        */

        var getCustomAttribute = function(){
            var custom = document.getElementsByTagName("data-customAttr");
            for(var n = 0; n < custom.length; n++){
                console.log(custom[n].textContent);
                console.log(custom[n]);
            }

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


        /*
        7. Skills Event

        NOTE: Write unobtrusive Javascript

        When user selects a skill, create an alert with a message similar to:
            
        "Are you sure CSS is one of your skills?"

        NOTE: no alert should appear when user deselects a skill.
        */


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


        