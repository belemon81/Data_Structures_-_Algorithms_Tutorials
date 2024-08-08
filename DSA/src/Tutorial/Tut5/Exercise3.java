package Tutorial.Tut5;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {
    public static void Column_Sort(ArrayList<String> strings, int d) {
        int[] c=new int[12];
        String [] b=new String[strings.size()];
        for (int i=0; i<strings.size(); i++) {
            int dg=strings.get(i).charAt(d); c[dg]=c[dg]+1;
        }
        for (int i=1; i<=255; i++)
            c[i]=c[i]+c[i-1];
        for (int i=strings.size()-1; i>=0; i--) {
            int dg=strings.get(i).charAt(d); b[c[dg]-1]=strings.get(i); c[dg]=c[dg]-1;
        }
        strings=new ArrayList<>();
        for (int j=0;j<strings.size();j++) {
            strings.add(b[j]);
        }
    }
    public static void Radix_Sort(ArrayList<String> strings, int m) {
        for (int i=m-1; i>=0; i++) {
            Column_Sort(strings,i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt(); sc.nextLine();
        System.out.print("Input m: ");
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Input string " + (i+1) + ": ");
            String str = sc.nextLine().substring(0, m);
            strings.add(str);
        }
        Radix_Sort(strings,m);
        System.out.println("The sorted String: ");
        for (int i = 0; i < n; i++) {
            System.out.println(strings.get(i));
        }
    }
}
