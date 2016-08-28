package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final int ADDRESS_COMPONENTS = 4;
    public static final String DELIMITER = ", ";

    private boolean isPrivate;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] parsedAddress = parseAddress(address);
        
        this.block = new Block(parsedAddress[0]);
        this.street = new Street(parsedAddress[1]);
        this.unit = new Unit(parsedAddress[2]);
        this.postalCode = new PostalCode(parsedAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    public static String[] parseAddress(String address) {
        return address.split(DELIMITER, ADDRESS_COMPONENTS);
    }

    @Override
    public String toString() {
        String[] components = new String[ADDRESS_COMPONENTS];
        
        components[0] = this.block.toString();
        components[1] = this.street.toString();
        components[2] = this.unit.toString();
        components[3] = this.postalCode.toString();
        
        return String.join(DELIMITER, components);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}