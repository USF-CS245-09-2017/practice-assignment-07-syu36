/**
 *
 * A list that uses nodes and links to other nodes. Grows and shrinks as necessary.
 *
 * @param <T> The type of the LinkedList
 */
public class LinkedList<T> implements List<T> {
	private int size;
	private Node<T> head;

	/**
	 * Initializes the head of the LinkedList to a null value and the number of elements to 0.
	 */
	public LinkedList(){
		size = 0;
		head = null;
	}

	@Override
	public void add(T item) {
		if (head == null) {
			Node<T> newNode = new Node<T>(item);
			head = newNode;
		} else {
			Node<T> prev = head;

			for(int i = 0; i < size - 1; i++) {
				prev = prev.getNext();
			}

			Node<T> newNode = new Node<T>(item);
			prev.setNext(newNode);
		}

		size++;
	}

	@Override
	public void add(int position, T item) {
		try {
			Assert.notFalse(position >= 0 && position <= size);
		} catch (Exception e) {
			System.err.println("Invalid index. Current size of ArrayList: " + size);
		}

		if (position == 0) {
			Node<T> newNode = new Node<T>(item);
			newNode.setNext(head);
			head = newNode;
		} else {
			Node<T> prev = head;

			for (int i = 0; i < position - 1; i++) {
				prev = prev.getNext();
			}

			Node<T> newNode = new Node<T>(item);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}

		size++;
	}

	@Override
	public T get(int pos) {
		try {
			Assert.notFalse(pos >= 0 && pos < size);
		} catch (Exception e) {
			System.err.println("Invalid Index: " + pos + ". Size of array: " + size);
		}

		Node<T> node = head;

		for(int i = 0; i < pos; i++) {
			node = node.getNext();
		}

		return node.getData();
	}

	@Override
	public T remove(int pos) {
		try {
			Assert.notFalse(pos >= 0 && pos < size);
		} catch (Exception e) {
			System.err.println("Invalid Index: " + pos + ". Size of array: " + size);
		}

		if (pos == 0) {
			Node<T> node = head;
			head = head.getNext();
			size--;
			return node.getData();
		}

		Node<T> prev = head;

		for(int i = 0; i < pos - 1; i++) {
			prev = prev.getNext();
		}

		Node<T> removed = prev.getNext();
		prev.setNext(removed.getNext());
		size--;
		return removed.getData();

	}

	@Override
	public int size() {
		return this.size;
	}
}