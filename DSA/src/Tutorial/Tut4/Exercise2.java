package Tutorial.Tut4;
import java.util.Scanner;
public class Exercise2 {
    public static void Merge(int [] a, String[] name, int left, int mid, int right) {
        int[] c = new int[right - left+1];
        String [] s = new String[right - left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while ((i<=mid)&&(j<=right)) {
            if (a[i]>a[j]) {
                c[k]=a[i]; s[k]=name[i]; i++;
            } else {
                c[k]=a[j]; s[k]=name[j]; j++;
            }
            k++;
        }
        for (int t=i;t<=mid;t++) {
            c[k]=a[t]; s[k]=name[t]; k++;
        }
        for (int t=j;t<=right;t++) {
            c[k]=a[t]; s[k]=name[t]; k++;
        }
        for (int t=0;t<k;t++) {
            a[left+t]=c[t]; name[left+t]=s[t];
        }
    }
    public static void Merge_Sort(int [] a,String[] name, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;
            Merge_Sort(a,name,left,mid);
            Merge_Sort(a,name,mid+1,right);
            Merge(a,name,left,mid,right);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt(); sc.nextLine();
        String name[]=new String[n];
        int score[]=new int[n];
        for (int i=0; i<n; i++) {
            System.out.print("Input name of student No. " + (i+1) + ": ");
            name[i]=sc.nextLine();
            System.out.print("Input score of student No. " + (i+1) + ": ");
            score[i]=sc.nextInt(); sc.nextLine();
        }
        System.out.println();
        System.out.print("Input m: ");
        int m = sc.nextInt(); sc.nextLine();
        Merge_Sort(score, name,0,n-1);
        System.out.println("The name of " + m + " students who has the highest mark: ");
        for (int i=0; i<m; i++) {
            System.out.println(i+1 + ". " + name[i]);
        }
    }
}
