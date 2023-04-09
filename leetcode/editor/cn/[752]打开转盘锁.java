import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        HashSet<String> dead = new HashSet<>();
        for(String deadend : deadends){
            dead.add(deadend);
        }
        // 记录已经穷举过的密码，防止走回头路
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (dead.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                for (int j = 0; j < 4; j++) {
                    String up = up(cur, j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = down(cur, j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    // 向上拨弄j位置的字符串
    public String up(String s, int j){
        char[] c = s.toCharArray();
        if (c[j] == '9')
            c[j] = '0';
        else
            c[j] += 1;
        return new String(c);
    }
    // 向下拨弄j位置的字符串
    public String down(String s, int j){
        char[] c = s.toCharArray();
        if (c[j] == '0')
            c[j] = '9';
        else
            c[j] -= 1;
        return new String(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
