package Tutorial.Tut1;

import java.util.Scanner;

public class Exercise3 {
    public static void ascendingSort(int[] a, int n) {
        int mediator;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (a[i]>a[j]) {
                    mediator=a[i];
                    a[i]=a[j];
                    a[j]=mediator;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input n: ");
        int n=sc.nextInt(); sc.nextLine();
        int[] a=new int[n];
        for (int i=0; i<n; i++) {
            System.out.print("a[" + (i+1) + "]=");
            a[i]=sc.nextInt(); sc.nextLine();
        }
        ascendingSort(a,n);
        System.out.print("The ascending-ordered list: ");
        for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
