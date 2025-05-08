package AB5;

import AB5.Interfaces.*;
import AB5.Provided.DinosaurListNode;

/**
 * A concrete implementation of the {@code BucketList} interface that uses a linked list
 * to store and manage {@code Dinosaur} objects. Each dinosaur is uniquely identified by its DNA.
 *
 * <p></p>This class allows adding, updating, removing, and querying dinosaurs within a dynamically
 * maintained list structure, using the {@code DinosaurDNA} as the identifier. Operations are
 * supported for checking the list's state (e.g., size, emptiness) and clearing all elements.</p>
 */
public class DinosaurBucketList implements BucketList {
    private AbstractListNode head;

    // TODO: variable declarations (optional)
    private int size;
    private AbstractListNode current;

    /**
     * Constructor for the DinosaurBucketList class.
     * Initializes an empty bucket.
     */
    public DinosaurBucketList(){
        // TODO: implementation
        head = new DinosaurListNode(null);
        size = 0;
    }

    /**
     * Stores a dinosaur in the list. If the list is empty, a new node is created with the given dinosaur.
     * If a dinosaur with the same DNA is already in the list, its value is updated, and the old value is returned.
     * If no match is found, the dinosaur is added to the end of the list.
     *
     * @param dinosaur the {@code Dinosaur} object to be stored or updated in the list. This must not be {@code null}.
     * @return the previous {@code Dinosaur} object with the same DNA if one existed, or {@code null} if the
     *         operation resulted in a new insertion.
     */
    @Override
    public Dinosaur store(Dinosaur dinosaur){
        // TODO: implementation
        AbstractListNode previous = null;
        current = head;
        while (current != null) {
            if (current.value() != null && current.value().getDNA() == dinosaur.getDNA()) {
                Dinosaur oldDino = current.value();
                current.setValue(dinosaur);
                return oldDino;
            }
            previous = current;
            current = current.next();
        }
        current = new DinosaurListNode(dinosaur);
        if (size == 0) head = current;
        else if (previous != null) previous.setNext(current);
        size++;
        return null;
    }

    /**
     * Removes a dinosaur from the bucket.
     * The dinosaur is identified by its DNA.
     *
     * @param dna the {@code DinosaurDNA} of the dinosaur to be removed. This must not be {@code null}.
     * @return the {@code Dinosaur} associated with the specified DNA if found and removed,
     *         or {@code null} if no dinosaur with the specified DNA exists in the bucket.
     */
    @Override
    public Dinosaur remove(DinosaurDNA dna){
        // TODO: implementation
        AbstractListNode previous = null;
        current = head;
        while (current != null) {
            if (current.value() != null && current.value().getDNA().equals(dna)) {
                Dinosaur oldDino = current.value();
                size--;
                if (previous != null) previous.setNext(current.next());
                else if (size == 0) head = null;
                else head = current.next();
                current = null;
                return oldDino;
            }
            previous = current;
            current = current.next();
        }
        return null;
    }

    /**
     * Finds and retrieves a {@code Dinosaur} associated with the given DNA from the bucket.
     * If no dinosaur with the specified DNA exists in the bucket, {@code null} is returned.
     *
     * @param dna the {@code DinosaurDNA} of the dinosaur to be retrieved. This must not be {@code null}.
     * @return the {@code Dinosaur} object associated with the specified DNA if found,
     *         or {@code null} if no match is found.
     */
    @Override
    public Dinosaur find(DinosaurDNA dna){
        // TODO: implementation
        current = head;
        while (current != null) {
            if (current.value() != null && current.value().getDNA().equals(dna)) {
                return current.value();
            }
            current = current.next();
        }
        return null;
    }

    /**
     * Checks if the bucket is empty.
     *
     * @return {@code true} if the bucket contains no elements, otherwise {@code false}.
     */
    @Override
    public boolean isEmpty(){
        // TODO: implementation

        return size == 0;
    }

    /**
     * Retrieves the number of elements currently stored in the bucket.
     *
     * @return the total count of elements in the bucket as an integer. If the bucket is empty, returns 0.
     */
    @Override
    public int size() {
        // TODO: implementation

        return size;
    }

    /**
     * Removes all elements stored within the bucket, effectively clearing its contents.
     * After this method is called, the bucket will be empty.
     */
    @Override
    public void clear(){
        // TODO: implementation
        head = null;
        size = 0;
    }

    /**
     * Returns a {@code ListIterator} for traversing the elements of the bucket.
     * The iterator provides sequential access to the elements in the bucket
     * starting from the head of the list.
     *
     * @return a {@code DinosaurListIterator} instance starting from the head of the bucket's list.
     */
    @Override
    public DinosaurListIterator iterator() {
        // TODO: implementation

        return new DinosaurListIterator(head);
    }
}
