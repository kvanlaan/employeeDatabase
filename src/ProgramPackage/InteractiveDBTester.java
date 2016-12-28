/**
 * 
 */
package ProgramPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * 
 * Title: program 1 //Semester: Fall 2016 //Author: Katrina Van Laan // Email:vanlaan@wisc.edu
 *
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InteractiveDBTester {

	public static void swap(int pos1, int pos2, LinkedList<DblListnode<String>> items) {
		if (items.size() > 0) {
			if (pos1 < 0 || pos1 >= items.size() || pos2 < 0 || pos2 >= items.size()) {
				throw new IndexOutOfBoundsException();
			}

			if (pos1 == pos2) {
				return;
			} else {

				int x = 0;
				int lowNum = pos1;
				int highNum = pos2;
				if (pos1 > pos2) {
					lowNum = pos2;
					highNum = pos1;
				}
				DblListnode<String> pos1El = null;
				DblListnode<String> pos2El = null;
				DblListnode<String> pos1Next = null;
				DblListnode<String> pos1Prev = null;
				DblListnode<String> pos2Next = null;
				DblListnode<String> pos2Prev = null;
				DblListnode<String> current = null;
				while (x < 1) {
					for (DblListnode<String> item : items) {
						if (x == 0) {
							current = item;
						}
						x++;
					}
				}

				for (int i = 0; i < items.size(); i++) {
					System.out.println("current");
					System.out.println(current.getData());
					if (i == lowNum) {
						if (i != 0) {
							pos1Prev = current.getPrev();
						}
						pos1Next = current.getNext();
						pos1El = current;
					}

					if (i == highNum) {

						if (current.getNext() != null) {
							pos2Next = current.getNext();
							pos2Next.setPrev(pos1El);
						}
						pos2Prev = current.getPrev();
						if (pos2Prev != null) {
							pos2Prev.setNext(pos1El);
						}
						current.setNext(pos1Next);
						current.setPrev(pos1Prev);
						if (pos1Prev != null) {
							pos1Prev.setNext(current);
						}
						if (pos2Prev != null) {
							pos1Next.setPrev(current);
						}
						pos1El.setNext(pos2Next);
						pos1El.setPrev(pos2Prev);
					}

					current = current.getNext();
				}
			}

		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public static void main(String[] args) {
		LinkedList<DblListnode<String>> items = new LinkedList<DblListnode<String>>();
		DblListnode<String> e = new DblListnode<String>("cluck");
		DblListnode<String> f = new DblListnode<String>("oink");
		DblListnode<String> g = new DblListnode<String>("moo");
		DblListnode<String> h = new DblListnode<String>("meow");
		items.add(e);
		items.add(f);
		items.add(g);
		items.add(h);
		// items.add(f);

		System.out.println("Original Linked List");
		System.out.println();
		for (DblListnode<String> item : items) {
			System.out.println(item.getData());
		}

		swap(1, 3, items);
		System.out.println();
		System.out.println("After Swapped Linked List");
		System.out.println();
		for (DblListnode<String> item : items) {
			System.out.println(item.getData());
			if (item.getPrev() != null) {
				System.out.println("previous");
				System.out.println(item.getPrev().getData());
				System.out.println("end previous");
			}
		}

		// Iterator<DblListnode<String>> itr = items.iterator();
		//
		// while(itr.)
		Scanner stdin = new Scanner(System.in); // for reading console input

		// *** Add code for steps 1 - 3 of the main method ***
		boolean done = false;
		EmployeeDatabase data = new EmployeeDatabase();// creating database
		if (args.length == 1) {
			File file = new File(args[0]);// reading input file
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					// converting .txt file into List<String>
					List<String> details = new ArrayList<String>(Arrays.asList(line.split(",")));
					// obtaining employee name
					String employeeName = details.get(0).toLowerCase().trim();
					List<String> destinations = new ArrayList<String>(details.subList(1, details.size()));
					data.addEmployee(employeeName);// adding employee to
													// database
					Iterator<String> destItr = destinations.iterator();// destinations
																		// iterator
					while (destItr.hasNext()) {
						String dest = destItr.next().toLowerCase();
						data.addDestination(employeeName, dest);// making
																// wishlists
					}

				}
				sc.close();
				printOptions();
			} catch (FileNotFoundException e1) {
				System.out.println("Error: Cannot access input file");
				done = true;
			}
		} else {
			System.out.println("Please provide input file as command-line argument");
			done = true;
		}

		while (!done) {
			System.out.print("Enter option ( dfhisqr ): ");
			String input = stdin.nextLine();

			input = input.toLowerCase(); // convert input to lower case

			// only do something if the user enters at least one character
			if (input.length() > 0) {
				char choice = input.charAt(0); // strip off option character

				String remainder = ""; // used to hold the remainder of input
				if (input.length() > 1) {
					// trim off any leading or trailing spaces
					remainder = input.substring(1).trim();
				}

				switch (choice) {

				case 'd':
					// *** Add code to implement this option ***
					EmployeeDatabase.removeDestination(remainder);
					//
					break;

				case 'f':
					// *** Add code to implement this option ***
					EmployeeDatabase.getDestinations(remainder);
					break;

				case 'h':
					printOptions();
					break;

				case 'i':
					// *** Add code to implement this option ***
					System.out.print("Employees:" + data.size() + ", ");
					DatabaseHelper.getDestinationInfo();
					break;

				case 's':
					// *** Add code to implement this option ***
					EmployeeDatabase.getEmployees(remainder);
					break;

				case 'q':
					done = true;
					System.out.println("quit");
					break;

				case 'r':
					// *** Add code to implement this option ***
					EmployeeDatabase.removeEmployee(remainder);
					break;

				default: // ignore any unknown commands
					// handling for bad input
					System.out.println("Please provide input file as command-line argument");
					break;
				}
			}
		}

		stdin.close();

	}

	/**
	 * Prints the list of command options along with a short description of one.
	 * This method should not be modified.
	 */
	private static void printOptions() {
		System.out.println("d <destination> - discontinue the given <destination>");
		System.out.println("f <Employee> - find the given <Employee>");
		System.out.println("h - display this help menu");
		System.out.println("i - display information about this Employee database");
		System.out.println("s <destination> - search for the given <destination>");
		System.out.println("q - quit");
		System.out.println("r <Employee> - remove the given <Employee>");
	}

}