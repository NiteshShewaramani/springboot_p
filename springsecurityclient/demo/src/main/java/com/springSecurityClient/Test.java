package com.springSecurityClient;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

interface H1{
    default void hi(){
        System.out.println("interface");
    }
    //public void h2();
}

class A{
//    public void  hi() {
//        System.out.println("class ");
//
//    }
}
class B extends A implements  H1{

    public void hi(){
        System.out.println("child class");
    }

    public void get(){
        hi();
    }


}

public class Test implements Callable<String> {

    @Override // overriding method
    public String call() throws Exception {
        Thread.sleep(500);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        H1 b = new B();
        b.hi();
        B b2 = new B();
        b2.get();
        A a = new B();
        //a.hi();

//        ExecutorService ex = Executors.newFixedThreadPool(5);
//
//        ThreadGroup tg1 = new ThreadGroup("tg");
//
//        Thread t1 = new Thread(()->{
//            System.out.println("thread 1");
//        });
//
//
//
//
//        Callable<String> s = new Test();
//
//        for(int i=0;i<50;i++)
//        {
//            ex.submit(s);
//            ex.execute(()-> System.out.println("hi"));
//        }
//        ex.shutdown();

    }
}
