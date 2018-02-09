/**************************
 * Author: Calvin Milliron
 * Assignment: JS HW, part 1:
 * Description: Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 
 **************************/

var homework = {};

/**************************
 * 1. Return the nth fibonacci number
 *
 * f(0) = 0
 * f(1) = 1
 * f(10) = 55
 **************************/
homework.fibonacci = function(n){
	var x = 0;
	var y = 1;
	for (var i = 1; i < n; i++) {
		// Add last number and next number
		var temp = x + y;
		// Update last number and next number
		x = y;
		y = temp;
	}
	return y;
};

/**************************
 * 2. Sort array of integers
 *
 * f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
 * 
 * Don't use the Array sort() method... that would be lame.
 **************************/
homework.sort = function(array) {
	if (array.length > 1) {
		// Iterate through each place in the array starting at the end
		for (var i = array.length; i >= 0; i--) {
			// Iterate through each place in the array starting left of the end
			for (var j = array.length - 2; j >= 0; j--) {
				// If place A is greater than place B, switch places
				if (array[j] >= array[j + 1]) {
						// Save value of place A
						var temp= array[j];
						// Copy value of place B into place A
						array[j] = array[j + 1];
						// Copy saved value of place A into place B
						array[j + 1] = temp;
					}
			}
		}
	}
	return array;
};

/**************************
 * 3. Return the factorial of n
 *
 * f(0) = 1
 * f(1) = 1
 * f(3) = 6
 **************************/
homework.factorial = function(n){
		var total = 1;
		var isNegative = false;
		if (n < 0) { isNegative = true; }
		// Multiply each number in sequence as if the number was positive
		for (var i = 1; i <= Math.abs(n); i++) {
			total *=  i;
		}
		// Print answer
		console.log("The answer is: ");
		// If the number was negative make the result negative
		if (isNegative) { total = -total; }
		return total;
};

/**************************
 * 4. Rotate left
 *
 * Given array, rotate left n times and return array
 * 
 * f([1,2,3,4,5], 1) = [2,3,4,5,1]
 * f([1,2,3,4,5], 6) = [2,3,4,5,1]
 * f([1,2,3,4,5], 3) = [4,5,1,2,3]
 **************************/
homework.rotateLeft = function(array, n) {
	var newarr = [0];
	// Find the modulus of the number of moves requested and the array length
	var moves = n % array.length;
	// Iterate through each element of the array
	for (var i = 0; i < array.length; i++) {
		// Calculate the new index by subtracting the modulus remainder from the current index
		var newspot = i - moves;
		// If the subtraction resulted in a negative number add the array length to find its new index
		if (newspot < 0) { newspot = newspot + array.length; }
		// copy the element to a new array
		newarr[newspot] = array[i];
	}
	return newarr;
};

/**************************
 * 5. Balanced Brackets
 *
 * A bracket is any one of the following: (, ), {, }, [, or ]
 *
 * The following are balanced brackets:
 *    ()
 *    ()()
 *    (())
 *    ({[]})
 *
 * The following are NOT balanced brackets:
 * (
 * )
 * (()
 * ([)]
 *
 * Return true if balanced
 * Return false if not balanced
 **************************/

homework.balancedBrackets = function(bracketsString){
	var acceptable = "";
	// Iterate through each character
	for (var i = 0; i < bracketsString.length; i++) {
		// If character is a closer, and that particular closer was not next in line, end function
		if ( (bracketsString.charAt(i) == ')' ||
			  bracketsString.charAt(i) == '}' ||
			  bracketsString.charAt(i) == ']' ) &&
			  bracketsString.charAt(i) != acceptable.charAt(0)) {
				  return false;
			  }
		switch(bracketsString.charAt(i)) {
		// If character is an opener, add its closer to the string of next acceptable characters
		case '(':
			acceptable = acceptable.concat(")");
			break;
		// If character is the next acceptable closer, remove it from the front of the string of next acceptable characters
		case ')':
			acceptable = acceptable.substring(1, acceptable.length);
		break;
		case '{':
			acceptable = acceptable.concat("}");
			break;
		case '}':
			acceptable = acceptable.substring(1, acceptable.length);
		break;
		case '[':
			acceptable = acceptable.concat("]");
			break;
		case ']':
			acceptable = acceptable.substring(1, acceptable.length);
		break;
		}
	}
	return true;
};

/**************************
 * YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
 **************************/

