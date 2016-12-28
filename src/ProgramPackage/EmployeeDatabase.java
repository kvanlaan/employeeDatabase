package ProgramPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This is for creating, adding to, removing from and querying an Employee
 * Database;
 *
 * The EmployeeDatabase consists of a list of Employee objects defined in
 * Employee.java;
 * 
 * @author Katrina Van Laan,
 */

public class EmployeeDatabase {
	// employees which will become property on new EmployeeDatabase
	private static List<Employee> employees;

	/**
	 * Constructor for the EmployeeDatabase class
	 *
	 */
	public EmployeeDatabase() {
		employees = new ArrayList<Employee>();
	}

	/**
	 * Iterator of List<Employee> for the EmployeeDatabase class
	 * 
	 * @return Iterator of List<Employee> for the EmployeeDatabase class
	 */
	public static Iterator<Employee> iterator() {
		return employees.iterator();
	}

	/**
	 * Adds an employee with the given username e to the end of the database.
	 * 
	 * @param String
	 *            e becomes new employee name
	 * @return only if employee e is already in the database.
	 */
	public static void addEmployee(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		if (!containsEmployee(e)) {
			Employee fresh = new Employee(e);// new Employee
			employees.add(fresh);// add employee object to database
		} else {
			return;
		}
	}

	/**
	 * Add the given destination d to the wish list for employee e in the
	 * database.
	 * 
	 * @param String
	 *            e is employee name;
	 * @param String
	 *            d is destination;
	 * @return destination is already in the wish list for employee e, just
	 *         return.
	 */
	public static void addDestination(String e, String d) {

		if (d == null || e == null || !containsEmployee(e)) {
			throw new IllegalArgumentException();
		} else {
			if (!hasDestination(e, d)) {
				Iterator<Employee> itr = iterator();// employeeDatabase iterator
				while (itr.hasNext()) {
					Employee user = itr.next();// employee object
					String userName = user.getUsername();// employee name
					if (userName.equals(e)) {
						user.getWishlist().add(d);// add d to wishlist
					}
				}
			} else {
				return;
			}
		}
	}

	/**
	 * Return true if and only if employee e is in the database.
	 * 
	 * @param String
	 *            e is employee name;
	 * @return true if and only if employee e is in the database.
	 */
	public static boolean containsEmployee(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		Iterator<Employee> itr = iterator();// employee database iterator
		while (itr.hasNext()) {
			String user = itr.next().getUsername();// employee name
			if (user.equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true if and only if destination d appears in at least one
	 * employee's wish list in the database.
	 * 
	 * @param String
	 *            d is destination;
	 * @return Return true if and only if destination d appears in at least one
	 *         employee's wish list in the database.
	 */
	public static boolean containsDestination(String d) {
		if (d == null) {
			throw new IllegalArgumentException();
		}
		Iterator<Employee> itr = iterator();// employee database iterator
		while (itr.hasNext()) {
			List<String> wish = itr.next().getWishlist();// wishlist
			Iterator<String> wishItr = wish.iterator();// wishlist iterator
			while (wishItr.hasNext()) {
				String destination = wishItr.next();// destination
				if (destination.equals(d)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Returns true if and only if destination d is in the wish list for
	 * employee e. If employee e is not in the database, return false.
	 * 
	 * @param String
	 *            e is employee name
	 * @param Strin
	 *            d is destination
	 * @return true if and only if destination d appears in at least one
	 *         employee's wish list in the database.
	 * @return false if employee e is not in the database
	 */

	public static boolean hasDestination(String e, String d) {
		if (e == null || d == null) {
			throw new IllegalArgumentException();
		}
		if (containsEmployee(e)) {
			Iterator<Employee> itr = iterator();
			while (itr.hasNext()) {
				Employee user = itr.next();// employee object
				String userName = user.getUsername().toLowerCase();
				if (userName.equals(e)) {
					List<String> wish = user.getWishlist();// wish list
					Iterator<String> wishItr = wish.iterator();// wishlist
																// iterator
					while (wishItr.hasNext()) {
						String destination = wishItr.next();// destination
						if (destination.equals(d)) {
							return true;
						}
					}
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Return the list of employees who have destination d in their wish list.
	 * If destination d is not in the database, return a null list.
	 * 
	 * @param String
	 *            d is the destination;
	 * @return the list of employees who have destination d in their wish list.
	 * @return null list if destination d is not in the database.
	 */

	public static List<String> getEmployees(String d) {
		if (d == null) {
			throw new IllegalArgumentException();
		}
		if (containsDestination(d)) {

			List<String> allEmployees = new ArrayList<String>();
			Iterator<Employee> itr = iterator();
			while (itr.hasNext()) {
				Employee user = itr.next();
				List<String> wish = user.getWishlist();
				Iterator<String> wishItr = wish.iterator();
				while (wishItr.hasNext()) {
					String destination = wishItr.next();
					if (destination.equals(d)) {
						allEmployees.add(user.getUsername());
					}
				}
			}
			System.out.println(d + ":" + String.join(",", allEmployees));

			return allEmployees;
		} else {
			System.out.println("destination not found");
			return Collections.emptyList();
		}
	}

	/**
	 * Return the wish list for the employee e. If an employee e is not in the
	 * database, return null.
	 * 
	 * @param String
	 *            e is the destination
	 * @return the wish list for the employee e. If an employee e is not in the
	 *         database, return null.
	 */
	public static List<String> getDestinations(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		List<Integer> arraySize = new ArrayList<Integer>();
		List<String> wish = new ArrayList<String>();
		if (containsEmployee(e)) {
			Iterator<Employee> itr = iterator();
			while (itr.hasNext()) {
				Employee user = itr.next();
				String userName = user.getUsername().toLowerCase();
				if (userName.equals(e)) {
					String joined = String.join(",", user.getWishlist());
					System.out.println(user.getUsername() + ":" + joined);
					wish = user.getWishlist();
				}
			}
			return wish;
		} else {
			System.out.println("Employee not found");
			return null;
		}
	}

	/**
	 * Remove employee e from the database.
	 * 
	 * @param String
	 *            e is the employee name;
	 * @return true if removal is successful;
	 * @return false if employee is not in database;
	 */

	public static boolean removeEmployee(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		if (containsEmployee(e)) {
			Iterator<Employee> itr = iterator();
			while (itr.hasNext()) {
				Employee user = itr.next();
				String userName = user.getUsername();
				if (userName.equals(e)) {
					itr.remove();
					System.out.println("Employee removed");
					return true;
				}
			}
			return false;
		} else {
			System.out.println("Employee not found");
			return false;
		}
	}

	/**
	 * Return Remove destination d from the database, i.e., remove destination d
	 * from every wish list in which it appears.
	 * 
	 * 
	 * @param String
	 *            d is destination;
	 * @return true if removal is successful;
	 * @return false if destination is not in database
	 */

	public static boolean removeDestination(String d) {
		if (d == null) {
			throw new IllegalArgumentException();
		}
		if (containsDestination(d)) {
			Iterator<Employee> itr = iterator();// database iterator
			while (itr.hasNext()) {
				Employee user = itr.next();// employee
				List<String> wish = user.getWishlist();// wishlist
				Iterator<String> wishItr = wish.iterator();// wishlist iterator
				while (wishItr.hasNext()) {
					String destination = wishItr.next();// destination
					if (d.equals(destination)) {
						wishItr.remove();// destination removed

					}
				}
			}
			System.out.println("destination removed");
			return true;
		} else {
			System.out.println("destination not found");
			return false;
		}

	}

	/**
	 * Return the number of employees in this database.
	 * 
	 * @return Integer of employees in this database.
	 */

	public int size() {
		return employees.size();
	}

}
