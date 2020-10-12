public class Solution33 {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0)
            return -1;
        if (size == 1) 
            return nums[0] == target ? 0 : -1;
    
        return binarySearch(nums, 0, size-1, target);    
    }
    
    private int binarySearch(int[] nums, int begin, int end, int target) {
        if (begin < end) {
            int medium = (begin+end)/2;
            int currentNum = nums[medium];
            if (target == currentNum) {
                return medium;
            }
            //按照两种可能来划分，第一种，取到了前一个顺序数列中的值
            if (currentNum >= nums[begin]) {
                if (target >= nums[begin] && target < currentNum) {
                    return binarySearch(nums, begin, medium-1, target);
                }
                else if (target <= nums[end] || target > currentNum) {
                    return binarySearch(nums, medium+1, end, target);
                }
                else
                    return -1;
            }
            //第二种，取到了后一个顺序数列中的值
            else {
                if (target > currentNum && target <= nums[end]) {
                    return binarySearch(nums, medium+1, end, target);
                }
                else if (target >= nums[begin] || target < currentNum) {
                    return binarySearch(nums, begin, medium-1, target);
                }
                else
                    return -1;
            }
            
        }
        
        return nums[begin] == target ? begin : -1;
    }
}