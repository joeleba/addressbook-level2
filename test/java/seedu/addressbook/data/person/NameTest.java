package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    private Name thisName;
    
    @Before
    public void setup() {
        thisName = generateTestName("Jon Snow");
    }
    
    @Test
    public void isSimilar_nullOtherName() {
        Name otherName = null; 
        assertFalse(thisName.isSimilar(otherName));
    }
    
    @Test
    public void isSimilar_differentCases() {
        Name otherName = generateTestName("jon snow"); 
        assertTrue(thisName.isSimilar(otherName));
    }
    
    @Test
    public void isSimilar_totallyDifferent() {
        Name otherName = generateTestName("Tormund"); 
        assertFalse(thisName.isSimilar(otherName));
    }
    
    @Test
    public void isSimilar_sameInitials() {
        Name otherName = generateTestName("Jim Snow");
        assertTrue(thisName.isSimilar(otherName));
    }
 
    @Test
    public void isSimilar_sameInitialsReversed() {
        Name otherName = generateTestName("Snow Jim");
        assertFalse(thisName.isSimilar(otherName));
    }
    
    @Test
    public void isSimilar_sameName() {
        Name otherName = generateTestName("Jon Snow");
        assertTrue(thisName.isSimilar(otherName));
    }

    private static Name generateTestName(String name) {
        try {
            return new Name(name);
        } catch (IllegalValueException ive) {
            throw new RuntimeException("test name should be valid by definition");
        }
    }
}
