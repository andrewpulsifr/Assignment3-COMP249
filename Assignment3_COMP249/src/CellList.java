import ExceptionClasses.NoSuchElementException;

public class CellList implements Cloneable{
	/**
     * Private inner class representing a node in the linked list.
     */
	private class CellNode {
		
        private CellPhone phone;
        private CellNode next;

        // Default constructor
        public CellNode() {
        	
	            this.phone = null;
	            this.setNext(null);
	        }
	        
	        public CellNode(CellPhone c, CellNode n) {
	            this.phone = c;
	            this.setNext(n);
	        }
	        
	        public CellNode(CellNode x) {
	        	this.phone = x.phone.clone();
				this.next = x.next;
	        }
	        //getter and setters
	        public CellNode getNextPointer() {
				return next;
			}
	
			public void setNext(CellNode next) {
				this.next = next;
			}
	        
	        public CellNode clone()
	    	{
	    		try
	    		{
	    			CellNode c = (CellNode)super.clone();
	    			
	    			// Adjust phone object clone
	    			c.phone = this.phone.clone();

	    			return c;
	    		}catch(CloneNotSupportedException e)
	    		{
	    			System.out.println("Cannot Clone! Clone Not Supported!");
	    			return null; // needed for the compiler!
	    		}
	    	}
        
    }
	private CellNode head;
	private int size;
	private int iteration;
	
	public CellList(){
		this.setHead(null);
		this.setSize(0);
	}
	
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

	public CellNode getHead() {
		return head;
	}

	public void setHead(CellNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addToStart(CellPhone phone) {
		head = new CellNode(phone,head);
		size++;
	}
	
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

public void deleteFromStart(CellPhone phone, int index) throws NoSuchElementException{
	if(head!=null) {
		head=head.next;
		size--;
		return;
	}
	
	throw new NoSuchElementException();
	
}


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

//privacy breach to account for with the pointer to the node 
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

public boolean contains(long serial){
	
	if(find(serial) != null)
		return true;
	else 
		return false;
	
}

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

public int getIteration() {
	return iteration;
}

public void setIteration(int iteration) {
	this.iteration = iteration;
}


	
	
	
}
