import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue implements IQueue 
{

	private java.util.Queue contents;
	
	public Queue(boolean isPriority)
	{
		if(isPriority)
			contents = new PriorityQueue();
		else
			contents = new LinkedList();
	}
	
	public Queue(Comparator comp)
	{
		contents = new PriorityQueue(comp);
	}
	
	public Queue()
	{
		contents = new LinkedList();
	}
	
	@Override
	public void enqueue(User item) 
	{
		contents.add(item);

	}

	@Override
	public User peek() throws QueueEmpty 
	{
		if (isEmpty())
			throw new QueueEmpty();

		return (User) contents.peek();
	}

	@Override
	public User dequeue() throws QueueEmpty {
		
		if (isEmpty())
			throw new QueueEmpty();

		return (User) contents.poll();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contents.size() == 0;
	}
	
	@Override
	public String toString()
	{
		int size = contents.size();
		
        String retString = "<" + size + ">\n<font:\n";
		
        
        if(contents.getClass().getName().equals("java.util.LinkedList"))
        {
        	Object[] tempArr = contents.toArray();
        	
        	for(int i=0; i<size; i++)
    		{
    			retString += tempArr[i] + "\n";
    		}
        	
        }
        else
        {
        	PriorityQueue temp_pq= new PriorityQueue(contents);
        	while(!temp_pq.isEmpty())
        	{
        		retString += temp_pq.poll() + "\n";
        	}
        	
        }        
        		
		retString += ":rear>";
		
		return retString;
	}

	@Override
	public boolean contains(User user) {
		if(contents.contains(user))
			return true;
		return  false;
	}

	@Override
	public int size() {
		
		return  contents.size();
	}
	

}















