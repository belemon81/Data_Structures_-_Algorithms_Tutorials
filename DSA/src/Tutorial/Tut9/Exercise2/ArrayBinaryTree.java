package Tutorial.Tut9.Exercise2;

/**
 * Class ArrayBinaryTree implements Binary Tree data structure using an array.
 * Binary Tree's nodes are indexed using the numbering scheme introduced in Lecture 09.
 * Node has a string label that is stored in the l array.
 * Please refers to Lecture 09 and week 09 tutorial instruction for more detail on Binary Tree's ADT.
 *
 * @author (nxthang)
 * @version (1.0)
 */

import java.util.Arrays;

public class ArrayBinaryTree {
    private static final int maxSize = 100; //Maximum possible number of nodes in the tree
    private String[] l;

    /**
     * Constructor for objects of class ArrayBinaryTree
     * Create an empty Binary Tree
     */
    public ArrayBinaryTree() {
        l = new String[maxSize];
        Arrays.fill(l, null);
    }

    public void addRoot(String label) {
        if (l[0] == null) {
            l[0] = label;
        }
    }

    public int getLeftChild(int node) {
        return 2 * node + 1;
    }

    public int getRightChild(int node) {
        return 2 * node + 2;
    }

    public int getParent(int node) {
        return (int) Math.floor((node - 1) / 2);
    }

    public String getNodeLabel(int node) {
        return l[node];
    }

    public void setNodeLabel(String label, int node) {
        l[node] = label;
    }

    public void addLeftChild(String label, int node) {
        setNodeLabel(label, getLeftChild(node));
    }

    public void addRightChild(String label, int node) {
        setNodeLabel(label, getRightChild(node));
    }

    public void preOrderTravel(int node) {
        if (l[node] != null) {
            System.out.print(l[node] + " ");
            preOrderTravel(getLeftChild(node));
            preOrderTravel(getRightChild(node));
        }
    }

    public boolean isEmpty() {
        return (l[0] == null);
    }

    public boolean isLeaf(int node) {
        if (getRightChild(node) < maxSize) {
            if (l[getLeftChild(node)] == null && l[getRightChild(node)] == null) return true;
            return false;
        }
        return false;
    }

    public int countLeaf() {
        int count = 0, i = 0;
        while (l[getParent(i)]!= null && i < maxSize) {
            if (isLeaf(i)) count++;
            i++;
        }
        return count;
    }

    public int getLevel(int node) {
        int count = 0, n = 1;
        while (n <= node) {
            count++;
            n *= 2;
        }
        return count;
    }

    public int getDepth() {
        int depth = 0, i = 0;
        while (i < maxSize) {
            if (isLeaf(i)) {
                int level = getLevel(i);
                if (level > depth) depth = level;
            }
            i++;
        }
        return depth;
    }

    public void inOrderTravel(int node) {
        if (l[node] != null) {
            inOrderTravel(getLeftChild(node));
            System.out.print(l[node] + " ");
            inOrderTravel(getRightChild(node));
        }
    }

    public void postOrderTravel(int node) {
        if (l[node] != null) {
            postOrderTravel(getLeftChild(node));
            postOrderTravel(getRightChild(node));
            System.out.print(l[node] + " ");
        }
    }

    public int search(String label) {
        int i = 0;
        while (i < maxSize) {
            if (l[i] == label) return i;
        }
        return -1;
    }
}