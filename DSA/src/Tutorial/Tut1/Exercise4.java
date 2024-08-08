package Tutorial.Tut1;

import java.util.Scanner;

public class Exercise4 {
    public static int searchingIndex(String name, String[] names, int n) {
        int index=-1;
        for (int i=0; i<n; i++) {
            if (name.equalsIgnoreCase(names[i])) {
                index=i+1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input n: ");
        int n=sc.nextInt(); sc.nextLine();
        String[] names=new String[n];
        for (int i=0; i<n; i++) {
            System.out.print("name[" + (i+1) + "]=");
            names[i]=sc.nextLine();
        }
        System.out.print("Input searching name: ");
        String searchingName=sc.nextLine();
        System.out.print("The name was found at the index: " + searchingIndex(searchingName,names,n));
    }
}
