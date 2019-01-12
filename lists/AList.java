public class AList<key> {
    // TODO: Adjust capacity to meet memory specs of the project.
    private int size;
    private key[] items;
    private int nextFirst;
    private int nextLast;

    public AList() {
        items = (key[])new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    private void increaseSize(int factor) {
        key[] temp = (key[])new Object[items.length*factor];
        System.arraycopy(items, nextFirst+1, temp, temp.length-nextFirst- 1, items.length-nextFirst -1);
        System.arraycopy(items, 0, temp, 0, nextLast);
        nextFirst = temp.length-nextFirst-2;
        items = temp;
    }

    private void decreaseSize(int factor) {
        key[] temp = (key[])new Object[items.length / factor];
        if (nextFirst > nextLast) {
            key[] temp2 = (key[])new Object[items.length];
            System.arraycopy(items, nextFirst+1, temp2, 0, items.length-nextFirst-1);
            System.arraycopy(items, 0, temp2, size-nextLast, nextLast);
            System.arraycopy(temp2, 0, temp, 0, size);
        } else {
            System.arraycopy(items, nextFirst+1, temp, 0, nextLast-nextFirst);
        }
        nextFirst = temp.length - 1;
        nextLast = size;
        items = temp;
    }

    private int incrementBackwards(int i) {
        if (i == 0) {
            return items.length-1;
        } else {
            return i-1;
        }
    }

    private int incrementForwards(int i) {
        if (i == items.length-1) {
            return 0;
        } else {
            return i+1;
        }
    }

    /** Adds item X to the front of the list.*/
    public void addFirst(key x) {
        if (nextFirst == nextLast) {
            increaseSize(2);
        }
        items[nextFirst] = x;
        nextFirst = incrementBackwards(nextFirst);
        size++;
    }

    /** Adds item X to the back of the list.*/
    public void addLast(key x) {
        if (nextFirst == nextLast) {
            increaseSize(2);
        }
        items[nextLast] = x;
        nextLast = incrementForwards(nextLast);
        size++;
    }

    /** Removes the first item from the list.*/
    public key removeFirst() {
        if (size * 4 < items.length){
            decreaseSize(2);
        }
        key tempFirst = items[incrementForwards(nextFirst)];
        items[incrementForwards(nextFirst)] = null;
        nextFirst = incrementForwards(nextFirst);
        size--;
        return tempFirst;
    }

    /** Removes the last item from the list.*/
    public key removeLast() {
        if (size * 4 <= items.length){
            decreaseSize(2);
        }
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
