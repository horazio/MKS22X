import java.util.*;

public class Merge{
    
    public static void mergesort(int[] data, int[] temp, int start, int end){
        if(start < end){	    
            int midpoint = (start + end) / 2;
            mergesort(temp, data, start, midpoint); 
            mergesort(temp, data, midpoint + 1, end);  
            merge(data, temp, start, midpoint, midpoint + 1, end);
        }else{
            //insertionSort(data, start, end);
        }
        
    }

    
    public static void merge(int[] data, int[] temp, int start, int mid, int augmid, int end){
        for(int i = start; i <= end; i++){
                if(augmid > end || (start <= mid && temp[start] < temp[augmid])){
                    data[i] = temp[start];
                    start++;
                }else{
                    data[i] = temp[augmid];
                    augmid++;
                }
        }

    }
    
    public static void mergesort(int[] data){
        int[] data2 = new int[data.length];
        for(int i = 0; i < data.length ; i++){
                data2[i] = data[i];
	}
        mergesort(data2, data, 0, data.length - 1);      
	 for(int i = 0; i < data.length; i++){
            data[i] = data2[i];
	 }      
    }
    
    public static void insertionSort(int[] data, int start, int end){
        for(int j = start; j < end + 1; j++){
            int i = j;
            while(i != 0 && data[i - 1] > data[i]){
            swap(data, i - 1, i);
            i--;
            }
		    
	    }
	    
	    
	}
	
  private static void swap(int[] ary, int a, int b){
      int holder = ary[a];
      ary[a] = ary[b];
      ary[b] = holder;
  }   

    
    
    public static void main(String args[]){	
	int[] data = new int[1000000];
	for(int i = 0; i < 1000000; i++){
	    data[i] = (int) (Math.random() * 1000000); 
	}
    System.out.println("asdf");
        mergesort(data);
	//for(int i = 0; i < 100; i++){
	//   System.out.println(data[i]);
	//}
    }
}
