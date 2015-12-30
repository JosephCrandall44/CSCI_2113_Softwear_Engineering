package BoundedQueue;

import java.util.Iterator;


public abstract class AbstractQueue<E> implements Queue<E> {
	
	public void clear() {
		while(length()!= 0){
			dequeue();
		}
	}

	public boolean isEmpty() {
		if(length() == 0){
			return true;
		}else return false;
	}

	public void append(Queue<E> that) throws IllegalStateException {
		if(capacity() < that.length() + length()){
			throw new IllegalStateException();
		}
		while(that.length() != 0){
			E temp = that.dequeue();
			enqueue(temp);
		}
	}

	public Queue<E> copy() {
		Queue<E> tempQueue = newInstance(); //generic
		Iterator<E> e = iterator();
		while(e.hasNext()){  // will end when hasnext passes false
			E temp = e.next();
			tempQueue.enqueue(temp);
		}
		return tempQueue;
	}

	// ==========================================================
	// Methods from Object (do not modify this code)
	// ==========================================================

	/**
	 * Compares the specified object with this queue for equality. Returns if
	 * and only if the specified object is also a queue, both queues have the
	 * same size, and all corresponding pairs of elements in the two lists are
	 * equal. Two elements e1 and e2 are equal if e1.equals(e2). In other words,
	 * two queues are equal if they contain the same elements in the same order.
	 *
	 * @param o
	 *            the object to be compared for equality with this queue
	 * 
	 * @return true if the specified object is equal to this queue
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Queue))
			return false;

		Queue<?> that = (Queue<?>) o;

		if (this.length() != that.length())
			return false;
		if (this.capacity() != that.capacity())
			return false;

		Iterator<E> e1 = iterator();
		Iterator<?> e2 = that.iterator();
		while (e1.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1.equals(o2)))
				return false;
		}
		return true;
	}

	/**
	 * Returns the hash code value for this queue.
	 *
	 * @return the hash code value for this queue
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;
		for (E element : this) {
			hashCode = 31 * hashCode + element.hashCode();
		}
		return hashCode;
	}

	/**
	 * Returns the string representation of this queue. The string begins and
	 * ends with a square bracket, and contains the string representation of
	 * each element (in order) separated by a comma and a space.
	 * 
	 * For example, [] represents the empty queue, and [a, b, c] represents a
	 * queue containing strings "a", "b", and "c" in that order.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		Iterator<E> iter = iterator();
		while (iter.hasNext()) {
			E elem = iter.next();
			sb.append(elem.toString());
			sb.append(" ");
		}
		sb.append("]");
		sb.append(":" + capacity());
		return sb.toString();
	}

}
