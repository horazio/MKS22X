import java.util.*;
public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];
	for(int i = 0; i < bucket.length; i++){
	    bucket[i] = new MyLinkedListImproved<Integer>();
	}
        for(int i = 0; i < Integer.toString(data.get(data.max())).length(); i++){
            for(Integer elem : data){
                bucket[(elem /( (int) Math.pow(10, i))) % 10].add(elem);
            }
            data.clear();
            for(int j = 0; j < bucket.length; j++){
                data.extend(bucket[j]);
	        bucket[j].clear();
            }
        }

	
        
    }
    
    public static void main(String[] args){

        //
	//
	//
	//   What if null data 
	// 
	//
        MyLinkedListImproved<Integer> list = new MyLinkedListImproved<>();
	list.add(7134);
	list.add(232);
	list.add(332);
	list.add(432);
	list.add(532);
	list.add(333145);
	list.add(833);
	radixsort(list);
	System.out.println(list);
    }

    
}
