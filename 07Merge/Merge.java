public class Merge{
    public static void mergesort(int[] data, int[] temp, int start, int end){
	int midpoint = (start + end) / 2;
	if(start < end){
	    int[] holder = temp;
	    temp = data;
	    data = holder;
	    mergesort(temp, data, start, midpoint); 
	    mergesort(temp, data, midpoint + 1, end);
	}
	merge(data, temp, start, midpoint, midpoint + 1, end);
    }

    public static void merge(int[] data, int[] temp, int start, int mid, int augmid, int end){
	for(int i = start; i < end; i++){
	    if(start < mid && temp[start] < temp[augmid]){
		data[i] = temp[start];
		start++;
	    }else{
		data[i] = temp[augmid];
		augmid++;	    }
	}

    }
    public static void main(String args[]){	
	int[] dat2 = {6,7,8,9,10,1,2,3,4,5};
	int length = dat2.length;
	int[] dat1 = new int[length];
	merge(dat1, dat2, 0,4, 5, length); 
	for(int i = 0; i < length; i++){
	    System.out.println(dat1[i]);
	}
    }
}
