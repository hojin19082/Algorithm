import java.lang.Math;
public class heapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,4,1,3,14,16,9,10,2,8,7};

		int heap_size = arr.length-1;
		for(int i=(int) Math.floor((arr.length-1)/2); i>=1; i--) {
			max_heap(arr, i, arr.length-1);
		}
		
		for(int i=heap_size; i>=1; i--) {
			int temp = arr[1];
			arr[1] = arr[i];
			arr[i] = temp;
			
			max_heap(arr, 1, i-1);
		}
		
		int temp = arr[1];
		arr[1] = arr[2];
		arr[2] = temp;
		
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}
	private static void max_heap(int[] arr, int k, int last) {
		if( k*2 >= last) {
			return;
		}
		int i=0;
		if(arr[(k*2)] > arr[(k*2)+1]) {
			i = k * 2;
		}else {
			i = (k*2) +1;
		}
		if(arr[k] >= arr[i]) {
			return;
		}
		
		int temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;

		max_heap(arr, i, last);
	}
}
