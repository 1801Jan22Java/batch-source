//1
function getUsa() {

  var h1info= document.getElementsByTagName("h1")[0];
  var spanElelment = h1info.getElementsByTagName("span")[1].innerHTML;

  console.log(spanElement);
}

//2
function getPeopleInSales(){
  var trs = document.getElementsByTagName("tr");
  for( var i = 1 ; i < (trs.length); i++){
        var d = document.getElementsByTagName("tr")[i];
        department = d.getElementsByTagName("td")[1].innerHTML;
        names = d.getElementsByTagName("td")[0].innerHTML;

        if(department == 'Sales'){
        console.log(names);  }

      }
};

//3
function getAnchorChildren(){
  var spanArray = document.getElementsByTagName("span");
  for(var i = 0; i < spanArray.length; i++){
    if(document.getElementsByTagName("span")[i].parentElement.nodeName != null){
    var d = document.getElementsByTagName("span")[i].parentElement.nodeName;
    console.log(d);
  }
  }

}


//4
  function getSkills(){
    var skills = document.getElementsByTagName("select")[2];
    var text= skills.options[skills.selectedIndex].text;
    console.log(text);


  }

//5

function getCustomAttribute(){
  var elems = document.body.getElementsByTagName("*");
  for(var i = 0; i< elems.length; i++){
    if(elems[i].hasAttribute("data-customAttr")){
      console.log(elems[i].getAttribute("data-customAttr"));
    }
  }

}

//6
function sumEvents(){
  document.getElementById("num1").onchange = function() {add()};
  document.getElementById("num2").onchange = function() {add()};
  function add() {
      var num1 = document.getElementById("num1").value;
      var num2 = document.getElementById("num2").value;
      var float1 = parseFloat(num1);
      var float2 = parseFloat(num2);

      if (isNaN(float1) || isNaN(float2)) {
        document.getElementById("sum").innerHTML = "Cannot add";
      } else {
          document.getElementById("sum").innerHTML = (float1+ float2);
          }
  }

}

//7
var skillsSelect = document.getElementsByName("skills");

function validationSelect() {
for (var i = 0; i < skillsSelect.length; i++) {
    skillsSelect[i].onchange = validationSelect;
}
    alert("Are you sure " + event.target.children[event.target.selectedIndex].textContent + " is one of your skills?")
    console.log("Are you sure " + event.target.children[event.target.selectedIndex].textContent + " is one of your skills?");
};

//8
function favoriteColor(){
}



//9
var employees = document.getElementsByClassName("empName");
for (var i = 0; i<employees.length; i++){
    employees[i].onmouseover = employeeHover;
    employees[i].style.color = "black";
}
function employeeHover() {
    if(event.target.style.color == "black"){
      event.target.style.color = "white";
    } else
    if(event.target.style.color == "white"){
      event.target.style.color = "black";
      }

}

//10

function timer() {

  var t = true
  while(t == true){
    var date = new Date();
    var timeString = date.toLocaleTimeString();
    timeElement = document.getElementById("currentTime").innerHTML;
    timeElement = timeString;
  console.log(timeElement.valueOf());}
}

//11

var helloTrigger = document.getElementById("helloWorld");
helloTrigger.onclick = changeColor;

function changeColor() {
    setTimeout(function () { helloTrigger.style.color = '#'+Math.random().toString(16).substr(-6) }, 3000);
}

//12












//4
