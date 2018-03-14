package com.data.structure;

/**
 * 线性表操作接口
 */
public interface LinearList<E> {
    /**
     * @return 返回线性表是否为空
     */
    boolean isEmpty();

    /**
     * @return 返回线性表长度
     */
    int size();

    E get(int index);

    void set(int index, E e);

    /**
     * @param e 向线性表尾部添加元素
     */
    void add(E e);

    /**
     * @param e     向线性表指定位置添加元素
     * @param index
     */
    void add(E e, int index);

    void remove(int index);

    void clear();
}
