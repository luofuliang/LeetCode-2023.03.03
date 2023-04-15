<p>给定一个整数数组 <code>nums</code> 和一个整数 <code>k</code>&nbsp;，请返回其中出现频率前 <code>k</code> 高的元素。可以按 <strong>任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
<strong>输出: </strong>[1,2]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums = [1], k = 1
<strong>输出: </strong>[1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li> 
 <li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 347&nbsp;题相同：<a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">https://leetcode-cn.com/problems/top-k-frequent-elements/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 分治 | 桶排序 | 计数 | 快速选择 | 排序 | 堆（优先队列）</details><br>

<div>👍 53, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [347. 前 K 个高频元素](/problems/top-k-frequent-elements) 相同。

首先，肯定要用一个 `valToFreq` [哈希表](https://appktavsiei5995.pc.xiaoe-tech.com/detail/p_6265484ae4b01a4851f65633/6) 把每个元素出现的频率计算出来。

然后，这道题就变成了 [215. 数组中的第 K 个最大元素](/problems/kth-largest-element-in-an-array)，只不过第 215 题让你求数组中元素值 `e` 排在第 `k` 大的那个元素，这道题让你求数组中元素值 `valToFreq[e]` 排在前 `k` 个的元素。

我在 [快速排序详解及运用](https://labuladong.github.io/article/fname.html?fname=快速排序) 中讲过第 215 题，可以用 [优先级队列](https://labuladong.github.io/article/fname.html?fname=二叉堆详解实现优先级队列) 或者快速选择算法解决这道题。这里稍微改一下优先级队列的比较函数，或者改一下快速选择算法中的逻辑即可。

这里我再加一种解法，用计数排序的方式找到钱 `k` 个高频元素，见代码。

**标签：二叉堆，哈希表，快速选择**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 用优先级队列解决这道题
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        unordered_map<int, int> valToFreq;
        for (int v : nums) {
            valToFreq[v]++;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        // 队列按照键值对中的值（元素出现频率）从小到大排序
        for (auto entry : valToFreq) {
            pq.push(make_pair(entry.second, entry.first));
            if (pq.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                pq.pop();
            }
        }

        vector<int> res(k);
        for (int i = 0; i < k; i++) {
            // res 数组中存储前 k 个最大元素
            res[i] = pq.top().second;
            pq.pop();
        }

        return res;
    }
};

// 用计数排序的方法解决这道题
class Solution2 {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        unordered_map<int, int> valToFreq;
        for (int v : nums) {
            valToFreq[v]++;
        }

        // 频率 -> 这个频率有哪些元素
        vector<vector<int>> freqToVals(nums.size() + 1);
        for (auto entry : valToFreq) {
            int val = entry.first;
            int freq = entry.second;
            freqToVals[freq].push_back(val);
        }

        vector<int> res;
        // freqToVals 从后往前存储着出现最多的元素
        for (int i = freqToVals.size() - 1; i >= 0; i--) {
            if (freqToVals[i].size() == 0) continue;
            for (int j = 0; j < freqToVals[i].size(); j++) {
                // 将出现次数最多的 k 个元素装入 res
                res.push_back(freqToVals[i][j]);
                if (res.size() == k) {
                    return res;
                }
            }
        }

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # nums 中的元素 -> 该元素出现的频率
        valToFreq = {}
        for v in nums:
            valToFreq[v] = valToFreq.get(v, 0) + 1

        # 优先队列按照键值对中的值（元素出现频率）从小到大排序
        pq = [(freq, val) for val, freq in valToFreq.items()]
        heapq.heapify(pq)

        # 将前 k 个最大元素装入 res
        res = []
        for i in range(k):
            res.append(heapq.heappop(pq)[1])

        return res


class Solution2:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # nums 中的元素 -> 该元素出现的频率
        valToFreq = {}
        for v in nums:
            valToFreq[v] = valToFreq.get(v, 0) + 1

        # 频率 -> 这个频率有哪些元素
        freqToVals = [[] for _ in range(len(nums) + 1)]
        for val, freq in valToFreq.items():
            freqToVals[freq].append(val)

        # freqToVals 从后往前存储着出现最多的元素
        res = []
        for i in range(len(nums), 0, -1):
            if freqToVals[i]:
                for val in freqToVals[i]:
                    res.append(val)
                    if len(res) == k:
                        return res

        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 用优先级队列解决这道题
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>>
                pq = new PriorityQueue<>((entry1, entry2) -> {
            // 队列按照键值对中的值（元素出现频率）从小到大排序
            return entry1.getValue().compareTo(entry2.getValue());
        });

        for (Map.Entry<Integer, Integer> entry : valToFreq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                // 弹出最小元素，维护队列内是 k 个频率最大的元素
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            // res 数组中存储前 k 个最大元素
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}

// 用计数排序的方法解决这道题
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        // nums 中的元素 -> 该元素出现的频率
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for (int v : nums) {
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        // 频率 -> 这个频率有哪些元素
        ArrayList<Integer>[] freqToVals = new ArrayList[nums.length + 1];
        for (int val : valToFreq.keySet()) {
            int freq = valToFreq.get(val);
            if (freqToVals[freq] == null) {
                freqToVals[freq] = new ArrayList<>();
            }
            freqToVals[freq].add(val);
        }

        int[] res = new int[k];
        int p = 0;
        // freqToVals 从后往前存储着出现最多的元素
        for (int i = freqToVals.length - 1; i > 0; i--) {
            ArrayList<Integer> valList = freqToVals[i];
            if (valList == null) continue;
            for (int j = 0; j < valList.size(); j++) {
                // 将出现次数最多的 k 个元素装入 res
                res[p] = valList.get(j);
                p++;
                if (p == k) {
                    return res;
                }
            }
        }

        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

// 用优先级队列解决这道题
func topKFrequent(nums []int, k int) []int {
    // nums 中的元素 -> 该元素出现的频率
    valToFreq := make(map[int]int)
    for _, v := range nums {
        valToFreq[v] = valToFreq[v] + 1
    }

    // 个性化的 lambda
    lessFn := func(a, b interface{}) bool {
        a.(*MapEntry).Value.(int)
        return a.(*MapEntry).Value.(int) < b.(*MapEntry).Value.(int)
    }

    pq := priorityqueue.NewPriorityQueue(lessFn)
    for key, val := range valToFreq {
        pq.Insert(&MapEntry{Key: key, Value: val})
        if pq.Len() > k {
            pq.Pop()
        }
    }

    res := make([]int, k)
    for i := k - 1; i >= 0; i-- {
        // res 数组中存储前 k 个最大元素
        res[i] = pq.Pop().(*MapEntry).Key.(int)
    }

    return res
}

// MapEntry 提供给优先级队列使用的数据结构
type MapEntry struct {
    Key   interface{}
    Value interface{}
}

// 用计数排序的方法解决这道题
func topKFrequent2(nums []int, k int) []int {
    // nums 中的元素 -> 该元素出现的频率
    valToFreq := make(map[int]int)
    for _, v := range nums {
        valToFreq[v] = valToFreq[v] + 1
    }

    // 频率 -> 这个频率有哪些元素
    freqToVals := make([][]int, len(nums)+1)
    for key, val := range valToFreq {
        if freqToVals[val] == nil {
            freqToVals[val] = make([]int, 0)
        }
        freqToVals[val] = append(freqToVals[val], key)
    }

    res := make([]int, k)
    p := 0
    // freqToVals 从后往前存储着出现最多的元素
    for i := len(freqToVals) - 1; i > 0; i-- {
        valList := freqToVals[i]
        if valList == nil {
            continue
        }
        for _, val := range valList {
            // 将出现次数最多的 k 个元素装入 res
            res[p] = val
            p++
            if p == k {
                return res
            }
        }
    }

    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
  // nums 中的元素 -> 该元素出现的频率
  const valToFreq = new Map();
  for (const v of nums) {
    valToFreq.set(v, (valToFreq.get(v) || 0) + 1);
  }

  const compare = (entry1, entry2) => entry1[1] - entry2[1];
  // 队列按照键值对中的值（元素出现频率）从小到大排序
  const pq = new PriorityQueue(compare);

  for (const entry of valToFreq.entries()) {
    pq.push(entry);
    if (pq.size() > k) {
      // 弹出最小元素，维护队列内是 k 个频率最大的元素
      pq.pop();
    }
  }

  const res = new Array(k);
  for (let i = k - 1; i >= 0; i--) {
    // res 数组中存储前 k 个最大元素
    res[i] = pq.pop()[0];
  }

  return res;
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent2 = function(nums, k) {
  // nums 中的元素 -> 该元素出现的频率
  const valToFreq = new Map();
  for (const v of nums) {
    valToFreq.set(v, (valToFreq.get(v) || 0) + 1);
  }

  // 频率 -> 这个频率有哪些元素
  const maxFreq = nums.length;
  const freqToVals = new Array(maxFreq + 1).map(() => new Array());
  for (const [val, freq] of valToFreq.entries()) {
    freqToVals[freq].push(val);
  }

  const res = new Array(k);
  let p = 0;
  // freqToVals 从后往前存储着出现最多的元素
  for (let freq = maxFreq; freq > 0; freq--) {
    const valList = freqToVals[freq];
    for (const val of valList) {
      // 将出现次数最多的 k 个元素装入 res
      res[p] = val;
      p++;
      if (p === k) {
        return res;
      }
    }
  }

  return null;
}
```

</div></div>
</div></div>

**类似题目**：
  - [692. 前K个高频单词 🟠](/problems/top-k-frequent-words)
  - [剑指 Offer II 060. 出现频率最高的 k 个数字 🟠](/problems/g5c51o)

</details>
</div>



