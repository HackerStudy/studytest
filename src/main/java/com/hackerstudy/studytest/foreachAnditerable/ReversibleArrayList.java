package com.hackerstudy.studytest.foreachAnditerable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @class: ReversibleArrayList
 * @description:
 * @author: yangpeng03614
 * @date: 2019-04-02 19:06
 */
public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<? extends T> c) {
        super(c);
    }

    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size()-1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }
}
