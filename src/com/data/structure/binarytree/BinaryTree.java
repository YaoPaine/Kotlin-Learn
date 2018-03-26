package com.data.structure.binarytree;


import java.util.Vector;

public class BinaryTree<K extends Comparable<K>, V> {
    /**
     * 根节点
     */
    private BNode rootNode;

    public BinaryTree() {

    }

    public BinaryTree(BNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * 将数据插入二叉搜索树中
     *
     * @param key
     * @param element
     */
    public void insert(K key, V element) {
        BNode bNode = new BNode(key, element);
        if (rootNode == null) {
            rootNode = bNode;
            return;
        }

        BNode current = rootNode;
        BNode parent;
        Boolean isLeft = null;
        while (true) {
            parent = current;
            if (current.key.compareTo(key) == 0) {//替换
                if (current.equals(rootNode)) {
                    rootNode.element = bNode.element;
                } else {
                    bNode.leftChild = current.leftChild;
                    if (current.leftChild != null) {
                        current.leftChild.parent = bNode;
                    }
                    bNode.rightChild = current.rightChild;
                    if (current.rightChild != null) {
                        current.rightChild.parent = bNode;
                    }
                    bNode.parent = current.parent;

                    if (isLeft == null) return;

                    if (isLeft) {
                        current.parent.leftChild = bNode;
                    } else {
                        current.parent.rightChild = bNode;
                    }
                }
                return;
            } else if (current.key.compareTo(key) > 0) {//插入到左子树中
                current = current.leftChild;
                isLeft = true;
                if (current == null) {
                    parent.leftChild = bNode;
                    bNode.parent = parent;
                    return;
                }
            } else {
                current = current.rightChild;
                isLeft = false;
                if (current == null) {
                    parent.rightChild = bNode;
                    bNode.parent = parent;
                    return;
                }
            }
        }
    }

    /**
     * 二搜索树节点删除操作
     * 1、该节点没有子节点
     * 2、该节点右一个子节点
     * 3、该节点有两个子节点
     */

    public boolean delete(K key) {
        BNode current = rootNode;
        boolean isLeftChild = true;
        if (current == null) return false;
        while (current.key.compareTo(key) != 0) {
            if (current.key.compareTo(key) < 0) {

            } else {

            }
        }
        return true;
    }


    /**
     * 二叉树的先序遍历
     */

    private String preOrder(BNode node) {
        if (node == null) {
            return "{}";
        }
        return "[" + node +
                "," + preOrder(node.leftChild)
                + "," + preOrder(node.rightChild)
                + "]";
    }

    /**
     * 二叉树的中序遍历
     */

    private String middleOrder(BNode bNode) {
        if (bNode == null) return "{}";

        return "[" +
                middleOrder(bNode.leftChild) + "," +
                bNode + "," +
                middleOrder(bNode.rightChild) +
                "]";
    }

    /**
     * 二叉树的后序遍历
     */
    private String endOrder(BNode bNode) {
        if (bNode == null) {
            return "{}";
        }

        return "[" +
                endOrder(bNode.leftChild) + ","
                + endOrder(bNode.rightChild) + ","
                + bNode
                + "]";
    }

    @Override
    public String toString() {
        return middleOrder(rootNode);
    }

    /**
     * 数的节点对象，包含数据元素，左子节点和右子节点
     */
    private class BNode {
        private K key;
        private V element;
        private BNode parent, leftChild, rightChild;

        private BNode(K key, V element) {
            this.key = key;
            this.element = element;
            this.leftChild = null;
            this.rightChild = null;
        }

        private BNode(K key, V element, BNode leftChild, BNode rightChild) {
            this.key = key;
            this.element = element;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "{\"" + key + "\":\"" + element + "\"}";
        }
    }

}
