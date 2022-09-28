package phoneList;


/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {
	private String Name;
	private long Number;
	
	public Contact (String Name, long Number) {
		this.Name = Name;
		this.Number = Number;
	}
	public String getName() {
	
		return Name;// Gets name
	}
	public long getNumber() {
		return Number;//This gets the name
		
	}
	public void setName(String Name) {
		this.Name = Name;// This sets the name
	}
	public void setNumber(long Number) {
		this.Number = Number;// This sets the number
	}
	@Override
	public String toString() {// Makes it easy to print account by name only
		return Name + "   " + Number;
	}
	
}








