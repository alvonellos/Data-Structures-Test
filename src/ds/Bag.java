package ds;

import java.util.*;

/**
*  The {@code Bag} class represents a bag (or multiset) of 
*  generic items. It supports insertion and iterating over the 
*  items in arbitrary order.
*  <p>
*  This implementation uses a singly linked list with a static nested class Node.
*  
*  The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations
*  take constant time. Iteration takes time proportional to the number of items.
*  <p>
*
*  @author Alexander Alvonellos
*
*  @param <Item> the generic type of an item in this bag
*/
public class Bag<T extends Comparable<T>> implements Iterable<T> {
   private Node<T> first;    // beginning of bag
   private int n;               // number of elements in bag
   /**
    * Initializes an empty bag.
    */
   public Bag() {
       first = null;
       n = 0;
   }

   /**
    * Returns true if this bag is empty.
    *
    * @return {@code true} if this bag is empty;
    *         {@code false} otherwise
    */
   public boolean isEmpty() {
       return first == null;
   }

   /**
    * Returns the number of items in this bag.
    *
    * @return the number of items in this bag
    */
   public int size() {
       return n;
   }

   /**
    * Adds the item to this bag.
    *
    * @param  item the item to add to this bag
    */
   public void add(T datum) {
       Node<T> oldfirst = first;
       first = new Node<T>();
       first.setDatum(datum);
       first.setNext(oldfirst);;
       n++;
   }


   /**
    * Returns an iterator that iterates over the items in this bag in arbitrary order.
    *
    * @return an iterator that iterates over the items in this bag in arbitrary order
    */
   public Iterator<T> iterator()  {
       return new LinkedIterator(first);  
   }

   // an iterator, doesn't implement remove() since it's optional
   private class LinkedIterator implements Iterator<T> {
       private Node<T> current;

       public LinkedIterator(Node<T> first) {
           current = first;
       }

       public boolean hasNext()  { return current != null;                     }
       public void remove()      { throw new UnsupportedOperationException();  }

       public T next() {
           if (!hasNext()) throw new NoSuchElementException();
           T item = current.getDatum();
           current = current.getNext(); 
           return item;
       }
   }

   /**
    * Unit tests the {@code Bag} data type.
    *
    * @param args the command-line arguments
    */
   public static void main(String[] args) {
       Bag<String> bag = new Bag<String>();
       bag.add("1");
       bag.add("2");
       bag.add("3");
       System.out.println("size of bag = " + bag.size());
       for (String s : bag) {
           System.out.println(s);
       }
   }

}