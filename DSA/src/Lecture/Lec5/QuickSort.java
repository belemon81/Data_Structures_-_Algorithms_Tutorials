package Lecture.Lec5; /**
 * Class QuickSort demonstrates Quick sort algorithm.
 *
 * @author (nxthang)
 * @version (1.0)
 */
import java.util.Scanner;
public class QuickSort {
    public static void print_array(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
    //left is smaller, right is greater
    /**
     * This method implements partition algorithm for Quick sort
     * Input: An array A from idLeftmost to idRightmost, pivot is a[idLeftmost]
     * Output: j is the final position of pivot 
     *         Array A is divided into two parts
     *              1) x[i] <= pivot for idLeftmost <= i < j
     *              2) x[i] >= pivot for j<i<= idRightmost
     *
     *
     * @author (nxthang)
     * @version (1.0)
     */
    private static int partition(int[] data, int idLeftMost, int idRightMost) {
        int down, up, pivot, temp;
        pivot = data[idLeftMost];
        up = idRightMost;
        down = idLeftMost;
        while (down < up) {
            while ((data[down] <= pivot) && (down < idRightMost)) down++;    /* move up the array */
            while (data[up] > pivot) up--;                                   /* move down the array */
            if (down < up) {                                                 /* interchange x[down] and x[up] */
                temp = data[down]; data[down] = data[up]; data[up] = temp;
            }
        }
        data[idLeftMost] = data[up]; data[up] = pivot;          //swap
        return up;
    }
    /**
     * This method implements Quick sort algorithm
     * Input: An unsorted array A from idLeftmost to idRightmost
     * Output: A sorted array
     *
     * @author (nxthang)
     * @version (1.0)
     */
    public static void Quick_Sort(int[] data, int idLeftmost, int idRightmost) {
        int idPivot;
        if (idLeftmost < idRightmost) {
            idPivot = partition(data, idLeftmost, idRightmost);
                        /* partition the elements of the subarray such that one of the elements
                                (the pivot=x[idLeftmost]) is now at x[j] (j is an output parameter) and
                                1) x[i] <= x[j] for idLeftmost <= i < j
                                2) x[i] >= x[j] for j<i<= idRightmost
                                pivot is now at its final position */
            Quick_Sort(data, idLeftmost, idPivot - 1);
            /* recursively sort the subarray between positions idLeftmost and j-1 */
            Quick_Sort(data, idPivot + 1, idRightmost);
            /* recursively sort the subarray between positions j+1 and idRightmost */
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

        Quick_Sort(a, 0, n - 1);

        System.out.println("The list of sorted integers is: ");
        print_array(a);
    }

}
