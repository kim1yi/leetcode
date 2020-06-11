public class Solution55 {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        int last=size-1,i;
        for(i=size-2;i>=0;i--){
            //意味着可以到达这一格
            if(i+nums[i]>=last) {
                last=i;
            }
        }
        //判断最后能到达的那一格是否是刚开始那格
        return last<=0;
    }

    public boolean myCanJump(int[] nums) {
        int size = nums.length;
        //记录最远能到达的位置
        int maxLocation = 0;
        for (int i = 0; i < size; i++) {
            //说明这格已经走不到了
            if (maxLocation < i) {
                return false;
            }
            maxLocation = Math.max(maxLocation, i+nums[i]);
        }
        return true;
    }
}