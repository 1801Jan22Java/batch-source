
var homework = {};


//#1
homework.fibonacci = function(num){
    var num;
    var fibonacciNumber = 0; // if the parameter is greater than 2 then variable fibonaciNumber will be returned
    if(num == 0) {
        return 0;}
    if(num <= 2) {
        return 1;
    }
    // recursively adds the ith + (i+1) term
    else {
        fibonacciNumber = homework.fibonacci(num - 1) + homework.fibonacci(num - 2);
        return fibonacciNumber;
    }

};



//#2
homework.sort = function(bubbleArray){

    var sorted = false;

    while (sorted == false) {
        sorted = true;
        var placeholder;
        // uses placeholder to keep the number of the larger number and sets the number in front of the i-1 element to it
        for(var i =1; i< bubbleArray.length ; i++) {
            placeholder =  0;
            if(bubbleArray[i-1] > bubbleArray[i]) {
                placeholder = bubbleArray[i-1];
                bubbleArray[i-1] = bubbleArray[i];
                bubbleArray[i] = placeholder;
                sorted = false; // sorted is set equal to false to so that the for loop can run to check the array again
            }
        }
    }return bubbleArray;

};

//#3
homework.factorial = function(n) {

    var computedFactorial = 1.0;

    if(n>1) {
        for(var i = 1; i< n+1; i++) {
            computedFactorial = computedFactorial *i;

        }}
    // if factorial is less than 0 uses logic above but multiplies by negative factor
    if(n<0) {
        n = n * -1;
        for(var i = 1; i< n+1; i++) {
            computedFactorial = computedFactorial * i;
            } computedFactorial = computedFactorial * -1;
    }

    return computedFactorial;
};

//console.log(computeFactorial(0));
//console.log(computeFactorial(1));
//console.log(computeFactorial(3));


//4
    homework.rotateLeft = function(array ,n){

        var hasShifted = 0;
        while (hasShifted < n) {
            var temp = array[0];
            for (var i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = temp;
            hasShifted++;
        } return array;

    }


    //5
homework.balancedBrackets = function(bracketsString){
    var balance = 0;

    if(bracketsString.split('(').length-1 == bracketsString.split(')').length-1){
        balance = 1;
    }

    if(bracketsString.split('[').length-1 == bracketsString.split(']').length-1){
        balance = 1;
    }

    if(bracketsString.split('{').length-1 == bracketsString.split('}').length-1){
        balance = 1;
    }

    if(balance == 1){
        return true;
    }
    if(balance == 0){
        return false;
    }


};







