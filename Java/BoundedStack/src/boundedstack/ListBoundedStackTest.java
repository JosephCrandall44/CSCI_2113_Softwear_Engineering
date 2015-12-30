package boundedstack;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ListBoundedStackTest {

    // Create some private (list-based) bounded stack variables
    
    private BoundedStack<String> s0;
    private BoundedStack<String> s1;
    private BoundedStack<String> s2;
    
    @Before
    public void setUp() throws Exception {
        
        s0 = new ListBoundedStack<>(5);
        s1 = new ListBoundedStack<>(5);
        s2 = new ListBoundedStack<>(10);
        s1.push("hello");
        s2.push("hello");
        s2.push("world");
        
    }

    // test that the constructor works
    
    @Test
    public void stackTest() {
        assertThat(s0.depth(), is(equalTo(0)));
        assertThat(s0.capacity(), is(equalTo(5)));
    }
    
    // test that the constructor illegal-argument-exception works
    
    @Test
    public void stackIllegalArgumentTest() {
        try {
            s0 = new ListBoundedStack<>(-10);
            fail("Should throw an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
        
        try {
            s0 = new ListBoundedStack<>(0);
            fail("Should throw an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
    
    // test that the push method works
    
    @Test
    public void pushTest() {
        assertThat(s1.depth(), is(equalTo(1)));
        assertThat(s1.capacity(), is(equalTo(5)));
        assertThat(s2.depth(), is(equalTo(2)));
        assertThat(s2.capacity(), is(equalTo(10)));
    }
    
    // test that the push null-pointer-exception works
    
    @Test
    public void pushNullPointerTest() {
        try {
            s0.push(null);
            fail("Should throw a NullPointerException.");
        } catch (NullPointerException e) {
            // success
        }
    }
    
    // test that the push illegal-state-exception works
    
    @Test
    public void pushIllegalStateTest() {
        s0.push("one");
        s0.push("two");
        s0.push("three");
        s0.push("four");
        s0.push("five");
        try {
            s0.push("six");
            fail("Should throw an IllegalStateException.");
        } catch (IllegalStateException e) {
            // success
        }
    }    
    
    // test that the pop method works
    
    @Test
    public void popTest() {
        String s = s1.pop();
        assertThat(s1.depth(), is(equalTo(0)));
        assertThat(s1.capacity(), is(equalTo(5)));
        assertThat(s, is(equalTo("hello")));

        s = s2.pop();
        assertThat(s2.depth(), is(equalTo(1)));
        assertThat(s2.capacity(), is(equalTo(10)));
        assertThat(s, is(equalTo("world")));
    }
    
    // test that the pop illegal-state-exception works
    
    @Test
    public void popIllegalStateTest() {
        try {
            s0.pop();
            fail("Should throw an IllegalStateException.");
        } catch (IllegalStateException e) {
            // success
        }        
    }
    
    // test that the equals method works
    
    @Test
    public void equalsTest() {
        assertThat(s0, is(not(equalTo(s1))));
        assertThat(s1, is(not(equalTo(s2))));
        s0.push("hello");
        assertThat(s0, is(equalTo(s1)));
        s1.push("world");
        assertThat(s1, is(not(equalTo(s2))));
    }
    
    // test that the toString method works
    
    @Test
    public void toStringTest() {
        assertThat(s0.toString(), is(equalTo("[ ]:5")));
        assertThat(s1.toString(), is(equalTo("[ hello ]:5")));
        assertThat(s2.toString(), is(equalTo("[ hello world ]:10")));
    }
    
}