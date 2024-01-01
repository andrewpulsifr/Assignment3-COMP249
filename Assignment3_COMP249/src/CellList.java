// -----------------------------------------------------
// Assignment 3
// Question: III
// Written by: Andrew Pulsifer (40234525)
// ---------------------------------

import ExceptionClasses.NoSuchElementException;

/**
 * Andrew Pulsifer (40234525)
 * COMP249
 * Assignment 3 
 * Due Date: December 4th 2023
 * 
 * Privacy leak through the implementation of clonable because it contains instances
 * variable that are mutable 
 * Could use be barriers that limit the ability to view or make changes through the contructor
 * and get classes — such as a password
 * 
 * Represents a linked list of {@link CellPhone} objects.
 * Implements the {@code Cloneable} interface.
 */
public class CellList implements Cloneable{
	/**
	 * Privacy leak through the implementation of clonable because it contains instances
	 * variable that are mutable 
	 * Could use barriers that limit the ability to view or make changes through the contructor
	 * and get classes — such as a password
	 * 
     * Private inner class representing a node in the linked list.
     */
	private class CellNode implements Cloneable {
		
        private CellPhone phone;
        private CellNode next;

        /**
         * Default constructor for CellNode.
         * Initializes the phone to {@code null} and the next pointer to {@code null}.
         */
        public CellNode() {
        	
            this.phone = null;
            this.setNext(null);
        }
        
        /**
         * Constructor for CellNode with specified CellPhone and next CellNode.
         *
         * @param c The CellPhone to be stored in the node.
         * @param n The next CellNode in the linked list.
         */
        public CellNode(CellPhone c, CellNode n) {
            this.phone = c;
            this.setNext(n);
        }
        
        /**
         * Copy constructor for CellNode.
         *
         * @param x The CellNode to be cloned.
         */
        public CellNode(CellNode x) {
        	this.phone = x.phone.clone();
            if (x.next != null) {
                this.next = x.next.clone(); 
            }
        }
        /**
         * Gets the next CellNode in the linked list.
         *
         * @return The next CellNode.
         */
        public CellNode getNext() {
			return next;
		}
        /**
         * Sets the next CellNode in the linked list.
         *
         * @param next The next CellNode.
         */
		public void setNext(CellNode next) {
			this.next = next;
		}
		 /**
         * Creates a deep copy of the current CellNode by recursively copying all the CellNodes in 
         * the CellList 
         *
         * @return A new CellNode with a cloned CellPhone and a cloned next CellNode.
         */
        public CellNode clone()
    	{
    		try
    		{
				CellNode c = (CellNode)super.clone();
				
				// Adjust phone object clone
				c.phone = this.phone.clone();
				
				if (this.next != null) {
		            c.next = this.next.clone(); // Recursively deep clone the next CellNode
		        }
	
				return c;
    		}
    			catch(CloneNotSupportedException e){
	    			System.out.println("Cannot Clone! Clone Not Supported!");
	    			return null; // needed for the compiler!
	    		}
    	}
        
  
        
    }
	private CellNode head;
	private int size;
	private int iteration;
	
	/**
     * Default constructor for CellList.
     * Initializes the head to {@code null} and the size to 0 for an empty list.
     */
	public CellList(){
		this.setHead(null);
		this.setSize(0);
	}
	
	/**
     * Copy constructor for CellList.
     * Creates a deep copy of another CellList.
     * Checks that the serial number input is not a duplicate
     * Does not use CellNode copy constructor because it does not have access
     * to the list and cannot check contains method for duplicates
     * If there was a prev pointer I could have however checked the list from within
     * CellNode but without it its impossible to make sure serial number doesn't exist
     * in instances before the Cellnode being copied by the clone method
     *
     * @param x The CellList to be cloned.
     */
	public CellList(CellList x) {
		
		if(x.head == null) {
			head = null;
		}
		else
		{
			head= null;
			CellNode t1, t2 ,t3;
			CellPhone c;
			
			t1=x.head;
			t2=t3=null;
			
			while(t1!= null) {
				
				if(head==null) {
					while(true) {
						
						c= t1.phone.clone();
						
						if(!this.contains(c.getSerialNumber())) {
							t2= new CellNode(c,null);//points to clone of first node 
							head=t2;//head points to first node
							size++;
							break;
						}
						System.out.println("-----------------------------------------------------------");
						System.out.println("You have input a duplicate serial number. Please try again.");
						System.out.println("-----------------------------------------------------------");
					}
				}
				else{
					while(true) {
						
						c= t1.phone.clone();
						
						if(!this.contains(c.getSerialNumber())) {
							t3= new CellNode(c,null);
							t2.next=t3;
							t2=t3;
							size++;
							break;
						}
						
						System.out.println("-----------------------------------------------------------");
						System.out.println("You have input a duplicate serial number. Please try again.");
						System.out.println("-----------------------------------------------------------");
					}
				}
			t1=t1.next;
			}
		t2 = t3 = null;
		}
	}
	/**
     * Creates a new CellList as a deep copy of another CellList for testing purposes.
     * Implemented to demonstrate CellNode copy constructor functionality
     * Used because it was not used for CellList copy constructor for reasons stated
     *
     * @param x The CellList to be cloned.
     */
	public void testCellNodeClone(CellList x) {
		if(x.head == null) {
			head = null;
		}
		else {
			head = new CellNode(x.head);
		}
		this.size=x.size;
	}
	/**
	 * Privacy leak risk because anyone could delete or iterate through the list to make changes
	 * Solution would be to not make the head accessible, return a copy(sloppy) or implement 
	 * protection to make it less easily modified
	 * 
     * Gets the head CellNode of the linked list.
     *
     * @return The head CellNode.
     */
	public CellNode getHead() {
		return head;
	}
	 /**
	  * Privacy leak risk because anyone could delete or iterate through the list to make changes
	 * Solution would be to not make the head accessible, return a copy(sloppy) or implement 
	 * protection to make it less easily modified
	 * 
     * Sets the head CellNode of the linked list.
     *
     * @param head The new head CellNode.
     */
	public void setHead(CellNode head) {
		this.head = head;
	}
	/**
     * Gets the size of the linked list.
     *
     * @return The size of the linked list.
     */
	public int getSize() {
		return size;
	}
	 /**
     * Sets the size of the linked list.
     *
     * @param size The new size of the linked list.
     */
	public void setSize(int size) {
		this.size = size;
	}
	
	 /**
     * Adds a new {@code CellPhone} to the start of the list.
     *
     * @param phone The {@code CellPhone} to be added.
     */
	public void addToStart(CellPhone phone) {
		head = new CellNode(phone,head);
		size++;
	}
	
	/**
     * Adds a new {@code CellPhone} to the end of the list.
     *
     * @param phone The {@code CellPhone} to be added.
     */
	public void addToEnd(CellPhone phone)
	{
		if(head == null)
		{
			head = new CellNode(phone, null);
			size++;
			return;
		}
		
		CellNode t = head;
		while(t.next != null)
			t = t.next;
		
		t.next = new CellNode(phone, null);	

		size++;
	}
	
	/**
     * Inserts a new {@code CellPhone} at the specified index in the list.
     *
     * @param phone The {@code CellPhone} to be inserted.
     * @param index The index at which to insert the new {@code CellPhone}.
     * @throws NoSuchElementException If the index is negative or out of bounds.
     */
	public void insertAtIndex(CellPhone phone, int index) throws NoSuchElementException{
		
		CellNode t=head;
		
		if(index<0) {
			throw new NoSuchElementException();
		}
		if(index==0) {
			head= new CellNode(phone,head);
			size++;
			return;
		}
		
		for(int c=0;c<index-1 && t!=null; c++) {
			t=t.next;
		}
		if(t==null)
			throw new NoSuchElementException();
		
		t.next= new CellNode(phone,t.next);
		t=null;
		size++;
	}

	/**
     * Deletes the {@code CellPhone} at the specified index in the list.
     *
     * @param index The index of the {@code CellPhone} to be deleted.
     * @throws NoSuchElementException If the index is negative or out of bounds.
     */
	public void deleteFromIndex(int index) throws NoSuchElementException{
		
		CellNode t=head;
		
		if(head == null)
		{
			throw new NoSuchElementException();
		}
		
		if(index==0) {
			head= head.next;
			size--;
			return;
		}
		
		if(index<0) {
			throw new NoSuchElementException();
		}
		
		for(int c=0;c<index -1 && t.next!=null; c++) {
			t=t.next;
		}
		if(t.next==null)
			throw new NoSuchElementException();
		
		t.next= t.next.next;
		size--;
	}

	/**
     * Deletes the first {@code CellPhone} from the list.
     *
     * @throws NoSuchElementException If the list is empty.
     */
	public void deleteFromStart(CellPhone phone, int index) throws NoSuchElementException{
		if(head!=null) {
			head=head.next;
			size--;
			return;
		}
		
		throw new NoSuchElementException();
		
	}

	/**
     * Replaces the {@code CellPhone} at the specified index in the list.
     *
     * @param phone The new {@code CellPhone} to replace the existing one.
     * @param index The index of the {@code CellPhone} to be replaced.
     * @throws NoSuchElementException If the index is negative or out of bounds.
     */
	public void replaceAtIndex(CellPhone phone, int index) throws NoSuchElementException{
	
		CellNode t=head;
		
		if(index<0) {
			throw new NoSuchElementException();
		}
		if(index==0) {
			head= new CellNode(phone,head.next);
			return;
		}
		
		for(int c=0;c<index-1 && t!=null; c++) {
			t=t.next;
		}
		if(t==null)
			throw new NoSuchElementException();
		
		t.next= new CellNode(phone,t.next.next);
		t=null;

	
	}

	/**
	 * This method allows for a privacy leak by returning the address to the cellnode
	 * To avoid this privacy leak the method would have to be private and only used by contains
	 * In short the address of the CellNode should not be returned at all but the contents could be printed
	 * Alternatively barriers to modifying or iterate through the list through CellNode could be implemented
	 * if it is required to return the address
	 * 
	 * Finds and returns the CellNode containing the CellPhone with the specified serial number.
	 *
	 * @param serial The serial number to search for.
	 * @return The CellNode containing the CellPhone with the specified serial number.
	 */
	public CellNode find(long serial) {
		
		CellNode t=head;
		
		for(int c=0;t!=null; c++) {
			if(t.phone.getSerialNumber() == serial) {
				iteration=c;
				return t;
			}
			t=t.next;
		}
	
		return null;
		
	}
	/**
	 * Checks if a CellPhone with the specified serial number exists in the list.
	 *
	 * @param serial The serial number to check.
	 * @return {@code true} if a CellPhone with the specified serial number exists, {@code false} otherwise.
	 */
	public boolean contains(long serial){
		
		if(find(serial) != null)
			return true;
		else 
			return false;
		
	}
	
	/**
	 * Displays the contents of the linked list.
	 */
	public void showContents() {
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("Displaying link list contents...");
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------------------\n");
		
		System.out.println("The current size of the list is "+size);
		System.out.println("===============================================================");
		
		CellNode t=head;
		
		if (t == null)
			System.out.println("\nThere is nothing to display; list is empty." );
		else {
			for(int c=0; t!=null;c++) {
				if(c%3==0)
					System.out.println();
				
				System.out.print(t.phone.toString()+" --->");
				t=t.next;
				
			}
			System.out.println("X");
		}
		System.out.println("\n===============================================================");
		t=null;
	}
	
	/**
	 * Checks if two CellList objects are equal by comparing their contents.
	 *
	 * @param x The object to compare with.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	public boolean equals(Object x) {
		
		if(this.getClass()!=x.getClass())
			return false;
		
		CellList c= (CellList)x;
		
		if(head==null && c.head==null)
			return true;
		
		CellNode t=head;
		CellNode t1=c.head;
		
		while(t!=null) {
			if(!t.phone.equals(t1.phone)) {
				return false;
			}
			t=t.next;
			t1=t1.next;
			
		}
		if(t1==null)
			return true;
		
		return false;
	}
	/**
	 * Privacy leak because the position at which an item is found can be changed
	 * Making the methods private would fix this 
	 * 
	 * Gets the index of the last CellNode accessed through the find method.
	 *
	 * @return The index of the last accessed CellNode.
	 */
	public int getIteration() {
		return iteration;
	}
	/**
	 * Privacy leak because the position at which an item is found can be changed
	 * Making the methods private would fix this 
	 * 
	 * Sets the index of the last CellNode accessed through the find method.
	 *
	 * @param iteration The index of the last accessed CellNode.
	 */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	

	
	
	
}
