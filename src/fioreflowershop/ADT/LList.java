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
public class LList<T extends Comparable<? super T>> implements ListInterface<T> {

    // reference(pointer) to first node
    private Node firstNode;
    // reference(pointer) to last node
    private Node lastNode;
    // number of entries in list
    private int totalEntries = 0;

    //empty constructor
    public LList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    //parameterized constructor
    public LList(Node firstNode) {
        this.firstNode = firstNode;
        this.lastNode = firstNode;
        totalEntries++;
    }

    //add an item to linked list
    @Override
    public boolean add(T item) {
        //call "add" method. See below.
        firstNode = add(item, firstNode);

        //if list is currently empty
        if (lastNode == null) {
            lastNode = firstNode;
        } //if list is currently not empty and the current last node has another 
        //node behind it
        else if (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        totalEntries++;

        return true;
    }

    //add and sort new item
    private Node add(T item, Node currentNode) {

        //determine the appropriate position in the list for given item
        if ((currentNode == null) || item.compareTo(currentNode.data) <= 0) {
            currentNode = new Node(item, currentNode);
        } else {
            //initialize new node
            Node nodeAfter = add(item, currentNode.next);
            //add new node to list
            currentNode.next = nodeAfter;
        }

        return currentNode;
    }

    //remove item of given index from linked list
    @Override
    public boolean remove(int index) {

        //if index is in valid range
        if ((index >= 0) && (index <= totalEntries - 1)) {
            if (index == 0) {
                //remove current first node
                firstNode = firstNode.next;
            } else {
                //initialize current node pointer
                Node currentNode = firstNode;

                //move current node pointer to one node before selected node
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }

                //if selected node is last node
                if (index == totalEntries - 1) {
                    //set current node as last node
                    lastNode = currentNode;
                    lastNode.next = null;
                } //if selected node is not last node
                else {
                    //deleted selected node from list and reconnect list
                    currentNode.next = currentNode.next.next;
                }
            }

            totalEntries--;
            return true;
        }
        return false;
    }

    //get item of given index
    @Override
    public T get(int index) {
        Node currentNode = firstNode;
        T data = null;

        //if index is not in valid range
        if (index > this.totalEntries) {
            return null;
        }

        //get selected node
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        data = currentNode.data;

        return data;
    }

    //checks if the given item is in the linked list. Returns it's index if it's
    //in the linked list
    //if item does not exist in linked list, returns -1
    @Override
    public int contains(T item) {
        Node currentNode = firstNode;
        int nodeIndex = -1;
        boolean endLoop = false;
        boolean isEqual = false;

        //loop through list if matching node is not found
        for (int i = 0; i < totalEntries || endLoop == false; i++) {
            isEqual = item.equals(currentNode.data);

            if (isEqual == true) {
                nodeIndex = i;
                endLoop = true;
            } else if (isEqual == false && endLoop == false && currentNode.next != null) {
                currentNode = currentNode.next;
            }
        }

        return nodeIndex;
    }

    //returns current linked list size
    @Override
    public int size() {
        return totalEntries;
    }

    //check if link list is currently empty
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
