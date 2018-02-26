/*JS HW, part 1: Eric Carpizo submission

Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 
*/

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n) {
    if(Number.isInteger(n))
    {
        var result = 0;
        if (n == 1 || n == 2)
            return 1;
        else if(n > 2)
        {
            var int1 = 1;
            var int2 = 1;
            for(i = 2; i < n; i++)
            {
                result = int1 + int2;
                int1 = int2;
                int2 = result; 
            }
        }
        return result;
    }
};

homework.fibonacci(5);

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    if (!array.every(isNaN)) {
        var temp = 0;
        if (array.length == 1)
            return array;
        else if (array.length == 2 && array[0] > array[1]) {
            temp = array[0];
            array[0] = array[1];
            array[1] = temp;
            return array;
        } else {
            var result = array;
            for (i = 0; i < array.length - 1; i++) {
                for (j = 0; j < array.length - 1; j++) {
                    if (result[j] > result[j + 1]) {
                        temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                    }
                }
            }
            return result;
        }
    }
};
var array = [2, 4, 5, 1, 3, 1];
homework.sort(array);

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n) {
    var result = 1;
    if (n === 0 || n === 1)
        return 1;
    else {
        for (i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
};

homework.factorial(5);
/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]
*/

homework.rotateLeft = function(array, n) {
    if (n == 0)
        return array;
    else {
        var holder = {};
        for (i = n; i > 0; i--) {
            holder = array[0];
            for (j = 1; j < array.length; j++) {
                array[j - 1] = array[j];
            }
            array[array.length - 1] = holder;
        }
        return array;
    }
};

var array = [1, 2, 3, 4, 5];
homework.rotateLeft(array, 6);

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

homework.balancedBrackets = function(bracketsString) {
    if (bracketsString.length % 2 != 0)
        return false;
    else {
        var j = bracketsString.length - 1;
        for (i = 0; i < bracketsString.length - 1; i++, j--) {
            if (bracketsString.charAt(i) === "(")
                if (bracketsString.charAt(j) !== ")")
                    return false;
            if (bracketsString.charAt(i) === "{")
                if (bracketsString.charAt(j) !== "}")
                    return false;
            if (bracketsString.charAt(i) === "[")
                if (bracketsString.charAt(j) !== "]")
                    return false;
        }
        return true;
    }
};

homework.balancedBrackets("()");
homework.balancedBrackets("()()");
homework.balancedBrackets("(())");
homework.balancedBrackets("({[]})");

homework.balancedBrackets("(");
homework.balancedBrackets(")");
homework.balancedBrackets("(()");
homework.balancedBrackets("([)]");