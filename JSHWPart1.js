var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
if(n==0) return 0; if(n==1) return 1; else return this.fibonacci(n-1)+this.fibonacci(n-2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
for (var i = 0; i < array.length; i++) {
	for (var j=0;j<array.length-i-1; j++){
		if (array[j] > array[j+1]){
			var temp = array[j+1];
			array[j + 1] = array[j];
			array[j] = temp;
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
if(n==0) return 1;
if(n==1) return 1;
else return n*this.factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
		if(n>array.length){
			n=n%array.length;
		}
		var array2 = [];
		var index = 0;
		for(var s=n; s<array.length; s++){
			array2[index] = array[s];
			index++;
		}
		for(var i = 0; i<n; i++){
			array2[index] = array[i];
			index++;
		}
		return array2;
		
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
var openparen = 0;
var openbrack = 0;
var openbrace = 0;
var closedparen = 0;
var closedbrack = 0;
var closedbrace = 0;
for(var i=0; i<bracketsString.length; i++){
	if(bracketsString.charAt(i)=="("){
		openparen+=1;
	}
	else if(bracketsString.charAt(i)=="["){
		openbrack+=1;
	}
	else if(bracketsString.charAt(i)=="{"){
		openbrace+=1;
	}
	else if(bracketsString.charAt(i)==")"){
		closedparen+=1;
	}
	else if(bracketsString.charAt(i)=="]"){
		closedbrack+=1;
	}
	else if(bracketsString.charAt(i)=="}"){
		closedbrace+=1;
	}
	else{}
	
}
if(openparen==closedparen && openbrack==closedbrack && openbrace==closedbrace) {
return true;
}
else return false;
};