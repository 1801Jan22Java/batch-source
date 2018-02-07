var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/

homework.fibonacci = function(n){
    var i = 0;
    var first = true;
    var num1 = 0;
    var num2 = 1;
    var fiboNum = 0;
    if(n === 0){
        return num1;
    }
    else if(n === 1){
        return num2;
    }
    for(i = 2; i <= n; i++)
    {
        fiboNum = num1 + num2;
        if(first === true)
        {
            first = false;
            num1 = fiboNum;
        }
        else{
            first = true;
            num2 = fiboNum;
        }
    }

    return fiboNum;
};

console.log("f(0) = " + homework.fibonacci(0));
console.log("f(1) = " + homework.fibonacci(1));
console.log("f(10) = " + homework.fibonacci(10));

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    var i = 0;
    var j = 0;
    var temp;

    for(i = 0; i < array.length; i++){
        for(j = 0; j < array.length-1; j++){
            if(array[j+1] < array[j]){
                temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
            }
        }
    }
    return array;
};

var arr = [2,4,5,1,3,1];
console.log("f([2,4,5,1,3,1]) = [" + homework.sort(arr).toString() + "]");

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var factori = 1;
    if(n === 0 || n === 1){
        return 1;
    }
    var i;
    for(i = 2; i <= n; i++){
        factori *= i;
    }
    return factori;
};

console.log("f(0) = " + homework.factorial(0));
console.log("f(1) = " + homework.factorial(1));
console.log("f(3) = " + homework.factorial(3));

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var temp;
    var i;
    var j;
    for(i = 0; i < n; i++){
        temp = array[0];
        for(j = 0; j < array.length-1; j++){
            array[j] = array[j+1];
        }
        array[array.length-1] = temp;
    }
    return array;
};

console.log("f([1,2,3,4,5], 1) = [" + homework.rotateLeft([1,2,3,4,5], 1) + "]");
console.log("f([1,2,3,4,5], 6) = [" + homework.rotateLeft([1,2,3,4,5], 6) + "]");
console.log("f([1,2,3,4,5], 3) = [" + homework.rotateLeft([1,2,3,4,5], 3) + "]");

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
    var stack = new Array();
    var popped;
    var i;
    for(i = 0; i < bracketsString.length; i++){
        if(bracketsString.charAt(i) == "(" || bracketsString.charAt(i) == "[" || bracketsString.charAt(i) == "{"){
            stack.push(bracketsString.charAt(i));
        }
        else{
            popped = stack.pop();
            switch (popped){
                case "("    :   if(bracketsString.charAt(i) != ")"){
                                    return false;
                                }
                                break;
                case "["    :   if(bracketsString.charAt(i) != "]"){
                                    return false;
                                }
                                break;
                case "{"   :   if(bracketsString.charAt(i) != "}"){
                                    return false;
                                break;
                }

            }
        }
    }
    return true;
};

console.log("({[]}) is balanced: " + homework.balancedBrackets("({[]})"));
console.log("([)] is balanced: " + homework.balancedBrackets("([)]"));
