package Interfaces;

import Exceptions.NoSuchElementException;

/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
public interface UnorderedListADT<T> extends ListADT<T> {
    //  Adds the specified element to the front of this list
    public void addToFront (T element);

    //  Adds the specified element to the rear of this list
    public void addToRear (T element);

    //  Adds the specified element after the specified target
    public void addAfter (T element, T target) throws NoSuchElementException;

}
