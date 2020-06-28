//Edit your CounterTest.java to look like the class definition below.
import static org.junit.Assert.*;

public class CounterTest {

    @org.junit.Test
    public void testConstructor() {
        Counter c = new Counter();
        assertTrue(c.value() == 0);
    }

    @org.junit.Test
    public void testIncrement() throws Exception {
        Counter c = new Counter();
        c.increment();
        assertTrue(c.value()  == 1);
        c.increment();
        assertTrue(c.value() == 2);
    }

    @org.junit.Test
    public void testReset() throws Exception {
        Counter c = new Counter();
        c.increment();
        c.reset();
        assertTrue(c.value() == 0);
    }
}