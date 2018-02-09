//JS HW, part 1:

//Fill in the functions and submit them to your branch in a file 
//called JSHWPart1.js by 5pm Friday, Feb. 9. 

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	//starting with base cases
	if(n<=1)
		return 1;
	else
	//recursively define what the sequence is
		return fibonacci(n-1)+fibonacci(n-2);
	
};


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	for(var i=0; i<array.length-1; i++)
		{
		var swapped;
	    do {
	        swapped = false;
	        for (var j=0; j < array.length-1; j++) {
	            if (array[j] > array[j+1]) {
	                var temp = array[j];
	                array[j] = array[j+1];
	                array[j+1] = temp;
	                swapped = true;
	            }
	        }
	    } while (swapped);
		}
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
	if(n<=1){
			return 1;
		}
	else
		return n*factorial(n-1);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	var rot = array;
	var a;
	var b;
	for(i =0; i<n; i++){
		//swap first and second
		for( j=0; j<rot.length-1; j++){
			b= rot[j];
			rot[j]=rot[j+1];
			rot[j+1]=b;
		}
	}
	return rot;
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
	//get the first half
	var a="";
	var b="";
	for(i=0;i<(bracketsString.length/2);i++){
			a+=bracketsString[i];
		}
	//get back half
	for(j=bracketsString.length-1;j>((bracketsString.length/2)-1);j--){
			b+=bracketsString[j];
		}
	 //get desired back
	c="";
	for(k=0;k<(bracketsString.length/2);k++){
		switch(bracketsString[k])
			{
				case "{":
					c+="}";
					break;
				case "[":
					c+="]";
					break;
				case "(":
					c+=")";
					break;
				case "}":
					c+="{";
					break;
				case "]":
					c+="[";
					break;
				case ")":
					c+="(";
					break;
			}
	}
	return c==b;
};




