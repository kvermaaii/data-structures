package datastructures;

public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int arr1[] = {2, 3, -8, 7, -1, 2, 3};
		int arr2[] = {-2, -4};
		int arr3[] = {5, 4, 1, 7, 8};
		int arr4[] = {-2, -3, -1, -5};
		int arr5[] = {0, -1, 0, -2, 0};
		int arr6[] =  {-100, -200, 10, 20, -5, 30};
		
		System.out.println(ms.maximumSum(arr1));
		System.out.println(ms.maximumSum(arr2));
		System.out.println(ms.maximumSum(arr3));
		System.out.println(ms.maximumSum(arr4));
		System.out.println(ms.maximumSum(arr5));
		System.out.println(ms.maximumSum(arr6));		

	}
	public int maximumSum(int arr[]) {
		int length = arr.length;
		int res = arr[0];
		int sum = 0;
		for(int i =0; i<length; i++) {
			if(sum < 0) {
		       sum = 0;
			   sum = sum + arr[i];
			} else{
				sum = sum + arr[i];
			}
			if(sum <0 && arr[i]<0) {
				res = Math.max(res, arr[i]);
			}
			if(sum >= res) {
				res = sum;
			}
		}
		return res;
	}

}
