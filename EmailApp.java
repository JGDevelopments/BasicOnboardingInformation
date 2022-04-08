package emailapp;

public class EmailApp {

	public static void main(String[] args) {

		Email em1 = new Email("Hiring","Manager"); // This is the constructor 
		System.out.println(em1.showInfo()); // we have to print using System.out.println because we are returning a value in the showInfo() 

	}
}
