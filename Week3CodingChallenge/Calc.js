window.onload = function() {
    document.getElementById("calculate").addEventListener('click', function(){
        var num1 = document.getElementById("firstOp").value;
        var num2 = document.getElementById("secondOp").value;
        var opList = document.getElementsByTagName("option");
        var op;
        for(var i = 0; i < opList.length; i++){
            if(opList[i].selected){
                op = opList[i].value;
            }
        }
        var res;
        if(!isNaN(num1) && !isNaN(num2)){
            switch(op){
                case "plus" :    res = parseFloat(num1) + parseFloat(num2);
                                document.getElementById("result").innerHTML = res;
                                break;
                case "subtract" :   res = parseFloat(num1) - parseFloat(num2);
                                    document.getElementById("result").innerHTML = res;
                                    break;
                case "multiply" :  res = parseFloat(num1) * parseFloat(num2);
                                    document.getElementById("result").innerHTML = res;
                                    break;
                case "divide" :     res = parseFloat(num1) / parseFloat(num2);
                                    document.getElementById("result").innerHTML = res;
                                    break;
                default  :          document.getElementById("result").innerHTML = "Invalid Input";
                                    break;
            }
        } else {
            document.getElementById("result").innerHTML = "Invalid Input";
        }
    }, false);
}