package com.hackerstudy.studytest.concurrent.synchronization;

/**
 * @class: ProductAndCustomerTest
 * @description: 生产者消费者模型
 * @author: HackerStudy
 * @date: 2020-06-08 20:28
 */
public class ProductAndCustomerTest {

    public static void main(String[] args) {
        Student student = new Student();
        Product product = new Product(student);
        Customer customer = new Customer(student);
        new Thread(product).start();
        new Thread(customer).start();
    }
}
