/**
 * Write a description of class ShortestPath here.
 *
 * @author (nxthang)
 * @version (1.0)
 */
package Lecture.Lec12.Example2;

public class ShortestPath {
    private static final int INF = 100000;
    private static int n = 8;
    private static int[][] w = {
            {0, 15, 9, 14, INF, INF, INF, INF},
            {INF, 0, INF, INF, 20, INF, INF, 44},
            {INF, INF, 0, INF, INF, INF, 24, INF},
            {INF, 5, INF, 0, 30, INF, 18, INF},
            {INF, INF, INF, INF, 0, 11, INF, 16},
            {INF, INF, INF, INF, INF, 0, 6, 6},
            {INF, INF, INF, INF, 2, INF, 0, 19},
            {INF, INF, INF, INF, INF, INF, INF, 0}
    };
    private static char[] label;

    /**
     * Constructor for objects of class ShortestPath
     */
    public ShortestPath() {
    }

    public static void Dijkstra(int s) {
        int[] d = new int[n];
        int[] path = new int[n];
        boolean[] marked = new boolean[n];
        boolean isFinished = false;

        for (int i = 0; i < n; i++) {
            d[i] = INF;
            path[i] = -1;
            marked[i] = false;
        }
        d[s] = 0;
        while (!isFinished) {
            isFinished = true;
            int u = -1;
            int min = INF;
            for (int i = 0; i < n; i++)
                if ((min > d[i]) && (!marked[i])) {
                    min = d[i];
                    u = i;
                }
            if (u != -1) {
                isFinished = false;
                marked[u] = true;
                for (int z = 0; z < n; z++)
                    if (d[z] > d[u] + w[u][z]) {
                        d[z] = d[u] + w[u][z];
                        path[z] = u;
                    }
            }
        }

        System.out.println("The d array is: ");
        for (int i = 0; i < n; i++)
            System.out.print(" D[" + i + "] = " + d[i]);
        System.out.println("");
        int t = 7;
        System.out.println("The shortest path from vertex " + label[s] + " to vertex " + label[t]);
        while (t != s) {
            System.out.print(label[t] + "<-- ");
            t = path[t];
        }
        System.out.print(label[t]);
    }

    public static void BellmanFord(int s) {
        int[][] d = new int[n][n];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                d[i][j] = INF;
            path[i] = -1;
            d[i][s] = 0;
        }

    }

    public static void main(String[] args) {
        label = new char[n];
        label[0] = 'A';
        label[1] = 'B';
        label[2] = 'C';
        label[3] = 'D';
        label[4] = 'E';
        label[5] = 'F';
        label[6] = 'G';
        label[7] = 'H';
        Dijkstra(0);
    }
}
