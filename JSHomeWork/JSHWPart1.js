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
	if(n===0) {
    	return 0;
  	}
	else if(n===1) {
		return 1;
	}
	else {
		return this.fibonacci(n-1) + this.fibonacci(n-2);
	}
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	// BUBBLESORT!!! :P
	var nextPass = true;
	
	var i;
	for(i = 0; i < array.length && nextPass; i++) {
		
		nextPass = false;

		var j;
		for(j = 0; j < array.length - i; j++) {
			if(array[j] > array[j+1]) {
				var temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				nextPass = true;
			}
		}
    }
    console.log(array.toString());
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n) {
	if(n === 0) {
		return 1; 
	} 
	else {
		return n * this.factorial(n - 1); 
	}
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {

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

};


YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)

