
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;     // 与外面定义的变量产生关联
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = (long) nums[i] + preSum[i];
        }
        sort(preSum);   // 对前缀和数组使用归并排序，然后夹带私货
        return count;
    }

    // 用于辅助合并有序数组
    private long[] temp;
    private int count = 0;

    public void sort(long[] nums) {
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    // 定义：将子数组 nums[lo..hi] 进行排序
    private void sort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // 将 nums[lo..mid] 和 nums[mid+1..hi] 这两个有序数组合并成一个有序数组
    private void merge(long[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // 这段代码会超时
        // for (int i = lo; i <= mid; i++) {
        //     // 在区间 [mid + 1, hi] 中寻找 lower <= delta <= upper 的元素
        //     for (int k = mid + 1; k <= hi; k++) {
        //         long delta = nums[k] - nums[i];
        //         if (delta <= upper && delta >= lower) {
        //             count++;
        //         }
        //     }
        // }

        // 进行效率优化
        // 维护左闭右开区间 [start, end) 中的元素落在 [lower, upper] 中
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && nums[start] - nums[i] < lower) {
                start++;
            }
            while (end <= hi && nums[end] - nums[i] <= upper) {
                end++;
            }
            count += end - start;
        }

        // 数组双指针技巧，合并两个有序数组
        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
