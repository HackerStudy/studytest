package com.hackerstudy.studytest.collection.map;

import java.util.*;

/**
 * @class: SlowMap
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-27 14:05
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys= new ArrayList<K>();
    private List<V> values= new ArrayList<V>();

    @Override
    public V put(K key, V value){
        V oldValue = get(key);
        if(keys.contains(key)){
            values.set(keys.indexOf(key),value);
            return oldValue;
        }else{
            keys.add(key);
            values.add(value);
            return value;
        }
    }

    @Override
    public V get(Object key){
        if(keys.contains(key)){
            return values.get(keys.indexOf(key));
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K, V>>();
        Iterator<K> kIterator = keys.iterator();
        Iterator<V> vIterator = values.iterator();
        while (kIterator.hasNext()){
            set.add(new SimpleEntry<K, V>(kIterator.next(),vIterator.next()));
        }
        return set;
    }
}
