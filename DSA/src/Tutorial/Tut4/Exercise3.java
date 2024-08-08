package Tutorial.Tut4;
import java.util.Scanner;
public class Exercise3 {
    public static void SortOn(int [] a) {
        int[] c=new int[a.length];
        int left=0, right=a.length-1;
        for (int i=0; i<a.length; i++) {
            if (a[i]<0) {
                c[left]=a[i]; left++;
            } else if (a[i]>0) {
                c[right]=a[i]; right--;
            }
        }
        for (int i=0; i<a.length; i++) {
            a[i]=c[i];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt(); sc.nextLine();
        int a[]=new int[n];
        for (int i=0; i<n; i++) {
            System.out.print("Input a[" + i + "]=");
            a[i]=sc.nextInt(); sc.nextLine();
        }
        SortOn(a);
        System.out.println("The rearranged list: ");
        for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}