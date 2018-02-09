var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    if(n === 1){
        return 1; 
    }
    else if (n === 2){
        return 2;
    }
    else{
        return (homework.fibonacci(n-1)+(n-2));
    }

};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    var x = 0;
    var s = false;
    while(!s){
        s = true;
        for(var u = 0; u < array.len-2; u++){
            if(array[u] > array[u+1]){
                s = false;
                x = array[u];
                array[u] = array[u+1];
                array[u+1] = x;
            }
        }    
    }
    console.log('[');
    for(var v = 0; v < array.len; v++){
        console.log(array[v]+', ');
    }
    console.log(']');
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if(n === 1){
        return 1;
    }
    else {
        return (n * homework.factorial(n-1));
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
    var length = array.len;
    var temp;
    for(var x = 0; x < n; x++){
        temp = array[0];
        for(var y = length-1; y > 0; y--){
            array[y-1] = array[y];
        }
        array[length-1] = temp;
    }
    console.log("[");
    for(var x = 0; x < length; x++){
        console.log(array[x]+", ")
    }
    console.log("]");
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
    /*
        Algorithm explanation - (for both your reference and mine)
        In this function, I'm effectively implementing
        a pushdown automata (PDA). It's like a 
        finite state machine, but has a stack of saved inputs. 
        Herein, it is represented by the var 'stack'. 
        
        If an opening symbol is encountered, push it onto the stack.

        If a closing symbol is encountered, check the top of the stack. 
        
            If the symbol at the top of the stack is the match 
            for the next input symbol, keep going.

            Else, halt and return false;

    */
    var stack = '';
    var y = -1;
    var pastMiddle = false;
    for(var x = 0; x < bracketsString.len; x++){
        
        if(bracketsString.charAt(x) === '('){
            stack+='(';
            y+=1;
        }
            

        if (bracketsString.charAt(x) === '['){
            stack+='[';
            y+=1;
        }

        if (bracketsString.charAt(x) === '{'){
            stack+='{';
            y+=1;
        }

        if(bracketsString.charAt(x) === ')'){
            stack = stack.substring(0,x);
            if(stack.charAt(y) !== '('){
                return false;
            }
            
        }

        if(bracketsString.charAt(x) === ']'){
            stack = stack.substring(0,x);
            if(stack.charAt(y) !== '['){
                return false;
            }
            
        }

        if(bracketsString.charAt(x) === '}'){
            stack = stack.substring(0,x);
            if(stack.charAt(y) !== '{'){
                return false;
            }
            
        }   
    }
    if(y == 0)
        return true;
    else
        return false;
};
