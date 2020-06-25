
public class QueueFactory {

	public static IQueue getQueue(String queueType)
	{
		if(queueType == null)
		{
			return null;
		}
		else if(queueType.equalsIgnoreCase("Dynamic"))
		{
			return new DynamicQueue();
		}
		else if(queueType.equalsIgnoreCase("Bounded"))
		{
			return new BoundedQueue(100);
		}
		else 
		{
			return new Queue();
		}
	}
}
