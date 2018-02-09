var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	var arr = [0,1,1];
  
  for(var i = 2; i<n;i++){
    arr[i+1] = arr[i]+arr[i-1];
  }
  
  return arr[n];
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

	for(var i = 1; i < array.length; i++) {
    var temp = array[i];
    for(var j = i - 1; j >= 0 && array[j] > temp; j--) {
      array[j+1] = array[j];
    }
    array[j+1] = temp;
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
	var answer= 1;
  for(var i = 0; i< n; i++){
    answer= answer *(i+1);
  }
return answer;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	var temp_f;
  var temp;
  var runs = n %5;
  
  for(var i = 0; i<n ;i++){
    temp = array[0];
      
    for(var j = 1; j<array.length;j++){
      
         array[j-1] = array[j];
        if(j == array.length-1){
          array[j] = temp;
        }
      
        
    }
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
	var array1=[];
  var character;
  var character2;
  
  var array2=[];

  for(var i = 0; i<bracketsString.length; i++){
    array1.push(bracketsString.charAt(i));
  }
  /*
  for(var k = 0; k< array1.length;k++){
    console.log("at position "+k+"there is " +array1[k]);
  }*/

  for(var j = 0; j< bracketsString.length;j++){
     character = array1.pop();
    
    
    
    
      if(character ==="("){
        character2 = array2.pop();
        console.log(character2);
        if(character2 !== ")"){
          return false;
          }
        }
    
        if(character ==="{"){
        if(array2.pop() !== "}"){
          return false;
          }
        }
        
        if(character ==="["){
        if(array2.pop() !== "]"){
          return false;
          }
        }
    
        if(character === ")"||character === "]"||character === "}"){
        array2.push(character);
       }
      if(character === undefined){
      break;
    }
    }
    
    return true;
};
