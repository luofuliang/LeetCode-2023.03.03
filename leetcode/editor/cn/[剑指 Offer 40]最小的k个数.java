
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 快速选择法
    public int[] getLeastNumbers(int[] arr, int k) {
       int[] res = new int[k];
       shuffle(arr);
       int low=0, high=arr.length-1;
       int ans = k-1;   // 最小的k个数，最大的下标为k-1；最大的k个数，最小的下标为n-k。
       while (low <= high){
           int p = partition(arr, low, high);
           if (p < ans){
               low = p+1;
           }else if (p > ans){
               high = p-1;
           }else {
               for (int i = 0; i <= p; i++) {
                   res[i] = arr[i];
               }
               //for (int i = 0; i < k; i++) {      最大的k个数这样取
               //    res[i] = arr[i+p];
               //}
               return res;
           }
       }
       return res;
    }
    public int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i=low+1, j=high;
        while (i <= j){
            while (i<=high && nums[i]<=pivot)
                i++;
            while (j>=low+1 && nums[j]>pivot)
                j--;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }
    public void shuffle(int[] nums){
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = i + random.nextInt(nums.length-i);
            swap(nums, i, j);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
