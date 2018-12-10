
import fioreflowershop.ADT.ListInterface;

/**
 *
 * @author Thiban
 */
public class OrderList<T> implements ListInterface<T> {

    private T[] itemArray;
    private int totalEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public OrderList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public OrderList(int capacity) {
        this.itemArray = (T[]) new Object[capacity];
        this.totalEntries = 0;
    }

    public boolean add(T item) {
        if (isFull()) {
            extendSize();
        }

        itemArray[totalEntries] = item;
        totalEntries++;
        return true;
    }

    public int indexOf(T item) {
        int objectIndex = -1;
        boolean found = false;

        for (int i = 0; !found && (i < totalEntries); i++) {
            if (item.equals(itemArray[i])) {
                found = true;
                objectIndex = i;
            }
        }
        return objectIndex;
    }

   
    public boolean checkType(T item) {
        return item.equals(item);
    }

    public int size() {
        return totalEntries;
    }

    public boolean isEmpty() {
        return size() <= 0;
    }

    public boolean isFull() {
        return size() == itemArray.length;
    }
    
    public void extendSize() {
        // save reference to array of list entries
        T[] oldList = itemArray;
        // save old max size of array
        int oldSize = oldList.length;
        // double size of array
        itemArray = (T[]) new Object[2 * oldSize];
        // copy entries from old array to new, bigger array
        //System.arraycopy(oldList, 0, itemArray, 0, oldSize);
        for (int i = 0; i < oldSize; i++) {
            itemArray[i] = oldList[i];
        }
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(int index, T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contains(T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
