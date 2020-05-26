package com.hackerstudy.studytest.collection.queue;

import java.util.Objects;

/**
 * @class: ToDoItem
 * @description: 代办子类
 * @author: HackerStudy
 * @date: 2020-05-26 15:22
 */
public class ToDoItem implements Comparable<ToDoItem>{
    //主次序
    private char primary;
    //次级
    private int secondary;
    //代办
    private String item;

    public ToDoItem(char primary, int secondary, String item) {
        this.primary = primary;
        this.secondary = secondary;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDoItem)) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return primary == toDoItem.primary &&
                secondary == toDoItem.secondary &&
                Objects.equals(item, toDoItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primary, secondary, item);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "primary=" + primary +
                ", secondary=" + secondary +
                ", item='" + item + '\'' +
                '}';
    }

    @Override
    public int compareTo(ToDoItem toDoItem) {
        if(this.primary>toDoItem.primary){
            return 1;
        }else if(this.primary==toDoItem.primary){
            if(this.secondary>toDoItem.secondary){
                return 1;
            }else if(this.secondary==toDoItem.secondary){
                return 0;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
