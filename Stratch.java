import java.util.Scanner;
import java.lang.Math;

public class Stratch {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,1,1,0};
        int k = 3;

        System.out.println(minKBitFlips(arr, k));

    }

    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] obs = new int[n+1];
        int count = 0;

        for(int i = 0; i < n-k; i++){
            obs[i] = 0;
        }

        int diff;
        for(int i = 0; i < n-k+1; i++){
            if(i==0)
                obs[i] = 0;
            else
                obs[i] += obs[i-1];
            diff = count - obs[i];

            if((nums[i] == 0 && diff%2 == 1) || (nums[i] == 1 && diff%2 == 0))
                continue;
            
            count++;
            obs[i+k] += 1;

            System.out.print("Obsoluete Array1: ");
            for(int t = 0; t < n; t++)
                System.out.print(obs[t] + " ");
            System.out.println("Count is "+ count);
        }

        for(int i = n-k; i < n; i++){
            obs[i] += obs[i-1];
            System.out.print("Obsoluete Array2: ");
            for(int t = 0; t < n; t++)
                System.out.print(obs[t] + " ");
            if((nums[i] == 0 && obs[i]%2==0) || (nums[i] == 1 && obs[i]%2==1))
                return -1;
        }
        return count;
    }
}
