package Interfaces;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import Exceptions.ConcurrentModificationException;
import Exceptions.EmptyCollectionException;
import Exceptions.NoSuchElementException;

public interface IteratorADT<T> {
    T next() throws ConcurrentModificationException, NoSuchElementException;

    boolean hasNext();

    void remove() throws ConcurrentModificationException, NoSuchElementException, UnsupportedOperationException, EmptyCollectionException;
}
