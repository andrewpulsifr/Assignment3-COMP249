import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class CellListUtilization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CellList c1 = new CellList();
		CellList c2 = new CellList();
		Scanner sc = null;
	
		try {
			sc= new Scanner( new FileInputStream("Cell_info.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Error: there was a problem finding your text file");
		}
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("Adding text input to link list...");
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------------------\n");
		while(sc.hasNextLine()) {
			CellPhone x = new CellPhone(sc.nextLong(), sc.next(),sc.nextDouble(),sc.nextInt());
			
			if(!c1.contains(x.getSerialNumber())) {
				c1.addToStart(x);
				System.out.println("---------------------");
				System.out.println("Added to link List :"+x);
				System.out.println("---------------------");
			}
			else {
				System.out.println("---------------------");
				System.out.println("Duplicate :"+x);
				System.out.println("---------------------");
			}
		}
		
		sc.close();
		
		
		c1.showContents();
		
		Scanner input = new Scanner(System.in);
		Long SNinput;
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("Running find menu...");
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------------------\n");
		while(true) {
			System.out.println("\n-------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("Please input a Serial Number you would like to find");
			System.out.print("Or press 0 to exit: ");
			SNinput= input.nextLong(); 
			System.out.println("---------------------------------------------------");
			
			if(SNinput==0) {
				System.out.println("\nExiting find Menu...");
				System.out.println("---------------------------------------------------");
				System.out.println("---------------------------------------------------------------");
				break;
			}
			if(c1.find(SNinput)==null) {
				System.out.println("Serial number was not found returned ====> "+null);
			}
			else
				System.out.println("It took "+c1.getIteration()+" iterations to find pointer ====> "+c1.find(SNinput));
				
		}

		CellList c3 = new CellList(c1);
		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("---------------------------------------------------");
		System.out.println("Running implementing test cases...");
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------------------\n");
		
		CellList c4 = new CellList();
		System.out.println("---------------------------------------------------");
		System.out.println("Showing content of copied CellList...");
		System.out.println("---------------------------------------------------");
		c3.showContents();
		System.out.println("---------------------------------------------------");
		System.out.println("Testing equals method for c1 & c3 clone...");
		System.out.println("---------------------------------------------------");
		System.out.println(c3.equals(c1));
		System.out.println("---------------------------------------------------");
		System.out.println("Testing equals method for c3 & c1 clone...");
		System.out.println("---------------------------------------------------");
		System.out.println(c1.equals(c3));
		System.out.println("---------------------------------------------------");
		System.out.println("Testing equals method for c1 & c2...");
		System.out.println("---------------------------------------------------");
		System.out.println(c2.equals(c1));
		System.out.println("---------------------------------------------------");
		System.out.println("Testing equals method for c4(empty) & c1 clone...");
		System.out.println("---------------------------------------------------");
		System.out.println(c4.equals(c1));
		System.out.println("---------------------------------------------------");
		System.out.println("Testing equals method for c1 & c4(empty) clone...");
		System.out.println("---------------------------------------------------");
		System.out.println(c4.equals(c1));

		System.out.println("---------------------------------------------------");
		System.out.println("Adding list from end");
		System.out.println("---------------------------------------------------");
		
		try {
			sc= new Scanner( new FileInputStream("Cell_info.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Error: there was a problem finding your text file");
		}
		
		while(sc.hasNextLine()) {
			CellPhone x = new CellPhone(sc.nextLong(), sc.next(),sc.nextDouble(),sc.nextInt());
			
			if(!c2.contains(x.getSerialNumber())) {
				c2.addToEnd(x);
				System.out.println("---------------------");
				System.out.println("Added to link List :"+x);
				System.out.println("---------------------");
			}
			else {
				System.out.println("---------------------");
				System.out.println("Duplicate :"+x);
				System.out.println("---------------------");
			}
		}
		c2.showContents();//Add to end works
		
		//input at index implementation
		CellPhone c;
		Scanner userIn = new Scanner(System.in);
		
		while(true) {
			
			try {
			//Output Instructions
			System.out.println("---------------------------------------------------");
			System.out.println("Please input :\n"
					+ "Serial Number,Brand,Price,Year"
					+ "\nExactly As shown with each input seperated by a comma");
			System.out.println("---------------------------------------------------");
			
			String UserInput = userIn.nextLine();
			String [] fields = UserInput.split(",");
			
			c = new CellPhone(Long.parseLong(fields[0]),fields[1],Double.parseDouble(fields[2]),Integer.parseInt(fields[3]));
	
			break;
			
				}catch(NumberFormatException e) {
					System.out.println("---------------------------------------------------");
					System.out.println("Error: Your input values were incorrect. Please follow the instructions and try again.");
					System.out.println("---------------------------------------------------");
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("---------------------------------------------------");
					System.out.println("Error: You input the incorrect number of fields. Please follow the instructions and try again.");
					System.out.println("---------------------------------------------------");
				}
		}
		while(true) {
			try {
			System.out.println("---------------------------------------------------");
			System.out.println("Please input index at which you would like to insert new cellphone : ");
			c1.insertAtIndex(c, userIn.nextInt());
			userIn.nextLine();
			
			c1.showContents();
			break;
			
				}catch(ExceptionClasses.NoSuchElementException e) {
					System.out.print(e.getMessage());
				}
		}
		
		
		while(true) {
			try {
			System.out.println("---------------------------------------------------");
			System.out.print("Please input index at which you would like to delete node : ");
			c1.deleteFromIndex(userIn.nextInt());
			userIn.nextLine();
			
			System.out.println("---------------------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("Displaying new linked list");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------------------");
			c1.showContents();
			break;
	
			
				}catch(ExceptionClasses.NoSuchElementException e) {
					System.out.print(e.getMessage());
				}
		}

		while(true) {
			
			try {
			//Output Instructions
			System.out.println("---------------------------------------------------");
			System.out.println("Please input :\n"
					+ "Serial Number,Brand,Price,Year"
					+ "\nExactly As shown with each input seperated by a comma");
			System.out.println("---------------------------------------------------");
			
			String UserInput = userIn.nextLine();
			String [] fields = UserInput.split(",");
			
			c = new CellPhone(Long.parseLong(fields[0]),fields[1],Double.parseDouble(fields[2]),Integer.parseInt(fields[3]));
	
			break;
			
				}catch(NumberFormatException e) {
					System.out.println("---------------------------------------------------");
					System.out.println("Error: Your input values were incorrect. Please follow the instructions and try again.");
					System.out.println("---------------------------------------------------");
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("---------------------------------------------------");
					System.out.println("Error: You input the incorrect number of fields. Please follow the instructions and try again.");
					System.out.println("---------------------------------------------------");
				}
		}
		while(true) {
			try {
			System.out.println("---------------------------------------------------");
			System.out.println("Please input index at which you would like to replace the cellphone : ");
			c1.replaceAtIndex(c, userIn.nextInt());
			userIn.nextLine();
			
			c1.showContents();
			break;
			
				}catch(ExceptionClasses.NoSuchElementException e) {
					System.out.print(e.getMessage());
				}
		}
		
	}

}
