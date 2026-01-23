package NeedCode;

public class ContainsDuplicate {
	public static void main(String[] args) {
		
		int [] nums = {1,2,5,4,7,4,8,9,1,5,0,3};
		System.out.println(hasDuplicate(nums));
	}
    public static boolean hasDuplicate(int[] nums) {

        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
	

