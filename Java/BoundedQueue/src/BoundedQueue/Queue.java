package BoundedQueue;

/**
 * A bounded first-in first-out sequence of non-null elements.
 * 
 * @param <E>
 *            the type of elements in this queue
 */
public interface Queue<E> extends Iterable<E> {

	// ==========================================================
	// Primary methods (implemented using instance variables)
	// ==========================================================

	/**
	 * Adds the specified element to the end of this queue.
	 * 
	 * @param element
	 *            element to be added to this queue
	 * @throws NullPointerException
	 *             if the specified element is null
	 * @throws IllegalStateException
	 *             if the queue is already at capacity
	 */
	public void enqueue(E element) throws NullPointerException,
			IllegalStateException;

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return element at the front of this queue
	 * @throws IllegalStateException
	 *             if the queue is empty
	 */
	public E dequeue() throws IllegalStateException;

	/**
	 * Returns the length of this queue.
	 * 
	 * @return the length of this queue
	 */
	public int length();

	/**
	 * Returns the maximum number of elements that are allowed in this queue.
	 * 
	 * @return the capacity of this queue
	 */
	public int capacity();

	/**
	 * Returns a new instance of a queue object. This queue does not change. The
	 * new queue object is empty and has the same capacity as this queue.
	 * 
	 * @return a new instance of a queue object
	 */
	public Queue<E> newInstance();

	// ==========================================================
	// Secondary methods (implemented using primary methods)
	// ==========================================================

	/**
	 * Clears this queue. The queue becomes empty.
	 */
	public void clear();

	/**
	 * Returns true if this queue is empty, false otherwise.
	 * 
	 * @return true if this queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Appends the elements of the specified queue to this queue and clears the
	 * specified queue.
	 * 
	 * @param that
	 *            the queue that is appended to this queue
	 */
	public void append(Queue<E> that)throws IllegalStateException;

	/**
	 * Copies the elements of this queue to a new queue and returns the new
	 * queue.
	 */
	public Queue<E> copy();
}

