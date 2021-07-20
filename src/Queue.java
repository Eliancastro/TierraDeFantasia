
public interface Queue<T> {
	
	public boolean isEmpty();
	
	public void enqueue(T newItem);
	
	public T dequeue();
	
	public T peek();
		
	

}
