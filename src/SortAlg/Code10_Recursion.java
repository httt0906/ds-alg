package SortAlg;

// 递归寻找最大值
public class Code10_Recursion {

    // 使用递归的方法 求得一个数组的最大值
    public static int getMax(int[] arr) {
        if (arr == null){
            throw new NullPointerException("null");
        } else if (arr.length == 0) {
            throw new IllegalArgumentException("empty");
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L)>> 1);
        int LMax = process(arr, L, mid);
        int RMax = process(arr, mid + 1, R);
        return Math.max(LMax, RMax);
    }    


}
