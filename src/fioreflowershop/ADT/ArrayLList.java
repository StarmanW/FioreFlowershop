/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.ADT;

/**
 *
 * @author ChongJH
 * @param <T>
 */
public class ArrayLList<T> implements ListInterface<T>{

    // reference(pointer) to first node
    private Node firstNode; 
    // number of entries in list
    private int totalEntries = 0;

    public ArrayLList() {
        this.firstNode = null;
    }

    public ArrayLList(Node firstNode) {
        this.firstNode = firstNode;
        totalEntries++;
    }
    
    @Override
    public boolean add(T item) {
        Node newNode = new Node(item);
        
        if (isEmpty())
            firstNode = newNode;
        // add to end of nonempty list
        else {                                      
            Node currentNode = firstNode;         
            
            // traverse linked list with p pointing to the current node
            // while have not reached the last node
            while (currentNode.next != null)        
                currentNode = currentNode.next;
            
            // make last node(currentNode.next that contains a null value in next node variable) reference new node
            currentNode.next = newNode;             
        }

        totalEntries++;
        
        return true;
    }

    @Override
    public boolean remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean replace(int index, T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        Node currentNode = firstNode;

        if (index > this.totalEntries)
            return null;

        for (int i = 0; i < index; i++) 
            currentNode = currentNode.next;
        
        return currentNode.data;
    }

    @Override
    public int contains(T item) {
        Node currentNode = firstNode;
        
        for (int i = 0; i < totalEntries; i++) {
            if (item.equals(currentNode.data))
                return i;
            
            currentNode = currentNode.next;
        }
        
        return -1;
    }

    @Override
    public boolean checkType(T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return totalEntries;
    }

    @Override
    public boolean isEmpty() {
        return (this.firstNode == null);
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //node inner class
    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
