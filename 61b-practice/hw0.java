public class Solutions {
	public static void main(String[] args) {
		int[] a = {1, 2, -3, 4, 5, 4};
		int n = 3;
		windowPosSum(a, n);
		System.out.println(java.util.Arrays.toString(a));
	}

	private static void windowPosSum(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				continue;
			}
			for (int j = 1; j <= n; j++) {
				if (i+j >= a.length) {
					break;
				}
				a[i] = a[i] + a[i+j];
			}
		}
	}

	/** Returns the larger of X and Y */
	private static int larger(int x, int y) {
		if (x < y) {
			return y;
		} return x;
	}

	/** Returns the absolute value of X */
	private static double abs(double x) {
		if (x < 0) {
			return -x;
		} else if (x == 0) {
			return 0;
		} return x;
	}

	/** Prints all the integers between X and LIMIT*/
	private static void printInts(int x, int limit) {
		if (x < limit) {
			while (x < limit) {
				System.out.println(x);
				x++;
			}
		}
	}

	private static void printTriangle(int base) {
		String layer = "*";
		while (layer.length() <= base) {
			System.out.println(layer);
			layer = layer + "*";
		}
	}

	private static int max(int[] m) {
		int greatest = m[0];
		for (int i=0;i< m.length;i++) {
			if (m[i] > greatest) {
				greatest = m[i];
			} 
		} return greatest;
	}
}