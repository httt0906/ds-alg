package SortAlg;

public class Code05_HeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
			return;
		}
        // 变成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        // 最大的数放在堆尾 并断开和堆的联系 堆的元素数量减去1
        swap(arr, 0, --size);
        // 循环操作 直至堆的大小为0
        while(size > 0){
            // 变成大根堆
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }


    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

    /**
     * 
     * @param arr
     * @param index 从哪个位置出发 往下做heapify
     * @param heapSize 堆内元素的个数
     */
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize) { // 表示index还有孩子
            int largest = left;
            if (left + 1 < heapSize){ // 表示index有两个孩子
                // largest = arr[left] > arr[left + 1] ? arr[left] : arr[left + 1];
                largest = arr[left] > arr[left + 1] ? left : left + 1;
            } 
            if (arr[index] < arr[largest]){
                swap(arr, index, largest);
                index = largest;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random():[0,1)
        int arrayLength = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[arrayLength];

        for (int i = 0; i < arr.length; i++) {
            // (int) 向接近0的方向取整数
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }

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
        int[] arr = generateRandomArray(20, 100);
        System.out.println("生成随机数组");
        printArray(arr);
        heapSort(arr);
        System.out.println("堆排序结果");
        printArray(arr);
    }

    
    
}
