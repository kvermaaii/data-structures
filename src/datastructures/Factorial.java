 package datastructures;

public class Factorial {
	
	private int fib[];
	private int fact[];
	
	public int fib(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public int fibUsingDp(int n) {
		fib[0] = 0;
		fib[1] = 1;
		for(int i = 2; i <= n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];
	}
	
	public int fibOptimized(int n) {
	    if (n == 0) return 0;
	    if (n == 1) return 1;
	    int a = 0, b = 1;
	    for (int i = 2; i <= n; i++) {
	        int current = b + a;
	        a = b;
	        b = current;
	    }
	    return b;
	}
	
	public int fact(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		return n*fact(n-1);
	}
	
	public int factUsingDp(int n) {
		fact[0] =1;
		fact[1] = 1;
		for(int i = 2; i <= n; i++) {
			fact[i] = fact[i-1]*i;
		}
		return fact[n];
	}
	
	public int factOptimized(int n) {
	    int result = 1;
	    for (int i = 2; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}

}
