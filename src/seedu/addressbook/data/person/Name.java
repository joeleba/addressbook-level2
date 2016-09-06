package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if:
     * - They consist of the same letters in the same order, case-insensitive
     * - They share the same initials
     * @param other
     */
    public boolean isSimilar(Name other) {
        if (other == null) {
            return false;
        }
        return isSameInitials(other) || isSimilarCaseInsensitive(other);
    }
    
    /**
     * Compare current name with other name, case-insensitive
     * @param other
     */
    private boolean isSimilarCaseInsensitive(Name other) {
        return this.fullName.equalsIgnoreCase(other.fullName);
    }
    
    /**
     * Return true if the current name and other name share the same initials
     * @param other
     */
    private boolean isSameInitials(Name other) {
        char[] ownNameInitials = getInitials(this.fullName);
        char[] otherNameInitials = getInitials(other.fullName);
        
        return Arrays.equals(ownNameInitials, otherNameInitials);
    }
    
    /**
     * Return the initials of the input name (in uppercase)
     * @param nameString
     * @return
     */
    private char[] getInitials(String nameString) {
        String[] splitted = nameString.split(" ");
        char[] result = new char[splitted.length];
        
        for (int i = 0; i < splitted.length; i++) {
            char firstChar = splitted[i].toCharArray()[0];
            result[i] = firstChar;
        }
        return result;
    }

}
