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

    private Node head;
    private Node tail;
    private int size;

    public DLList() {
        size = 0;
        head = new Node(null, null, null);
        tail = new Node(head, null, null);
        head.next = tail;
    }

    /** Returns the size of the list.*/
    public int size() {
        return size;
    }

    /** Adds X to the front of the list.*/
    public void addFirst(key x) {
        head.next = new Node(head, head.next, x);
        head.next.next.prev = head.next;
        size++;
    }

    /** Adds X to the back of the list.*/
    public void addLast(key x) {
        tail.prev = new Node(tail.prev, tail, x);
        tail.prev.prev.next = tail.prev;
        size++;
    }

    /** Adds all elements of vals to the end of the list*/
    public void addMany(key[] vals) {
        for (key x: vals) {
            this.addLast(x);
        }
    }

    /** Removes the first item in the list.*/
    public void removeFirst() {
        head.next = head.next.next;
        head.next.prev = head;
        size--;
    }

    /** Removes the last element in the list.*/
    public void removeLast() {
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
    }

    public boolean isEmpty() {
        return (tail.prev.prev == null) && (head.next.next == null);
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
            return getRecursiveFromTail(tail.prev, size()-i-1);
        }
        return getRecursiveFromHead(head.next, i);
    }

    private key getFromTail(int i) {
        Node p = this.tail.prev;
        while (i != 0) {
            p = p.prev;
            i--;
        }
        return p.item;
    }

    private key getFromHead(int i) {
        Node p = this.head.next;
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
}
