package prj5;

public interface LList<T> {
    
    /**
     * returns the size of the linked list
     * @return size
     */
    public int getSize();
    
    /**
     * adds to the linked list
     * @param thing to be added
     * @return if added or not
     */
    public boolean add(T thing);
    
    /**
     * adds to the linked list at an index
     * @param index where it be added
     * @param thing to be added
     * @return if added or not
     */
    public void add(int index, T thing);
    
    /**
     * checks if the list is empty
     * @return if empty yes or no
     */
    public boolean isEmpty();
    
    /**
     * removes the last instance of a specific thing
     * @param thing to be removed
     * @return if removed or not
     */
    public void remove(T thing);
    
    /**
     * index to have thing removed at
     * @param index where thing to be removed
     * @return if removed or not
     */
    public void remove(int index);
    
    /**
     * returns item at that index
     * @param index where to get the thing
     * @return the thing at the index
     */
    public T get(int index);
    
    /**
     * clears the linked list
     */
    public void clear();
    
    /**
     * returns the last index of the thing
     * @param thing to be found
     * @return index of the last thing thing in the linked list
     */
    public int getLastIndexOf(T thing);
}
