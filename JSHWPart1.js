/*JS HW, part 1:

Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 
*/
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/

homework.fibonacci = function(n){
var a =0;
var b = 1;
var temp;
var i;
for (i = 0; i<n; i++)
{
	temp = a;  //save a value
	a = a+b;   //add a and b
	b = temp;  //restore previous value
}
return a;       //return nth fibonacci number
};


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    //use bubble sort to sort the array
  for (var i = array.length-1; i >= 0; i--) 
  {
    for(var j = 0; j < i; j++) 
    {
        //if the element at the current index is larger then the one next to it then swap
      if (array[j] >= array[j+1]) 
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
var fact = 1;
if (n===0)
{
	return 1;
}
while(n>0)
{fact = fact*n;
n--;}
return fact;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
var temp;
var i;
for(i = 0; i<n; i++)
{
	temp = array.shift();
	array.push(temp);
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
var stack = [];
 var map = {
    '(': ')',
    '[': ']',
    '{': '}'
  };
  for (var i = 0; i < bracketsString.length; i++) {
    if (bracketsString[i] === '(' || bracketsString[i] === '[' || bracketsString[i] === '{') {
      stack.push(bracketsString[i]);
    } 
    else 
    {
      var last = stack.pop();

      if (bracketsString[i] !== map[last])
      {
        return false;
      }
    }
  }
  if (stack.length !== 0) 
  {
    return false;
  }

  return true;
};


//YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
