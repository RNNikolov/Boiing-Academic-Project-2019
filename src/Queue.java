
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueElement<T> head;
	private QueueElement<T> tail;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty() {
		return ((head == null) && (tail == null));
	}

	/**
	 * Returns the element at the head of the queue
	 */
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			return head.getElement();
		}
	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		} else {
			this.head = this.head.getNext();
			if (this.head == null) {
				this.tail = null;
			}
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue(T element) {
		QueueElement<T> newLink = new QueueElement<T>(element, null);
		if (isEmpty()) {
			this.head = this.tail = newLink;

		} else {
			if (this.head == this.tail) {
				this.head.setNext(newLink);
				this.tail.setNext(newLink);
				this.tail = newLink;
			} else {
				this.tail.setNext(newLink);
				this.tail = newLink;
			}

		}
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print() {
		if (isEmpty()) {
			System.out.println("The queue is empty!");
		} else {
			QueueElement<T> currItem = this.head;
			while (currItem != null) {
				System.out.println(currItem.getElement());
				currItem = currItem.getNext();

			}
		}
	}
}
