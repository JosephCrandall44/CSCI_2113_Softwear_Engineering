package boundedstack;

import java.util.*;

public class ArrayBoundedStack<E> implements BoundedStack<E> {
		
	 private E[] array;
	 private int size;
	    
	    public ArrayBoundedStack(int max) throws IllegalArgumentException {
	        if (max <= 0)
	            throw new IllegalArgumentException();
	        array = (E[]) new Object[max];
	        size = 0;
	    }
	    
	    @Override
	    public Iterator<E> iterator() {
	        return Arrays.asList(array).iterator();
	    }
	    
	    @Override
	    public void push(E element) throws NullPointerException,
	            IllegalStateException {
	        if (element == null) throw new NullPointerException();
	        if (array.length == size) throw new IllegalStateException();
	        array[size] = element;
	        size++;
	    }

	    @Override
	    public E pop() throws IllegalStateException {
	        if (size == 0) throw new IllegalStateException();
	        size--;
	        E element = array[size];
	        array[size] = null;
	        return element;
	    }

	    @Override
	    public int depth() {
	        return size;
	    }

	    @Override
	    public int capacity() {
	        return array.length;
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (o == this)
	            return true;
	        if (!(o instanceof BoundedStack))
	            return false;
	        BoundedStack bs = (BoundedStack) o;
	        if (this.depth() != bs.depth()) return false;
	        if (this.capacity() != bs.capacity()) return false;
	        Iterator e = bs.iterator();
	        for(int i = 0 ; i < size ; i++){
	        	Object ob = e.next();
	        	if (!(ob.equals(array[i]))) return false;
	        }return true;
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("[ ");
	        for (int i = 0; i<size;i++) {
	            sb.append(array[i].toString());
	            sb.append(" ");
	        }
	        sb.append("]:");
	        sb.append(capacity());
	        return sb.toString();
	    }

}
