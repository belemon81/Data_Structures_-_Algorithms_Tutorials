package Lecture.Lec1;

import java.util.Random;
import java.util.Scanner;

public class Ex02
{
    public static void main(String[]args)
    {
        int n;
        int [] a;
        a=new int[1000];
        
        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        
        Random rand = new Random(); 
        for (int i=0; i<n; i++)
        {
            a[i]=rand.nextInt(11)-5;//[-5,5]   
            //print a[i]
        }        
        
        System.out.println("The list of " + n + " integers is:");
        for (int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");     
        scanner.close();
    }
}
