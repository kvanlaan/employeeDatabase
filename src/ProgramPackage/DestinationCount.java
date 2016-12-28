package ProgramPackage;

/**
 * The Destination Count class is used to represent a destination and its number
 * of appearances in the Employee Database. I am using it in order to find the
 * Most popular destination.
 * 
 * @author Katrina Van Laan
 */
public class DestinationCount {
	// count Integer will be incremented to reflect occurrences of each
	// destination
	Integer count = 1;
	// destination name
	String destination = "";

	public DestinationCount(String d) {
		destination = d;
		count = 1;
	}

	public String getDestination() {
		return destination;
	}

	public int getCount() {
		return count;
	}

	public void incrementCount() {
		count++;
	}

}
