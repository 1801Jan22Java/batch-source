// JS HW, part 1:
//
// Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9.

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    if(n == 0){
        return 0;
    }
    if (n == 1){
        return 1;
    }
    if (n >= 1){
        return homework.fibonacci(n-1) + homework.fibonacci(n-2);
    }
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    var temp = 0;
    for(var i = 0; i < array.length; i++){
        if(array[i] > array[i+1]){
            temp = array[i+1];
            array[i+1] = array[i];
            array[i] = temp;
            i = i - 2;
        }
    }
    return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var arr = [1,1];
    for(var i = 2; i <=n; i++){
        arr[i] = arr[i-1] * i;
    }
    return arr[arr.length-1];
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var tempArr = [];
    if(n > array.length){
        n = n - array.length;
    }
    while(n >=0 ){
        array.push(array.shift());
        n--;
    }
    console.log(array);
    return array;
};

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
    var isBalanced = true;
    var bracketDict = {
        ")" : "(",
        "]" : "[",
        "}" : "{"
    }
    var openBrackets = [];
    for(var i = 0; i < bracketsString.length; i++){
        if(bracketsString[i] == "(" || bracketsString[i] == "[" || bracketsString[i] == "{"){
            openBrackets.push(bracketsString[i]);
        }
        else if(bracketsString[i] == ")" || bracketsString[i] == "}" || bracketsString[i] == "]"){
            if(bracketDict[bracketsString[i]] == openBrackets[openBrackets.length-1]){
                isBalanced = true;
                openBrackets.pop();
            } else {
                isBalanced = false;
              break;
            }
        }
    }
    if(openBrackets.length != 0){
        isBalanced = false;
    }
    console.log(isBalanced);
    return isBalanced;
};

// YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
