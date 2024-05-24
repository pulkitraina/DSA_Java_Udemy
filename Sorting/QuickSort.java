import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int l, int h){
        if(h == l || h < l)
            return;
        if(h - l == 1){
            if(arr[h] > arr[l]){
                return;
            }
        }
        int pivot = pivot(arr, l, h);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot+1, h);
    }

    public static int pivot(int[] arr, int l, int h){

        int pivot = l;
        for(int i = l + 1; i <= h; i++){
            if(arr[i] < arr[l]){
                pivot++;
                swap(arr, pivot, i);
            }
        }
        swap(arr, l, pivot);

        return pivot;
    }

    public static void swap(int[] arr, int ind1, int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public static int removeDuplicates(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res = nums.length;
        for(int i : nums){
            if(hm.containsKey(i)){
                res--;
            }
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        return res;
    }
}
