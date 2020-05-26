package com.hackerstudy.studytest.collection.set;

/**
 * @class: TreeSetType
 * @description:
 * @author: HackerStudy
 * @date: 2020-05-26 14:48
 */
public class TreeSetType extends HashSetType implements Comparable<TreeSetType> {
    public TreeSetType(int i) {
        super(i);
    }

    @Override
    public int compareTo(TreeSetType treeSetType) {
        int compareI = treeSetType.i;
        return (compareI>this.i?1:(compareI==i?0:-1));
    }
}
