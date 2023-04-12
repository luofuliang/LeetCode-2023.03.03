<p>请实现两个函数，分别用来序列化和反序列化二叉树。</p>

<p>你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>

<p><strong>提示：</strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="https://support.leetcode-cn.com/hc/kb/article/1567641/">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" /> 
<pre>
<strong>输入：</strong>root = [1,2,3,null,null,4,5]
<strong>输出：</strong>[1,2,3,null,null,4,5]
</pre>

<p>&nbsp;</p>

<p>注意：本题与主站 297 题相同：<a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/</a></p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树</details><br>

<div>👍 391, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=xu-lie-hua-er-cha-shu-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [297. 二叉树的序列化与反序列化](/problems/serialize-and-deserialize-binary-tree) 相同。

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 247 页。

序列化问题其实就是遍历问题，你能遍历，顺手把遍历的结果转化成字符串的形式，不就是序列化了么？

这里我就简单说说用前序遍历的思路，前序遍历的特点是根节点在开头，然后接着左子树的前序遍历结果，然后接着右子树的前序遍历结果：

![](https://labuladong.github.io/pictures/二叉树序列化/1.jpeg)

所以如果按照前序遍历顺序进行序列化，反序列化的时候，就知道第一个元素是根节点的值，然后递归调用反序列化左右子树，接到根节点上即可，上述思路翻译成代码即可解决本题。

当然，这题也可以尝试使用二叉树的中序、后序、层序的遍历方式来做，具体可看详细题解。

**详细题解：[东哥带你刷二叉树（序列化篇）](https://labuladong.github.io/article/fname.html?fname=二叉树的序列化)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，递归**

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

class Codec {
public:
    string SEP = ",";
    string EMPTY = "#";

    /* 主函数，将二叉树序列化为字符串 */
    string serialize(TreeNode* root) {
        string res = "";
        serialize(root, res);
        return res;
    }

    /* 辅助函数，将二叉树存入字符串 */
    void serialize(TreeNode* root, string& res) {
        if (root == nullptr) {
            res += EMPTY + SEP;
            return;
        }

        /******前序遍历位置******/
        res += to_string(root->val) + SEP;
        /***********************/

        serialize(root->left, res);
        serialize(root->right, res);
    }
  
    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode* deserialize(string data) {
        // 将字符串转化成列表
        vector<string> nodes;
        string s = "";
        for (char& c : data) {
            if (c == SEP[0]) {
                nodes.emplace_back(s);
                s = "";
            }
            else {
                s += c;
            }
        }
        if (!s.empty()) nodes.emplace_back(s);
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode* deserialize(vector<string>& nodes) {
        if (nodes.empty()) return nullptr;

        /******前序遍历位置******/
        // 列表最左侧就是根节点
        string first = nodes[0];
        nodes.erase(nodes.begin());
        if (first == EMPTY) return nullptr;
        TreeNode* root = new TreeNode(stoi(first));
        /***********************/

        root->left = deserialize(nodes);
        root->right = deserialize(nodes);

        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Codec:
    def __init__(self):
        self.SEP = ","
        self.NULL = "#"
    
    # 主函数，将二叉树序列化为字符串
    def serialize(self, root: TreeNode) -> str:
        sb = []
        self._serialize(root, sb)
        return ''.join(sb)

    # 辅助函数，将二叉树存入列表
    def _serialize(self, root: TreeNode, sb: list):
        if not root:
            sb.append(self.NULL).append(self.SEP)
            return

        # 前序遍历
        sb.append(str(root.val)).append(self.SEP)

        self._serialize(root.left, sb)
        self._serialize(root.right, sb)

    # 主函数，将字符串反序列化为二叉树结构
    def deserialize(self, data: str) -> TreeNode:
        # 将字符串转化成列表
        nodes = data.split(self.SEP)
        return self._deserialize(nodes)

    # 辅助函数，通过 nodes 列表构造二叉树 
    def _deserialize(self, nodes: list) -> TreeNode:
        if not nodes:
            return None

        # 前序遍历
        first = nodes.pop(0)
        if first == self.NULL:
            return None
        root = TreeNode(int(first))

        root.left = self._deserialize(nodes)
        root.right = self._deserialize(nodes)

        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Codec {
    String SEP = ",";
    String NULL = "#";

    /* 主函数，将二叉树序列化为字符串 */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /******前序遍历位置******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /******前序遍历位置******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

type Codec struct {
    SEP string
    NULL string
}

func Constructor() Codec {
    return Codec{
        SEP: ",",
        NULL: "#",
    }
}

/* 辅助函数，将二叉树存入字符串 */
func (this *Codec) serialize(root *TreeNode, sb *strings.Builder) {
    if root == nil {
        sb.WriteString(this.NULL)
        sb.WriteString(this.SEP)
        return
    }

    /******前序遍历位置******/
    sb.WriteString(strconv.Itoa(root.Val))
    sb.WriteString(this.SEP)
    /***********************/

    this.serialize(root.Left, sb)
    this.serialize(root.Right, sb)
}

/* 主函数，将二叉树序列化为字符串 */
func (this *Codec) serialize(root *TreeNode) string {
    var sb strings.Builder
    this.serialize(root, &sb)
    return sb.String()
}

/* 辅助函数，根据字符串构建二叉树 */
func (this *Codec) deserialize(nodes *[]string) *TreeNode {
    if len(*nodes) == 0 {
        return nil
    }
    /* 从 nodes 中取出一个元素作为当前子树的根节点 */
    first := (*nodes)[0]
    if first == this.NULL {
        // 若该元素为 "#" ，代表其为空节点，直接弹出并返回 nil
        *nodes = (*nodes)[1:]
        return nil
    }
    /* 否则，该元素实际上是整数，将其转化为节点 */
    val, _ := strconv.Atoi(first)
    root := &TreeNode{Val: val}
    /* 递归构造左右子树 */
    *nodes = (*nodes)[1:]
    root.Left = this.deserialize(nodes)
    root.Right = this.deserialize(nodes)
    return root
}

/* 主函数，将字符串反序列化为二叉树结构 */
func (this *Codec) deserialize(data string) *TreeNode {
    nodes := strings.Split(data, this.SEP)
    return this.deserialize(&nodes)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    if(!root) {
        return '#,'; // 把空节点转换为 "#,"
    }
    return root.val + ',' + serialize(root.left) + serialize(root.right); // 先把当前节点的值存入字符串，然后递归地序列化左子树和右子树
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    var nodes = data.split(','); // 把字符串转换成节点列表
    var dfs = function() {
        var value = nodes.shift(); // 当前字符串对应的节点
        if(value === '#') { // 遇到空节点，返回 null
            return null;
        }
        var node = new TreeNode(value); // 创建当前节点
        node.left = dfs(); // 递归构造左子树
        node.right = dfs(); // 递归构造右子树
        return node;
    };
    return dfs(); // 从根节点开始构造二叉树
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
```

</div></div>
</div></div>

**类似题目**：
  - [449. 序列化和反序列化二叉搜索树 🟠](/problems/serialize-and-deserialize-bst)
  - [剑指 Offer 37. 序列化二叉树 🔴](/problems/xu-lie-hua-er-cha-shu-lcof/)
  - [剑指 Offer II 048. 序列化与反序列化二叉树 🔴](/problems/h54YBf)

</details>
</div>



