package Tutorial.Tut7.SLLQueue;

public class SLLQueue {
    SLNode front = null;
    SLNode rear = null;

    public boolean isEmpty() {
        if (front == null && rear == null) return true;
        return false;
    }

    public void enqueue(SLNode newNode) {
        newNode.setNext(null);
        if (isEmpty()) {
            front = newNode; rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public SLNode dequeue() {
        if (!isEmpty()) {
            SLNode tmp;
            if (front == rear) {
                tmp = front; front = null; rear = null;
            } else {
                tmp = front;
                front = front.getNext();
            }
            return tmp;
        } else {
            return null;
        }
    }

    public SLNode peek() {
        if (!isEmpty())
            return front;
        else
            return null;
    }
}
