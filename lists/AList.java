public class AList<key> {
    // TODO: Adjust capacity to meet memory specs of the project.
    // TODO: Make the underlying array circular (recommended by Hug).
    private int size;
    private key[] items;
    private int nextFirst;
    private int nextLast;
    private int first;
    private int last;

    public AList() {
        items = (key[])new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /** Doubles the size of the array and copies all current elements.*/
    private void resize(boolean increase_size) {
        // TODO: Implement resizing.
    }

    private int incrementBackwards(int i) {
        if (i == 0) {
            return items.length;
        } else {
            return i-1;
        }
    }

    private int incrementForwards(int i) {
        if (i == items.length) {
            return 0;
        } else {
            return i+1;
        }
    }

    /** Adds item X to the front of the list.*/
    public void addFirst(key x) {
        if (nextFirst == nextLast) {
            resize(true);
        }
        items[nextFirst] = x;
        nextFirst = incrementBackwards(nextFirst);
        size++;
    }

    /** Adds item X to the back of the list.*/
    public void addLast(key x) {
        if (nextFirst == nextLast) {
            resize(true);
        }
        items[nextLast] = x;
        nextLast = incrementForwards(nextLast);
        size++;
    }

    /** Removes the first item from the list.*/
    public key removeFirst() {
        key tempFirst = items[incrementForwards(nextFirst)];
        items[incrementForwards(nextFirst)] = null;
        nextFirst = incrementForwards(nextFirst);
        size--;
        return tempFirst;
    }

    /** Removes the last item from the list.*/
    public key removeLast() {
        key tempLast = items[incrementBackwards(nextLast)];
        items[incrementBackwards(nextLast)] = null;
        nextLast = incrementBackwards(nextLast);
        size--;
        return tempLast;
    }


    /** Returns the ith item in the list.*/
    public key get(int i) {
        if (nextFirst + i > items.length-1) {
            return items[nextFirst+i-items.length];
        }
         return items[nextFirst+i+1];
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
        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                res += items[i] + " ";
            }
        } else {
            for (int i = nextFirst+1; i < items.length; i++) {
                res += items[i] + " ";
            }
            for (int i = 0; i < nextLast; i++) {
                res += items[i] + " ";
            }
        }
        return res;
    }

    /** Prints the string representation of the list.*/
    public void printDeque() {
        System.out.println(toString());
    }
}
