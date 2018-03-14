package com.data.structure.stack;

public interface Stack<E> {

    boolean isEmpty();

    int size();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 删除栈顶元素并返回
     *
     * @return
     */
    E pop();

    /**
     * @return 获取栈顶的数据元素
     */
    E peek();
}
