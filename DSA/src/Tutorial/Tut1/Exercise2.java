package Tutorial.Tut1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input n: ");
        int n=sc.nextInt(); sc.nextLine();
        int[] a=new int[n];
        int max=Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            System.out.print("a[" + (i+1) + "]=");
            a[i]=sc.nextInt(); sc.nextLine();
            if (a[i]>max) {
                max=a[i];
            }
        }
        System.out.print("The maximum integer of the list: " + max);
    }
}
