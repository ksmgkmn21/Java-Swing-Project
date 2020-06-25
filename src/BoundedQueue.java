import jdk.nashorn.internal.ir.Flags;

public class BoundedQueue implements IQueue {
	private int front;
	private int rear;
	private User[] contents;

	public BoundedQueue(int cap) {
		front = rear = 0;
		contents = new User[cap];
	}

	@Override
	public void enqueue(User item) throws QueueFull {
		if (isFull())
			throw new QueueFull();

		contents[rear] = item;
		rear = (rear + 1) % contents.length;

	}

	@Override
	public User peek() throws QueueEmpty {
		if (isEmpty())
			throw new QueueEmpty();

		return contents[front];
	}

	@Override
	public User dequeue() throws QueueEmpty {
		if (isEmpty())
			throw new QueueEmpty();

		User retVal = contents[front];
		contents[front] = null;
		front = (front + 1) % contents.length;
		
		return retVal;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == front;
	}
	
	public boolean isFull()
	{
		return front == (rear + 1) % contents.length;
	}

	@Override
	public String toString()
	{
		int size = (rear - front + contents.length) % contents.length;
		
		String retString = "<" + size + ">\n<font:\n";
		
		for(int i=front; i!= rear; i= (i+1) % contents.length)
		{
			retString += contents[i] + "\n";
		}
		
		retString += ":rear>";
		
		return retString;
	}

	@Override
	public boolean contains(User user) {
		boolean flag = false;
		for (int i = 0; i < contents.length; i++) 
		{
			if(contents[i] == user)
				flag = true;
		}
		return flag;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return contents.length;
	}
	
	
	
}











