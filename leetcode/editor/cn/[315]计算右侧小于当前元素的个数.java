
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private class Pair{
        int val, index;
        Pair(int val, int index){
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.index = index;
        }
    }
    // 归并排序所⽤的辅助数组
    private Pair[] temp;
    // 记录每个元素后⾯⽐⾃⼰⼩的元素个数
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];
        Pair[] arr = new Pair[n];
        // 记录元素原始的索引位置，以便在 count 数组中更新结果
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i],i);
        }
        sort(arr, 0, n-1);

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }
    public void sort(Pair[] arr, int start, int end){
        // base case
        if (start == end)
            return;
        int mid = start + (end-start)/2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    public void merge(Pair[] arr, int start, int mid, int end){
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int i=start, j=mid+1;
        for (int k = start; k <= end; k++) {
            if (i == mid+1){
                arr[k] = temp[j++];
            }else if (j == end+1){
                arr[k] = temp[i++];
                count[arr[k].index] += j-(mid+1);     // 更新 count 数组
            }else if (temp[i].val > temp[j].val){
                arr[k] = temp[j++];
            }else {
                arr[k] = temp[i++];
                count[arr[k].index] += j-(mid+1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
