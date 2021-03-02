package linkedLists;

/** A class representing a linked list. */
public class LinkedList {
	private Node head, tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	/** Inserts a new node to the front of the list */
	public void insertAtFront(int elem) {
		Node newNode = new Node(elem);
		if (head != null) {
			newNode.setNext(head);
		} else {
			tail = newNode;
		}
		head = newNode;
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			head = tail = newNode;
		}

	}

	/** Prints all the nodes in the link list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.elem() + " ");
			current = current.next();
		}

	}

	/** Return true if the given element is in the list */
	public boolean find(int elem) {
		Node current = head;
		while (current != null) {
			if (current.elem() == elem) {
				return true;
			}
			current = current.next();
		}
		return false;
	}

	/**
	 * Remove the node after "previousNode". Return the value of the element at
	 * the deleted node
	 */
	public int remove(Node previousNode) {
		if ((previousNode == null) || (previousNode.next() == null)) {
			System.out.println("Nothing to remove");
			return Integer.MAX_VALUE;
		}
		int elem = previousNode.next().elem();

		// if removing the tail
		if (previousNode.next() == tail) {
			tail = previousNode;
			tail.setNext(null);

		} else {
			// delete node
			previousNode.setNext(previousNode.next().next());
		}

		return elem;
	}


	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtFront(40);
		list.insertAtFront(15);
		list.insertAtFront(34);
		list.printNodes();
	}

}
