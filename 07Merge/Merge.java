public class Merge{
    
    public static void mergesort(int[] data, int[] temp, int start, int end){
        if(start < end){
            
            for(int i = start; i <= end; i++){
                data[i] = temp[i];
            }
            
            int midpoint = (start + end) / 2;
            
            //int[] holder = temp;
            //temp = data;
            //data = holder;
            
            mergesort(temp, data, start, midpoint); 
            mergesort(temp, data, midpoint + 1, end);
            
            
            
            merge(data, temp, start, midpoint, midpoint + 1, end);
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
        mergesort(data2, data, 0, data.length - 1);      
        for(int i = 0; i < data.length; i++){
            data[i] = data2[i];
        }      
    }
    
    public static void main(String args[]){	
        int[] dat2 = new ;
        mergesort(dat2);
        
        
        for(int i = 0; i < dat2.length; i++){
            System.out.println(dat2[i]);
        }
    }
}
