/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
/**
 * @author 8210311 Daniela Moreira
 * @author 8210367 Orlando Pires
 */
import Exceptions.EmptyCollectionException;
public interface HeapADT<T> extends BinaryTreeADT<T> {
   /** 
    * Adds the specified object to this heap. 
    *
    * @param obj  the element to added to this head
    */
   void addElement (T obj);

   /** 
    * Removes element with the lowest value from this heap. 
    *
    * @return  the element with the lowest value from this heap
    */
   T removeMin() throws EmptyCollectionException;

   /** 
    * Returns a reference to the element with the lowest value in 
    * this heap. 
    *
    * @return  a reference to the element with the lowest value 
    * in this heap
    */
   T findMin();
}
