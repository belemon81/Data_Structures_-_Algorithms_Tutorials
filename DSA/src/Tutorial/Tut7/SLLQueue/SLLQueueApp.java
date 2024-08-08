package Tutorial.Tut7.SLLQueue;

public class SLLQueueApp {
    public SLLQueueApp() {
    }

    public static void copyQueue(SLLQueue scr, SLLQueue des) {
        SLLQueue tmp = new SLLQueue();
        SLNode item;
        do {
            item = scr.dequeue();
            if (item != null)
                tmp.enqueue(item);
        } while (item != null);
        do {
            item = tmp.dequeue();
            if (item != null) {
                scr.enqueue(item);
                des.enqueue(item);
            }
        } while (item != null);
    }

    public static void printQueue(SLLQueue q) {
        SLLQueue tmp = new SLLQueue();
        copyQueue(q, tmp);
        SLNode item;
        do {
            item = tmp.dequeue();
            if (item != null)
                System.out.print(item.getData() + " ");
        } while (item != null);
        System.out.println(" ");
    }

    public static void main(String[] args) {
        SLLQueue q = new SLLQueue();
        System.out.println("Enqueue three items into the queue:");
        q.enqueue(new SLNode(100));
        q.enqueue(new SLNode(1000));
        q.enqueue(new SLNode(10000));
        System.out.println("Print out all queue's items:");
        printQueue(q);
        System.out.println("The current front item of the queue is: " + q.peek().getData());
        System.out.println("Dequeue one item from the queue. Returned item is: " + q.dequeue().getData());
        System.out.println("Now, the current front item of the queue is: " + q.peek().getData());
        System.out.println("Enqueue two items into the queue:");
        q.enqueue(new SLNode(12345));
        q.enqueue(new SLNode(67890));
        q.dequeue();
        printQueue(q);

        SLLQueue q1 = new SLLQueue();
        copyQueue(q, q1);
        System.out.println("Copy q to q1. Print out all q1's items:");
        printQueue(q1);
    }
}

