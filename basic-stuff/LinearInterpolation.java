class LinearInterpolation {
	public static void main(String[] args) {
	}

	/** Given an array of x values, XS, and corresponding f(x) values, YS, give the 
	value of f(x) on some input X, using linear interpolation.*/
	public static double interpolate(double x, double[] xs, double[] ys) {
		int lowerIndex = 0;
		int upperIndex = 1;
		while (xs[upperIndex] < x):
			lowerIndex++;
			upperIndex++;
		double x1 = xs[lowerIndex];
		double y1 = ys[lowerIndex];
		double x2 = xs[upperIndex];
		double y2 = ys[upperIndex];
		return y1 + (y2 - y1) * (x-x1) / (x2-x1)
	}
}
