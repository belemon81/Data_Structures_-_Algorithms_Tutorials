package Lecture.Lec4;
import java.util.Scanner;
public class SelectionSort {
    public static void print_array(int [] a) {
        for (int i=0; i<a.length; i++) {
           System.out.print(a[i]+" ");
        }        
        System.out.println(" ");
    }
    public static void Selection_Sort(int [] a) {
        for (int i=a.length-1; i>0; i--) {
            int max=a[i];
            int pos=i;
            for(int j=i-1; j>=0; j--){
                if (max<a[j]){
                    max=a[j];pos=j;
                }
            }
            a[pos]=a[i];
            a[i]=max;
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
        Selection_Sort(a);
        System.out.println("The list of sorted integers is: ");       
        print_array(a);
    }    
}
