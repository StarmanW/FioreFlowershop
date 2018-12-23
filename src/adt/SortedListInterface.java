package adt;

/**
 * @author Cheng Foong Kian
 * @param <T> 
 */
public interface SortedListInterface<T extends Comparable<? super T>> {

    public boolean add(T newEntry);

    public T getEntry(int givenPosition);

    public boolean contains(T anEntry);

    public T changeStatus(int orderNum);

    public void clear();

    public int getLength();

    public boolean isEmpty();

    public boolean isFull();
}
