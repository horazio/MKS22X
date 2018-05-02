import java.util.*;
public class Sorts{
    private static void heapify(int[] data){
        for(int i = data.length - 1; i >= 0; i--){
            pushdown(data, i, data.length);
        }
    }
    
    
    private static void pushdown(int[] data, int i, int end){
	 if(end - i > 1){
            int temp;
            int newi = i;
            boolean goOn = true;
            while(newi == 0 || (goOn && data[i] <= data[newi])){
                swap(data, i, newi);
                i = newi;
                if((2 * i) + 1 >= end){
                    goOn = false;
                }else if((2 * i) + 2 >= end){
                    newi = (2 * i) + 1; 
                }else{
                    if(data[(2 * i) + 2] > data[(2 * i) + 1]){ 
                        newi = (2 * i) + 2; 
                    }else{
                        newi = (2 * i) + 1;
                    }
                }
            }
	      }
    }
    
    public static void swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    
    public static void heapsort(int[] data){
        heapify(data);
        
        for(int pos = data.length - 1; pos > 0; pos--){
            swap(data, 0, pos);
            pushdown(data, 0, pos);
        }
    }
    
    public static void main(String[] args){
        int[] a = new int[10000000];
        
        for(int i = 0; i < a.length; i++){
            a[i] = (int) (100 * Math.random());
        }
	    heapsort(a);
        
        for(int i = 0; i < a.length; i++){
            if(i > 0 && a[i] < a[i - 1]){
                System.out.println("bad");
            }
        }
        System.out.println("good");

    }
}
