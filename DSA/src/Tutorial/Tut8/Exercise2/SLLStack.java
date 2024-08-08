/**
 * Class SLLStack implement a stack using linked-list data structure. Each element of the stack is a character.
 * Please refer to Lecture 7 for the detail singly linked list-based stack ADT.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tutorial.Tut8.Exercise2;

public class SLLStack
{
    private StackNode top;

    /**
     * Constructor for objects of class SLLStack.
     * This constructor creates an empty Stack.
     */
    public SLLStack()
    {
        top=null;
    }

    /**
     * This operation returns true if the Stack is empty, otherwise it returns false
     */    
    public boolean isEmpty()
    {
        if (top==null)
            return true;
        else
            return false;
    }
    
    /**
     * This operation adds a newNode to the Stack.
     */        
    public void push(StackNode newNode)
    {
        newNode.setNext(top);
        top=newNode;
    }

    /**
     * This operation returns the node at the top position of the Stack and deletes this node.
     */    
    public StackNode pop()
    {
        StackNode tmp;
        if (!isEmpty())
        {
            tmp=top;
            top=top.getNext();
            return tmp;    
        }
        else
            return null;
    }
    
    /**
     * This operation returns a node at the top position of the Stack. This node will not be deleted.
     */        
    public StackNode peek()
    {
        if (!isEmpty())
            return top;
        else
            return null;
    }
}