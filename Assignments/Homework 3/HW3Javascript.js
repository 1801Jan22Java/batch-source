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
    var text= skills.options[sel.selectedIndex].text;
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





//4
