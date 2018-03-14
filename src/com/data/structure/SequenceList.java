package com.data.structure;

/**
 * 线性表顺序存储实现方式
 *
 * @param <E>
 */
public class SequenceList<E> implements LinearList<E> {

    private Object[] eList;
    private int size;

    public SequenceList() {
        this(10);
    }

    public SequenceList(int size) {
        if (size == 0) {
            this.eList = new Object[10];
        }
        this.eList = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public void add(E e) {

    }

    @Override
    public void add(E e, int index) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void clear() {

    }
}
