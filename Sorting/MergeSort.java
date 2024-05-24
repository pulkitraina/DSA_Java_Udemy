import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        arr = mergeSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }    

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1)
            return arr;
        int mid = arr.length/2;
        
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArrays(left, right);
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                res[k++] = arr1[i++];
            }
            else{
                res[k++] = arr2[j++];
            }
        }
        while(i < arr1.length){
            res[k++] = arr1[i++];
        }
        while(j < arr2.length){
            res[k++] = arr2[j++];
        }
        return res;
    }
}
