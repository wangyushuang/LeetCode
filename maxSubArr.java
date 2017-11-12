//最大子数组问题（Maximum SubArray）

import java.util.Arrays;
public class maxSubArr{
	public static void main(String[] args){
		int [] array={-2,1,-3,4,-1,2,1,-5,4};
		int max=maxSubArray(array);
		System.out.println(Arrays.toString(array)+":"+max);
	}	
    public static int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<=0)
                sum=nums[i];
            else
                sum+=nums[i];
            if(sum>max)
                max=sum;
        }
        return max;
    }
}