package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Abstract Superclass of the contact classes (Phone, Email, Address).
 * Guarantees: immutable;
 */
public abstract class Contact {
    public final String value;
    protected boolean isPrivate;

    /**
     * Constructor
     *
     */
    public Contact(String value, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
