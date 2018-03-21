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
        data = data2;
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        
        
        
    }
    
    public static void main(String args[]){	
        int[] dat2 = {2,3,1,12,21,9,8,7,6,5,4,3,2,1,12,31,342,124,12,2,3,4,3,2,1,2,3,4,3,2,1,2,2,3};
        //int length = dat2.length;
        //int[] dat1 = new int[length];
        //merge(dat1, dat2, 0,1, 2, length - 1); 
        //mergesort(dat1, dat2, 0, length - 1);
        mergesort(dat2);
        
        
        for(int i = 0; i < dat2.length; i++){
            System.out.println(dat2[i]);
        }
    }
}
