import java.util.*;
public class Quick{

    /*Choose a random pivot element, and modify the array such that:
    *1. Only the indices from start to end inclusive are considered in range
    *2. A random index from start to end inclusive is chosen, the corresponding 
    *   element is designated the pivot element. 
    *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
    *4. all elements in range that are larger than the pivot element are placed after the pivot element.
    *@return the index of the final position of the pivot element.
    */
    public static int partition( int[] data, int start, int end){
        Random randGen = new Random();
        int pivot = start;
        swap(data, start, randGen.nextInt(end - start) + start);
        start++;
        while(start <= end){     
            if(data[start] < data[pivot]){
                start++;
            }else{
                swap(data, start, end);
                end--;
            }
                  
        }
        swap(data, pivot, end);
        
        return end;
    }
    
    public static void swap(int[] data, int a, int b){
        int holder = data[a];
        data[a] = data[b];
        data[b] = holder;
    }

    
    public static int quickselect(int[]ary, int k){
        int start = 0;
        int end = ary.length - 1;
        int index = -1;
        while(index != k){
            index = partition(ary, start, end);
            if (index > k){
                end = index;
            }else{
                start = index;
            }
        }
        return ary[k];
    }
    
    public static void quicksort(int[]ary){
        quickHelper(ary, 0, ary.length - 1);
    }
    
    public static void quickHelper(int[] ary, int start, int end){
        int index = -1;
        while(start != end){
            index = partition(ary, start, end);
            quickHelper(ary, index, end);
            quickHelper(ary, start, index);
        }
        
    }
    
    public static void main(String[] args){
        
        int[] data = {999,999,999,4,1,0,3,2,999,999,999};
        
        
        //System.out.println(partition(data, 0, data.length - 1));
        quicksort(data);
        
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
        
        System.out.println(); System.out.println();
        System.out.println(); System.out.println();
        System.out.println(); System.out.println();
        System.out.println(quickselect(data, 0));
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
         System.out.println(); System.out.println();
        System.out.println(quickselect(data, 1));
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }        
         System.out.println(); System.out.println();
        System.out.println(quickselect(data, 2));
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
         System.out.println(); System.out.println();
        System.out.println(quickselect(data, 3));
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
         System.out.println(); System.out.println();
        System.out.println(quickselect(data, 5));
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
    }

}

