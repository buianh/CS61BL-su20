import static org.junit.Assert.*;

public class MeasurementTest {
    @org.junit.Test
    public void test1() {
        // TODO: stub for first test
        Measurement c = new Measurement();
        assertTrue(c.getFeet() == 0);
    }

    // TODO: Add additional JUnit tests for Measurement.java here.
    @org.junit.Test
    public void test2() {
        Measurement c = new Measurement(5,2);
        assertTrue(c.getFeet() == 5);
        assertTrue(c.getInches() == 2);
    }

    @org.junit.Test
    public void test3() {
        Measurement c = new Measurement(5,2);
        Measurement d = new Measurement(5,1);
        c.plus(d);
        assertTrue(c.getFeet()==10);
        assertTrue(c.getInches()==3);

    }

    @org.junit.Test
    public void test4() {
        Measurement c = new Measurement(5,2);
        Measurement d = new Measurement(5,1);
        c.minus(d);
        assertTrue(c.getFeet()==0);
        assertTrue(c.getInches()==1);

    }

    @org.junit.Test
    public void test5() {
        Measurement c = new Measurement(5,2);
        Measurement d = new Measurement(5,11);
        c.plus(d);
        assertTrue(c.getFeet()==11);
        assertTrue(c.getInches()==1);

    }

    @org.junit.Test
    public void test6() {
        Measurement c = new Measurement(5,2);
        Measurement d = new Measurement(3,3);
        c.minus(d);
        assertTrue(c.getFeet()==1);
        assertTrue(c.getInches()==11);

    }

    @org.junit.Test
    public void test7() {
        Measurement c = new Measurement(0,8);
        c.multiple(3);
        assertTrue(c.getFeet()==2);
        assertTrue(c.getInches()==0);

    }

    @org.junit.Test
    public void test8() {
        Measurement c = new Measurement(0,8);
        assertEquals(c.toString(),"0'8''");

    }

}