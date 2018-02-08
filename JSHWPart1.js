/*
Michael Chen JSHW Part 1
February 7, 2018
*/
var homework = {};

/*
create a fibonacci function by using memoization. you create a table
to keep track of the computation you have already done so that you can
instead of recalculating the two previous fibonacci sequence nunbers, you
can just look them up in the table
*/
homework.fibonacci = function(n){

  // hard code the first two values
  var arr = [0,1]

 // return the hard coded first two values if n is less than 2
  if(n < 2) {
    return arr[n]
  }
  // for every value n higher than 2, create a table and look up the result
  for (var i = 2; i <= n; i++) {
    arr[i] = arr[i - 1] + arr[i -2];
  }

  return arr[n];

};

/*
create a sort function that implements bubble sort. make a double for loop
where the outer loop iterates from the tail of the list to the front of the
list. the inner loop iterates from the begining of the list to the index
of the outer loop. the inner loop swaps an index if the next index is smaller,
which pushes the largest values to the index of the outer loop which eventually
sorts the array
*/
homework.sort = function(array) {

  for (var i = array.length-1; i >= 0; i--) {
    for(var j = 0; j < i; j++) {
      if (array[j] >= array[j+1]) {
        var temp = array[j];
        array[j] = array[j+1];
        array[j+1] = temp;
      }
    }
  }

  return array;
};

/*
create a factorial function by using memoization. you create a table
to keep track of the computation you have already done so that you can
instead of recalculating the previous factorial, you can look up the
factorial in the table then just multiply by the next value of the factorial
*/
homework.factorial = function(n){

  // hard code the first value of the factorial
  var arr = [1];

  // for every other factorial value use the table and find the result
  for (var i = 1; i <= n; i++) {
    arr[i] = i * arr[i - 1];
  }
  return arr[n];

};

/*
create a rotate left function that rotates an array n times. The function
utilizes a modulus to keep the index within the range of the array
*/
homework.rotateLeft = function(array, n) {

  var temp = [];
  // set the legntht to a variable because i dont want to write out .length
  var len = array.length;
  for(var i = 0; i < len; i++) {
    // set the next value in the temp array to the value n indexes further
    // into array, if the index is larger than the length then the modulus
    // should keep the index within bounds
    temp[i] = array[(i + n) % len];
  }

  return temp;

};

/*
create a balanced brackets function that returns true or false if the
string supplied is balanced or not. If there is a closing bracket in
the string supplied, it checks if the corresponding opening bracket is
the last item in the arr variable. If not then the brackets are not
balanced. If the next item in the string supplied is an open bracket, then
append the value to the end of the arr variable
*/
homework.balancedBrackets = function(bracketsString){

  // create a table to reference closing brackets
  var closed = [")", "}","]"];

  // create a dictionary that maps closing brackets to opening brackets
  var dictionary = {"}":"{" , ")":"(","]":"["};
  var arr = [];

  // if the supplied string is empty then return false, because no brackets
  // were balanced
  if (bracketsString.length == 0) {
    return false;
  }

  for(var i = 0; i < bracketsString.length; i++) {
    // if the next tiem in the supplied string is a closing bracket
    if (closed.includes(bracketsString[i])) {

      // pop the last item in the arr variable to check if it matches the
      // closing bracket. if it does then that set of brackets is balancedBrackets
      // and the opening bracket before that can now get balanced
      if (arr.pop() != dictionary[bracketsString[i]] ) {

        // if the popped item and the current item in the supplied string
        // do no match, then return false
        return false;
      }
    }

    // if the item is not a closing bracket then add it to the arr variable
    // to be balanced
    else {
      arr.push(bracketsString[i]);
    }

  }

  // a final check to make sure all opening brackets are closed; if not then
  // the length of the array will be non zero, so return false
  if (arr.length > 0) {
    return false;
  }
  return true;

};
