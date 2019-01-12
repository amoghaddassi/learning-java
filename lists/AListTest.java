import org.junit.Test;

import static org.junit.Assert.*;

public class AListTest {

    @Test
    public void get() {
        AList<Integer> L = new AList<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        assert(L.get(3) == null);
        assert(L.get(2) == 1);
    }

    @Test
    public void isEmpty() {
        AList<Integer> L = new AList<>();
        assert(L.isEmpty());
    }

    @Test
    public void size() {
        AList<Integer> L = new AList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.removeLast();
        assert(L.size() == 2);
    }

    @Test
    public void toStringTest() {
        AList<Integer> L = new AList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.removeLast();
        System.out.println(L);
        assertEquals("1 2 3 ", L.toString());
    }

    @Test
    public void removeFirst() {
        AList<Integer> L = new AList<>();
        L.addFirst(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.removeFirst();
        System.out.println(L.get(3));
        assert(L.get(3) == null);
    }

    @Test
    public void increaseSize() {
        AList<Integer> L = new AList<>();
        for (int i =0; i < 10; i++) {
            L.addLast(i);
        }
        assert(L.get(9) == 8);
    }

    @Test
    public void decreaseSize() {
        AList<Integer> L = new AList<>();
        for (int i=0; i<100; i++) {
            L.addLast(i);
        }
        for (int j=0; j<70; j++) {
            L.removeLast();
        }
        System.out.println(L);
    }
}