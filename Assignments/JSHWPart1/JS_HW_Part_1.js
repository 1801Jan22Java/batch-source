//JS HW, part 1:


//Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 


var homework = {};

/*
1. Return the nth fibonacci number

f(0) = 0
f(1) = 1
f(10) = 55
*/
homework.fibonacci = function(n){
    var i = 1;
    var num = 1;
    var num2 = 0;
    var tmp = 0;

    if (n < 2) return n;

    while (i < n) {
        tmp = num;
        num += num2;
        num2 = tmp;
        i++;
    };

    return num;
};

/*
2. Sort array of integers

f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    for (var i = 0; i < array.length; i++){
        for (var j = i + 1; j < array.length; j++){
            if (array[j] < array[i]){
                var tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
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

    var i = 1;
    var prev = 1;

    if (i == 0) return 0;

    while (i < n) {
        i++;
        prev *= i;
    };

    return prev;
};

/*
4. Rotate left

Given array, rotate left n times and return array

f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    for (var i = 0; i < n; i++){
        var tmp = array[0];
        for (var j = 0; j < array.length; j++){
            array[j] = j + 1 < array.length ? array[j + 1] : tmp;
        }
    }

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
    var paraCount = 0;
    var braceCount = 0;
    var bracketCount = 0;

    for (var i = 0; i < bracketsString.length; i++){
        if (bracketsString[i] == "(") paraCount++;
        else if (bracketsString[i] == ")") paraCount--;
        else if (bracketsString[i] == "{") braceCount++;
        else if (bracketsString[i] == "}") braceCount--;
        else if (bracketsString[i] == "[") bracketCount++;
        else if (bracketsString[i] == "]") bracketCount--;
    }

    return (bracketCount == 0) && (paraCount == 0) && (braceCount == 0);
};