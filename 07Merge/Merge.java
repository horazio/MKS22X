public class Merge{
    
    public static void mergesort(int[] data, int[] temp, int start, int end){
        if(start < end){	    
            int midpoint = (start + end) / 2;
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
	for(int i = 0; i < data.length ; i++){
                data2[i] = data[i];
	}
        mergesort(data2, data, 0, data.length - 1);      
	 for(int i = 0; i < data.length; i++){
            data[i] = data2[i];
	 }      
    }
    
    public static void main(String args[]){	
	int[] data = {1,2,33,234,15,43,123,1234,1324,134,4,322,345,234,235,4312,1344,42,12344,234,432,34,4,5,6,7,6,5,4,3,2,1};
	
	mergesort(data);

	for(int i = 0; i < data.length; i++){
	    System.out.println(data[i]);
	}
	
    }
}
