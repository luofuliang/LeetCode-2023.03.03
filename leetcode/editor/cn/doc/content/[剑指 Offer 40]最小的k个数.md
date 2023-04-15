<p>输入整数数组 <code>arr</code> ，找出其中最小的 <code>k</code> 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [3,2,1], k = 2
<strong>输出：</strong>[1,2] 或者 [2,1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [0,1,2,1], k = 1
<strong>输出：</strong>[0]</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul> 
 <li><code>0 &lt;= k &lt;= arr.length &lt;= 10000</code></li> 
 <li><code>0 &lt;= arr[i]&nbsp;&lt;= 10000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 快速选择 | 排序 | 堆（优先队列）</details><br>

<div>👍 551, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [215. 数组中的第 K 个最大元素](/problems/kth-largest-element-in-an-array) 很像，建议你先做 215 题，我专门给那道题写了一篇详细的题解。

这道题有很多解题思路，第一个最简单的思路就是排序，然后把前 `k` 个元素拿出来就行了，时间复杂度是 `O(NlogN)`，`N` 表示 `arr` 的元素个数。

第二个思路是利用 [二叉堆](https://labuladong.github.io/article/fname.html?fname=二叉堆详解实现优先级队列)，时间复杂度是 `O(NlogK)`，第三个思路是利用 [快速选择算法](https://labuladong.github.io/article/fname.html?fname=快速排序)，时间复杂度是 `O(N)`，效率最高。

这里我写一下后两种思路吧，其实就是把 215 题的解法稍微改一改就行了，具体思路解析见 215 题和 [快速选择算法](https://labuladong.github.io/article/fname.html?fname=快速排序) 的图文解析。

**标签：快速排序**

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

// 二叉堆的解法思路
class Solution1 {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        // 大顶堆，堆顶是最大元素
        priority_queue<int> pq;
        for (int e : arr) {
            // 每个元素都要过一遍二叉堆
            pq.push(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.pop();
            }
        }
        // pq 中剩下的是 arr 中最小的 k 个元素
        vector<int> res(k);
        int i = 0;
        while (!pq.empty()) {
            res[i] = pq.top();
            pq.pop();
            i++;
        }
        return res;
    }
};

// 快速选择的解法思路
class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        vector<int> res(k);
        // 注意此题的 k 是元素个数而不是索引，所以和索引 p 做比较时要 - 1
        // 首先随机打乱数组
        shuffle(arr);
        int lo = 0, hi = arr.size() - 1;
        // 现在开始寻找第 k 大的元素
        while (lo <= hi) {
            // 在 arr[lo..hi] 中选一个分界点
            int p = partition(arr, lo, hi);
            if (p < k - 1) {
                // 第 k 大的元素在 arr[p+1..hi] 中
                lo = p + 1;
            } else if (p > k - 1) {
                // 第 k 大的元素在 arr[lo..p-1] 中
                hi = p - 1;
            } else {
                // arr[p] 就是第 k 大元素，又因为快速排序的性质，
                // arr[p] 左边的元素都比 arr[p] 小，所以现在 arr[0..k] 就是我们要找的答案
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            }
        }
        return res;
    }

    // 对 nums[lo..hi] 进行切分
    int partition(vector<int>& nums, int lo, int hi) {
        int pivot = nums[lo];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }

            if (i >= j) {
                break;
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            // 交换 nums[j] 和 nums[i]
            swap(nums[i], nums[j]);
            // 此时 [lo, i] <= pivot && [j, hi] > pivot
        }
        // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums[lo], nums[j]);
        return j;
    }

    // 洗牌算法，将输入的数组随机打乱
    void shuffle(vector<int>& nums) {
        srand((unsigned)time(NULL));
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand() % (n - i);
            swap(nums[i], nums[r]);
        }
    }

    // 原地交换数组中的两个元素
    void swap(int& a, int& b) {
        int temp = a;
        a = b;
        b = temp;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# 二叉堆的解法思路
class Solution1:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        # 大顶堆，堆顶是最大元素
        pq = []
        for e in arr:
            # 每个元素都要过一遍二叉堆
            heapq.heappush(pq, -e)
            # 堆中元素多于 k 个时，删除堆顶元素
            if len(pq) > k:
                heapq.heappop(pq)
        # pq 中剩下的是 arr 中最小的 k 个元素
        res = []
        while pq:
            res.append(-heapq.heappop(pq))
        return res[::-1]

# 快速选择的解法思路
class Solution:
    def getLeastNumbers(self, arr: List[int], k: int) -> List[int]:
        res = [0] * k

        # 注意此题的 k 是元素个数而不是索引，所以和索引 p 做比较时要 - 1
        # 首先随机打乱数组
        self.shuffle(arr)
        lo, hi = 0, len(arr) - 1
        # 现在开始寻找第 k 大的元素
        while lo <= hi:
            # 在 arr[lo..hi] 中选一个分界点
            p = self.partition(arr, lo, hi)
            if p < k - 1:
                # 第 k 大的元素在 arr[p+1..hi] 中
                lo = p + 1
            elif p > k - 1:
                # 第 k 大的元素在 arr[lo..p-1] 中
                hi = p - 1
            else:
                # arr[p] 就是第 k 大元素，又因为快速排序的性质，
                # arr[p] 左边的元素都比 arr[p] 小，所以现在 arr[0..k] 就是我们要找的答案
                for i in range(k):
                    res[i] = arr[i]
                return res

        return res

    # 对 nums[lo..hi] 进行切分
    @staticmethod
    def partition(nums: List[int], lo: int, hi: int) -> int:
        pivot = nums[lo]
        # 关于区间的边界控制需格外小心，稍有不慎就会出错
        # 我这里把 i, j 定义为开区间，同时定义：
        # [lo, i) <= pivot；(j, hi] > pivot
        # 之后都要正确维护这个边界区间的定义
        i, j = lo + 1, hi
        # 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while i <= j:
            while i < hi and nums[i] <= pivot:
                i += 1
                # 此 while 结束时恰好 nums[i] > pivot
            while j > lo and nums[j] > pivot:
                j -= 1
                # 此 while 结束时恰好 nums[j] <= pivot

            if i >= j:
                break
            # 此时 [lo, i) <= pivot && (j, hi] > pivot
            # 交换 nums[j] 和 nums[i]
            nums[i], nums[j] = nums[j], nums[i]
            # 此时 [lo, i] <= pivot && [j, hi] > pivot

        # 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        nums[lo], nums[j] = nums[j], nums[lo]
        return j

    # 洗牌算法，将输入的数组随机打乱
    @staticmethod
    def shuffle(nums: List[int]) -> None:
        n = len(nums)
        for i in range(n):
            # 生成 [i, n - 1] 的随机数
            r = i + random.randint(0, n - i - 1)
            nums[i], nums[r] = nums[r], nums[i]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 二叉堆的解法思路
class Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 大顶堆，堆顶是最大元素
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int e : arr) {
            // 每个元素都要过一遍二叉堆
            pq.offer(e);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 arr 中最小的 k 个元素
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}

// 快速选择的解法思路
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        // 注意此题的 k 是元素个数而不是索引，所以和索引 p 做比较时要 - 1
        // 首先随机打乱数组
        shuffle(arr);
        int lo = 0, hi = arr.length - 1;
        // 现在开始寻找第 k 大的元素
        while (lo <= hi) {
            // 在 arr[lo..hi] 中选一个分界点
            int p = partition(arr, lo, hi);
            if (p < k - 1) {
                // 第 k 大的元素在 arr[p+1..hi] 中
                lo = p + 1;
            } else if (p > k - 1) {
                // 第 k 大的元素在 arr[lo..p-1] 中
                hi = p - 1;
            } else {
                // arr[p] 就是第 k 大元素，又因为快速排序的性质，
                // arr[p] 左边的元素都比 arr[p] 小，所以现在 arr[0..k] 就是我们要找的答案
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            }
        }
        return res;
    }

    // 对 nums[lo..hi] 进行切分
    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        // 关于区间的边界控制需格外小心，稍有不慎就会出错
        // 我这里把 i, j 定义为开区间，同时定义：
        // [lo, i) <= pivot；(j, hi] > pivot
        // 之后都要正确维护这个边界区间的定义
        int i = lo + 1, j = hi;
        // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                // 此 while 结束时恰好 nums[i] > pivot
            }
            while (j > lo && nums[j] > pivot) {
                j--;
                // 此 while 结束时恰好 nums[j] <= pivot
            }

            if (i >= j) {
                break;
            }
            // 此时 [lo, i) <= pivot && (j, hi] > pivot
            // 交换 nums[j] 和 nums[i]
            swap(nums, i, j);
            // 此时 [lo, i] <= pivot && [j, hi] > pivot
        }
        // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
        swap(nums, lo, j);
        return j;
    }

    // 洗牌算法，将输入的数组随机打乱
    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

// 二叉堆的解法思路
func getLeastNumbers(arr []int, k int) []int {
    // 大顶堆，堆顶是最大元素
    pq := make(IntHeap, 0)
    heap.Init(&pq)
    for _, e := range arr {
        // 每个元素都要过一遍二叉堆
        heap.Push(&pq, e)
        // 堆中元素多于 k 个时，删除堆顶元素
        if pq.Len() > k {
            heap.Pop(&pq)
        }
    }
    // pq 中剩下的是 arr 中最小的 k 个元素
    res := make([]int, k)
    i := 0
    for pq.Len() > 0 {
        res[i] = heap.Pop(&pq).(int)
        i++
    }
    return res
}

type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
    old := *h
    n := len(old)
    x := old[n-1]
    *h = old[0 : n-1]
    return x
}

// 快速选择的解法思路
func getLeastNumbers(arr []int, k int) []int {
    res := make([]int, k)
    // 注意此题的 k 是元素个数而不是索引，所以和索引 p 做比较时要 - 1
    // 首先随机打乱数组
    shuffle(arr)
    lo, hi := 0, len(arr)-1
    // 现在开始寻找第 k 大的元素
    for lo <= hi {
        // 在 arr[lo..hi] 中选一个分界点
        p := partition(arr, lo, hi)
        if p < k-1 {
            // 第 k 大的元素在 arr[p+1..hi] 中
            lo = p + 1
        } else if p > k-1 {
            // 第 k 大的元素在 arr[lo..p-1] 中
            hi = p - 1
        } else {
            // arr[p] 就是第 k 大元素，又因为快速排序的性质，
            // arr[p] 左边的元素都比 arr[p] 小，所以现在 arr[0..k] 就是我们要找的答案
            copy(res, arr[:k])
            return res
        }
    }
    return res
}

// 对 nums[lo..hi] 进行切分
func partition(nums []int, lo, hi int) int {
    pivot := nums[lo]
    // 关于区间的边界控制需格外小心，稍有不慎就会出错
    // 我这里把 i, j 定义为开区间，同时定义：
    // [lo, i) <= pivot；(j, hi] > pivot
    // 之后都要正确维护这个边界区间的定义
    i, j := lo+1, hi
    // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
    for i <= j {
        for i < hi && nums[i] <= pivot {
            i++
            // 此 while 结束时恰好 nums[i] > pivot
        }
        for j > lo && nums[j] > pivot {
            j--
            // 此 while 结束时恰好 nums[j] <= pivot
        }

        if i >= j {
            break
        }
        // 此时 [lo, i) <= pivot && (j, hi] > pivot
        // 交换 nums[j] 和 nums[i]
        nums[i], nums[j] = nums[j], nums[i]
        // 此时 [lo, i] <= pivot && [j, hi] > pivot
    }
    // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
    nums[lo], nums[j] = nums[j], nums[lo]
    return j
}

// 洗牌算法，将输入的数组随机打乱
func shuffle(nums []int) {
    rand.Seed(time.Now().UnixNano())
    n := len(nums)
    for i := 0; i < n; i++ {
        // 生成 [i, n - 1] 的随机数
        r := i + rand.Intn(n-i)
        nums[i], nums[r] = nums[r], nums[i]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var getLeastNumbers = function(arr, k) {
  // 大顶堆，堆顶是最大元素
  let pq = new PriorityQueue((a, b) => {
    return b - a;
  });
  for (let e of arr) {
    // 每个元素都要过一遍二叉堆
    pq.offer(e);
    // 堆中元素多于 k 个时，删除堆顶元素
    if (pq.size() > k) {
      pq.poll();
    }
  }
  // pq 中剩下的是 arr 中最小的 k 个元素
  let res = new Array(k);
  let i = 0;
  while (pq.size() > 0) {
    res[i] = pq.poll();
    i++;
  }
  return res;
}

class PriorityQueue {
  constructor(compareFn = (a, b) => a - b) {
    this.compareFn = compareFn;
    this.heap = [];
  }

  // 获取堆的大小
  size() {
    return this.heap.length;
  }

  // 获取堆顶元素
  peek() {
    if (this.heap.length === 0) {
      return null;
    }
    return this.heap[0];
  }

  // 删除堆顶元素
  poll() {
    if (this.heap.length === 0) {
      return null;
    }
    const top = this.heap[0];
    const last = this.heap.pop();
    if (this.heap.length > 0) {
      this.heap[0] = last;
      this.siftDown(0);
    }
    return top;
  }

  // 向堆中插入一个元素
  offer(elem) {
    this.heap.push(elem);
    this.siftUp(this.heap.length - 1);
  }

  // 元素下滤操作
  siftDown(k) {
    while (2 * k + 1 < this.heap.length) {
      let j = 2 * k + 1;
      if (j + 1 < this.heap.length && this.compareFn(this.heap[j + 1], this.heap[j]) < 0) {
        j++;
      }
      if (this.compareFn(this.heap[k], this.heap[j]) <= 0) {
        break;
      }
      this.swap(k, j);
      k = j;
    }
  }

  // 元素上滤操作
  siftUp(k) {
    while (k > 0 && this.compareFn(this.heap[k], this.heap[Math.floor((k - 1) / 2)]) < 0) {
      this.swap(k, Math.floor((k - 1) / 2));
      k = Math.floor((k - 1) / 2);
    }
  }

  // 交换堆中的两个元素
  swap(i, j) {
    const temp = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = temp;
  }
}

var getLeastNumbers = function(arr, k) {
  let res = new Array(k);
  // 注意此题的 k 是元素个数而不是索引，所以和索引 p 做比较时要 - 1
  // 首先随机打乱数组
  shuffle(arr);
  let lo = 0, hi = arr.length - 1;
  // 现在开始寻找第 k 大的元素
  while (lo <= hi) {
    // 在 arr[lo..hi] 中选一个分界点
    let p = partition(arr, lo, hi);
    if (p < k - 1) {
      // 第 k 大的元素在 arr[p+1..hi] 中
      lo = p + 1;
    } else if (p > k - 1) {
      // 第 k 大的元素在 arr[lo..p-1] 中
      hi = p - 1;
    } else {
      // arr[p] 就是第 k 大元素，又因为快速排序的性质，
      // arr[p] 左边的元素都比 arr[p] 小，所以现在 arr[0..k] 就是我们要找的答案
      for (let i = 0; i < k; i++) {
        res[i] = arr[i];
      }
      return res;
    }
  }
  return res;
}

// 对 nums[lo..hi] 进行切分
function partition(nums, lo, hi) {
  let pivot = nums[lo];
  // 关于区间的边界控制需格外小心，稍有不慎就会出错
  // 我这里把 i, j 定义为开区间，同时定义：
  // [lo, i) <= pivot；(j, hi] > pivot
  // 之后都要正确维护这个边界区间的定义
  let i = lo + 1, j = hi;
  // 当 i > j 时结束循环，以保证区间 [lo, hi] 都被覆盖
  while (i <= j) {
    while (i < hi && nums[i] <= pivot) {
      i++;
      // 此 while 结束时恰好 nums[i] > pivot
    }
    while (j > lo && nums[j] > pivot) {
      j--;
      // 此 while 结束时恰好 nums[j] <= pivot
    }

    if (i >= j) {
      break;
    }
    // 此时 [lo, i) <= pivot && (j, hi] > pivot
    // 交换 nums[j] 和 nums[i]
    swap(nums, i, j);
    // 此时 [lo, i] <= pivot && [j, hi] > pivot
  }
  // 最后将 pivot 放到合适的位置，即 pivot 左边元素较小，右边元素较大
  swap(nums, lo, j);
  return j;
}

// 洗牌算法，将输入的数组随机打乱
function shuffle(nums) {
  let rand = new Random();
  let n = nums.length;
  for (let i = 0; i < n; i++) {
    // 生成 [i, n - 1] 的随机数
    let r = i + rand.nextInt(n - i);
    swap(nums, i, r);
  }
}

// 原地交换数组中的两个元素
function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

class Random {
  nextInt(bound) {
    return Math.floor(Math.random() * bound);
  }
}
```

</div></div>
</div></div>

</details>
</div>



