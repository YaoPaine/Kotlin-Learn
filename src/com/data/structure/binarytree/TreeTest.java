package com.data.structure.binarytree;

public class TreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.insert(9, "李世民");
        binaryTree.insert(11, "尉迟恭");
        binaryTree.insert(10, "秦叔宝");
        binaryTree.insert(12, "杜如晦");
        binaryTree.insert(7, "程咬金");
        binaryTree.insert(8, "魏征");
        binaryTree.insert(5, "长孙无忌");
        binaryTree.insert(6, "房玄龄");
        binaryTree.insert(4, "侯君集");
        binaryTree.insert(1, "李孝恭");

        binaryTree.insert(12, "罗成");
        /**
         *                李世民
         *            程咬金         尉迟恭
         *     长孙无忌    魏征    秦叔宝   杜如晦/罗成
         * 侯君集     房玄龄
         */
       /* binaryTree.insert(9, "毛主席");
        binaryTree.insert(10, "彭德怀");
        binaryTree.insert(11, "林彪");
        binaryTree.insert(12, "刘伯承");
        binaryTree.insert(7, "徐向前");
        binaryTree.insert(6, "陈赓");
        binaryTree.insert(5, "粟裕");
        binaryTree.insert(4, "叶剑英");*/

        System.out.println(binaryTree);

        binaryTree.delete(7);

        System.out.println(binaryTree);

        /*BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.insert(10, "毛泽东");
        tree.insert(8, "林彪");
        tree.insert(12, "华国锋");
        tree.insert(11, "邓华");
        tree.insert(13, "罗荣桓");
        System.out.println(tree);
        tree.delete(10);
        System.out.println(tree);*/
        /**
         *          毛泽东
         *    林彪        华国锋
         *            邓华    罗荣桓
         */

    }
}
