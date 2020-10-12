public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        int size = nums.length;
        if (size == 0 || target < nums[0] || target > nums[size-1]) {
            return result;
        }
        //从左边逼近
        int positionLeft = binarySearchLeft(nums, target, 0, size-1);
        if (positionLeft == -1) {
            return result;
        }
        result[0] = positionLeft;
        //从右边逼近
        int positionRight = binarySearchRight(nums, target, 0, size-1);
        result[1] = positionRight;

        
        return result;
    }
    private int binarySearchLeft(int[] nums, int target, int begin, int end) {
        if (begin < end) {
            //当总数为偶数时，中间的位置归属于左边
            int medium = (begin+end)/2;
            if (target <= nums[medium]) {
                //当中间位置与目标值相等时，往左取
                return binarySearchLeft(nums, target, begin, medium);      
            }
            else {
                return binarySearchLeft(nums, target, medium+1, end);
            }
        }
        
        return nums[end] == target ? end : -1;
    }
    
    private int binarySearchRight(int[] nums, int target, int begin, int end) {
        if (begin < end) {
            //当总数为偶数时，中间位置归属于右边
            int medium = (begin+end+1)/2;
            if (nums[medium] <= target) {
                //当中间位置与目标值相等时，往右取
                return binarySearchRight(nums, target, medium, end);
            }
            else {
                return binarySearchRight(nums, target, begin, medium-1);
            }
        }
        
        return nums[begin] == target ? begin : -1;
    }
}