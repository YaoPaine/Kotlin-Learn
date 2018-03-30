package com.data.structure.binarytree;

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
        while (current.key.compareTo(key) != 0) {
            parent = current;
            if (current.key.compareTo(key) > 0) {//插入到左子树中
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
    }

    /**
     * 二搜索树节点删除操作
     * 1、该节点没有子节点
     * 2、该节点右一个子节点
     * 3、该节点有两个子节点
     */

    public boolean delete(K key) {
        BNode current = rootNode;
        Boolean isLeftChild = null;
        if (current == null) return false;
        while (current.key.compareTo(key) != 0) {
            if (current.key.compareTo(key) > 0) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }
        /**
         * 找到了待删除的节点，开始进行操作
         */
        //第一种情况
        if (current.leftChild == null && current.rightChild == null) {
            return deleteNoChild(current, isLeftChild);
        } else if (current.leftChild != null && current.rightChild != null) {
            return deleteTwoChild(current, isLeftChild);
        } else {//第三种情况，有两个节点
            return deleteOneChild(current, isLeftChild);
        }
    }

    private boolean deleteNoChild(BNode current, Boolean isLeftChild) {
        if (current.equals(rootNode)) {
            rootNode = null;
            return true;
        }
        if (isLeftChild) {
            current.parent.leftChild = null;
        } else {
            current.parent.rightChild = null;
        }
        return true;
    }

    private boolean deleteTwoChild(BNode current, Boolean isLeftChild) {
        //递归遍历找出删除节点，最左节点。
        BNode targetNode = current.rightChild;
        while (targetNode.leftChild != null) {
            targetNode = targetNode.leftChild;
        }

        if (!targetNode.equals(current.rightChild)) {//表示被删除节点的右节点，还存在左子节点
            targetNode.parent.leftChild = targetNode.rightChild;
            if (targetNode.rightChild != null) {
                targetNode.rightChild.parent = targetNode.parent;
            }
            targetNode.rightChild = current.rightChild;
            current.rightChild.parent = targetNode;
        }

        if (current.equals(rootNode)) {
            //targetNode.leftChild = rootNode.leftChild;
            if (!targetNode.equals(current.rightChild)) {
                targetNode.rightChild = rootNode.rightChild;
            }
            targetNode.parent = null;
            rootNode = targetNode;
        } else if (isLeftChild) {
            current.parent.leftChild = targetNode;
            targetNode.parent = current.parent;
        } else {
            current.parent.rightChild = targetNode;
            targetNode.parent = current.parent;
        }
        targetNode.leftChild = current.leftChild;
        current.leftChild.parent = targetNode;
        return true;
    }

    private boolean deleteOneChild(BNode current, Boolean isLeftChild) {
        boolean isLeftNull = current.leftChild == null;

        if (current.equals(rootNode)) {
            if (isLeftNull) {
                rootNode = current.rightChild;
                current.rightChild.parent = null;
            } else {
                rootNode = current.leftChild;
                current.leftChild.parent = null;
            }
            return true;
        }

        if (isLeftChild) {
            current.parent.leftChild = isLeftNull ? current.rightChild : current.leftChild;
        } else {
            current.parent.rightChild = isLeftNull ? current.rightChild : current.leftChild;
        }
        if (isLeftNull) {
            current.rightChild.parent = current.parent;
        } else {
            current.leftChild.parent = current.parent;
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
