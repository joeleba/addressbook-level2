package seedu.addressbook.data.person;

public class AddressComponent {

    protected String value;

    public AddressComponent(String value) {
        this.value = value;
    }

    /**
     * Getter
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Setter
     */
    public void setValue(String newDetails) {
        this.value = newDetails;
    }

    @Override
    public String toString() {
        return value;
    }
}