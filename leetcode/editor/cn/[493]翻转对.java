
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 归并排序，在merge函数处进行加逻辑
    int count = 0;
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length-1);
        return count;
    }
    public void sort(int[] nums, int start, int end){
        if (start == end){
            return;
        }
        int mid = start + (end-start)/2;
        sort(nums, start, mid);
        sort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }
    public void merge(int[] nums, int start, int mid, int end){
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        // 进⾏效率优化，维护左闭右开区间 [mid+1, p) 中的元素乘 2 ⼩于 nums[i]
        // 为什么 p 是开区间？因为这样的话可以保证初始区间 [mid+1, mid+1) 是⼀个空区间
        int p = mid + 1;
        for (int i = start; i <= mid; i++) {
            // nums 中的元素可能较⼤，乘 2 可能溢出，所以转化成 long
            while (p <= end && (long)nums[i] > (long)nums[p] * 2) {
                p++;
            }
            count += p - (mid + 1);
        }

        int i=start, j=mid+1;
        for (int k = start; k <= end; k++) {
            if (i == mid+1){
                nums[k] = temp[j++];
            }else if (j == end+1){
                nums[k] = temp[i++];
            }else if (temp[i] > temp[j]){
                nums[k] = temp[j++];
            }else {
                nums[k] = temp[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
