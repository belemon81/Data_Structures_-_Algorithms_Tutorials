package Lecture.Lec5;
/**
 * Class SortComparison2 implements and compares the running time of 6 sorting algorithms:
 * Selection sort, Insertion sort, Bubble sort, Merge sort, Quick sort and Heap sort
 * An array data of the size N is randomly generated.
 * An array a is copied from the array data. Then array a is used as the input for testing the sorting algorithms.
 * The running time that each sorting algorithm takes to sort the array a is show on the screen.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */

import java.util.Random;

public class SortComparison2 {

    public static void print_array(int [] a) {
        for (int i=0; i<a.length; i++)
        {
           System.out.print(a[i]+" ");
        }        
        System.out.println(" ");
    }
    
    public static void Selection_Sort(int [] a) {
        for (int i=a.length-1; i>0; i--)
        {
            int max=a[i];
            int pos=i;
            for(int j=i-1; j>=0; j--)
            {
                if (max<a[j])
                {
                    max=a[j];
                    pos=j;        
                }
            }
            a[pos]=a[i];
            a[i]=max;
        }
    }
    
    public static void Insertion_Sort(int [] a) {
        for (int j=1; j<a.length; j++)
        {
            int key=a[j];
            int i=j-1;
            while ((i>=0)&&(a[i]>key))
            {
                a[i+1]=a[i];
                i=i-1;
            }
            a[i+1]=key;
        }
    }   
    
    public static void Bubble_Sort(int [] a) {
        Boolean isSorted = false;
        while (!isSorted)
        {
            isSorted=true;
            for (int i=0; i<a.length-1; i++)
                if (a[i]>a[i+1])
                {
                    int tmp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=tmp;
                    isSorted=false;
                }
        }
    }
    
    public static void Merge(int [] a, int left, int mid, int right) {
        int [] c;
        c = new int[right - left+1];
        int i=left;
        int j=mid+1;
        int k=0;

        while ((i<=mid)&&(j<=right))
        {
            if (a[i]<a[j])
            {
                c[k]=a[i];
                i++;
            }
            else
            {
                c[k]=a[j];
                j++;
            }
            k++;
        }
        
        for (int t=i;t<=mid;t++)
        {
            c[k]=a[t];
            k++;
        }
        
        for (int t=j;t<=right;t++)
        {
            c[k]=a[t];
            k++;
        }               

        for (int t=0;t<k;t++)
            a[left+t]=c[t];        
    }
    
    public static void Merge_Sort(int [] a, int left, int right) {
        if (left < right)
        {
            int mid = (left + right)/2;
            Merge_Sort(a,left,mid);
            Merge_Sort(a,mid+1,right);
            Merge(a,left,mid,right);
        }
    }

    /**
     * This method implements partition algorithm for Quick sort
     * Input: An array A from idLeftmost to idRightmost, pivot is a[idLeftmost]
     * Output: j is the final position of pivot 
     *         Array A is divided into two parts
     *              1) x[i] <= pivot for idLeftmost <= i < j
     *              2) x[i] >= pivot for j<i<= idRightmost
     *           
     * 
     * @author (nxthang) 
     * @version (1.0)
     */    
    private static int partition(int[] data, int idLeftMost, int idRightMost) {
        int down, up, pivot, temp;
        pivot = data[idLeftMost];
        up = idRightMost;
        down = idLeftMost;
        while (down < up) {
            while ((data[down] <= pivot) && (down < idRightMost))
                down++; 	/* move up the array */
            while (data[up] > pivot)
                up--; 		/* move down the array */
            if (down < up) 	/* interchange x[down] and x[up] */ {
                temp = data[down];
                data[down] = data[up];
                data[up] = temp;
            }
        }
        data[idLeftMost] = data[up];
        data[up] = pivot;
        return up;
    }

    
    /**
     * This method implements Quick sort algorithm
     * Input: An unsorted array A from idLeftmost to idRightmost
     * Output: A sorted array
     * 
     * @author (nxthang) 
     * @version (1.0)
     */
    public static void Quick_Sort(int[] data, int idLeftmost, int idRightmost)
    {
            int j;

            if (idLeftmost < idRightmost)
            {

                j=partition(data, idLeftmost, idRightmost);
                        /* partition the elements of the subarray such that one of the elements
                                (the pivot=x[idLeftmost]) is now at x[j] (j is an output parameter) and
                                1) x[i] <= x[j] for idLeftmost <= i < j
                                2) x[i] >= x[j] for j<i<= idRightmost
                                pivot is now at its final position */
    
                Quick_Sort(data, idLeftmost, j-1); 
                /* recursively sort the subarray between positions idLeftmost and j-1 */
    
                Quick_Sort(data, j+1, idRightmost); 
                /* recursively sort the subarray between positions j+1 and idRightmost */
            }
    }

    public static int LeftChild(int i)
    {
        return 2*i+1;
    }

    public static int RightChild(int i)
    {
        return 2*i+2;
    }

    /**
    * This method implements the TrickleDown algorithm.
    * 
    * Input: Binary tree A of the size n starting from 0, 
    *        i is the node to be trickle down.
    * Output: Tree A becomes max heap.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void TrickleDown(int[] a, int n, int i)
    {
        int l=LeftChild(i);
        int r=RightChild(i);
        int maxpos=i;
        if ((l<n)&&(a[l]>a[maxpos]))
            maxpos=l;
        if ((r<n)&&(a[r]>a[maxpos]))
            maxpos=r;
        if (maxpos != i)
        {
            int tmp=a[i];
            a[i]=a[maxpos];
            a[maxpos]=tmp;
            TrickleDown(a,n,maxpos);
        }
    }
    
    /**
    * This method implements the BuildHeap algorithm.
    * 
    * Input:  An array A of the size n, starting from 0.
    * Output: A becomes max heap.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void BuildHeap(int[] a, int n) {
        for (int i=n/2; i>=0; i--) {
            TrickleDown(a,n,i);
        }
    }

    /**
    * This method implements the Heap sort algorithm.
    * 
    * Input:  An array A.
    * Output: A is sorted.
    * 
    * @author (nxthang) 
    * @version (1.0)
    */
    
    public static void Heap_Sort(int[] a) {
        int n=a.length;
        BuildHeap(a,n);        
        for (int i=n-1; i>0; i--) {
            int tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            n=n-1;
            TrickleDown(a,n,0);
        }
    }   
    
    public static void main(String[]args) {
        int n;
        int [] data; 
        int [] a;

        n=600000;
        data=new int[n];
        a=new int[n];       
        
        Random rand = new Random(); 
        for (int i=0; i<n; i++)
        {
            data[i]=rand.nextInt(65000) + 1;
        }        
        
        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }        

        long startTime, stopTime, elapsedTime;

        System.out.println("Sorting a list of "+n+" random integers using Selection sort algorithm ...");
        startTime=System.currentTimeMillis();
        Selection_Sort(a);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
      

        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }                
        System.out.println("Sorting a list of "+n+" random integers using Insertion sort algorithm ...");
        startTime=System.currentTimeMillis();
        Insertion_Sort(a);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
      

        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }                
        System.out.println("Sorting a list of "+n+" random integers using Bubble sort algorithm ...");
        startTime=System.currentTimeMillis();
        Insertion_Sort(a);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
     
        
        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }                
        System.out.println("Sorting a list of "+n+" random integers using Merge sort algorithm ...");
        startTime=System.currentTimeMillis();
        Merge_Sort(a,0,n-1);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
        
        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }                
        System.out.println("Sorting a list of "+n+" random integers using Quick sort algorithm ...");
        startTime=System.currentTimeMillis();
        Quick_Sort(a,0,n-1);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
    

        for (int i=0; i<n; i++)
        {
            a[i]=data[i];
        }                
        System.out.println("Sorting a list of "+n+" random integers using Heap sort algorithm ...");
        startTime=System.currentTimeMillis();
        Heap_Sort(a);
        stopTime=System.currentTimeMillis();
        elapsedTime=stopTime - startTime;
        System.out.println("Algorithm took : " + elapsedTime + " milliseconds to finish");
            
    }        
}
