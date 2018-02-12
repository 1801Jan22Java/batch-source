function getUSA(){
    //console.log("got here");
    var elements = document.getElementsByTagName("span");
    for(var i = 0; i<elements.length;i++){
        if(elements[i].innerHTML== "USA"){
            console.log(elements[i].innerHTML);
        }           
    }    
}
// To run uncomment the text below
//getUSA();


// Problem 2
function getPeopleInSales(){
    var elements = document.getElementsByClassName("empName");
    for(var i = 0; i< elements.length; i++){
      console.log(elements[i].innerHTML); 
    }
}
// To run uncomment the text below
//getPeopleInSales();


// Problem 3
function getAnchorChildren (){
    var elements = document.getElementsByTagName("a");
    for(var i =0; i<elements.length; i++){
        //console.log(elements[i]);
        //console.log(elements[i].hasChildNodes());
        if(elements[i].hasChildNodes()){
            var elements_c = elements[i].children;            
            for(var j = 0; j<elements[i].childElementCount; j++){  
                if(elements_c[j].tagName == "SPAN"){
                      console.log(elements_c[j].innerHTML);
                   
                }
            }
        }
    }
}
// To run uncomment the text below
//getAnchorChildren();

// Problem 4
function getSkills(){
    var elements = document.getElementsByName("skills");
    
    for(var i = 0; i < elements.length; i++){
        //console.log(elements[i]);
        if(elements[i].hasChildNodes){
            var elements_c = elements[i].children;
            for(var j = 0; j< elements_c.length; j++){
                
                if(elements_c[j].getAttribute("selected")){
                    console.log(elements_c[j].value);
                    console.log(elements_c[j].innerHTML);
                }
            }
        }  
    
    }
}
// To run uncomment the text below
//getSkills();

// Problem 5
function getCustomAttribute(){
    var elements = document.getElementsByTagName("*");
    for(var i = 0; i<elements.length; i++){
        if(elements[i].getAttribute("data-customAttr")){
            console.log(elements[i].getAttribute("data-customAttr"));
        }
    }
}
// To run uncomment the text below
//getCustomAttribute();
    
 window.onload = function(){ 
//problem 6
     var num1_value;
     var num2_value;
     var num1 = document.getElementById("num1");
     var num2 = document.getElementById("num2");
     num1.onchange = function (){
         num1_value=num1.value;
         console.log(num1.value);
        if(!isNaN(num1_value) && !isNaN(num2_value)){
         console.log("got here");
         document.getElementById("sum").innerHTML = parseInt(num1_value)+parseInt(num2_value);
         }else{
             document.getElementById("sum").innerHTML ="Cannot add";
         }
     }
     
     num2.onchange = function (){
         console.log("got here");
        num2_value = num2.value;
         
         if(!isNaN(num1_value) && !isNaN(num2_value)){
         console.log("got here");
             
         document.getElementById("sum").innerHTML.value = parseInt(num1_value)+parseInt(num2_value);
       }else{
             document.getElementById("sum").innerHTML ="Cannot add";
         }
     }
     

//problem 7 
  var skills = document.getElementsByName("skills");
     console.log(skills[0].childElementCount);
     for(var i = 0; i<skills.length;i++){
      skills[i].addEventListener("change",function(){
          var skills_options = document.getElementsByName("skills")[0];
          alert("are you sure "+skills_options.value+" is one of your skills");
         
      
      },false);  

     }
     
     
//Problem 8     
     var color = document.getElementsByName("favoriteColor");
     var previous_color;
     var current_color;
     for(var k = 0; k<color.length;k++){
         color[k].add = '#AA0000';
     }
         for(var j = 0; j< color.length;j++){
            color[j].addEventListener("click",function(){
                if(previous_color!=undefined){
                    alert("So you like " +this.value+" more than "+previous_color);
                    previous_color = this.value;
                    current_color = this.value;
                }else{
                    alert("So you like " +this.value);
                    previous_color = this.value
                    current_color = this.value;
                }
                    document.getElementById("firstForm").style.backgroundColor= ""+current_color+"";
                
            },false);
            // console.dir(colors[j]);
         }
     
     
     
 //Problem 9    
     var emp_name = document.getElementsByClassName("empName");
     var words;
     for(var i = 0; i< emp_name.length; i++){
         emp_name[i].addEventListener("mouseover", function(){
            var emp_names = document.getElementsByClassName("empName");
             //emp_names[i].style.visibility = "hidden";
             this.style.visibility = "hidden";
             /*for(var j = 0; j< emp_names.length;j++){
                emp_names[j].style.visibility = "hidden";
             }*/
      
         },true);
     }     
     
     for(var k = 0; k< emp_name.length; k++){
         emp_name[k].addEventListener("mouseout", function(){
            var emp_names = document.getElementsByClassName("empName");
             this.style.visibility ="visible";
             //emp_names[1].style.visibility= "visible";
             /*for(var j = 0; j< emp_names.length;j++){
                 emp_names[j].style.visibility = "visible";
             }*/
      
         },false);
     }
     
 // Problem 10 is at the bottom    
     var start = Date.now();
     console.log(start);
     
//Problem 11
     var hello = document.getElementById("helloWorld");
    var hello_function = function(){
        hello.style.color = "blue";
    }
     function time_delay (){
         hello.onclick = setTimeout(hello_function,3000);
     }
     time_delay();
     
     //Problem 12
     var count = 0
     function walkTheDOM(node, func){
        func(node);
        node = node.firstChild;
        while (node) {

            walkTheDOM(node, func);
            node = node.nextSibling;
        }
     }
     walkTheDOM(document.getElementById("start"),function(node){
                     count+=1;
            //console.log(count);
     });
     
 }
 
 function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}

// Problem 10
function startTime() {
  var today = new Date();
  var hour = today.getHours();
  var min = today.getMinutes();
  var sec = today.getSeconds();
  var am_pm;
    if(hour>12){
        hour -=12;
        am_pm = "PM";
    }else{
        am_pm ="AM";
    }
  // add a zero in front of numbers<10
  min = checkTime(min);
  sec = checkTime(sec);
  document.getElementById('currentTime').innerHTML = hour + ":" + min + ":" + sec+am_pm;
  t = setTimeout(function() {
    startTime()
  }, 500);
}
startTime();

 
 
     
 


