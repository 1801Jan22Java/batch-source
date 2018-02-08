/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function (n) {
    var count = parseInt(n);
    var temp = 0;
    var prev = 0;
    var next = 0;
    while (count >= 0) {
        temp = next;
        next += prev;
        prev = temp;

        if (prev === 0 && next === 0) {
            next++;
        }
        count--;
    }
    return prev;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {

    for (var i = 0; i < array.length; i++) {
        for (var j = 0; j < i; j++) {
            if (array[i] < array[j]) {
                var temp = array[j];
                array[j] = array[i];
                array[i] = temp;
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
homework.factorial = function (n) {
    if (n === 0) {
        return 1;
    }
    var output = 1;
    for (var i = 1; i <= n; i++) {
        output *= i;
    }
    return output;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    var shift = n % array.length;
    var newArr = [];

    // Dive into the negatives
    for (var i = 0; i < array.length; i++) {
        array[i - shift] = array[i];
    }
    var index = array.length - shift;
    var negIndex = -shift;

    // Reassign from the negatives
    for (; index < array.length; index++) {
        array[index] = array[negIndex];
        negIndex++;
    }

    // Create new array from rotated mutated array
    for (var c = 0; c < array.length; c++) {
        newArr[c] = array[c];
    }

    return newArr;
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
homework.balancedBrackets = function (bracketsString) {
    var stack = [];
    var temp;

    for (var i = 0; i < bracketsString.length; i++) {
        var bracket = bracketsString[i];
        if (bracket == "(" || bracket == "{" || bracket == "[") {
            stack.push(bracket);
        } else if (bracket === ")") {
            temp = stack.pop();
            if (temp !== "(") {
                return false;
            }
        } else if (bracket === "}") {
            temp = stack.pop();
            if (temp !== "{") {
                return false;
            }
        } else if (bracket === "]") {
            temp = stack.pop();
            if (temp !== "[") {
                return false;
            }
        }
    }
    return true;
};
