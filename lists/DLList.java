public class DLList<key> {
    private class Node {
        Node prev;
        Node next;
        key item;

        public Node(Node p, Node n, key x) {
            prev = p;
            next = n;
            item = x;
        }
    }

    private Node sentinel;
    private int size;

    public DLList() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Returns the size of the list.*/
    public int size() {
        return size;
    }

    /** Adds X to the front of the list.*/
    public void addFirst(key x) {
        sentinel.next = new Node(sentinel, sentinel.next, x);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Adds X to the back of the list.*/
    public void addLast(key x) {
        sentinel.prev = new Node(sentinel.prev, sentinel, x);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /** Adds all elements of vals to the end of the list*/
    public void addMany(key[] vals) {
        for (key x: vals) {
            this.addLast(x);
        }
    }

    /** Removes the first item in the list.*/
    public key removeFirst() {
        key item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    /** Removes the last element in the list.*/
    public key removeLast() {
        key item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return (sentinel.next == sentinel.prev);
    }

    private key getRecursiveFromTail(Node n, int i) {
        // where i is the index looking at the list in reverse order.
        if (i == 0) {
            return n.item;
        }
        return getRecursiveFromTail(n.prev, i-1);
    }

    private key getRecursiveFromHead(Node n, int i) {
        if (i == 0) {
            return n.item;
        }
        return getRecursiveFromHead(n.next, i-1);
    }

    /** Returns the ith item in the list.*/
    public key getRecursive(int i) {
        assert(i < size());
        if (i > size() / 2) {
            return getRecursiveFromTail(sentinel.prev, size()-i-1);
        }
        return getRecursiveFromHead(sentinel.next, i);
    }

    private key getFromTail(int i) {
        Node p = sentinel.prev;
        while (i != 0) {
            p = p.prev;
            i--;
        }
        return p.item;
    }

    private key getFromHead(int i) {
        Node p = sentinel.next;
        while (i != 0) {
            p = p.next;
            i--;
        }
        return p.item;
    }


    public key get(int i) {
        if (i > size() / 2) {
            return getFromTail(size() - i - 1);
        }
        return getFromHead(i);
    }

    public String toString() {
        String res = "";
        Node p = sentinel.next;
        while (p.next != sentinel) {
            res += p.item + " ";
            p = p.next;
        }
        return res;
    }

    public void printDeque() {
        System.out.println(toString());
    }

}
