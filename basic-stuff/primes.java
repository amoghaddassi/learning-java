class Primes {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		for (int i=2; i <= x; i++) {
			if (is_prime(i))
				System.out.println(i);
		}
	}
	
	/** Returns if x is prime */
	private static boolean is_prime(int x) {
		if (x == 2) return true;
		for (int i=2;i<=Math.sqrt(x);i++) {
			if (x % i == 0)
				return false;
		} return true;
	}
}
