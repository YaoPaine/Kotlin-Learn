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

        binaryTree.insert(9, "毛主席");
        binaryTree.insert(10, "彭德怀");
        binaryTree.insert(11, "林彪");
        binaryTree.insert(12, "刘伯承");
        binaryTree.insert(7, "徐向前");
        binaryTree.insert(6, "陈赓");
        binaryTree.insert(5, "粟裕");
        binaryTree.insert(4, "叶剑英");

        System.out.println(binaryTree);

        /**
         *                李世民
         *          程咬金             尉迟恭
         *     长孙无忌             秦叔宝   杜如晦
         * 侯君集     房玄龄
         */
    }
}
