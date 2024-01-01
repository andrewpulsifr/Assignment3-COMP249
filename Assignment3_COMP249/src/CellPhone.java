// -----------------------------------------------------
// Assignment 3
// Question: III
// Written by: Andrew Pulsifer (40234525)
// ---------------------------------

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Andrew Pulsifer (40234525)
 * COMP249
 * Assignment 3 
 * Due Date: December 4th 2023
 * 
 * The {@code CellPhone} class represents a mobile phone with a serial number, brand, year of release, and price.
 * It implements the {@code Cloneable} interface to support cloning with a new serial number.
 */
public class CellPhone implements Cloneable {
	private long serialNumber;
	private String brand;
	private int year;
	private double price;
	
	 /**
	 * Privacy leak for the entire class due to the ability to add cellphones 
	 * and change/read their contents without restriction 
	 * This could be resolved by implementing barriers such as requiring a password 
	 * to add/edit/get information from CellPhone 
	 * This being said it is only a problem if access is granted through CellNode
	 * 
     * Constructs a new {@code CellPhone} object with the specified attributes.
     *
     * @param serialNumber Unique identifier for the cell phone.
     * @param brand        Brand of the cell phone.
     * @param price        Price of the cell phone.
     * @param year         Year of release.
     */
	public CellPhone(long serialNumber, String brand, double price,int year) {
		this.serialNumber=serialNumber;
		this.brand=brand;
		this.year=year;
		this.price=price;

	}
	
	/**
     * Constructs a new {@code CellPhone} object based on an existing one with a new serial number.
     *
     * @param x          The original cell phone object.
     * @param serialNum  New serial number for the cloned cell phone.
     */
	public CellPhone(CellPhone x, long serialNum) {
		this.serialNumber=serialNum;
		this.brand=x.brand;
		this.year=x.year;
		this.price=x.price;
	}
	
	 // Getter and setter methods...

    /**
     * Gets the serial number of the cell phone.
     *
     * @return The serial number.
     */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
     * Sets the serial number of the cell phone.
     *
     * @param serialNumber The new serial number.
     */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	/**
     * Returns a string representation of the {@code CellPhone} object.
     *
     * @return A string representation.
     */
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
	
	 /**
     * Returns a string representation of the {@code CellPhone} object.
     *
     * @return A string representation.
     */
	public String toString() {
		return "["+serialNumber+"; "+brand+" "+price+" "+year+"]";
		}
	 /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param x The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
	public boolean equals(Object x) {
		if(x==null || this.getClass()!=x.getClass())
			return false;
		
		CellPhone c= (CellPhone)x;
		
		if(this.brand.equals(c.brand) && this.price==c.price &&this.year==c.year)
			return true;
		return false;
	}
	
	//could cause a privacy leak— look on interfaces to double check
	/**
	 * Creates and returns a copy of this {@code CellPhone} object with a new serial number.
	 *
	 * @return A cloned {@code CellPhone} object with a new serial number.
	 */
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
				sc.nextLine();
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
