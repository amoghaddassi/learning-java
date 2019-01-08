public class IntList {
	public int first;
	public IntList rest;

	public IntList(int x, IntList r) {
		first = x;
		rest = r;
	}

	public IntList(int x) {
		first = x;
		rest = null;
	}

	/** Returns the length of this intList */
	public int length() {
		if (rest == null) {
			return 1;
		} else {
			return 1 + rest.length();
		}
	}

	/** Returns the length of the list using iteration */
	public int iterativeLength() {
		int res = 0;
		IntList temp = this;
		while (temp != null) {
			res++;
			temp = temp.rest;
		}
		return res;
	}

	/** Gets the item at index i of the list */
	public int get(int i) {
		if (i == 0) {
			return this.first;
		}
		return this.rest.get(i-1);
	}

	public static void main(String[] args) {
		IntList L = new IntList(3, new IntList(23));
		System.out.println(L.get(1));
	}

}