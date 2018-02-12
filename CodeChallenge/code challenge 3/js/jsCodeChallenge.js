function math(){

    document.getElementById("num1").onchange = function() {doMath()};
    document.getElementById("num2").onchange = function() {doMath()};
    //document.getElementById("operand").onchange = function() {doMath()};


    function doMath() {
        var num1 = document.getElementById("num1").value;
        var num2 = document.getElementById("num2").value;
        var float1 = parseFloat(num1);
        var float2 = parseFloat(num2);


        if (isNaN(float1) || isNaN(float2)) {
          document.getElementById("result").innerHTML = "Cannot do math";
        } else {
          if(  document.getElementById("operand").value == "+"){
            document.getElementById("result").innerHTML = (float1 + float2);
          } else
          if(  document.getElementById("operand").value == "-"){
            document.getElementById("result").innerHTML = (float1 - float2);
          } else
          if(  document.getElementById("operand").value == "/"){
            document.getElementById("result").innerHTML = (float1 / float2);
          } else
          if(  document.getElementById("operand").value == "*"){
            document.getElementById("result").innerHTML = (float1 * float2);
          }



    }

}
}
