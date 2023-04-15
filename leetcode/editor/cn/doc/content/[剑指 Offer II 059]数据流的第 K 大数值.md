<p>设计一个找到数据流中第 <code>k</code> 大元素的类（class）。注意是排序后的第 <code>k</code> 大元素，不是第 <code>k</code> 个不同的元素。</p>

<p>请实现 <code>KthLargest</code>&nbsp;类：</p>

<ul> 
 <li><code>KthLargest(int k, int[] nums)</code> 使用整数 <code>k</code> 和整数流 <code>nums</code> 初始化对象。</li> 
 <li><code>int add(int val)</code> 将 <code>val</code> 插入数据流 <code>nums</code> 后，返回当前数据流中第 <code>k</code> 大的元素。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
<strong>输出：</strong>
[null, 4, 5, 5, 8, 8]

<strong>解释：</strong>
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= val &lt;= 10<sup>4</sup></code></li> 
 <li>最多调用 <code>add</code> 方法 <code>10<sup>4</sup></code> 次</li> 
 <li>题目数据保证，在查找第 <code>k</code> 大元素时，数组中至少有 <code>k</code> 个元素</li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 703&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/">https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/</a></p>

<details><summary><strong>Related Topics</strong></summary>树 | 设计 | 二叉搜索树 | 二叉树 | 数据流 | 堆（优先队列）</details><br>

<div>👍 43, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [703. 数据流中的第 K 大元素](/problems/kth-largest-element-in-a-stream) 相同。

这题考察优先级队列的使用，可以先做下这道类似的题目 [215. 数组中的第 K 个最大元素](/problems/kth-largest-element-in-an-array)。

优先级队列的实现原理详见 [图文详解二叉堆，实现优先级队列](https://labuladong.github.io/article/fname.html?fname=二叉堆详解实现优先级队列)。

**标签：二叉堆，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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

class KthLargest {
private:
    int k;
    // 默认是小顶堆
    priority_queue<int, vector<int>, greater<int>> pq;
public:
    KthLargest(int k, vector<int>& nums) {
        // 将 nums 装入小顶堆，保留下前 k 大的元素
        for (int e : nums) {
            pq.push(e);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        this->k = k;
    }

    int add(int val) {
        // 维护小顶堆只保留前 k 大的元素
        pq.push(val);
        if (pq.size() > k) {
            pq.pop();
        }
        // 堆顶就是第 k 大元素（即倒数第 k 小的元素）
        return pq.top();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

from queue import PriorityQueue

class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        # 默认是小顶堆
        self.pq = PriorityQueue()
        # 将 nums 装入小顶堆，保留下前 k 大的元素
        for e in nums:
            self.pq.put(e)
            if self.pq.qsize() > k:
                self.pq.get()

    def add(self, val: int) -> int:
        # 维护小顶堆只保留前 k 大的元素
        self.pq.put(val)
        if self.pq.qsize() > self.k:
            self.pq.get()
        # 堆顶就是第 k 大元素（即倒数第 k 小的元素）
        return self.pq.queue[0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class KthLargest {

    private int k;
    // 默认是小顶堆
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        // 将 nums 装入小顶堆，保留下前 k 大的元素
        for (int e : nums) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        this.k = k;
    }

    public int add(int val) {
        // 维护小顶堆只保留前 k 大的元素
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        // 堆顶就是第 k 大元素（即倒数第 k 小的元素）
        return pq.peek();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

import (
	"container/heap"
)

// KthLargest 是一个数据结构，它维护了一个保留前 k 大元素的小顶堆
type KthLargest struct {
	k  int
	pq PriorityQueue
}

// Constructor 是 KthLargest 的构造函数
func Constructor(k int, nums []int) KthLargest {
	pq := make(PriorityQueue, 0, k)
	for _, e := range nums {
		pq.offer(e)
		if pq.Len() > k {
			pq.poll()
		}
	}
	return KthLargest{
		k:  k,
		pq: pq,
	}
}

// add 方法将一个元素添加到小顶堆中，并返回第 k 大元素
func (kl *KthLargest) add(val int) int {
	kl.pq.offer(val)
	if kl.pq.Len() > kl.k {
		kl.pq.poll()
	}
	// 堆顶就是第 k 大元素（即倒数第 k 小的元素）
	return kl.pq.peek()
}

// PriorityQueue 是一个带有 Peek 方法的小顶堆
type PriorityQueue []int

// Len 返回小顶堆中的元素数量
func (pq PriorityQueue) Len() int {
	return len(pq)
}

// Less 定义了小顶堆的排序规则
func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i] < pq[j]
}

// Swap 交换小顶堆中的两个元素的位置
func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

// Push 向小顶堆中添加一个元素
func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(int)
	*pq = append(*pq, item)
}

// Pop 从小顶堆中弹出最小的元素
func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[:n-1]
	return item
}

// Peek 返回小顶堆中的最小元素
func (pq PriorityQueue) Peek() int {
	return pq[0]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var KthLargest = function(k, nums) {
    this.k = k;
    // 默认是小顶堆
    this.pq = new PriorityQueue();
    // 将 nums 装入小顶堆，保留下前 k 大的元素
    for (let e of nums) {
        this.pq.offer(e);
        if (this.pq.size() > k) {
            this.pq.poll();
        }
    }
};

KthLargest.prototype.add = function(val) {
    // 维护小顶堆只保留前 k 大的元素
    this.pq.offer(val);
    if (this.pq.size() > this.k) {
        this.pq.poll();
    }
    // 堆顶就是第 k 大元素（即倒数第 k 小的元素）
    return this.pq.peek();
};

// PriorityQueue implementation
var PriorityQueue = function() {
    this.data = [];
};

PriorityQueue.prototype.offer = function(val) {
    this.data.push(val);
    this.bubbleUp(this.data.length - 1);
};

PriorityQueue.prototype.poll = function() {
    const last = this.data.pop();
    const result = this.data[0];
    if (this.data.length > 0) {
        this.data[0] = last;
        this.bubbleDown(0);
    }
    return result;
};

PriorityQueue.prototype.peek = function() {
    return this.data[0];
};

PriorityQueue.prototype.size = function() {
    return this.data.length;
};

PriorityQueue.prototype.bubbleUp = function(pos) {
    while (pos > 0) {
        const parent = Math.floor((pos - 1) / 2);
        if (this.data[parent] > this.data[pos]) {
            this.swap(parent, pos);
            pos = parent;
        } else {
            break;
        }
    }
};

PriorityQueue.prototype.bubbleDown = function(pos) {
    while (pos * 2 + 1 < this.data.length) {
        let minChild = pos * 2 + 1;
        if (pos * 2 + 2 < this.data.length && this.data[pos * 2 + 2] < this.data[minChild]) {
            minChild = pos * 2 + 2;
        }
        if (this.data[minChild] < this.data[pos]) {
            this.swap(minChild, pos);
            pos = minChild;
        } else {
            break;
        }
    }
};

PriorityQueue.prototype.swap = function(i, j) {
    const temp = this.data[i];
    this.data[i] = this.data[j];
    this.data[j] = temp;
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 059. 数据流的第 K 大数值 🟢](/problems/jBjn9C)

</details>
</div>



