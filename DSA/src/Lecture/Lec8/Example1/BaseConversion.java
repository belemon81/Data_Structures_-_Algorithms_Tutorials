/**
 * Class BaseConversion implements an algorithm to find the representation in base B of an integer K.
 * A stack contains integer items is used to support the conversion.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Lecture.Lec8.Example1;
import java.util.Scanner;
public class BaseConversion {
    public static void main (String[]args) 
    {
        int k;
        int b;
        
        System.out.println("Please input a number in base 10 ");
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        System.out.println("Please input a base to convert");        
        b = scanner.nextInt();
        
        ArrayStack s = new ArrayStack();
        
        while (k / b != 0)
        {
            s.push(k % b); 
            k = k / b;
        }       
        s.push(k);
        
        System.out.println("The number in base " + b + " is : ");        
        while (!s.isEmpty())
            System.out.print(s.pop());
        System.out.println("");        
    }    
}
