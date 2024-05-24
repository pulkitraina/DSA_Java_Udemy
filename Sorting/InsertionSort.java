public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {4,6,3,1,2,7,5};
        nums = IS(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] IS(int[] nums){
        if(nums.length == 1){
            return nums;
        }
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i - 1;
            while(temp < nums[j]){
                nums[j+1] = nums[j];
                j -= 1;
                if(j == -1)
                    break;
            }
            nums[j+1] = temp;
        }
        return nums;
    }
}
