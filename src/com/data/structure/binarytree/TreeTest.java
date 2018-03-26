package com.data.structure.binarytree;

public class TreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.insert(9, "李世民");
        binaryTree.insert(11, "尉迟恭");
        binaryTree.insert(10, "秦叔宝");
        binaryTree.insert(12, "杜如晦");
        binaryTree.insert(7, "程咬金");
        binaryTree.insert(5, "长孙无忌");
        binaryTree.insert(6, "房玄龄");
        binaryTree.insert(4, "侯君集");
        System.out.println(binaryTree);

        /**
         *                李世民
         *          程咬金             尉迟恭
         *     长孙无忌             秦叔宝   杜如晦
         * 侯君集     房玄龄
         */
    }
}
