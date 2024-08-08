package Lecture.Lec5;
/**
 * Counting sort assumes that each of the n input elements is an integer in the range 0 to m,
 * for some integer m. The time complexity of the algorithm is O(m+n).
 *
 * @author (nxthang)
 * @version (1.0)
 */
import java.util.Scanner;
public class CountingSort {
    public static void print_array(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
    /**
     * This method implements the counting sort algorithm. 
     * Array a[0..n] stores n input elements which are integers in the range 0 to m.
     * Array b[0..n] holds the sorted output. Array c[0..m] is the buckets or count array
     *
     * @author (nxthang)
     * @version (1.0)
     */
    public static void Counting_Sort(int[] a, int[] b, int m) {
        int[] c = new int[m + 1];                                       //range 0 to m
        //for (int i = 0; i <= m; i++) c[i] = 0;                        //Initialize the array c to all zeros
        for (int i = 0; i < a.length; i++) c[a[i]] = c[a[i]] + 1;       //c[i] is the number of elements i (0->a.length)
        for (int i = 1; i <= m; i++) c[i] = c[i] + c[i - 1];            //c[i] = c[i] + the number of elements <= i // order of i in arranged array (1->m)
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i]; c[a[i]] = c[a[i]] - 1;
        }
    }
    public static void main(String[] args) {
        int n, m;
        int[] a;
        int[] b;

        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println("Please input the integer M:");
        m = scanner.nextInt();

        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Please input the integer a[" + i + "]" + "(a[" + i + "] must <= " + m + "):");
            a[i] = scanner.nextInt();
        }

        System.out.println("The list of integers is: ");
        print_array(a);

        Counting_Sort(a, b, m);

        System.out.println("The list of sorted integers is: ");
        print_array(b);
    }
}
