public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {3,5,2,4,1,7,6};

        nums = SS(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] SS(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int minIndex = i;
            for(int j = minIndex+1; j<nums.length; j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
