/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop.ADT;

/**
 *
 * @author ChongJH
 */
public interface ListInterface<T> {
    public boolean add(T item);
    public boolean remove(int index);
    public boolean replace(int index, T item);
    public T get(int index);
    public int contains(T item);
    public boolean checkType(T item);
    public int size();
    public boolean isEmpty();
    public boolean isFull();
    @Override
    public String toString();
}
