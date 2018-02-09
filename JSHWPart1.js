var homework = {};

homework.fibonacci = function(n) {
	// First and second terms in Fib. sequence is 0 and 1
	var first = 0;
	var second = 1;
	
	// Memoized Fibonacci
	for (var i = 0; i < n; i++) {
		
		// Change the value of first to that of second
		var temp = first;
		first = second;
		
		// Change the value of second to the sum of itself and
		// the previous value of first
		second += temp;
	}

	return first;
};

homework.sort = function(array) {
	// If swapFlag is true, we need to make at least one more pass over list
	var swapFlag = true;
	
	while (swapFlag) {
		// Assume list is sorted
		swapFlag = false;
		
		for (var i = 0; i < array.length - 1; i++) {
			
			// If an element is greater than the one that succeeds it ...
			if (array[i] > array[i + 1]) {
				// ... we know that it is not sorted, so we need to make another pass
				swapFlag = true;
				
				// Here, a swap is performed to correct the order
				var temp = array[i + 1];
				array[i + 1] = array[i];
				array[i] = temp;
			}
			// At this point, if swapFlag is still false, then the array is sorted
			// so we can exit the while loop and the entire method
		}
	}

	return arr;
};

homework.factorial = function(n) {
	if (n < 0) return -1;

	// 0! = 1
	if (n == 0) return 1;
	
	// Keep multiplying in descending order until we reach 1
	var result = n;
	while (n != 1) {
		n--;
		result *= n;
	}
	
	return result;
};

homework.rotateLeft = function(array, n) {
	if (array.length == 0 || n <= 0) {
		return array;
	}

	// Take the first element...
	// ... and make it the last.
	for (var i = 0; i < n; i++) {
		var temp = array[0];
		array.shift();
		array.push(temp);
	}

	return array;
};

homework.balancedBrackets = function(bracketsString) {
	var charStack = [];
	var openList = ["(", "[", "{"];

    for(var i = 0; i < bracketsString.length; i++) {
		var c = bracketsString.charAt(i);

		// If we have an opening bracket, push it to "stack".
		//
		// If we have a closing bracket, check if it matched the opening bracket
		// that we pop from the stack. If matching, we can continue, else false.
		// If the stack is empty, there is an uneven number of brackets anyway, so
		// so it must be false.
		//
		// Any other characters are allowed as they do not form brackets and cannot violate
		// any rules.

        if (openList.includes(c)) {     
            charStack.push(c);
        } else if (c == ']' && (charStack.length == 0 || charStack.pop() != '[')) {
            return false;
        } else if (c == ')' && (charStack.length == 0 || charStack.pop() != '(')) {
            return false;          
        } else if (c == '}' && (charStack.length == 0 || charStack.pop() != '{')) {
            return false;
        }
    }

    // At the end, if stack is not empty, then we have an uneven number of brackets, making it false.
    return charStack.length == 0;
};