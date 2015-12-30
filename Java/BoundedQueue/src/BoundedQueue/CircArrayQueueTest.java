package BoundedQueue;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class CircArrayQueueTest {

	// Create some private (list-based) bounded stack variables

	private Queue<String> q0;
	private Queue<String> q1;
	private Queue<String> q2;

	@Before
	public void setUp() throws Exception {

		q0 = new CircArrayQueue<>(5);
		q1 = new CircArrayQueue<>(5);
		q2 = new CircArrayQueue<>(10);
		q1.enqueue("hello");
		q2.enqueue("hello");
		q2.enqueue("world");

	}

	// test that the constructor works

	@Test
	public void stackTest() {
		assertThat(q0.length(), is(equalTo(0)));
		assertThat(q0.capacity(), is(equalTo(5)));
	}

	// test that the constructor illegal-argument-exception works

	@Test
	public void stackIllegalArgumentTest() {
		try {
			q0 = new CircArrayQueue<>(-10);
			fail("Should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			// success
		}

		try {
			q0 = new CircArrayQueue<>(0);
			fail("Should throw an IllegalArgumentException.");
		} catch (IllegalArgumentException e) {
			// success
		}
	}

	// test that the enqueue method works

	@Test
	public void enqueueTest() {
		assertThat(q1.length(), is(equalTo(1)));
		assertThat(q1.capacity(), is(equalTo(5)));
		assertThat(q2.length(), is(equalTo(2)));
		assertThat(q2.capacity(), is(equalTo(10)));
	}

	// test that the enqueue null-pointer-exception works

	@Test
	public void enqueueNullPointerTest() {
		try {
			q0.enqueue(null);
			fail("Should throw a NullPointerException.");
		} catch (NullPointerException e) {
			// success
		}
	}

	// test that the enqueue illegal-state-exception works

	@Test
	public void enqueueIllegalStateTest() {
		q0.enqueue("one");
		q0.enqueue("two");
		q0.enqueue("three");
		q0.enqueue("four");
		q0.enqueue("five");
		try {
			q0.enqueue("six");
			fail("Should throw an IllegalStateException.");
		} catch (IllegalStateException e) {
			// success
		}
	}

	// test that the dequeue method works

	@Test
	public void dequeueTest() {
		String s = q1.dequeue();
		assertThat(q1.length(), is(equalTo(0)));
		assertThat(q1.capacity(), is(equalTo(5)));
		assertThat(s, is(equalTo("hello")));

		s = q2.dequeue();
		assertThat(q2.length(), is(equalTo(1)));
		assertThat(q2.capacity(), is(equalTo(10)));
		assertThat(s, is(equalTo("hello")));
	}

	// test that the dequeue illegal-state-exception works

	@Test
	public void dequeueIllegalStateTest() {
		try {
			q0.dequeue();
			fail("Should throw an IllegalStateException.");
		} catch (IllegalStateException e) {
			// success
		}
	}

	// test that the equals method works

	@Test
	public void equalsTest() {
		assertThat(q0, is(not(equalTo(q1))));
		assertThat(q1, is(not(equalTo(q2))));
		q0.enqueue("hello");
		assertThat(q0, is(equalTo(q1)));
		q1.enqueue("world");
		assertThat(q1, is(not(equalTo(q2))));
	}

	// test that the toString method works

	@Test
	public void toStringTest() {
		assertThat(q0.toString(), is(equalTo("[ ]:5")));
		assertThat(q1.toString(), is(equalTo("[ hello ]:5")));
		assertThat(q2.toString(), is(equalTo("[ hello world ]:10")));
	}
	
	@Test
	public void newInstanceTest(){
		assertThat(q0.newInstance().toString(), is(equalTo("[ ]:5")));
		assertThat(q1.newInstance().toString(), is(equalTo("[ ]:5")));
		assertThat(q2.newInstance().toString(), is(equalTo("[ ]:10")));
		
	}
}
