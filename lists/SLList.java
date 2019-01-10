public class SLList {
	/**
	 * Naked recursive structure SLList will wrap
	 * Advantage over directly using IntNode class by storing meta info and methods about the list.
	 */
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;

	public SLList(int x) {
		sentinel = new IntNode(42, new IntNode(x, null));
		size = 1;
	}

	/** Constructor for the empty list.*/
	public SLList() {
		sentinel = new IntNode(42, null); // using 42 as the arbitrary value to hold in the sentinel node.
		size = 0;
	}

	/** Add X to the front of the list.*/
	public void addFirst(int x) {
		size++;
		sentinel.next = new IntNode(x, sentinel.next);
	}

	/** Adds X to the end of the list.*/
	public void addLast(int x) {
		size++;
		IntNode p = sentinel;
		while (p.next != null) {
			p = p.next;
		}
		p.next = new IntNode(x, null);
	}

	/** Returns the size of the list. */
	public int size() {
		return size;
	}

	/** Returns the item in the ith node of L */
	private static int getItem(int i, IntNode L) {
		if (i == 0) {
			return L.item;
		}
		return getItem(i-1, L.next);
	}

	/** Returns the item at index i */
	public int getItem(int i) {
		return getItem(i, sentinel.next);
	}

	/** Returns a SLList containing integers from 0 to X noninclusive */
	public static SLList range(int x) {
		SLList res= new SLList(0);
		for (int i = 1; i < x; i++) {
			res.addLast(i);
		}
		return res;

	}

	private static SLList slice(int i, int j, IntNode l) {
		if (i == 0) {
			if (j == 0) {
				return null;
			}
			SLList res = new SLList(l.item);
			IntNode p = l.next;
			for (int x = 1; x < j; x++) {
				res.addLast(p.item);
				p = p.next;
			}
			return res;
		}
		return slice(i-1, j-1, l.next);
	}

	/** Returns a slice of this list from i, inclusive, to j, exclusive. */
	public SLList slice(int i, int j) {
		return slice(i, j, sentinel.next);
	}

	/** Returns a SLList with the same elements as nums. */
	public static SLList of(int[] nums) {
		SLList res = new SLList();
		for (int i = 0; i < nums.length; i++) {
			res.addLast(nums[i]);
		}
		res.size = nums.length;
		return res;
	}

	private static String toString(IntNode p) {
		if (p == null) {
			return "";
		}
		return p.item + " " + toString(p.next);
	}

	/** String rep of and SLList */
	public String toString() {
		IntNode p = sentinel.next;
		return "[" + toString(p) + "]";
	}

	/** Checks for equality between another SLList */
	public boolean equals(SLList L) {
		if (L.size() != this.size()) {
			return false;
		}
		for (int i=0; i<size(); i++) {
			if (L.getItem(i) != this.getItem(i)) {
				return false;
			}
		}
		return true;
	}
} 