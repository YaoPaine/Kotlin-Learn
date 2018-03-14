package com.data.structure.stack;

import java.util.Scanner;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> head;
    private int size = 0;

    public LinkedStack() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E e) {
        head = new Node<>(e, head);
        size++;
    }

    @Override
    public E pop() {
        if (head == null) {
            throw new NullPointerException("empty");
        }
        E element = head.getElement();
        head = head.getNext();
        size--;
        return element;
    }

    @Override
    public E peek() {
        if (head == null) {
            throw new NullPointerException("empty");
        }
        return head.getElement();
    }

    public static class Node<E> {

        E e;//数据元素

        Node<E> next;//尾指针，指向下一个结点

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public E getElement() {
            return e;
        }

        public void setElement(E e) {
            this.e = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        Scanner in = new Scanner(System.in);
        int temp;
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            temp = in.nextInt();
            stack.push(temp);
        }
        //遍历输出
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
