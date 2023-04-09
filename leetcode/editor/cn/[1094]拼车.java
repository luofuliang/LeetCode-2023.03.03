
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int[] trip : trips){   //即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int val = trip[0];      //乘客数量
            int i = trip[1];        //上车站点
            int j = trip[2]-1;      //下车站点

            df.updata(i,j,val);
        }
        int[] result = df.result();
        for (int i = 0; i < result.length; i++) {
            if(result[i]>capacity)
                return false;
        }
        return true;
    }
    class Difference{
        static int[] diff;

        public Difference(int[] nums){
            assert nums.length>0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < diff.length; i++) {
                diff[i] = nums[i] - nums[i-1];
            }
        }

        public void updata(int i, int j, int val){
            diff[i] += val;
            if(j+1 < diff.length){
                diff[j+1] -= val;
            }
        }

        public int[] result(){
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i=1; i<diff.length; i++){
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
