package NeedCode;
import java.util.HashMap;

public class TwoSums {
	public static void main(String[] args) {
		
	}


	public static int [] toSumHashmap(int[] nums, int target){
		HashMap <Integer, Integer> result = new HashMap<>();

		for(int i = 0 ; i < nums.length ; i++){
			int tempNum = target - nums[i];

			if(result.containsKey(tempNum)){
				return new int[] { result.get(tempNum), i};
			}

			result.put(nums[i], i);
		}

		return new int[2];
	}

	 public int[] twoSum(int[] nums, int target) {
        int [] result = new int [2];

        for(int i = 0 ; i < nums.length - 1 ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
