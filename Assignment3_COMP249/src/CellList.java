import java.util.NoSuchElementException;

public class CellList implements Cloneable{
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
			
			t1=x.head;
			t2=t3=null;
			
			while(t1!= null) {
				
				if(head==null) {
					t2= new CellNode(t1.phone.clone(),null);//points to clone of first node 
					head=t2;//head points to first node
				}
				else{
					t3= new CellNode(t1.phone.clone(),null);
					t2.next=t3;
					t2=t3;
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
	}
	
	public void addToEnd(CellPhone phone) {
		CellNode t = head;
		
		while(t.next!=null) {
			t=t.next;
		}
		
		t.next= new CellNode(phone,null);
		t=null;
		size++;
	}
	
	public void insertAtIndex(CellPhone phone, int index) throws NoSuchElementException{
		
		CellNode t=head;
		
		if(index<0) {
			throw new NoSuchElementException();
		}
		
		for(int c=0;c<index || t.next!=null; c++) {
			t=t.next;
		}
		if(t.next==null)
			throw new NoSuchElementException();
		
		t.next= new CellNode(phone,t.next);
		t=null;
		size++;
	}
	
public void deleteFromIndex(int index) throws NoSuchElementException{
		
		CellNode t=head;
		
		if(index<0) {
			throw new NoSuchElementException();
		}
		
		for(int c=0;c<index || t.next!=null; c++) {
			t=t.next;
		}
		if(t.next==null)
			throw new NoSuchElementException();
		
		t.next= t.next.next;
		t=null;
		size--;
	}

public void deleteFromStart(CellPhone phone, int index) throws NoSuchElementException{
	if(head!=null) {
		head=head.next;
		size--;
	}
}


public void replaceAtIndex(CellNode Node, int index) throws NoSuchElementException{
	
	CellNode t=head;
	
	if(index<0) {
		throw new NoSuchElementException();
	}
	
	for(int c=0;c<index || t.next!=null; c++) {
		t=t.next;
	}
	if(t.next==null)
		throw new NoSuchElementException();
	Node.setNext(t.next);
	t.next= Node;
	t=null;
}

//privacy breach to account for with the pointer to the node 
public CellNode find(long serial) throws NoSuchElementException{
	
	CellNode t=head;
	
	while(serial!=t.phone.getSerialNumber() || t.next!=null) {
		t=t.next;
	}
	if(t.next==null)
		return null;
	else
		return t;
	
}

public boolean contains(long serial){
	
	CellNode t=head;
	
	while(serial!=t.phone.getSerialNumber() || t.next!=null) {
		t=t.next;
	}
	if(t.next==null)
		return false;
	
	return true;
	
}

public void showContents() {
	
	CellNode t=head;
	
	for(int c=0; t.next!=null;c++) {
		if(c%3==0)
			System.out.println();
		
		System.out.print(t.phone.toString()+" --->");
		t=t.next;
		
	}
	System.out.println("X");
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
	
	while(t.next!=null) {
		if(!t.phone.equals(t1.phone)) {
			return false;
		}
		t=t.next;
		t1=t1.next;
		
	}
	if(t1.next==null)
		return true;
	
	return false;
}


	
	
	
}
