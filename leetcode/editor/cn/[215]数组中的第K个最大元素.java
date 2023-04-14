
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 快速选择算法
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int low=0, high=nums.length-1;
        int ans = nums.length-k;    // 排名第一的最大元素的下标为n-1，排名第k的最大元素n-k
        while (low <= high){
            int p = partition(nums, low, high);
            if (p == ans){
                return nums[p];
            }else if (p < ans){
                low = p+1;
            }else if (p > ans){
                high = p-1;
            }
        }
        return -1;
    }
    public int partition(int[] nums, int low, int high){
        int povit = nums[low];
        int i=low+1, j=high;
        while (i <= j){
            while (i<=high && nums[i]<=povit)
                i++;
            while (j>=low+1 && nums[j]>povit)
                j--;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void shuffle(int[] nums){
        int n = nums.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = i + random.nextInt(n-i);
            swap(nums,i, j);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
