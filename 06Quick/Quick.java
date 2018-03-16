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
        Random randGen = new Random();
        int start = 0;
        int end = ary.length - 1;
        int index = -1;
        int lt = 0;
        int gt = 0;
        int i = 0;
        while(index != k && end > start){
            lt = start;
            gt = end;
            i = start + 1;
            
         
            swap(ary, start, randGen.nextInt(end - start) + start);
            int pivot = ary[start];
            while(i <= gt){     
                if(ary[i] == pivot){
                    i++;
                }else if (ary[i] > pivot){
                    swap(ary, i, gt);
                    gt--;
                }else{
                    swap(ary, i, lt);
                    lt++;
                    i++;
                }  
            }
            if(i > k){
                start = i;
            }else{
                end = lt - 1;
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
            int pivot = ary[start];
            while(i <= gt){     
                if(ary[i] == pivot){
                    i++;
                }else if (ary[i] > pivot){
                    swap(ary, i, gt);
                    gt--;
                }else{
                    swap(ary, i, lt);
                    lt++;
                    i++;
                }  
            }
            quickHelper(ary, i, end);
            quickHelper(ary, start, lt - 1);            
        }
        
    }
    
    public static void main(String[] args){
        
        int[] data = {10,9,8,7,6,5,4,3,2,1,0};
        
        
        //System.out.println(partition(data, 0, data.length - 1));
        System.out.println(quickselect(data, 6));
        
        
        for(int i = 0; i < data.length; i++ ){
            System.out.print(" " + data[i]);
        }
        
       
    }

}

