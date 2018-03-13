import java.util.*;
public class Quickselect{

    /*Choose a random pivot element, and modify the array such that:
    *1. Only the indices from start to end inclusive are considered in range
    *2. A random index from start to end inclusive is chosen, the corresponding 
    *   element is designated the pivot element. 
    *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
    *4. all elements in range that are larger than the pivot element are placed after the pivot element.
    *@return the index of the final position of the pivot element.
    */
    public static int partition ( int[] data, int start, int end){
        Random randGen = new Random(7975);
        int pivot = start;
        swap(data, start, randGen.nextInt(end - start) + start);
        start++;
        while( Math.abs(start - end) > 1){
            
            
            
            
            if(data[start] < data[pivot]){
                start++;
            }else{
                swap(data, start, end);
                end--;
            }
            
            System.out.println("   " + start);
            System.out.println("   " + end);
            for(int i = 0; i < data.length; i++ ){
                System.out.print(" " + data[i]);
            }        
            System.out.println();
            
        }
        swap(data, pivot, start--);
        
        for(int i = 0; i < data.length; i++ ){
                System.out.print(" " + data[i]);
        }   
        System.out.println(start + 1);
        for(int i = 0; i < data.length; i++ ){
                System.out.print(" " + data[i]);
        }       
        
        return start + 1;
    }
    
    public static void swap(int[] data, int a, int b){
        int holder = data[a];
        data[a] = data[b];
        data[b] = holder;
    }

    public static void main(String[] args){
        
        int[] data = {12, 4, 132, 34, 45, 56, 23, 356, 213, 153};
        System.out.println(partition(data, 0, data.length - 1));
        System.out.println();
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }        
    }

}

