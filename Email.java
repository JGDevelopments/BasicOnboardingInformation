package emailapp;

import java.util.Scanner;

public class Email {

	private String firstname; //Don't want people accessing these variables
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 300;
	private int defaultPasswordLength = 6; //length has to be set
	private String alternateEmail; 
	private String companySuffix = "Carefirst.com";


	//Constructor to receive the first name and last name 
	public Email(String firstname, String lastname){
		this.firstname = firstname;		// this. is used to refer to the class level variable, so we are just declaring that this.firstname is equal to the local variable firstname
		this.lastname = lastname; 
		// System.out.println("EMAIL CREATED: " + this.firstname + " " + this.lastname); //should print EMAIL CREATED: John Smith 
		this.department = setDepartment(); //Essentially this lets you know that the private variable department is equal to the setDepartment() method 
		
		// Calls a method that returns a random password
		this.password = randomPassword(defaultPasswordLength); 
		System.out.println("Your password is: " + this.password);  //prints out password 

		// Combines elements to generate email 
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;}
	
		// asks for the department 
	private String setDepartment() {
		System.out.print("Mr. Hiring Manager please enter your \nDepartment Code: \n1 for Sales \n2 for Development \n3 for Accoutning \n4 for none\nEnter Department Code");
		Scanner in = new Scanner(System.in); //how to get user input also the import java.util.Scanner needs to be imported 	
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {return "sales"; } // These evaluate the number and returns the department accordingly 
		else if (deptChoice == 2) {return "dev"; }
		else if (deptChoice == 3) {return "acct"; }
		else {return ""; } // this doesn't have "none" in it because then it would be implemented as "john.smith@none.company.com" and we don't want that 
	}	
	//generates a random password 
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRTUVWXYZ1234567890!@#$%&";
		char[] password = new char [length]; //this creates an array of characters to the variable length 
		for (int i = 0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length()); //so the goal here is to make a random 
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);}

	//sets mailbox capacity 
	public void setMailboxCapacity(int capacity) { //this is encapsulation at its finest. Were setting and hiding these properties. 
		this.mailboxCapacity = capacity; 
		}

	//sets alternate email 
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail; 
		}

	//changes password 
	public void changePassword(String password) {
		this.password = password; 
		}
		
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() {return password;} 
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstname + " " + lastname + " " +
				"\nCOMPANY EMAIL: " + email + " " +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb"; 
				}

}