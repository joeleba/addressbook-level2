package seedu.addressbook.model;

import seedu.addressbook.common.Utils;

import java.util.*;

/**
 * A list of tags that enforces no nulls and uniqueness between its elements.
 *
 * Supports minimal set of list operations for the app's features.
 *
 * @see Tag#equals(Object)
 * @see Utils#elementsAreUnique(Collection)
 */
public class UniqueTagList implements Iterable<Tag> {

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicateTagException extends DuplicateDataException {
        protected DuplicateTagException() {
            super("Operation would result in duplicate tags");
        }
    }

    /**
     * Signals that an operation targeting a specified Tag in the list would fail because
     * there is no such matching Tag in the list.
     */
    public static class TagNotFoundException extends Exception {}

    private final List<Tag> internalList = new ArrayList<>();

    /**
     * Constructs empty TagList.
     */
    public UniqueTagList() {}

    /**
     * Varargs/array constructor, enforces no nulls or duplicates.
     */
    public UniqueTagList(Tag... tags) throws DuplicateTagException {
        Utils.assertNotNull(tags);
        final List<Tag> initialTags = Arrays.asList(tags);
        if (!Utils.elementsAreUnique(initialTags)) {
            throw new DuplicateTagException();
        }
        internalList.addAll(initialTags);
    }

    /**
     * java collections constructor, enforces no null or duplicate elements.
     */
    public UniqueTagList(Collection<Tag> tags) throws DuplicateTagException {
        Utils.assertNoNullElements(tags);
        if (!Utils.elementsAreUnique(tags)) {
            throw new DuplicateTagException();
        }
        internalList.addAll(tags);
    }

    /**
     * java set constructor, enforces no nulls.
     */
    public UniqueTagList(Set<Tag> tags) {
        Utils.assertNoNullElements(tags);
        internalList.addAll(tags);
    }

    /**
     * Copy constructor, insulates from changes in source.
     */
    public UniqueTagList(UniqueTagList source) {
        internalList.addAll(source.internalList); // insulate internal list from changes in argument
    }

    /**
     * Unmodifiable java List view. For use with other methods/libraries.
     * Any changes to the internal list/elements are immediately visible in the returned list.
     */
    public List<Tag> immutableListView() {
        return Collections.unmodifiableList(internalList);
    }

    /**
     * All tags in this list as a Set. This set is mutable and change-insulated against the internal list.
     */
    public Set<Tag> toSet() {
        return new HashSet<>(internalList);
    }

    /**
     * Checks if the list contains an equivalent Tag as the given argument.
     */
    public boolean contains(Tag toCheck) {
        Utils.assertNotNull(toCheck);
        return internalList.contains(toCheck);
    }

    /**
     * Adds a Tag to the list.
     *
     * @throws DuplicateTagException if the Tag to add is a duplicate of an existing Tag in the list.
     */
    public void add(Tag toAdd) throws DuplicateTagException {
        Utils.assertNotNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateTagException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent Tag from the list.
     *
     * @throws TagNotFoundException if no such Tag could be found in the list.
     */
    public void remove(Tag toRemove) throws TagNotFoundException {
        Utils.assertNotNull(toRemove);
        final boolean TagFoundAndDeleted = internalList.remove(toRemove);
        if (!TagFoundAndDeleted) {
            throw new TagNotFoundException();
        }
    }

    /**
     * Clears all tags in list.
     */
    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Tag> iterator() {
        return internalList.iterator();
    }

}
