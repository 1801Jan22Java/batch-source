//James Whitten

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
var num1 = 0;
var num2 = 1;
var i = 2;
for (i = 2; i < n+1; i++)
		{
			var num3 = num1 + num2; 
			num1 = num2;
			num2 = num3;
        }
		return num3;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

		for (var i = 0; i < array.length - 1 ; i++)
		{
			for (var j = 0; j < array.length - i - 1; j++)
			{
				if (array[j] > array[j+1])
				{
					var temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
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
var ourResult = 1;
		if (n < 0)
		{
			return -1;
		}
		if (n == 0)
		{
			return 1;
		}
		for (var i = 1; i <= n; i++)
		{
			ourResult = ourResult * i;
		}
		return ourResult;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
var temp = 0;
for (var i = 0; i < n; i++)
{
	temp = array[0];
	for (var j = 0; j < array.length - 1; j++)
	{
		array[j] = array[j+1];
		
		
	}
	array[array.length-1] = temp;
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

for (var i = 0; i < (bracketsString.length/2); i++)
{
	if (bracketsString.charAt(i) == "]" || bracketsString.charAt(i) == ")" || bracketsString.charAt(i) == "}")
	{
		return false;
	}
	if (bracketsString.charAt(i) == "[" && bracketsString.charAt(bracketsString.length-(i+1))!= "]")
	{
		return false;
	}
	if (bracketsString.charAt(i) == "(" && bracketsString.charAt(bracketsString.length-(i+1))!= ")")
	{
		return false;
	}
	if (bracketsString.charAt(i) == "{" && bracketsString.charAt(bracketsString.length-(i+1))!= "}")
	{
		return false;
	}
}
return true;

};
