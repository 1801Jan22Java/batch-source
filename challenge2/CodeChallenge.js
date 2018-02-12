window.onload = function(){
    
    var button = document.getElementById("go");
    var opperand_one = document.getElementById("opperand1");
    var opperand_two = document.getElementById("opperand2");
    var opperator = document.getElementById("opperator");
    var result = document.getElementById("result");
    var opperator = document.getElementById("opperator2")
    button.onclick = function(){
        //opperand_one.nodeValue;
        if(opperator21.value == "+"){
          result.innerHTML = parseInt(opperand_one.value) + parseInt(opperand_two.value);
           }
        else if(opperator21.value == "-"){
           result.innerHTML =parseInt(opperand_one.value) - parseInt(opperand_two.value);
           }
        else if(opperator21.value == "*"){
            result.innerHTML = parseInt(opperand_one.value) * parseInt(opperand_two.value);
           }
        else if(opperator21.value == "/"){
          result.innerHTML = parseInt(opperand_one.value) / parseInt(opperand_two.value);
           }
    }
   /* function calculate (){
    button.addEventListener("click",function(){
        var operand_one = document.getElementById("operand1").value;
        console.log(opperand_one);
    });
     
     calculate();   
    }*/
    
}