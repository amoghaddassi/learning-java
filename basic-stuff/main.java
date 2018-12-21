class Main {
	public static void main(String[] args) {
		int res[] = new int[args.length];
		for (int i = 0;i < args.length;i++) {
			res[i]=Integer.parseInt(args[i]);
		}
		System.out.println(dist(res[0], res[1], res[2], res[3]));
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
}
