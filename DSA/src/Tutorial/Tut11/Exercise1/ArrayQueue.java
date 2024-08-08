/**
 * Class ArrayQueue implements an array-based queue data structure. Each element of the queue is an integer.
 * Please refer to Lecture 7 for the array-based queue ADT in detail. 
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tutorial.Tut11.Exercise1;
public class ArrayQueue
{
    private int[] items;
    private static final int maxSize=10000;
    private int front;
    private int rear;
    /**
     * Constructor for objects of class ArrayQueue.
     * This construtor creates an empty queue.
     */
    public ArrayQueue()
    {
        items=new int[maxSize];
        front=0;
        rear=0;
    }

    /**
     * This operation returns true if the queue is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if (front==rear)
            return true;
        else
            return false;
    }
    
    /**
     * This operation returns true if the queue is full, otherwise it returns false
     */    
    public boolean isFull()
    {
        if (rear==front-1)
            return true;
        else
            return false;
    }
    
    /**
     * This operation adds a newItem to the queue.
     */        
    public void enqueue(int newItem)
    {
        if (!isFull())
        {
            items[rear]=newItem;
            rear=(rear+1) % maxSize;
        }
    }

    /**
     * This operation returns the item at the front position of the queue and deletes this item.
     */    
    public int dequeue()
    {
        if (!isEmpty())
        {
            int pos=front;
            front=(front+1) % maxSize;
            return items[pos];
        }
        else
            return -1;
    }
    
    /**
     * This operation returns an item at the front position of the queue. This item will not be deleted.
     */        
    public int peek()
    {
        if (!isEmpty())
            return items[front];
        else
            return -1;
    }
}