// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		} 

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x2 < 0){
			sum = minus(x1, -x2);
		}
		else{
			for(int i = 0; i < x2; i++) {
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if(x2 < 0){
			sum = plus(x1, -x2);
		}
		else{
			for(int i = 0; i < x2; i++) {
				sum--;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int tSum = Math.abs(x1);
		if(x1 == 0 || x2 == 0){	//if either x1 or x2 is 0 then x1*x2 is 0
			return 0;
		} else for(int i = 1; i < Math.abs(x2); i++) {	//calculates the absolute value of x1*x2
			tSum = plus(tSum, Math.abs(x1));
		}
		if(x1 < 0) tSum = -tSum;
		if(x2 < 0) tSum = -tSum;
		return tSum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int tSum = x;
		if(n == 0){
			return 1;
		}
		else if (n < 0){	//if n is negative then x^n = 1/x^-n which is -1 < 1/x^-n < 1
			return 0;
		}
		else {
			for(int i = 1; i < n; i++) {
				tSum = times(tSum, x);
			}
		}
		return tSum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divV = 0;	//div Value
		if(x2 == 0){	//if x2 is 0 then x1/x2 is undefined
			return 0;
		}	
		else while (times(Math.abs(x2), plus(divV, 1)) <= Math.abs(x1)) {
			divV++;
		}
		if(x1 < 0) divV = -divV;
		if(x2 < 0) divV = -divV;
		return divV;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divV = div(x1, x2);		//div Value
		int modV = minus(x1, times(x2, divV));		//mod Value
		return (x2 >= 0) ? modV : x2-modV;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int count = 0;
		if(x <= 0){
			count = 0;
		}
		else while (pow(plus(count, 1) , 2) <= x) {
			count++;
		}
		return count;
	}	  	  
}