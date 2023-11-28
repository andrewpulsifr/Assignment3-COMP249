import java.util.InputMismatchException;
import java.util.Scanner;

public class CellPhone implements Cloneable {
	private static long serialNumCtr=0;
	private long serialNumber;
	private String brand;
	private int year;
	private double price;
	
	public CellPhone(long serialNumber, String brand, int year, double price) {
		this.serialNumber=serialNumber;
		this.brand=brand;
		this.year=year;
		this.price=price;

	}
	
	public CellPhone(CellPhone x, long serialNum) {
		this.serialNumber=serialNum;
		this.brand=x.brand;
		this.year=x.year;
		this.price=x.price;
	}
	
	//getter and setters
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "["+serialNumber+"; "+brand+" "+price+" "+year+"]";
		}
	public boolean equals(Object x) {
		if(x==null || this.getClass()!=x.getClass())
			return false;
		
		CellPhone c= (CellPhone)x;
		
		if(this.brand.equals(c.brand) && this.price==c.price &&this.year==c.year)
			return true;
		return false;
	}
	
	//could cause a privacy leak— look on interfaces to double check
	public CellPhone clone() {
		CellPhone c =null;
		Scanner sc= new Scanner(System.in);
		long serialNum;
		//loop for user input
		while(true) {
			//try until valid input is input from keyboard
			try {
			System.out.println("Please enter new serial number for cloned CellPhone:");
			serialNum=sc.nextLong();
			break;//Exit loop
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input please try again");
			}
		}
		//
		try {
		c= (CellPhone)super.clone();
		c.serialNumber=serialNum;
		
		return c;
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println("Cannot Clone! Clone Not Supported!");
			return null; // needed for the compiler!
		}
		
	}
}
