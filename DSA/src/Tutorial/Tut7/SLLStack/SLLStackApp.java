package Tutorial.Tut7.SLLStack;

public class SLLStackApp {
    /**
     * Constructor for objects of class ArrayStackApp
     */
    public SLLStackApp() {
    }

    public static void copyStack(SLLStack scr, SLLStack des) {
        SLLStack tmp = new SLLStack();
        SLNode item;
        do {
            item = scr.Pop();
            if (item != null)
                tmp.Push(item);
        } while (item != null);
        do {
            item = tmp.Pop();
            if (item != null) {
                scr.Push(item);
                des.Push(item);
            }
        } while (item != null);
    }

    public static void printStack(SLLStack st) {
        SLLStack tmp = new SLLStack();
        copyStack(st, tmp);
        SLNode item;
        do {
            item = tmp.Pop();
            if (item != null)
                System.out.print(item.getData() + " ");
        }
        while (item != null);
        System.out.println();
    }

    public static void main(String[] args) {
        SLLStack s = new SLLStack();
        System.out.println("Push three items into the stack:");
        s.Push(new SLNode('a'));
        s.Push(new SLNode('b'));
        s.Push(new SLNode('c'));
        System.out.println("Print out all stack's items:");
        printStack(s);//three two one
        System.out.println("The current top item of the stack is: " + s.Peek().getData());
        System.out.println("Pop one item from the stack. Returned item is: " + s.Pop().getData());
        System.out.println("Now, the current top item of the stack is: " + s.Peek().getData());
        System.out.println("Push two items into the stack:");
        s.Push(new SLNode('d'));
        s.Push(new SLNode('e'));

        SLLStack s1 = new SLLStack();

        copyStack(s, s1);
        System.out.println("Copy s to s1. Print out all s1's items:");
        printStack(s1);


    }
}
