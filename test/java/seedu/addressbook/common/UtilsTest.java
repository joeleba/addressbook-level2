package seedu.addressbook.common;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

public class UtilsTest {
    /**
     * Test empty args
     */
    @Test
    public void isAnyNull_falseOnEmptyInput() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test
    public void elementsAreUnique_trueOnEmptyCollection() {
        Collection<String> items = new ArrayList<String>();
        
        assertTrue(Utils.elementsAreUnique(items));
    }
    
    /**
     * Test multiple args
     */
    @Test
    public void isAnyNull_noNullInput() {
       Object first_obj = new String("First");
       Object second_obj = new String("Second");
       assertFalse(Utils.isAnyNull(first_obj, second_obj));
    }
    
    @Test
    public void isAnyNull_inputContainsNull() {
        Object first_obj = new String("First");
        Object second_obj = new String("Second");
        Object null_obj = null;
        assertTrue(Utils.isAnyNull(first_obj, second_obj, null_obj));
    }
    
    @Test
    public void elementsAreUnique_noRepetition() {
        Collection<String> items = new ArrayList<String>();
        items.add("No");
        items.add("Repetition");
        
        assertTrue(Utils.elementsAreUnique(items));
    }
    
    @Test
    public void elementsAreUnique_inputContainsRepetition() {
        Collection<String> items = new ArrayList<String>();
        items.add("Repetition");
        items.add("Repetition");
        
        assertFalse(Utils.elementsAreUnique(items));
    }
    
}
