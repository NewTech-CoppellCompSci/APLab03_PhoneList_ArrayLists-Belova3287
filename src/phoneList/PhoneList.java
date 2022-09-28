package phoneList;

import java.util.ArrayList;
import java.util.Scanner;




/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {


	
	/*
	 * Instance Variables
	 */
	private static ArrayList<Contact> Contacts; //Creates an Array List called contacts that holds contact

		
	

		
	
	
	//Constructor
	public PhoneList() {
		//initialize instance variables
		 Contacts = new ArrayList<Contact>();

		
		
		}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number
	 *   - create a new Contact object with that input
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	public static void addContact() {
	
		Scanner inKey = new Scanner(System.in);
		System.out.println("What name would you like to put the contact under: "); //Asks for a name to put the contact under
		String Name = inKey.nextLine();
		System.out.println("What is the phone number for this contact: "); //Asks for a number to put the contact under
		Long Number = inKey.nextLong();
		Contact newContact = new Contact (Name, Number); // Creates a new contact that holds the new name and number
		System.out.print(newContact.getName() + "'s contact has been added");
		Contacts.add(newContact); // Adds the new contact to the Array List, Contacts
		for (int i = 0; i < Contacts.size(); i++) {
			
			for(int j = i + 1; j < Contacts.size(); j++) {
				
				int value = Contacts.get(i).getName().compareToIgnoreCase(Contacts.get(j).getName()); //Compares the name under I to the name under j while ignoring the case
				
				if (value > 0) {
					
					Contact holder = Contacts.get(i);
					
					Contact holder2 = Contacts.get(j);
					
					Contacts.set(i, holder2);
					
					Contacts.set(j, holder);

				}
			}
		}
	}
	
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public static void removeContact() {
		
//		Contact myCont = new Contact();
		
		Scanner inKey = new Scanner(System.in);
		System.out.println("What is the contacts name: "); //Asks the contacts name and sets boolean to false
		String Cont = inKey.nextLine();
		Boolean foundContact = false;
		
		
	for (int i = 0; i < Contacts.size(); i++ ) { // as long as I is less than the length of the contact, it will run the loop
		
		
		if (Cont.equalsIgnoreCase(Contacts.get(i).getName())){ //If whatever the input contact is, matches the name of the names in the contacts list
			System.out.println(" Removing Contact: " + Contacts.get(i)); // It will remove it
			Contacts.remove(i);
			foundContact=true; //It will stop here
			break;
		}
		
		
	}
	if (foundContact == false) { // If the boolean is false, it will say that the contact the user is trying to use does not exist
		
			System.out.print("Contact " + Cont + " is not found");
	
		
	}

	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	public static void printList() {
		System.out.println("\n\n----------------------------");
		System.out.println("   Name              Number\n----------------------------");
		
		for (int Loml = 0; Loml < Contacts.size(); Loml++) {
			
			System.out.println(Contacts.get(Loml) + "\n"); //It will print the list in alphabetical order as it was made in Add Contact
		}
		System.out.println("----------------------------");
		System.out.println("\n");
		
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	public static void menu() {
		
		
		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	public static String getString(String str) {
		
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		return inKey.nextLine();
		
	}
	
	
	public static void main(String[] args) {
		PhoneList app = new PhoneList();

		
		app.menu();
	}
}

