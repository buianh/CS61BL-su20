import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addFirst() {
        ArrayDeque p = new ArrayDeque();
        p.addFirst(8);
        p.addFirst(10);
        assertEquals(8,p.items[0]);
        assertEquals(10,p.items[7]);
    }

    @Test
    public void isEmpty() {
        ArrayDeque p = new ArrayDeque();
        assertTrue(p.isEmpty());
    }

    @Test
    public void removeLast() {
        ArrayDeque p = new ArrayDeque();
        p.addFirst(1);
        p.addLast(2);
        p.addLast(3);
        assertEquals(3,p.items[2]);
        p.removeLast();
        assertNull(p.items[2]);

    }

    @Test
    public void get() {
        ArrayDeque p = new ArrayDeque();
        p.addFirst(1);
        p.addLast(2);
        p.addLast(3);
        assertEquals(3,p.get(2));
    }
}