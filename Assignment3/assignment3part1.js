var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	var result = 0;
	if(n==0){ return 0;}
	if(n==1){ return 1;}
	else
	{
		result=this.fibonacci(n-1)+this.fibonacci(n-2);
	}
	return result;
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	for(var i=0;i<arr.length;i++){
    for(var j=0;j<arr.length-1;j++){
        if(arr[j]>arr[j+1]){
            var temp=arr[j+1];
            arr[j+1]=arr[j];
            arr[j]=temp; 
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
	var result = 0;
	if(n==1) return 1;
	if(n==0) return 1;
	else{
	
		result =n* this.factorial(n-1);
	}
	return result;

};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, offset) {
		var tempArr =arr;
		for(var i = 0;i<arr.length;i++)
		{
			if(i<=offset){
				arr[i]=arr[(i+offset)%length];
			}
			else
			{
				for(var j=0;j<=offset;j++){
					arr[i]=tempArr[j];
				}
			}
		}
	
		for(var i =0;i< arr.length;i++)
		{
			//System.out.print(tempArr[i] + " ");
			console.log(arr[i]+ " ");
		}

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
	
	if(bracketsString.includes("]")){
	bracketsString=bracketsString.replace(/]/gi,"[");
	};
	if(bracketsString.includes("}")){
	bracketsString=bracketsString.replace(/}/gi,"{");
	};
	if(bracketsString.includes(")")){
	bracketsString=bracketsString.replace(/)/gi,"(");
	};
	
	var arr = bracketsString.split("");
	var result = false;
	console.log("Testing odd length strings");
	if(arr.length%2!==0){
		return false;
		}
		var j = 0;
		for(j=0;j<arr.length;j++)
		{
			var begin = j;
			var end = length-j;
			console.log("Begin: "+arr[begin]+ " End "+ arr[end]);
			if(arr[begin]!=arr[end])
			{
				console.log("False!");
				return false;
			}
			else{
				result=true;
			}
		}
	return result;

};
