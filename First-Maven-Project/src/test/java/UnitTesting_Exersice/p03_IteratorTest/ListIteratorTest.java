package UnitTesting_Exersice.p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private String[] NAMES = {"Deqn", "Iva", "Denis", "Ivo"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateListIterator_WithNull_Throw () throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void test_HasNext (){
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }
    @Test
    public void test_Move (){
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void test_Print_Empty_Throw() throws OperationNotSupportedException {
       ListIterator list =  new ListIterator();
       list.print();
    }
    @Test
    public void test_Print() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(NAMES[index],listIterator.print());
            index++;
            listIterator.move();
        }

    }

}