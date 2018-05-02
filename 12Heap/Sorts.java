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
            System.out.print("Asfasdf");
            swap(data, 0, pos);
            pushdown(data, 0, pos);
        }
    }
    
    public static void main(String[] args){
        int[] a = {1,1,1,1,1,1,1,3,1,1, 234,325,145,513341,13,45,13,13,3,3,31,2,35,13,34,1,57,27,652,624,43,22,1,1};
	    MyHeap<Integer> heap = new MyHeap<Integer>(true);
        for(int i : a){
            System.out.print(i + " ");
        }
	    heapsort(a);
        System.out.println();
	    //	pushdown(a, 0, a.length);
        for(int i : a){
	        //heap.add(i);
            System.out.print(i + " ");
        }

	//	System.out.println(heap);
    }
}
