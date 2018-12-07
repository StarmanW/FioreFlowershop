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
public class LList<T> implements ListInterface<T> {

    // reference(pointer) to first node
    private Node firstNode;
    // reference(pointer) to last node
    private Node lastNode;
    // number of entries in list
    private int totalEntries = 0;

    public LList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public LList(Node firstNode) {
        this.firstNode = firstNode;
        this.lastNode = firstNode;
        totalEntries++;
    }

    @Override
    public boolean add(T item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } // add to end of nonempty list
        else {
//            Node currentNode = firstNode;         
//            
//            // traverse linked list with p pointing to the current node
//            // while have not reached the last node
//            while (currentNode.next != null)        
//                currentNode = currentNode.next;
//            
//            // make last node(currentNode.next that contains a null value in next node variable) reference new node
//            currentNode.next = newNode;       
            lastNode.next = newNode;
            lastNode = lastNode.next;
        }

        totalEntries++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        if ((index >= 0) && (index <= totalEntries - 1)) {
            if (index == 0) {
                firstNode = firstNode.next;
            } else {
                Node currentNode = firstNode;
                
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }

                if (index == totalEntries - 1) {
                    lastNode = currentNode;
                    lastNode.next = null;
                } else {
                    Node tempRemoveNode = currentNode.next;
                    currentNode.next = currentNode.next.next;
                    tempRemoveNode.next = null;
                }
            }

            totalEntries--;
            return true;
        }
        return false;
    }

    @Override
    public boolean replace(int index, T item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int index) {
        Node currentNode = firstNode;

        if (index > this.totalEntries) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    @Override
    public int contains(T item) {
        Node currentNode = firstNode;

        for (int i = 0; i < totalEntries; i++) {
            if (item.equals(currentNode.data)) {
                return i;
            }

            currentNode = currentNode.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return totalEntries;
    }

    @Override
    public boolean isEmpty() {
        return (this.firstNode == null);
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
