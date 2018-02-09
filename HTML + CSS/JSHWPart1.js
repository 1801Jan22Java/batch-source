var homework = {};

/*
 1. Return the nth fibonacci number
*/
homework.fibonacci = function(n){
	var results = [];
	results[0] = 0;
	results[1] = 1;
		for (var i = 2; i <= n; i++) {
			results[i] = (results[i - 1] + results[i - 2]);
		}
		return results[n];
};

/*
 2. Sort array of integers
*/
homework.sort = function(array) {
	var array = array;
	var temp = 0;

	for (var i = array.length; i > 0; i--) {
		for (var j = 0; j < (i - 1); j++) {
			if (array[j] > array[j + 1]) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	}
	return array;
};

/*
 3. Return the factorial of n
*/
homework.factorial = function(n){
	var fact = 1;
	for(var i=1; i<=n; i++) {
		fact *= i;
	}
	return fact;
};

/*
 4. Rotate left
*/
homework.rotateLeft = function(array, n) {
	var l = array.length;
	var n = n%l;
	var newArray = []
	for (var i=0; i<l; i++) {
		newArray[((i-n)+l)%l] = array[i];
	}
	return newArray;
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
  var stack = [];
  var open = {'{':'}','[':']','(':')'};
  var closed = {'}':true,']':true,')':true};
  for (var i=0; i<bracketsString.length; i++){
    var index = bracketsString[i];
    if (open[index]) {
      stack.push(index);
    } else if (closed[index]) {
      if (open[stack.pop()] !== index){
		return false;}
    }
  }
  return stack.length === 0;
};