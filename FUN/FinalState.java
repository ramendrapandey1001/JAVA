/*
3264. Final Array State After K Multiplication Operations
You are given an integer array nums, an integer k, and an integer multiplier.

        1.You need to perform k operations on nums. In each operation:
        2.Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
        3.Replace the selected minimum value x with x * multiplier.
        4.Return an integer array denoting the final state of nums after performing all k operations.
*/
package JAVA.FUN;
import java.util.Arrays;
public class FinalState {
    public static void main(String[] args) {
        int [] array = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        int[] result = FinalState.getFinalState(array, k, multiplier );
        System.out.println(Arrays.toString(result));
    }
        public static int[] getFinalState(int[] nums, int k, int multiplier) {
            while(k>0){
                int min = nums[0];
                int minIndex = 0;
                for(int i = 0; i< nums.length; i++){
                    if(nums[i] < min){
                        min = nums[i];
                        minIndex = i;
                    }
                }
                nums[minIndex] = nums[minIndex] * multiplier;
                k--;
            }
            return nums;
        }
    }

