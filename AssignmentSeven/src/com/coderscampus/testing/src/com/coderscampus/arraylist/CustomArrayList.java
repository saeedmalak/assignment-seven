package com.coderscampus.testing.src.com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	Integer size = 0;

	@Override
	public boolean add(T item) {
		// double the size of our Object if the array is full
		if (size == items.length) {
			expandBackingObjectArray();
		}
		items[size++] = item;
		return true;
	}

	private void expandBackingObjectArray() {
		Object[] oldArray = items;
		items = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			items[i] = oldArray[i];
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException("You went out of bounds, enter a valid index");
		return (T) items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException("You went out of bounds, enter a valid index");
		addElementAndShiftArray(index, item);
		size++;
		return true;
	}

	private void addElementAndShiftArray(int index, T item) {
		Object[] oldArray = items;
		items = new Object[size + 1];
		for (int i = size; i >= 0; i--) {
			if (i > index) {
				// Shift all elements over to the right by one until new 'index' value
				items[i] = oldArray[i - 1];
			} else if (i == index) {
				// Add the new item at the requested index
				items[i] = item;
			} else if (i < index) {
				// copy everything else as is from the old array
				items[i] = oldArray[i];
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index >= size)
			throw new IndexOutOfBoundsException("You went out of bounds, enter a valid index");
		removeElementAndShiftArray(index);
		size--;
		return (T) items[index];
	}

	private void removeElementAndShiftArray(int index) {
		Object[] oldArray = items;
		items = new Object[size - 1];
		for (int i = 0; i < size-1; i++) {
			if (i < index) {
				// copy everything as is from the current array until the 'index' value
				items[i] = oldArray[i];
			} else {
				// shift everything else over to the left by one until the new reduced size of the array
				items[i] = oldArray[i + 1];
			}
		}
	}
	

}
