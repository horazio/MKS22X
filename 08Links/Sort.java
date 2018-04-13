import java.util.*;
public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
        MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved<Integer>[10];
        for(int i = 0; i < ((String) data.max()).length(); i++){
            for(Integer elem : data){
                bucket[(elem / Math.pow(10, i)) % 10].add(elem);
            }
            data.clear();
            for(int i = 0; i < bucket.length; i++){
                data.extend(bucket[i]);
            }
        }
        
    }
    
    public static void main(String[] args){
        
    }

    
}
