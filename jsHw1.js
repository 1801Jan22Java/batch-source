var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	if(n == 0)
		return 0;
	if(n == 1)
		return 1;
	return n + fibonacci(n - 1);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	for(var i = 0; i < array.length - 1; i++){
		for(var j = i + 1; j < array.length; j++){
			if(array[i] > array[j]){
			var swap = array[i];
			array[i] = array[j];
			array[j] = swap;
			}
		}
	}
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	if(n == 0)
		return 1;
	return n * factorial(n - 1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	if(n == 0)
		return array;
	arr[];
	for(var k = 1; k < array.length; k++){
		arr.push(array[k]);
	}
	arr.push(array[0]);
	return rotateLeft(arr, n - 1);
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
	var parenCountLeft = 0;
	var parenCountRight = 0;
	var bracketCountLeft = 0;
	var bracketCountRight = 0;
	var sBracketCountLeft = 0;
	var sBracketCountRight = 0;
	for( var i = 0; i < bracketsString.length; i++){
		if(bracketsString.charAt(i) === '(')
			parenCountLeft++;
		if(bracketsString.charAt(i) === ')')
			parenCountRight++;
		if(bracketsString.charAt(i) === '{')
			bracketCountLeft++;
		if(bracketsString.charAt(i) === '}')
			bracketCountRight++;
		if(bracketsString.charAt(i) === '[')
			sBracketCountLeft++;
		if(bracketsString.charAt(i) === ']')
			sBracketCountRight++;
	}
	
		
	if(parenCountLeft === parenCountRight){
		if(bracketCountLeft == bracketCountRight){
			if(sBracketCountLeft === sBracketCountRight){
				return true;
			}
		}
	}
		
	return false;
};
