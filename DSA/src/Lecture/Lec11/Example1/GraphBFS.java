/**
 * Write a description of class GraphBFS here.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Lecture.Lec11.Example1;

public class GraphBFS {
    private static int n = 7;
    private static int[][] a = {
            {0, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 0},
            {1, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0}
    };
    private static GVertex[] v;

    /**
     * Constructor for objects of class GraphBFS
     */
    public GraphBFS() {
    }

    public static void BFS(int s) {
        for (int u = 0; u < n; u++)
            v[u].setColor('B');
        v[s].setColor('Y');
        System.out.print(v[s].getLabel() + " ");
        ArrayQueue q = new ArrayQueue();
        q.enqueue(s);
        while (!q.isEmpty()) {
            int u = q.dequeue();
            for (int w = 0; w < n; w++)
                if ((a[u][w] == 1) && (v[w].getColor() == 'B')) {
                    v[w].setColor('Y');
                    System.out.print(v[w].getLabel() + " ");
                    q.enqueue(w);
                }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        v = new GVertex[n];     //Create an empty list of n vertices
        // Initialize vertex's label
        v[0] = new GVertex('A');
        v[1] = new GVertex('B');
        v[2] = new GVertex('C');
        v[3] = new GVertex('D');
        v[4] = new GVertex('E');
        v[5] = new GVertex('F');
        v[6] = new GVertex('G');

        System.out.println("BFS traversal from vertex v[0]");
        BFS(0);
        System.out.println("BFS traversal from vertex v[6]");
        BFS(6);

    }
}
