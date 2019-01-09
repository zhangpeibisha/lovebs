package org.nix.zpbs.trie;

import java.util.Arrays;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2019/1/9
 */
public class TrieTree {
    //每个节点能包含的子节点数，即需要SIZE个指针来指向其孩子
    private final int SIZE = 26;
    //字典树的根节点
    private Node root;

    /**
     * 字典树节点类
     *
     * @author Lenovo
     */
    private class Node {
        //标识该节点是否为某一字符串终端节点
        private boolean isStr;
        //标识经过该节点的字符串数。在计算前缀包含的时候会用到
        private int num;
        //该节点的子节点
        private Node[] child;
        // 该节点的完整字符有多少个
        private long count;

        public Node() {
            child = new Node[SIZE];
            isStr = false;
            num = 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "isStr=" + isStr +
                    ", num=" + num +
                    ", child=" + Arrays.toString(child) +
                    ", count=" + count +
                    '}';
        }
    }

    public TrieTree() {
        root = new Node();
    }

    /**
     * 检查字典树中是否完全包含字符串word
     *
     * @param word
     * @return
     */
    public boolean hasStr(String word) {
        return hasStrCount(word) != 0;
    }

    /**
     * 查询这个字符串有多少格
     *
     * @param word 字符串
     * @return 字符串数量，没有返回0
     */
    public long hasStrCount(String word) {
        Node pNode = this.root;
        //逐个字符去检查
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //在字典树中没有对应的节点，或者word字符串的最后一个字符在字典树中检测对应节点的isStr属性为false，则返回false
            Node node = pNode.child[index];
            boolean b = node == null || (i + 1 == word.length() && !pNode.child[index].isStr);
            if (b) {
                return 0;
            }
            pNode = pNode.child[index];
        }
        return pNode.count;
    }

    /**
     * 在字典树中插入一个单词
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        Node pNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //如果不存在节点，则new一个一节点插入字典树
            if (pNode.child[index] == null) {
                Node tmpNode = new Node();
                pNode.child[index] = tmpNode;
            } else {
                //如果字典树中改路径上存在节点，则num加1，表示在该节点上有一个新的单词经过
                pNode.child[index].num++;
            }
            pNode = pNode.child[index];
        }
        pNode.count++;
        pNode.isStr = true;
    }

    /**
     * 统计在字典树中有多少个单词是以str为前缀的
     *
     * @param str
     * @return
     */
    public int countPrefix(String str) {
        Node pNode = this.root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (pNode.child[index] == null) {
                return 0;
            } else {
                pNode = pNode.child[index];
            }
        }

        return pNode.num;
    }

    /**
     * 先序遍历
     *
     * @param root
     */
    public void preWalk(Node root) {
        Node pNode = root;
        for (int i = 0; i < SIZE; i++) {
            Node node = pNode.child[i];
            if (node != null) {
                System.out.println("单词有=" + node.count + " 前缀有=" + node.num + " char=" + (char)('a' + i));
                preWalk(node);
            }
        }
    }

    /**
     * 返回字典树根节点
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }
}
