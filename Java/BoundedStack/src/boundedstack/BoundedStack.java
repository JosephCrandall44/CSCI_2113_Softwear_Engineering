package boundedstack;

/**
 * A bounded stack is a LIFO stack of non-null elements.
 * 
 * Implementations of this interface have a one-argument constructor
 * that takes an integer (max) which denotes the maximum capacity
 * of the stack. If max is less than or equal to zero the constructor
 * should throw an IllegalArgumentException.
 * 
 * The equals method for bounded stack should return true if and only if
 * the two stacks have the same depth and the same elements in the same
 * order. Elements e1 and e2 are equal if e1.equals(e2). Two bounded
 * stacks are NOT equal if they have different capacities.
 * 
 * The toString method for bounded stack should return stack elements
 * separated by spaces and surrounded by square brackets. The elements
 * of the stack should printed in order from left to right starting with
 * the bottom element and ending with the top element. After the final
 * bracket should be a colon followed by the stack's capacity.
 * 
 * toString examples:
 * [ ]:10 - denotes the empty stack whose capacity is 10
 * [ hello world ]:20 - denotes a stack with two elements, where "world"
 * is the top element, and the stack has a capacity of 2 0
 *
 * @param <E> the type of elements in the stack
 */
public interface BoundedStack<E> extends Iterable<E> {
    
    /**
     * Adds the specified element to the top of the stack.
     * 
     * @param element the element to be added to the stack
     * @throws NullPointerException when the specified element is null
     * @throws IllegalStateException when the stack is full
     */
    public void push(E element) throws NullPointerException, IllegalStateException;
    
    /**
     * Removes and returns the top element in the stack.
     * 
     * @return the top element in the stack
     * @throws IllegalStateException when the stack is empty
     */
    public E pop() throws IllegalStateException;
    
    /**
     * Returns the number of elements on the stack.
     * 
     * @return the number of elements on the stack
     */
    public int depth();
    
    /**
     * Returns the maximum number of elements that the stack can hold.
     * 
     * @return the maximum number of elements the stack can hold
     */
    public int capacity();

}