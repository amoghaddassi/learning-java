import org.junit.Test;

import static org.junit.Assert.*;

public class DLListTest {

    @Test
    public void size() {
        DLList<String> L = new DLList<>();
        L.addMany(new String[]{"Hello", "World"});
        assertEquals(2, L.size());
    }

    @Test
    public void getItem() {
        DLList<Integer> L = new DLList<>();
        L.addMany(new Integer[]{1,2,3,1,3,234,1,3,2});
        assert(3 == L.get(2));
        assert(1 == L.get(6));
    }

    @Test
    public void addFirst() {
        DLList<Integer> L = new DLList<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        assert(3 == L.get(0));
    }

    @Test
    public void addLast() {
        DLList<Integer> L = new DLList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        assert(1 == L.get(0));
    }

    @Test
    public void removeFirst() {
        DLList<Integer> L = new DLList<>();
        L.addMany(new Integer[]{1,2,3,1,3,234,1,3,2});
        L.removeFirst();
        assert(2 == L.get(0));
    }

    @Test
    public void removeLast() {
        DLList<Integer> L = new DLList<>();
        L.addMany(new Integer[]{1,2,3,1,3,234,1,3,2});
        L.removeLast();
        assert(3 == L.get(L.size() - 1));
    }

    @Test
    public void isEmpty() {
        DLList<Integer> L = new DLList<>();
        assert(L.isEmpty());
    }
}