
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Queue</tt> class represents a first-in-first-out (FIFO)
 *  queue of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the top item,
 *  testing if the queue is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  All queue operations except iteration are constant time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Deque<Item> implements Iterable<Item> {
    private int N;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Create an empty queue.
     */
    public Deque() {
        first = null;
        last  = null;
        N = 0;
        assert check();
    }

   /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;     
    }

   /**
     * Return the item least recently added to the queue.
     * Throw an exception if the queue is empty.
     */
    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        return first.item;
    }

   /**
     * Add the item to the queue.
     */
    public void addLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
        assert check();
    }
    public void addFirst (Item item){
	Node oldfirst =first;
	first =new Node();
	first.item =item;
	first.next=oldfirst;
	if(last==null) {
	last=first;
	first.next=null;
	}
	N++;
	
	assert check();
	StdOut.println("first"+first.item);
	StdOut.println("last"+last.item);
	
    }

   /**
     * Remove and return the item on the queue least recently added.
     * Throw an exception if the queue is empty.
     */
    public Item removeFirst() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        assert check();
        return item;
    }
    public Item removeLast() {
	if(isEmpty()) throw new RuntimeException("Queue underflow");
	Item item =last.item;
	last=null;
	Node node= first;
	if(N==1){
	  first=null;
	}
	else{
	while (node.next!=null){
	  node=node.next;
	}
	last=node;
	}
	N--;
	assert check();
	return item;
	
    }

   /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (N == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
               numberOfNodes++;
            }
            if (numberOfNodes != N) return false;

            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
               lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    } 
 

   /**
     * Return an iterator that iterates over the items on the queue in FIFO order.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


   /**
     * A test client.
     */
      public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (item.equals("addFirst")) {q.addFirst(StdIn.readString());}
            else if (item.equals("addLast")){
		//StdOut.println(StdIn.readString());	
		q.addLast(StdIn.readString());
	    }
	    else if (item.equals("removeFirst")) {
		q.removeFirst();
	    }
	    else if (item.equals("removeLast")) {
		q.removeLast();		
	    }
	    else if (item.equals("print")) {
		Iterator iter=q.iterator();

		while (iter.hasNext()){
			StdOut.print(iter.next());
		      if(iter.hasNext())
			StdOut.print(",");
		      else StdOut.print("\n");
		}
		
	   }
        }
    }
}
