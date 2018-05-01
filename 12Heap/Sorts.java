public class Sorts{
    private static void heapify(int[] data){
        for(int i = data.length - 1; i >= 0; i--){
            pushdown(data, i, data.length);
        }
    }
    
    
    private static void pushdown(int[] data, int i, int end){
        if(end - i > 1){
            int temp;
            int newi = 0;
            boolean goOn = true;
            while( newi == 0 || (goOn && data[i] <= data[newi])){
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
    
    public static void heapSort(int[] data){
        heapify(data);
        for(int pos = data.length - 1; pos > 0; pos--){
            swap(data, 0, pos);
            pushdown(data, 0, pos);
        }
    }
    
    public static void main(String[] args){
        int[] a = {1,2,3,7,3,2,56,6,2,1,245,2,345,71,46,21345,145,14,7613,6,234,61,45,71,47,1};
        heapSort(a);
        for(int i : a){
            System.out.println(i);
        }
    }
}