
/**
 * Write a description of class FindMyCoffee here.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Lecture.Lec12.Example1;

public class FindMyCoffee {
    private static int m = 5;
    private static int n = 8;
    private static char[][] map = {
            {'G', 'G', 'G', 'G', 'G', 'X', 'G', 'G'},
            {'G', 'G', 'G', 'G', 'G', 'X', 'G', 'G'},
            {'G', 'G', 'G', 'G', 'G', 'X', 'G', 'C'},
            {'G', 'G', 'X', 'G', 'G', 'G', 'G', 'G'},
            {'Y', 'G', 'X', 'G', 'G', 'G', 'G', 'G'}
    };
    private static GVertex startVertex, endVertex;
    private static int numOfVertex = 0;
    private static GVertex[] listVertex;
    private static GVertex[] path;

    /**
     * Constructor for objects of class FindMyCoffee
     */
    public FindMyCoffee() {
    }

    private static void constructGraph() {
        //list of m*n vertices
        listVertex = new GVertex[m * n];
        numOfVertex = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                //map[0][0] -> map[4][7]: 40 nodes
                //create new vertices (associated with their adjacency properties)
                listVertex[numOfVertex] = new GVertex(numOfVertex, map, m, n);
                if (map[i][j] == 'Y')//map[4][0]='Y'
                    startVertex = listVertex[numOfVertex];
                if (map[i][j] == 'C')//map[2][7]='C'
                    endVertex = listVertex[numOfVertex];
                numOfVertex++;
            }
    }

    private static boolean BFS(GVertex s, GVertex t) {
        path = new GVertex[numOfVertex];
        for (int i = 0; i < numOfVertex; i++)
            path[i] = null;
        ArrayQueue q = new ArrayQueue();
        q.enqueue(s);
        s.setMarked(true);
        while (!q.isEmpty()) {
            GVertex u = q.dequeue();
            if (u.getIndex() == t.getIndex()) {
                showPath(s, t);
                return true;
            }
            int numOfAdjVertexU = u.getNumOfAdjVertex();
            int[] adjVertexU = u.getAdjVertex();
            for (int i = numOfAdjVertexU - 1; i >= 0; i--) {
                GVertex v = listVertex[adjVertexU[i]];
                if (v.getMarked() == false) {
                    v.setMarked(true);
                    path[v.getIndex()] = u;
                    q.enqueue(v);
                }
            }
        }
        return false;
    }

    //path[0] -> path[39]:
    //path[33]=Vertex(32)
    //path[32]=Vertex(25)
    //path[25]=Vertex(18)
    //.....
    //path[23]=Vertex(22)
    private static void showPath(GVertex src, GVertex des) {
        GVertex u = des;//u=23
        String s = new String();
        while (u != src)//u!=33
        {
            s = String.format("-->(%d,%d)", u.getRow(), u.getColumn()) + s;
            u = path[u.getIndex()];//u=22
        }
        s = String.format("(%d,%d)", src.getRow(), src.getColumn()) + s;
        System.out.println(s);
    }

    public static void main(String[] args) {
        constructGraph();
        BFS(startVertex, endVertex);
    }
}
