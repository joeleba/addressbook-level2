package seedu.addressbook.data.tag;

import java.util.Objects;

import seedu.addressbook.data.person.Person;

/**
 * Logs the addition/removal of tags during a session 
 * Association class of Person and Tag
 */
public class Tagging {
    public final Person person;
    public final Tag tag;
    public final boolean isAdd;
    
    /**
     * Constructor
     * Create a tagging
     * @param person The tagged person
     * @param tag The targeted tag
     * @param isAdd true is the tag was added, false if the tag was removed from the person
     */
    public Tagging(Person person, Tag tag, boolean isAdd) {
        this.person = person;
        this.tag = tag;
        this.isAdd = isAdd;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Tagging
                && this.isSameStateAs((Tagging) other));
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(person, tag, isAdd);
    }
    
    /**
     * Return the String that represents the Tagging
     */
    @Override
    public String toString() {
        String sign = this.isAdd ? "+" : "-";
        return String.format("%s %s [%s]", sign, this.person.toString(), this.tag.toString());
    }
    
    /**
     * Compare self with another Tagging object
     * @return true if the states are the same, false otherwise
     */
    private boolean isSameStateAs(Tagging other) {
        return this.person == other.person
                && this.tag == other.tag
                && this.isAdd == other.isAdd;
    }
    
}
