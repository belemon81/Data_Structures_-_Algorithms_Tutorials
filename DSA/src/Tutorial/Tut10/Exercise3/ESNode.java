/**
 * Class StackNode implements an elements (a node) of a stack using singly linked list data structure.
 * Each element of the queue contains a character (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Tutorial.Tut10.Exercise3;

public class ESNode {
    private ExpressionTree data;
    private ESNode next;

    /**
     * Constructor for objects of class StackNode
     * This constructor create a node from an input character (data)
     */
    public ESNode(ExpressionTree data) {
        this.data = data;
        this.next = null;
    }

    /**
     * This operation sets the next reference to the node specify in the parameter (next)
     */
    public void setNext(ESNode next) {
        this.next = next;
    }

    /**
     * This operation return the next reference
     */
    public ESNode getNext() {
        return this.next;
    }

    /**
     * This operation assigns data of the node to the input character (data)
     */
    public void setData(ExpressionTree data) {
        this.data = data;
    }

    /**
     * This operation return the current data of the node
     */
    public ExpressionTree getData() {
        return this.data;
    }
}