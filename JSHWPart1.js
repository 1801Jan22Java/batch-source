JS HW, part 1:

Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
  var myArray = [];
  if (n >= 0) {
		myArray[0] = 0;
		myArray[1] = 1;
		for (var i = 2; i <= n; i++) {
			myArray[i] = myArray[i - 2] + myArray[i-1];
        }
		console.log("The fibonacci of " + n + " is " + myArray[n]);
		return myArray[n];
	}
    console.log("Invalid input! Please enter a positive integer!");
	return 0;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
  var x = true;
  
  while (x === true) {
		x = false;
		for (var i = 0; i < array.length; i++) {
			if (array[i] > array[i + 1]) {
			var temp = array[i];
			array[i] = array[i+1];
			array[i+1] = temp;
			x = true;
			}
		}
	}
    console.log("The sorted array is: " + array);
	return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	if (n < 0) {
        console.log("Invalid input! Please enter a positive integer!");
        return 0;
    }
    if (n === 0) {
        console.log("The factorial of " + n + " is " + 1);
		return 1;
	}
	if (n === 1) {
        console.log("The factorial of " + n + " is " + 1);
		return 1;
	}
	var total = 1;
	for (var i = 1; i <= n; i++) {
		total *= i;
	}
    console.log("The factorial of " + n + " is " + total);
    return total;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	if (n < 0) {
      console.log("Invalid input! n should be a positive integer!")
      return 0;
    }
    var temp;
	while (n !== 0) {
		temp = array[0];
		for (var i = 0; i < array.length - 1; i++) {
			array[i] = array[i+1];
		}
		array[array.length-1] = temp;
		n--;		
	}
    console.log("The rotated array is: " + array);
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
  var array = bracketsString.split("");
  var x = true;
  
  if (array.length%2 == 1) {
    x = false;
    console.log(x);
    return x;
  }
  
  for (var i = array.length/2 - 1, j = array.length/2; i >= 0, j < array.length; i--, j++) {
    if (!((array[i] === "(" && array[j] === ")") || (array[i] === "{" && array[j] === "}") || (array[i] === "[" && array[j] === "]"))) {
       x = false;
       if (x === false) {
         console.log(x);
         return x;
       }
    }
  }                                                                                         
  
  console.log(x);
  return x;
};


YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)

