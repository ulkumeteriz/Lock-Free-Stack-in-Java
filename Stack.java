import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Stack<T> {
		
	public Stack()
	{
		// Create a dummy head node.
		Node<T> headNode = new Node<T>();
		
		// Create an AtomicReference to the dummy head node.
		head = new AtomicReference<Node<T>>(headNode);
		
		// Create a new AtomicInteger and initialize it with 0.
		numberOfOperations = new AtomicInteger(0);
	}
	
	public T Pop()
	{
		// If element of head is null, return null.
		// INFO: Atomic read.
		if(head.get().element == null)
			return null;
		Node<T> temp;
		// Try to pop the head element.
		while(true)
		{
			// Get a local reference to current head. 
			// INFO: Atomic read.
			temp = head.get();
			
			// If head is not change until here, set it to its next.
			if(head.compareAndSet(temp, temp.next.get()))
			{
				// Increment the number of operations.
				numberOfOperations.incrementAndGet();
				
				// Return the popped element.
				return temp.element;
			}
		}
	}
	
	public boolean Push(T newElement)
	{
		// Create a new node by only specifying its element.
		Node<T> newNode = new Node<T> (newElement);
		
		// Trying to push the new node to the stack.
		while(true)
		{
			// Get a local reference to current head. 
			// INFO: Atomic read.
			Node<T> temp = head.get();
			
			// Set the next of the newNode as temp.
			newNode.next.set(temp);
			
			// If the head is not changed until here, set it to the newNode.
			if(head.compareAndSet(temp, newNode))
			{
				// Increment the number of operations.
				numberOfOperations.incrementAndGet();
				return true;
			}
		}
	}
		
	public AtomicReference<Node<T>> head;
	public AtomicInteger numberOfOperations;
}
