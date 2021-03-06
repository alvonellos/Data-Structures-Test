package ds;

/**
 * Fully generic node class for utilization in other data structures that need a node
 * @author Alex Alvonellos
 *
 * @param <T> Type
 * @implNote Implements comparable through and through
 */
public class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> { 
	 private static boolean DEBUG = true;
	 private Node<T> next;
	 private Node<T> prev; 
	 
	 private T datum;
	 private boolean isHead = false;
	
	 /**
	  * Generic constructor for just one node with a datum;
	  * @param datum
	  */
	 public Node(T datum) { 
		 this.setDatum(datum);
		 debug("ctor: Node(T datum) " + this.toString());
	 }
	 
	 /**
	  * Special constructor for one node with a boolean variable denoting whether this node is a head or not. 
	  * @param isHead Is this the head? 
	  * @param datum The data to store. 
	  */
	 public Node(boolean isHead, T datum) { 
		 this.setDatum(datum);
		 this.setHead(isHead);
		 debug("ctor: Node(boolean isHead, T datum) " + this.toString());
	 }
	
	 /**
	  * This constructor sets just a blank node with default values. 
	  */
	public Node() {
		this.isHead = false;
		this.datum = null;
		debug("ctor: Node() " + this.toString());
	}
	 
	/**
	 * gets the next node
	 * @return the next node
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * Sets the next node
	 * @param next the next node
	 */
	public void setNext(Node<T> next) {
		this.next = (next != null) ? next : null;
	}
	
	/**
	 * gets the previous node
	 * @return The previous node
	 */
	public Node<T> getPrev() { 
		return this.prev;
	}
	
	/**
	 * Sets the previous node
	 * @param the node previous to this one  
	 */
	public void setPrev(Node<T> prev) { 
		this.prev = (prev != null) ? prev : null;;	
	}
	
	/**
	 * sets whether or not this is the head. 
	 * @param value true if it is the head, false if it is not. 
	 */
	public void setHead(boolean value ) { 
		this.isHead = value;
	}
	
	/**
	 * Returns whether or not this node has been specified as the head. 
	 * @return a boolean, true if it is the head, and false if it is not
	 */
	public boolean getHead() { 
		return this.isHead;
	}
	
	/**
	 * Sets the datum stored in this object
	 * @param datum the datum. 
	 */
	public void setDatum(T datum) {
		this.datum = datum;
	}
	
	/**
	 * Gets the datum stored in this object
	 * @return the datum
	 */
	public T getDatum() { 
		return this.datum;
	}
	
	
	// String representation of this object. 
	public String toString() { 
		String s = "";
		s += " This-> " + addrString(this);
		s += " Prev-> " + addrString(prev);
		s += " Next-> " + addrString(next); 
		String datums = (this.datum != null) ? this.datum.toString() : "null";
		s += " Datum->" + datums;
		s += " isHead->" + this.isHead;
		return s;
		
	}
	

	@Override
	public int compareTo(Node<T> o) {
		return this.getDatum().compareTo(o.getDatum());
	}
	
	public boolean equals(Node<T> o) { 
		return this.compareTo(o) == 0;
	}
	
	// Privates
	
	private String addrString(Object o) {
		return o == null ? "null" : o.getClass().getName() + "@" + 
				Integer.toHexString(System.identityHashCode(o));
	}
	
	private void debug(String message) { 
		if(DEBUG) { 
			System.err.println("Message: " + message); 
		}	
	} 

} // End Class
