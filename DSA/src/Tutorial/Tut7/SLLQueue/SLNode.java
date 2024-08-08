/**
 * Class SLNode implement an elements (a node) of a linked-list data structure.
 * Each element of the list contains a string (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Tutorial.Tut7.SLLQueue;

public class SLNode {
    private int data;
    private SLNode next;

    public SLNode(int data) {
        this.data = data;
    }

    public void setNext(SLNode abc) {
        this.next = abc;
    }

    public SLNode getNext() {
        return this.next;
    }

    public void setData(int xyz) {
        this.data = xyz;
    }

    public int getData() {
        return this.data;
    }
}