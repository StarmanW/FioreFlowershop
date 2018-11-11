package fioreflowershop.ADT;

/**
 * @author StarmanW
 */
public interface PickUpQueueInterface {
    public void enqueue();
    public void dequeue();
    public void frontQueue();
    public void lastQueue();
    public void size();
    public void isEmpty();
    public String toString();    
}
