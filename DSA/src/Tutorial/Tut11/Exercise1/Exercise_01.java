/**
 * Write a description of class Exercise_01 here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Tutorial.Tut11.Exercise1;
public class Exercise_01
{
    private static int n=9;
    private static int[][] a = {
                                {0,0,0,1,0,0,0,0,0},
                                {0,0,1,0,0,0,0,0,0},
                                {0,1,0,0,0,0,0,0,0},
                                {1,0,0,0,0,0,1,1,0},
                                {0,0,0,0,0,1,0,0,1},
                                {0,0,0,0,1,0,0,0,1},
                                {0,0,0,1,0,0,0,0,0},
                                {0,0,0,1,0,0,0,0,0},
                                {0,0,0,0,1,1,0,0,0}                                
                               };
    private static GVertex[] v;                           
    /**
     * Constructor for objects of class Exercise_01
     */
    public Exercise_01()
    {
    }
    
    public static void BFS(int s, char label)
    {
        v[s].setColor('Y');
        ArrayQueue q = new ArrayQueue();
        q.enqueue(s);
        while (!q.isEmpty())
        {
            int u = q.dequeue();
            v[u].setLabel(label);   //Visit u (assigned a label to u)
            v[u].setColor('R');
            for (int w=0; w<n; w++)
                if ((a[u][w] == 1)&&(v[w].getColor() == 'B'))
                {
                    v[w].setColor('Y');
                    q.enqueue(w);
                }
        }        
    }
    
    public static void main()
    {
        v = new GVertex[n];     //Create an empty list of n vertices
        for (int i=0; i<n; i++)
            v[i]=new GVertex(' ');  //At the start, every vertex is assigned a special label            
        char label='A';
        boolean isFinishing = false;
        while (!isFinishing)
        {
            isFinishing=true;
            for (int i=0; i<n; i++)
                if (v[i].getLabel() == ' ')
                {
                    isFinishing=false;
                    BFS(i,label);
                    label++;
                }
        }
        for (int i=0; i<n; i++)
            System.out.println("Vertex "+i+" is assigned label: "+v[i].getLabel());
    }
}
