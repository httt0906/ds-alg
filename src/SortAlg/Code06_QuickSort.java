package SortAlg;

public class Code06_QuickSort {
    /**
     * 改进快排 枢轴随机选
     * @param arr
     */
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l >= r) { // == 只有一个元素 > 空元素
            return;
        }
        // 随机选择一个枢轴 
        int rand = (int) (l + Math.random() * (r - l + 1));
        swap(arr, r, rand);

        int[] bounds = netherlandsFlagQ2(arr, arr[r], l, r);
        int lBound = bounds[0];
        int rBound = bounds[1];
        quickSort(arr, l, lBound);
        quickSort(arr, rBound, r);        
    }



    public static void quickSortNotImprove(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSortNotImprove(arr, 0, arr.length - 1);
    }

    public static void quickSortNotImprove(int[] arr, int l, int r){
        if (l >= r) { // == 只有一个元素 > 空元素
            return;
        }
        
        int[] bounds = netherlandsFlagQ2(arr, arr[r], l, r);
        int lBound = bounds[0];
        int rBound = bounds[1];
        quickSortNotImprove(arr, l, lBound);
        quickSortNotImprove(arr, rBound, r);        
    }
    
    /**
     * 荷兰国旗问题 01
     * @param arr
     * @param num
     */
    public static void netherlandsFlagQ1(int[] arr, int num){
        // printArray(arr);
        int bound = -1;
        int index = 0;
        while(index < arr.length){
            if (arr[index] <= num){
                swap(arr, index, bound + 1);
                bound++;
            } 
            index++;
        }
        // printArray(arr);
        // return bound
    }

    // 荷兰国旗问题 02 partition
    public static int[] netherlandsFlagQ2(int[] arr, int num, int L, int R){
        int index = L;
        L = L - 1;
        R = R + 1;
        // printArray(arr);
        while (index < R){
            if(arr[index] < num){
                swap(arr, index, L + 1);
                index++;
                L++;
            } else if(arr[index] > num){
                swap(arr, index, R - 1);
                R--;
            } else {
                index++;   
            }
        }
        // printArray(arr);
        return new int[] {L , R};
    }


    public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

    // for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 20);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

    public static void main(String[] args) {
        int[] arr = generateArray();
        // int[] arr = {1, 5, 7, 2, 4, 6};
        printArray(arr);
        // netherlandsFlagQ1(arr, 10);
        // netherlandsFlagQ2(arr, 10, 0, arr.length - 1);
        // quickSortNotImprove(arr);
        quickSort(arr);
        printArray(arr);
    }
}




