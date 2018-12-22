package adt;

/**
 * @author StarmanW
 */
public interface QueueInterface<T> {
    public void enqueue(T newEntry);
    public T dequeue();
    public T frontQueue();
    public int size();
    public boolean isEmpty();
    public boolean isQueueFull();
    public void expandPickUpQueue();
    public String toString();    
}
