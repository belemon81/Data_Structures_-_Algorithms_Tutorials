package Tutorial.Tut7.SLLStack;

public class SLLStack {
    SLNode top = null;

    public boolean isEmpty() {
        if (top == null) return true;
        return false;
    }

    public void Push(SLNode newNode) {
        newNode.setNext(top);
        top = newNode;
    }

    public SLNode Pop() {
        if (!isEmpty()) {
            SLNode topNode = top;
            top = top.getNext();
            return topNode;
        } else {
            return null;
        }
    }

    public SLNode Peek() {
        if (!isEmpty()) {
            return top;
        } else {
            return null;
        }
    }

}
