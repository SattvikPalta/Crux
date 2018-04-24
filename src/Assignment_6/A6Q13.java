package Assignment_6;

public class A6Q13 {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 2, 3, 0, 1, 6 };
		display(arr);
		inverse(arr, 0);
		System.out.println();
		display(arr);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static void inverse(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		int temp = arr[vidx];
		inverse(arr, vidx + 1);
		arr[temp] = vidx;
	}
}