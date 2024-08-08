package Lecture.Lec5; /**
 * Class InsertionSort demonstrates Heap sort algorithm.
 *
 * @author (nxthang)
 * @version (1.0)
 */
import java.util.Scanner;
public class HeapSort {
    public static void print_array(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
    //parent=(i-1)/2
    public static int LeftChild(int i) {
        return 2 * i + 1;
    }
    public static int RightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * 1 2 5 3 1 4 6
     * i=2;
     *          6
     *     4         5
     * maxpos=7 -> 1 2 6 3 1 4 5
     * i=1
     *          3
     *     2         1
     * maxpos=3 -> 1 3 6 2 1 4 5
     * i=0
     *          6
     *     3         1
     * maxpos=2 -> 6 3 1 2 1 4 5
     * maxpos=i=2
     *          5
     *     4         1
     * -> 6 3 5 2 1 4 1
     *          6
     *     3         5
     *   2   1     4   1
     */
    /**
     * This method implements the TrickleDown algorithm.
     *
     * Input: Binary tree A of the size n starting from 0,
     *        i is the node to be trickle down.
     * Output: Tree A becomes max heap.
     *
     * @author (nxthang)
     * @version (1.0)
     */
    public static void TrickleDown(int[] a, int n, int i) {
        int l = LeftChild(i);
        int r = RightChild(i);
        int maxpos = i;
        if ((l < n) && (a[l] > a[maxpos])) maxpos = l;
        if ((r < n) && (a[r] > a[maxpos])) maxpos = r;
        if (maxpos != i) {
            int tmp = a[i]; a[i] = a[maxpos]; a[maxpos] = tmp;
            TrickleDown(a, n, maxpos);
        }
    }
    /**
     * This method implements the BuildHeap algorithm.
     *
     * Input:  An array A of the size n, starting from 0.
     * Output: A becomes max heap.
     */
    public static void BuildHeap(int[] a, int n) {
        int parent = (n/2)-1; //2
        for (int i = parent; i >= 0; i--) {
            TrickleDown(a, n, i);
        }
    }
    /**
     * This method implements the Heap sort algorithm.
     *
     * Input:  An array A.
     * Output: A is sorted.
     *
     * @author (nxthang)
     * @version (1.0)
     */
    public static void Heap_Sort(int[] a) {
        int n = a.length;
        BuildHeap(a, n);
        for (int i = n - 1; i > 0; i--) {
            int tmp = a[0]; a[0] = a[i]; a[i] = tmp;
            n--;
            TrickleDown(a, n,0);  //Trickle down the new root
        }
    }
    public static void main(String[] args) {
        int n;
        int[] a;

        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Please input the integer a[" + i + "]:");
            a[i] = scanner.nextInt();
        }

        System.out.println("The list of integers is: ");
        print_array(a);

        Heap_Sort(a);

        System.out.println("The list of sorted integers is: ");
        print_array(a);
    }
}
