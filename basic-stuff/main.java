class Main {
	public static void main(String[] args) {
		int x0 = Integer.parseInt(args[0]);
		int x1 = Integer.parseInt(args[1]);
		System.out.println(comb(x0, x1));
		System.out.println(fib(x0)); 
	}

	/**Computes the square of X */
	public static double square(double x) {
		return x * x;
	}	

	/**Computes the distance between (X0, Y0) and (X1, Y1)*/
	public static double dist(double x0, double y0, double x1, double y1) {
		return Math.sqrt(square(x1 - x0) + square(y1-y0));
	}
	
	/** Computes absolute value of x using if statement */
	public static double abs_if(double x) {
		if (x > 0) 
			return x;
		else if (x == 0) 
			return 0;
		else 
			return -x;
	}

	/** Computes N! */
	private static int fact(int n) {
		if (n == 1) 
			return 1;
		else return n * fact(n-1);
	}
	
	/** Computs N choose K */
	private static int comb(int n, int k) {
		return fact(n) / (fact(k) * fact(n-k));
	}

	/** Computes the Nth fibonacci number */
	private static int fib(int n) {
		if (n == 0 || n == 1) return n;
		else return fib(n-1) + fib(n-2);
	}
}
