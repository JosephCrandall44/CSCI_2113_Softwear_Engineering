package boundedstack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListBoundedStack<E> implements BoundedStack<E> {

    private List<E> list;
    private final int capacity;

    public ListBoundedStack(int max) throws IllegalArgumentException {
        if (max <= 0)
            throw new IllegalArgumentException();
        list = new ArrayList<>();
        //System.out.println(max);
        capacity = max;
        //System.out.println(capacity);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public void push(E element) throws NullPointerException,
            IllegalStateException {
        if (element == null) throw new NullPointerException();
        if (list.size() == capacity) throw new IllegalStateException();
        list.add(element);
    }

    @Override
    public E pop() throws IllegalStateException {
        if (list.isEmpty()) throw new IllegalStateException();
        return list.remove(list.size() - 1);
    }

    @Override
    public int depth() {
        return list.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BoundedStack))
            return false;

        BoundedStack that = (BoundedStack) o;
        
        if (this.depth() != that.depth()) return false;
        if (this.capacity() != that.capacity()) return false;
        
        Iterator<E> e1 = iterator();
        Iterator e2 = that.iterator();
        while (e1.hasNext()) {
            E o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1.equals(o2))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (E elem : list) {
            sb.append(elem.toString());
            sb.append(" ");
        }
        sb.append("]:");
        sb.append(capacity());
        return sb.toString();
    }

}