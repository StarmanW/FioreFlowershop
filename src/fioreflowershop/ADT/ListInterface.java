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
public interface ListInterface<T extends Comparable<? super T>> {
    //add an item to linked list
    public boolean add(T item);
    
    //remove an item of given idex from linked list
    public boolean remove(int index);
    
    //returns the item of given index
    public T get(int index);
    
    //checks if the given item is in the linked list. Returns it's index if it's
    //in the linked list
    public int contains(T item);
    
    //returns the current size of the linked list
    public int size();
    
    //checks if the linked list is empty
    public boolean isEmpty();
}
