
/**
 * Class SLList implement a linked-list data structure. Each element of the list is a string.
 * Please refer to Lecture 6 for the detail Linked-List ADT.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Tutorial.Tut6.Exercise3.SLListPolynomial;

public class SLList {
    private SLNode head;

    /**
     * Constructor for objects of class SLList.
     * This constructor will create an empty list.
     */
    public SLList() {
        head = null;
    }

    /**
     * This operation adds a newNode into the beginning of the list
     */
    public void add(SLNode newNode) {
        newNode.setNext(head);
        head = newNode;
    }

    public void printPolynomial() {
        System.out.print("\nThe polynomial is: P(x) = ");
        SLNode nodes = this.head;
        if (nodes != null) System.out.print(nodes.getCoefficient() + "x^" + nodes.getDegree());
        nodes = nodes.getNext();
        while (nodes != null) {
            int d = nodes.getDegree();
            if (d != 0) {
                System.out.print(" + " + nodes.getCoefficient() + "x^" + d);
                nodes = nodes.getNext();
            } else {
                System.out.print(" + " + nodes.getCoefficient());
                nodes = nodes.getNext();
            }
        }
        System.out.println();
    }

    public double EvaluateP(double x) {
        SLNode nodes = this.head;
        double s = 0.0D, p = 1.0D;
        while (nodes != null) {
            s += nodes.getCoefficient() * p;
            p = p * x;
            nodes = nodes.getNext();
        }
        System.out.println();
        return s;
    }
}