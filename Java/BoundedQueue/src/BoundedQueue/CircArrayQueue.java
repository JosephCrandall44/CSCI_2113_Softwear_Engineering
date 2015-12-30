package BoundedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A bounded queue based on a circular array implementation.
 * 
 * @param <E>
 *            the type of elements in this queue
 */
public class CircArrayQueue<E> extends AbstractQueue<E> {

	private E[] elements;
	private int front;
	private int size;
	private final int capacity;

	/**
	 * Constructs a new queue with the specified capacity.
	 * 
	 * @param capacity
	 *            the maximum capacity that this queue can hold
	 * @throws IllegalArgumentException
	 *             if the specified capacity is strictly less than 0
	 */
	@SuppressWarnings("unchecked")
	public CircArrayQueue(int capacity) throws IllegalArgumentException {
		if (capacity < 1)
			throw new IllegalArgumentException();
		elements = (E[]) new Object[capacity];
		front = 0;
		size = 0;
		this.capacity = capacity;
	}

	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	public void enqueue(E element) throws IllegalStateException, NullPointerException {
		if(size == capacity){
			throw new IllegalStateException();
		}
		if(null == element){
			throw new NullPointerException();
		}
		elements[(front + size) % capacity] = element;
		size++;
		
	}

	public E dequeue() throws IllegalStateException {
		if (size == 0){
			throw new IllegalStateException();
		}
		E temp = elements[front];
		 elements[front] = null;
		 front = ((front+1) % capacity);
		 size--;
		return temp;
	}

	public int length() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	public Queue<E> newInstance() {
		return new CircArrayQueue<>(capacity);
	}

	// ==========================================================
	// QueueIterator inner class (do not modify this code)
	// ==========================================================

	/**
	 * An iterator for circular-array-based queues in which the elements are
	 * returned in the order they appear in the queue (from front to back).
	 */
	class QueueIterator implements Iterator<E> {

		private int index;
		private int count;

		/**
		 * Constructs an iterator for queue. The elements are returned in the
		 * order they appear in the queue (from front to back).
		 */
		public QueueIterator() {
			index = front;
			count = 0;
		}

		public boolean hasNext() {
			return count < size;
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			count++;
			E result = elements[index];
			index = (index + 1) % capacity;
			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
