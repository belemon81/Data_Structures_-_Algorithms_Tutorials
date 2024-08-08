package Tutorial.Tut4;
import java.util.Scanner;
public class Exercise1 {
    public static void Merge(int [] a, int left, int mid, int right) {
        int [] c;
        c = new int[right - left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while ((i<=mid)&&(j<=right)) {
            if (a[i] <= 0 && a[j] >= 0) {
                c[k]=a[i];
                i++;
            } else {
                c[k] = a[j];
                j++;
            }
            k++;
        }
        for (int t=i;t<=mid;t++) {
            c[k]=a[t]; k++;
        }
        for (int t=j;t<=right;t++) {
            c[k]=a[t]; k++;
        }
        for (int t=0;t<k;t++)
            a[left+t]=c[t];
    }
    public static void Merge_Sort(int [] a, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;
            Merge_Sort(a,left,mid);
            Merge_Sort(a,mid+1,right);
            Merge(a,left,mid,right);
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
        Merge_Sort(a,0,n-1);
        System.out.println("The rearranged list: ");
        for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
