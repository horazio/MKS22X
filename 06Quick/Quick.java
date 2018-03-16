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
        if(start < end){
            
            
            
            
            
            Random randGen = new Random();
            int lt = start;
            int gt = end;
            int i = start + 1;
            swap(ary, start, randGen.nextInt(end - start) + start);
            System.out.println(ary[start]);
            while(i <= gt){     
                if(ary[i] < ary[lt]){
                    i++;
                }else if (ary[i] > ary[start]){
                    swap(ary, i, gt);
                    gt--;
                }else{
                    swap(ary, i, lt);
                    lt++;
                    i++;
                }
                  
            }
        
            
            
            for(int j = 0; j < ary.length; j++ ){
                System.out.print(" " + ary[j]);
            }
            
            
            
	    
            //quickHelper(ary, index + 1, end);
            //quickHelper(ary, start, index - 1);            
        }
        
    }
    
    public static void main(String[] args){
        
        int[] data = {0, 0,0,1,1,1,2,2,2,0,0};
        
        
        //System.out.println(partition(data, 0, data.length - 1));
        quickHelper(data, 0, data.length - 1);
        
        
        //for(int i = 0; i < data.length; i++ ){
         //   System.out.print(" " + data[i]);
        //}
        
       
    }

}

