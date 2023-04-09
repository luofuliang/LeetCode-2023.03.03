
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference df = new Difference(nums);

        for(int[] booking : bookings){
            int i = booking[0]-1;
            int j = booking[1]-1;
            int val = booking[2];
            df.increment(i, j, val);
        }
        return df.result();
    }

    class Difference{
        //1.定义一个差分数组
        static int[] diff;

        //2.输⼊⼀个初始数组，区间操作将在这个数组上进行
        public Difference(int[] nums) {
            assert nums.length>0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        //3.给闭区间 [i, j] 增加 val（可以是负数）
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if(j+1 < diff.length)
                diff[j+1] -= val;
        }

        //4.还原结果集
        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
