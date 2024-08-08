/**
 * Write a description of class Exercise_02 here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tutorial.Tut11.Exercise2;
import java.util.Arrays;
public class Exercise_02
{
    private static int n=8;
    private static int[][] a = {
                                {0,0,0,1,1,0,0,0},
                                {0,0,0,1,0,0,0,0},
                                {0,0,0,0,1,0,0,1},
                                {0,0,0,0,0,1,1,1},
                                {0,0,0,0,0,0,1,0},
                                {0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0}                                
                               };
    private static GVertex[] v;                           
    private static boolean[] marked;

    /**
     * Constructor for objects of class Exercise_02
     */
    public Exercise_02()
    {
    }
    
    public static boolean allMarked()
    {
        for (int i=0; i<n; i++)
            if (marked[i]==false)
                return false;
        return true;        
    }
    
    public static void TopologicalSort()
    {
        ArrayQueue q=new ArrayQueue();
        while (!allMarked())
        {
            for (int i=0; i<n; i++)
                if ((!marked[i])&&(isNoAncestor(i)))
                {
                    marked[i]=true;
                    q.enqueue(i);
                    removeVertex(i);
                }
        }

        System.out.println("One topological order is:");
        while (!q.isEmpty())
        {
            System.out.print(v[q.dequeue()].getLabel()+" ");
        }
    }
    
    public static boolean isNoAncestor(int u)
    {
        for (int i=0; i<n; i++)
            if ((!marked[i])&&(a[i][u]==1))
                return false;
        return true;        
    }
    
    public static void removeVertex(int u)
    {
        for (int i=0; i<n; i++)
        {
            a[i][u]=0;
            a[u][i]=0;
        }    
    }
    
    public static void main()
    {
        v = new GVertex[n];
        v[0]=new GVertex('A'); v[1]=new GVertex('B'); v[2]=new GVertex('C');
        v[3]=new GVertex('D'); v[4]=new GVertex('E'); v[5]=new GVertex('F');
        v[6]=new GVertex('G'); v[7]=new GVertex('H');        
        
        marked=new boolean[n];
        Arrays.fill(marked,false);
        TopologicalSort();
    }
}
