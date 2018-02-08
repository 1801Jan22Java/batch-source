 var homework = {};
        /*
        JS HW, part 1:

        Fill in the functions and submit them to your branch in a file called JSHWPart1.js by 5pm Friday, Feb. 9. 

        var homework = {};

        /*
         1. Return the nth fibonacci number

         f(0) = 0
         f(1) = 1
         f(10) = 55
        */
        homework.fibonacci = function(n) {


            var fibonacci = []; // n: create the empty array.

            // first two initial numbers
            var init0 = 0;
            var init1 = 1;

            for (var i = 0; i < n; i++) {

                if (i == 0 || i == 1) {
                    fibonacci[i] = i;
                } else {
                    // generates the added number using previous 2 numbers		
                    var added = init0 + init1;
                    fibonacci[i] = added;
                    init0 = init1;
                    init1 = added;
                }
            }

            console.log("Q1 Answer: " + fibonacci.toString());
        };

        homework.fibonacci(10);

        
        
        
        
        /*
         2. Sort array of integers

         f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

         Don't use the Array sort() method... that would be lame.
        */
        homework.sort = function(intArr) {

            for (var j = 0; j < intArr.length - 1; j++) {

                var init = 0; // This means the total number of times that two adjacent numbers have changed when a bubble sort is run.		

                for (var i = 0; i < intArr.length - 1; i++) {

                    if (intArr[i] - intArr[i + 1] > 0) {
                        var temp = intArr[i];
                        intArr[i] = intArr[i + 1];
                        intArr[i + 1] = temp;
                        init++;
                    };
                }

                if (init < 1) { // If no element exchange has taken place, stop a bubble sort.
                    break;
                }
            }
            console.log("Q2 Answer: " + intArr.toString());
        };
        homework.sort([2,4,5,7,3,1]);

        
        
        
        
        /*
         3. Return the factorial of n

         f(0) = 1
         f(1) = 1
         f(3) = 6
        */
        homework.factorial = function(n) {
            var sum = 1; // initialize the total sum number

            var i = 1;
            while (i <= n) { // The numbers between 1 to n will be multiplied 
                sum *= i;
                i++;
            }
            console.log("Q3 Answer: " + sum);
        };
        homework.factorial(5);
        
        
        
        
        /*
         4. Rotate left

         Given array, rotate left n times and return array

         f([1,2,3,4,5], 1) = [2,3,4,5,1]
         f([1,2,3,4,5], 6) = [2,3,4,5,1]
         f([1,2,3,4,5], 3) = [4,5,1,2,3]

        */
        homework.rotateLeft = function(array, n) {
            var rotateNo = n % array.length;
            
            for (var i = 0 ; i <rotateNo ; i++){
                var firstEl = array.shift();
                array.push(firstEl);
                  
            }
            console.log("Q4 Answer: "+array.toString());   
        };

        homework.rotateLeft([1,2,3,4,5,6,7], 18);
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
        homework.balancedBrackets = function(bracketsString) {
            var arr = bracketsString.split("");
            var lastWord ="";
            var ifSame = true;
            if (arr.length%2 != 0){
                console.log("it's not even no");
                ifSame = false;
            } else {
                for (var i= 0 ; i < arr.length ; i++){
                    if (arr[i] == "("){                      
                        ifSame = (arr.pop() === ")");  
                    }  else if (arr[i] == "["){
                        ifSame = (arr.pop() == "]"); 
                    }  else if (arr[i] == "{"){
                        ifSame = (arr.pop() == "}"); 
                    }  else if (arr[i] == ")"){
                        ifSame = (arr.pop() == "("); 
                    }  else if (arr[i] == "}"){
                        ifSame = (arr.pop() == "{"); 
                    }  else if (arr[i] == "]"){
                        ifSame = (arr.pop() == "["); 
                    }
                  
                }
            }
            console.log("Q5 Answer: "+ifSame);
            return ifSame;
        };
        homework.balancedBrackets("})]{][({");
 