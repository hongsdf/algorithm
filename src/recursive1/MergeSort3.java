package recursive1;

class Main111{
	
	public void MergeSort(int arr[] , int start, int end) {
		if(start < end) { 
			int mid = (start+end) /2; //5 // 2 // 1 //0
			MergeSort(arr,start,mid);
//			MergeSort(arr,mid,end); // 증명하니 무한 루프가 도네
			MergeSort(arr,mid+1,end);
			Merge(arr,start,mid,end);
			
			//    1,5,3
			//  1     5,3 -> 1,3,5
		}
			
	}

	public void Merge(int[] arr, int start,int mid,int end) {
		int temp[] = new int[end-start+1];
		
		int i =start;  
		int j =mid+1; 
		int k =0;		
		while(i<=mid && j <=end) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				k++;
				i++;
			}else {
				temp[k] = arr[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid) {
			temp[k] = arr[i];
			k++;
			i++;
		}
		while(j<=end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		for(int v = start; v<=end; v++) {
			arr[v] = temp[v-start];
		}
	}
	
	
}




public class MergeSort3 {
	public static void main(String[] args) {
		Main111 m = new Main111();
		int arr1[] = {-1,3,5,2,5}; // -1,2,3,5,5
//		int arr2[] = {4,0,1,3,2};
		m.MergeSort(arr1,0,arr1.length-1);
		for(int i =0; i <arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
	}
}
