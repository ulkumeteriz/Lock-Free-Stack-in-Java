import java.util.concurrent.atomic.AtomicReference;

public class Node<T>
{

	public Node()
	{
		element = null;
		next = new AtomicReference<Node<T>>(null);
	}
	public Node(T e, AtomicReference<Node<T>> n)
	{
		element = e;
		next = n;
	}
	public Node(T e)
	{
		element = e;
		next = new AtomicReference<Node<T>>();
	}
	
	public T element;
	public AtomicReference<Node<T>> next;
		
}
