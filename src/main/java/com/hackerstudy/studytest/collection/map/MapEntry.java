package com.hackerstudy.studytest.collection.map;

import java.util.Map;

/**
 * @class: MapEntry
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-27 15:08
 */
public class MapEntry<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V oldValue = value;
        value = v;
        return oldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) return false;
        MapEntry mapEntry = (MapEntry) o;
        return (key==null?mapEntry.getKey()==null:key.equals(mapEntry.getKey()))&&
                (value==null?mapEntry.getValue()==null:value.equals(mapEntry.getValue()));
    }

    @Override
    public int hashCode() {
        return (key==null?0:key.hashCode())^(value==null?0:value.hashCode());
    }
}
