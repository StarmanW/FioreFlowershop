package fioreflowershop.ADT;

/**
 * @author StarmanW
 */
public class PickUpQueue<T> implements QueueInterface<T> {

    private T[] pickUpQueue;
    private final static int FRONT_INDEX = 0;
    private int totalQueueEntry;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public PickUpQueue() {
        this(PickUpQueue.DEFAULT_INITIAL_CAPACITY);
    }

    public PickUpQueue(int initialCapacity) {
        this.pickUpQueue = (T[]) new Object[initialCapacity];
        this.totalQueueEntry = 0;
    }

    // Method to enqueue pick up order
    @Override
    public void enqueue(T newEntry) {
        // Check if queue is full or not
        if (this.isQueueFull()) {
            this.expandPickUpQueue();
        }

        // Add the new pick up order into the queue
        this.pickUpQueue[totalQueueEntry] = newEntry;
        this.totalQueueEntry++;
    }

    // Element to dequeue pick up order
    @Override
    public T dequeue() {
        // Check if queue is empty
        // Return null if true
        if (this.isEmpty()) {
            return null;
        }

        // Get the front element of the queue
        T frontEntry = this.pickUpQueue[PickUpQueue.FRONT_INDEX];

        // Shift the remaining element in the queue to left
        for (int i = 0; i < this.totalQueueEntry; i++) {
            this.pickUpQueue[i] = this.pickUpQueue[i + 1];
        }

        // Return the front element
        return frontEntry;
    }

    // Method to preview the front queue
    @Override
    public T frontQueue() {
        // Check if queue is empty
        // Return null if true
        if (this.isEmpty()) {
            return null;
        }

        // Return the front element without removing it
        return this.pickUpQueue[PickUpQueue.FRONT_INDEX];
    }

    // Method to get the current
    // entries size of the queue
    @Override
    public int size() {
        return this.totalQueueEntry;
    }

    // Method to check if queue is empty
    @Override
    public boolean isEmpty() {
        // Check if 0 == 0
        return PickUpQueue.FRONT_INDEX == this.totalQueueEntry;
    }

    // Method to check if queue is full
    @Override
    public boolean isQueueFull() {
        return this.totalQueueEntry == this.pickUpQueue.length;
    }

    // Method for expanding the queue
    @Override
    public void expandPickUpQueue() {
        // Get the size for the old queue
        int oldQueueSize = this.pickUpQueue.length;

        // Copy a reference of the old queue
        // into temporarily variable
        T[] oldQueue = this.pickUpQueue;

        // Set the queue reference to the expanded queue 
        this.pickUpQueue = (T[]) new Object[2 * oldQueueSize];

        // For loop to populate entries from
        // the old queue into the new queue.
        for (int i = 0; i < oldQueueSize; i++) {
            this.pickUpQueue[i] = oldQueue[i];
        }
    }

    // String representation of the queue
    @Override
    public String toString() {
        return "Stub";
    }
}
