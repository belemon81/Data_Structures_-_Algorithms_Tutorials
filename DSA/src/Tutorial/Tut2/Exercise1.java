//The Big-Oh of the new algorithm: O(logn)

package Tutorial.Tut2;
import java.util.Scanner;
public class Exercise1 {
    public static void print_array(int[] a) {
        for(int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
    //The Big-Oh of the new algorithm: O(logn)
    public static int Search(int[] a, int first, int last, int m) {
        if (m<a[first]||m>a[last]) return -1;
        else {
            int mid = (first + last) / 2;
            if (m == a[mid]) {
                return mid;
            } else if (m > a[mid]) {
                return Search(a, mid + 1, last, m);
            } else {
                return Search(a, first, mid - 1, m);
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Please enter the integer n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        int[] a = new int[n];
        for(int i = 0; i < a.length; ++i) {
            System.out.print("Please enter the integer a[" + i + "]:");
            a[i] = scanner.nextInt(); scanner.nextLine();
        }
        print_array(a);
        System.out.print("Please enter the integer m for searching:");
        int m = scanner.nextInt(); scanner.nextLine();
        System.out.println("The search result is: " + Search(a,0,a.length-1,m));
        scanner.close();
    }
}
