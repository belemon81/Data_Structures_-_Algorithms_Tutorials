/**
 * Class SLNode implement an elements (a node) of a linked-list data structure.
 * Each element of the list contains a string (data) and a reference variable named next.
 * Please refer to Lecture 6 for the Node ADT in detail.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Tutorial.Tut6.Exercise3.SLListPolynomial;

public class SLNode {
    private int degree;
    private double coefficient;
    private SLNode next;

    /**
     * Constructor for objects of class SLNode
     * This constructor create a node from an input string (data)
     */
    public SLNode(double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }

    public double getCoefficient() {
        return this.coefficient;
    }

    /**
     * This operation sets the next reference to the node specify in the parameter (next)
     */
    public void setNext(SLNode abc) {
        this.next = abc;
    }

    /**
     * This operation return the next reference
     */
    public SLNode getNext() {
        return this.next;
    }
}