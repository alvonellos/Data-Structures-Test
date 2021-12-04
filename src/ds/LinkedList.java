package ds;

import java.util.Iterator;

/**
 * A simple homebrew linked list class as a coding exercise. 
 * @author alex
 *
 * @param <T> Generic Paramter Type
 * 
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T>{
	
	protected final static boolean DEBUG = true;      // Enables / disables debug messages. 
	protected Node<T> head; // Head node. 
	protected int     size =0; //Start is 0 in it, but otherwise it's 1
	
	/**
	 * A simple iterator implementation for this class
	 * @author alex
	 *
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	protected class LLIterator<T extends Comparable<T>> implements Iterator<T> {
		private Node<?> cursor;
		
		/**
		 * Ctor. You should be supplying "this" as the parameter
		 * @param obj
		 */
		public LLIterator(LinkedList<?> obj) {
		        this.cursor = obj.head;   
		}
		
		/**
		 * Returns whether or not there is a next node. 
		 * @return
		 */
		@Override
		public boolean hasNext() {
			if(cursor != null) { 
				return true;
			}
			
			return false;
		}

		/**
		 * Fetches the next data from the next node, then updates the cursor
		 * @return the data from the next node. 
		 */
		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if(cursor != null) { 
				T datum = (T) cursor.getDatum();
				cursor=cursor.getNext();
				return datum;
			}
			return null;
		}
	}
	
	/**
	 * CTOR Implementation of the linked list.
	 */
    public LinkedList() { 
    	this.head = new Node<T>(); 
    	this.head.setPrev(null);
    	this.head.setNext(null);
    	this.head.setHead(true);
    }
    
    // List Interface Methods
    
    /**
     * Fetches the size. Keep in mind this starts at 1 by default empty since the head occupies space. 
     * @return
     */
	public int size() {
		return this.size;
	}

	/**
	 * Boolean to test whether or not this is empty. 
	 * @return
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Adds an object to the list
	 * @param e the data to add
	 */
	public void add(T e) {
		if(this.size() < 1) { 
			this.head.setDatum(e);
			debug("hit base case");
			size += 1;
		} else {
			debug("hit size > 1");
			Node<T> nn = new Node<T>();
			nn.setDatum(e);
			nn.setNext(null);
			nn.setHead(false);;
			
			//Seek to end;
			Node<T> cur; 
			for(cur = head; cur.getNext() != null; cur=cur.getNext()) {	}
			
			cur.setNext(nn);
			nn.setPrev(cur);
			size += 1;
		}
	
	}

	/**
	 * Remove an object from the list, by searching for the data first. 
	 * @param o the data to remove
	 * @return true if the object was removed. False if it was not. 
	 */
	public void remove(T key) { 
		Node<T> temp = head, prev = null;
		 
		if(size <= 1) { this.clear(); }
		
        // If head node itself holds the key to be deleted
        if (temp != null && temp.getDatum().equals(key)) {
            head = temp.getNext(); // Changed head
            size -= 1;
            return;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.getNext()
        while (temp != null && temp.getDatum() != key) {
            prev = temp;
            temp = temp.getNext();
        }
 
        // If key was not present in linked list
        if (temp == null)
            return;
 
        // Unlink the node from linked list
        prev.setNext(temp.getNext());
        size -= 1;
	}
	
	
	/**
	 * Clears the linked list
	 */
	public void clear() {
		size = 0;
    	this.head = new Node<T>(); 
    	this.head.setPrev(null);
    	this.head.setNext(null);
    	this.head.setHead(true);
	}

	/**
	 * Fetches the node at an index. 
	 * @param index The index to search for
	 * @return the node or null. 
	 * @throws Exception if the index is greater than the size, or if the index is less than 1. 
	 */
	public Node<T> get(int index) {
		Node<T> cur; 
		int i = 1;
		for(cur = head, i = 1; cur != null; cur=cur.getNext(), i++) {
			if(i == index) { return cur; } 
		}
		return null;
	}

	

	/**
	 * Gets the index of a particular datum. 
	 * @param o the data to search for. 
	 * @return -1 if not found
	 */
	public int indexOf(Object o) {
		Node<T> cur; 
		int i = 1;
		for(cur = head, i = 1; cur != null; cur=cur.getNext(), i++) {
			if(cur.getDatum().equals(o)) { return i; } 
		}
		return -1;
	}
	
	public Node<T> nodeIndexOf(T o) {
		Node<T> cur; 
		int i = 1;
		for(cur = head, i = 1; cur != null; cur=cur.getNext(), i++) {
			if(cur.getDatum().equals(o)) { return cur; } 
		}
		return null;
	}

    
	/**
	 * Get an iterator for this object
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new LLIterator<>(this);
		return it;
	}

	
	/**
	 * Utility function to get the address of a string. 
	 * @param o
	 * @return
	 */
    protected String addrString(Object o) {
	    return o == null ? "null" : o.getClass().getName() + "@" + 
	           Integer.toHexString(System.identityHashCode(o));
    }

    /**
     * Debug function
     * @param message
     */
	protected static void debug(String message) { 
		if(DEBUG) { 
			System.err.println("Message: " + message); 
		}	
	} 
	
	
	/**
	 * Traverse the linked list and spit the contents to debug. 
	 */
    private void Traversal() { 
    	debug("Traversal");
    	Node<T> cur = head; 
		while(cur != null) { 
			debug(cur.toString());
			cur = cur.getNext();
		}
    }
    
    // Driver program
    public static void main(String... args) throws Exception {
		LinkedList<String> myLL = new LinkedList<String>();
	
		debug("Adding elements to the list");
		debug("Size at start is: " + myLL.size());
		
		myLL.Traversal();
		myLL.add("1"); 
		myLL.add("2");
		myLL.add("3");
		myLL.add("4");
		myLL.add("5");
		myLL.add("6");
		myLL.add("7");
		myLL.add("8");
		myLL.add("9");
		myLL.add("10");
		myLL.Traversal();
		
		debug("finished adding elements to the list");
		debug("Size at end is " + myLL.size());

		
		debug("Traversing list");
		myLL.Traversal();

		debug(""); 
//		
        debug("(Testing get()");
		System.out.println("get(0): " + myLL.get(0));
		System.out.println("get(1): " + myLL.get(1));
		System.out.println("get(3): " + myLL.get(3));
		System.out.println("get(9): " + myLL.get(9));
		System.out.println("get(10): " + myLL.get(10));

		debug("Testing IndexOf");
		System.out.println("get(0): " + myLL.indexOf("0"));
		System.out.println("get(1): " + myLL.indexOf("1"));
		System.out.println("get(3): " + myLL.indexOf("3"));
		System.out.println("get(9): " + myLL.indexOf("9"));
		System.out.println("get(10): " + myLL.indexOf("10"));
		
		
	debug("Testing Iterator");
		
		for(String s : myLL) { 
			debug("Item: " + s);
		}

		debug("testing remove, current size is: " + myLL.size() + "current node is ");
		myLL.Traversal();

		myLL.remove("10"); debug("Removed 10, so size is: " + myLL.size());
		myLL.remove("9");  debug("Removed 9, so size is: " + myLL.size());
		myLL.remove("1");  debug("Removed 1, so size is: " + myLL.size()); // fix whatever the fuck is going on here. 
		//myLL.remove("3");  debug("Removed 1, so size is: " + myLL.size());	
		myLL.Traversal();

	
		debug("clearing LL");
		myLL.clear();
		debug("after clearing size: " + myLL.size());
		myLL.Traversal();
		
		debug("create one and then remove just one");
		myLL.add("1000");
		myLL.Traversal();
		myLL.remove("1000");
		debug("myLL: " + myLL.head);
		
		
		
    }
}
