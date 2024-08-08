/**
 * Class GVertex implements the graph Vertex ADT that is introduced in lecture 12.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Lecture.Lec12.Example1;
public class GVertex
{
    private int index;
    private int row;
    private int column;
    private boolean marked;
    private int numOfAdjVertex;
    private int[] adjVertex;
    /**
     * Constructor for objects of class GVertex
     */
    public GVertex(int index, char[][] map, int m, int n)
    {
        this.index=index;
        row=index / n;
        column=index % n;
        marked=false;
        numOfAdjVertex=0;
        adjVertex = new int[4];
        if (row>0)  {//row=1 >0        
            if (map[row-1][column] != 'X') {//map[0][1] != 'X'
                adjVertex[numOfAdjVertex]=(row-1)*n + column;
                //adjVertex[0]=
                numOfAdjVertex++;
            }
        }    
        
        if (column<n-1) {
            if (map[row][column+1] != 'X') {
                adjVertex[numOfAdjVertex]=row*n+column+1;
                numOfAdjVertex++;
            }    
        }    
        
        if (row<m-1) {
            if (map[row+1][column] != 'X') {
                adjVertex[numOfAdjVertex]=(row+1)*n + column;
                numOfAdjVertex++;
            }
        }
        
        if (column>0) {
            if (map[row][column-1] != 'X') {
                adjVertex[numOfAdjVertex]=row*n+column-1;
                numOfAdjVertex++;
            }
        }
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getColumn()
    {
        return column;
    }
    
    public boolean getMarked()
    {
        return marked;
    }
    
    public void setMarked(boolean marked)
    {
        this.marked=marked;
    }
    
    public int getNumOfAdjVertex()
    {
        return numOfAdjVertex;
    }
    
    public int[] getAdjVertex()
    {
        return adjVertex;
    }
    
    public String toString()
    {
        String s = String.format("Vertex: %d Row: %d Column: %d Marked: %b numOfAdjVertex: %d%n {",index,row,column,marked,numOfAdjVertex);
        for (int i=0; i<numOfAdjVertex; i++)  {
            String s1 = String.format("%d ",adjVertex[i]);
            s+=s1;
        }
        return s+"}";
    }
}
