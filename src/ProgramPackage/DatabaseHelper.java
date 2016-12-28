
package ProgramPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is a class of helper methods for finding info about the
 * EmployeeDatabase;
 *
 *
 * @author Katrina Van Laan
 */
public class DatabaseHelper {

	/**
	 * Method for finding average of List<Integer>
	 * 
	 * @param List<Integer>
	 * @return double representing average;
	 */
	public static double findAverage(List<Integer> arrList) {
		double sum = 0;
		for (int i = 0; i < arrList.size(); i++)
			sum += (double) arrList.get(i);
		return sum / arrList.size();
	}

	/**
	 * Method for calculating overall database info;
	 * 
	 * 
	 */

	public static void getDestinationInfo() {
		// list of all unique destination names
		List<String> allDestinations = new ArrayList<String>();

		// list of wish list sizes to find most/least/average values
		List<Integer> wishListSize = new ArrayList<Integer>();

		// list of DestinationCount objects, including each unique destination's
		// name and # of occurrences in database (count)
		List<DestinationCount> destinationCounts = new ArrayList<DestinationCount>();
		Iterator<Employee> itr = EmployeeDatabase.iterator();
		while (itr.hasNext()) {
			Employee user = itr.next();
			List<String> wish = user.getWishlist();
			wishListSize.add(wish.size());
			Iterator<String> wishItr = wish.iterator();
			while (wishItr.hasNext()) {
				String destination = wishItr.next();
				// create new DestinationCount object and add to, if not
				// already present, destinationCounts list
				if (!allDestinations.contains(destination)) {
					allDestinations.add(destination);
					DestinationCount newCount = new DestinationCount(destination);
					destinationCounts.add(newCount);
				} else {
					// iterate through destinationCounts, if destination already
					// present,count is incremented
					Iterator<DestinationCount> destItr = destinationCounts.iterator();
					while (destItr.hasNext()) {
						DestinationCount count = destItr.next();
						if (count.destination.equals(destination)) {
							// increase count/occurrence by 1
							count.incrementCount();
						}
					}
				}
			}
		}

		// I will iterate through the destinationCounts List and add each
		// object's count property to averageArr in order to find the average
		// Employees/destination
		List<Integer> averageArr = new ArrayList();

		// sorting destinationCounts by lowest to highest 'count' property
		Collections.sort(destinationCounts, (o1, o2) -> o1.count.compareTo(o2.count));
		// obtaining max count by grabbing last element in destinationCounts
		Integer max = destinationCounts.get(destinationCounts.size() - 1).getCount();
		// add destination names which share the max count
		List<String> maxArr = new ArrayList();

		Iterator<DestinationCount> destItr = destinationCounts.iterator();
		while (destItr.hasNext()) {
			DestinationCount count = destItr.next();
			averageArr.add(count.getCount());
			if (count.getCount() == max) {
				maxArr.add(count.destination);
			}
		}

		System.out.println("Destinations:" + destinationCounts.size());

		// finding average of destination/employee
		// using findAverage method to calculate average of wishListSize list
		// rounding to 2 decimal places
		double average = Math.round(findAverage(wishListSize) * 10.0) / 10.0;
		// same methodology to calculate average employee/destination
		double averageTwo = Math.round(findAverage(averageArr) * 10.0) / 10.0;

		System.out.println("# of destinations/Employee: most " + Collections.max(wishListSize) + ", least "
				+ Collections.min(wishListSize) + ", average " + average);
		System.out.println(
				"# of Employees/destination: most " + destinationCounts.get(destinationCounts.size() - 1).getCount()
						+ ", least " + destinationCounts.get(0).getCount() + ", average " + averageTwo);
		System.out.println("Most popular destination: " + String.join(",", maxArr) + " [" + max + "]");
	}

}
