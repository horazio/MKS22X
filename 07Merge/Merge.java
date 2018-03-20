public class Merge{
    public static void mergesort(int[] data, int[] temp, int start, int end){
	int midpoint = (start + end) / 2;
	if(start < end){
	    mergesort(temp, data, start, midpoint); 
	    mergesort(temp, data, midpoint + 1, end);
	}
	merge(data, temp, start, midpoint, midpoint + 1, end);
    }
}
