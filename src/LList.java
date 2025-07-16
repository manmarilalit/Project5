package prj5;

/**
 * This class provides a definition for all of the methods used in the 
 * SingularLinkedList implementation
 *
 * @author snvad, lalitmanmari, Kexin Zhang, Vaibhav Lokesh
 * @param <E>
 *            class that is stored by list
 * @version 14/11/2024
 */
public interface LList<E>
{
    /**
     * Adds the object to the designated position in the list
     *
     * @param index
     *            position the object is added
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(int index, E obj);
    
    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(E obj);

    
    /**
     * Removes the first instance of the given object from the list
     * first in first out structure
     *
     * @param obj
     *            the object to remove
     * @return true if successful, false otherwise
     */
    public abstract boolean remove(E obj);

    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public abstract boolean remove(int index);

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public abstract int size();

    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty and false otherwise
     */
    public abstract boolean isEmpty();


    /**
     * Gets the object at the designated position
     *
     * @param index
     *            the object being checked
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there is not a node at the given index
     */
    public abstract E get(int index);

    /**
     * Checks if the list contains the target object
     *
     * @param obj
     *            the target object
     * @return true if it contains the object, false otherwise
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public abstract boolean contains(E obj);

    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     *                  resulting in an empty list
     */
    public abstract void clear();

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public abstract int lastIndexOf(E obj);

    /**
     * Returns a string representation of the list 
     * For example, if a list contains 1, 2, and
     * 3, toString method should return "{1, 2, 3}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public abstract String toString();
}
