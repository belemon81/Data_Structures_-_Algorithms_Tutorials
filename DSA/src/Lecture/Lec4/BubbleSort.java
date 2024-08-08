package Lecture.Lec4;
import java.util.Scanner;
public class BubbleSort {
    public static void print_array(int [] a) {
        for (int i=0; i<a.length; i++) {
           System.out.print(a[i]+" ");
        }        
        System.out.println(" ");
    }

    /**
     *                    e.g. 5 1 4 3
     * (1) isSorted=true; i=0; 1 5 4 3; isSorted=false
     *                    i=1; 1 4 5 3; isSorted=false
     *                    i=2; 1 4 3 5; isSorted=false
     * (2) isSorted=true; i=0; 1 4 3 5;
     *                    i=1; 1 3 4 5; isSorted=false
     * (3) isSorted=true; i=0; 1 3 4 5;
     *                    ---> 1 3 4 5;
     */
    public static void Bubble_Sort(int [] a) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted=true;
            for (int i=0; i<a.length-1; i++)
                if (a[i]>a[i+1]) {
                    int tmp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=tmp;
                    isSorted=false;
                }
        }
    }
    public static void main(String[]args) {
        int n;
        int [] a;
        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        a=new int[n];
        for (int i=0; i<n; i++) {
            System.out.println("Please input the integer a["+i+"]:");
            a[i]=scanner.nextInt();
        }
        System.out.println("The list of integers is: ");
        print_array(a);
        Bubble_Sort(a);
        System.out.println("The list of sorted integers is: ");       
        print_array(a);
    }    
}