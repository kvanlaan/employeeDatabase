package ProgramPackage;

/**
 * In this program the DblListnode class is used to populate the LinkedLoop
 * class and takes the Image class as Data.
 * 
 * @author Beck Hasti/Charles Fischer, CS 367 instructor, copyright 2014-2016
 */
public class DblListnode<E> {

	private DblListnode<E> prev;
	private E data;
	private DblListnode<E> next;

	// *** constructors ***
	public DblListnode() {
		this(null, null, null);
	}

	public DblListnode(E d) {
		this(null, d, null);
	}

	public DblListnode(DblListnode<E> p, E d, DblListnode<E> n) {
		prev = p;
		data = d;
		next = n;
	}

	public E getData() {
		return data;
	}

	public DblListnode<E> getNext() {
		return next;
	}

	public DblListnode<E> getPrev() {
		return prev;
	}

	public void setData(E d) {
		data = d;
	}

	public void setNext(DblListnode<E> n) {
		next = n;
	}

	public void setPrev(DblListnode<E> p) {
		prev = p;
	}
}
