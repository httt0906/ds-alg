package SortAlg;

public class Code03_InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // [0:i-1]有序 将i插入[0:i]使之有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
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
        int testNum = 10;
        for (int i = 0; i < testNum; i++) {
            System.out.println("第" + (i + 1) + "次测试：");
            int[] arr = generateRandomArray(20, 20);
            printArray(arr);
            insertionSort(arr);
            printArray(arr);
        }

    }

}
