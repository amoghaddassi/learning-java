class Primes {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		for (int i=2; i <= x; i++) {
			if (isPrimeDivisible(i))
				System.out.println(i);
		}
	}
	
	/** Returns if x is prime */
	private static boolean isPrime(int x) {
		if (x == 2) return true;
		for (int i=2;i<=Math.sqrt(x);i++) {
			if (x % i == 0)
				return false;
		} return true;
	}

	/** Returns if x is prime using isDivisible */
	private static boolean isPrimeDivisible(int x) {
		if (x <= 1) return false;
		else return ! isDivisible(x, 2);
	}

	private static boolean isDivisible(int x, int k) {
		if (k < x) {
			if (x % k == 0) return true;
			else return isDivisible(x, k+1);
		} else return false;
	}
	
	private static boolean isDivisibleIterative(int x, int k) {
		while (k < x) {
			if (x % k == 0) return true;
			else k++;
		} return false;
	}
}
