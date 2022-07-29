package UnitTesting_Exersice.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.security.PublicKey;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {1, 15, 19, 18, 21, 55, 67};

    @Before
    public void setUp() throws OperationNotSupportedException {
        Integer[] numbers = NUMBERS;
        database = new Database(numbers);
    }

    @Test
    public void test_CreationDB() {
        Integer[] dbElements = database.getElements();
        assertEquals(NUMBERS.length, dbElements.length);

        assertArrayEquals(dbElements, NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Construction_With_LessThan_1Argument() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Construction_With_MoreThan_16Argument() throws OperationNotSupportedException {
        Integer[] integers = new Integer[17];
        new Database(integers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_WithNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_Add_WithArguments() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(12);
        Integer[] dbElements = database.getElements();
        int lastElement = dbElements[dbElements.length - 1];

        assertEquals(initialSize + 1, dbElements.length);
        assertEquals(12,lastElement);
    }

    @Test
    public void test_Remove_Arguments() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.remove();
        Integer[] dbElements = database.getElements();
        int deletedElement = dbElements[dbElements.length - 1];

        int expectedElementToDelete = NUMBERS[NUMBERS.length-2];
        assertEquals(initialSize - 1, dbElements.length);
        assertEquals(expectedElementToDelete,deletedElement);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void test_Should_Throw_ForEmpty_DB() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

}