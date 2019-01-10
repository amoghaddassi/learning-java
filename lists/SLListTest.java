import org.junit.Test;

import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void size() {
        SLList L  = SLList.of(new int[]{1,2,3,4,5});
        assertEquals(5, L.size());

        SLList L2 = new SLList();
        assertEquals(0, L2.size());
        L2.addLast(10);
        assertEquals(1, L2.size());
    }

    @Test
    public void getItem() {
        SLList L = SLList.range(10);
        assertEquals(1, L.getItem(1));
    }

    @Test
    public void range() {
        SLList A = SLList.range(5);
        SLList B = SLList.of(new int[]{0, 1, 2, 3, 4});
        assert(A.equals(B));

    }

    @Test
    public void slice() {
        SLList A = SLList.range(10);
        SLList B = SLList.range(4);
        assert(B.equals(A.slice(0, 4)));
    }
}