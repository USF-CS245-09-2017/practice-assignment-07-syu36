/**
 *
 * A list of <Type> that is able to grow in size as the user adds more elements to the list.
 *
 * @param <T> The type of the ArrayList
 */
public class ArrayList<T> implements List<T> {
	private T[] arr;
	private int size;

	@SuppressWarnings("unchecked")
	/**
	 * Initializes the array with an initial array size of 10 and num of elements as 0.
	 */
	public ArrayList() {
		arr = (T[]) new Object[10];
		size = 0;
	}

	@Override
	public void add(T item) {
		if (size == arr.length) {
			growArray();
		}

		arr[size++] = item;
	}

	@Override
	public void add(int pos, T item) {
		try {
			Assert.notFalse(pos >= 0 || pos <= size);
		} catch (Exception e) {
			System.err.println("Invalid index. Current size of ArrayList: " + size);
		}

		if (pos == arr.length) {
			growArray();
		}

		for (int i = size; i > pos; i--) {
			arr[i] = arr[i - 1];
		}

		size++;
		arr[pos] = item;
	}

	@Override
	public T get(int pos) {
		try {
			Assert.notFalse(pos >= 0 || pos < size);
		} catch (Exception e) {
			System.err.println("Invalid Index: " + pos + ". Size of array: " + size);
		}

		return arr[pos];
	}

	@Override
	public T remove(int pos) {
		try {
			Assert.notFalse(pos >= 0 || pos < size);
		} catch (Exception e) {
			System.err.println("Invalid Index: " + pos + ". Size of array: " + size);
		}

		T temp = arr[pos];

		for (int i = pos; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		size--;

		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Doubles the size of the array and copies over all of the old array to the new array.
	 */
	private void growArray() {
		T[] temp = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

}
