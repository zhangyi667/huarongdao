package com.medopad.Util;

import java.util.LinkedList;


public class NotNullLinkedList<E> extends LinkedList<E> {

    @Override
    public boolean add(E e) {
        return null != e && super.add(e);
    }
}
