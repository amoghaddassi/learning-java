public class AList<key> {
    // TODO: Adjust capacity to meet memory specs of the project.
    // TODO: Make the underlying array circular (recommended by Hug).
    private int capacity;
    private int size;
    private key[] items;

    public AList() {
        capacity = 8;
        items = (key[])new Object[capacity];
        size = 0;
    }

    /** Doubles the size of the array and copies all current elements.*/
    private void resize(boolean increase_size) {
        if (increase_size) {
            capacity = capacity * 2;
        } else {
            capacity = capacity / 2;
        }

        key[] temp = (key[])new Object[capacity];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    /** Moves a block of length from items starting at srcPos to a block starting at destPos*/
    private void move(int srcPos, int destPos, int length) {
        // Resizes as necessary so there are available spaces to move the block.
        // NOTE: This shouldn't have to loop more than once under normal usage.
        while (destPos + length > capacity) {
            resize(true);
        }
        key[] temp = (key[])new Object[capacity];
        System.arraycopy(items, srcPos, temp, destPos, length);
        items = temp;
    }

    /** Adds item X to the front of the list.*/
    public void addFirst(key x) {
        if (size == capacity) {
            resize(true);
        }
        move(0, 1, size);
        items[0] = x;
        size++;

    }

    /** Adds item X to the back of the list.*/
    public void addLast(key x) {
        if (size == capacity) {
            resize(true);
        }
        items[size] = x;
        size++;
    }

    /** Removes the first item from the list.*/
    public key removeFirst() {
        key first = items[0];
        move(1, 0, size-1);
        size--;
        return first;
    }

    /** Removes the last item from the list.*/
    public key removeLast() {
        key last = items[size-1];
        items[size-1] = null;
        size--;
        return last;
    }

    /** Returns the ith item in the list.*/
    public key get(int i) {
        return items[i];
    }

    /** Returns if the list contains no elements.*/
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the # of elements stored in the list.*/
    public int size() {
        return size;
    }

    public String toString() {
        String res = "";
        for (int i =0; i < size; i++) {
            res += items[i]+" ";
        }
        return res;
    }

    /** Prints the string representation of the list.*/
    public void printDeque() {
        System.out.println(toString());
    }
}
