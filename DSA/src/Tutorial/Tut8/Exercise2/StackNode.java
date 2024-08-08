/**
 * Class StackNode implements an elements (a node) of a stack using singly linked list data structure.
 * Each element of the queue contains a character (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tutorial.Tut8.Exercise2;
public class StackNode
{
    private char data;
    private StackNode next;

    /**
     * Constructor for objects of class StackNode
     * This constructor create a node from an input character (data)
     */
    public StackNode(char data)
    {
        this.data=data;
        this.next=null;
    }

    /**
     * This operation sets the next reference to the node specify in the parameter (next)
     */    
    public void setNext(StackNode next)
    {
        this.next=next;
    }

    /**
     * This operation return the next reference
     */    
    public StackNode getNext()
    {
        return this.next;
    }

    /**
     * This operation assigns data of the node to the input character (data)
     */        
    public void setData(char data)
    {
        this.data=data;
    }

    /**
     * This operation return the current data of the node
     */        
    public char getData()
    {
        return this.data;
    }    
}