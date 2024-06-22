package SortAlg;

public class Code04_MergeSort {
    public static void mergeSort(int[] arr, int L, int R) {
        if (arr == null){
            throw new NullPointerException("null");
        }
        if (arr.length == 0){
            throw new IllegalArgumentException("empty");
        }
        if (L == R){
            return;
        }

        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r){
            help[i] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            i++;
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
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
        int[] arr = generateRandomArray(50, 100);
        System.out.println("生成随机数组");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("归并排序结果");
        printArray(arr);

        
    }
    
}
