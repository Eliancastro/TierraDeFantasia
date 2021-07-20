import java.util.NoSuchElementException;
import java.util.Stack;

public class Cola<T> implements Queue<T> {
	
	private Stack<T> pilaA = new Stack<T>();
	private Stack<T> pilaB = new Stack<T>();

	@Override
	public boolean isEmpty() {
		return (pilaA.isEmpty() && pilaB.isEmpty());
	}

	@Override
	public void enqueue(T newItem) {
		pilaA.push(newItem);
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		if (this.isEmpty()) {
	           throw new NoSuchElementException();
	       }
		
		if(pilaB.isEmpty())
			pasarTodoAB();
					
		return pilaB.pop();
		
	}

	private void pasarTodoAB() {
			while(!this.pilaA.isEmpty())
			this.pilaB.push(this.pilaA.pop());
	
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (this.isEmpty()) {
	           throw new NoSuchElementException();
	       }
		
		if(pilaB.isEmpty())
			pasarTodoAB();
		
		return pilaB.peek();
	}

}