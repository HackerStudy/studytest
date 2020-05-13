package com.hackerstudy.studytest.collection.stack;

/**
 * @class: LinkedStack
 * @description: 自定义链式存储结构的堆栈
 * @author: HackerStudy
 * @date: 2020-05-13 16:32
 */
public class LinkedStack<T> {
    /**
     * @class: Node
     * @description: 一维元组存储对象(将自身对象作为成员存储)
     * @auther: HackerStudy
     * @date: 2020-05-13 16:33
     */
    private static class Node<U>{
        U item;
        Node<U> next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * @description: 末端哨兵-用于监测出栈是不是已经到末尾了
         * @param:
         * @return: boolean
         * @auther: HackerStudy
         * @date: 2020-05-13 16:43
         * @throws
         */
        boolean isEnd(){
            return item == null&&next == null?true:false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item){
        top =  new Node<T>(item,top);
    }

    public T pop(){
        T result = top.item;
        if(!top.isEnd()){
            top =  top.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "top=" + top +
                '}';
    }
}
