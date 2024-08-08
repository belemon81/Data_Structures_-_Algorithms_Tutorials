/**
 * Class ArrayQueue implements an array-based queue data structure. Each element of the queue is a character.
 * Please refer to Lecture 7 for the array-based queue ADT in detail.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Lecture.Lec7.ArrayBasedQueue;

public class ArrayQueue {
    private char[] items;
    private static final int maxSize = 100;
    private int front;
    private int rear;

    /**
     * Constructor for objects of class ArrayQueue.
     * This constructor creates an empty queue.
     */
    public ArrayQueue() {
        items = new char[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * This operation returns true if the queue is empty, otherwise it returns false
     */
    public boolean isEmpty() {
        if (front == rear)
            return true;
        else
            return false;
    }

    /**
     * This operation returns true if the queue is full, otherwise it returns false
     */
    public boolean isFull() {
        if (rear == (front - 1) % maxSize)
            return true;
        else
            return false;
    }

    /**
     * This operation adds a newItem to the queue.
     */
    public void enqueue(char newItem) {
        if (!isFull()) {
            items[rear] = newItem;
            rear = (rear + 1) % maxSize;
        }
    }

    /**
     * This operation returns the item at the front position of the queue and deletes this item.
     */
    public char dequeue() {
        if (!isEmpty()) {
            int pos = front;
            front = (front + 1) % maxSize;
            return items[pos];
        } else
            return '\u0000';
    }

    /**
     * This operation returns an item at the front position of the queue. This item will not be deleted.
     */
    public char peek() {
        if (!isEmpty())
            return items[front];
        else
            return '\u0000';
    }
}