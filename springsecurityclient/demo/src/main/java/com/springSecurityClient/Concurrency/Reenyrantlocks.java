package com.springSecurityClient.Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Reenyrantlocks {
    static ReentrantLock lock = new ReentrantLock();//default false unfair
    static ReentrantLock lockFair = new ReentrantLock(true);
    public static void resource(){
        lock.lock();
        System.out.println("" + lock.getHoldCount());
        try{}
        finally{
            lock.unlock();
        }


    }

    public static void tryresource() throws InterruptedException {
        boolean isRequired = lock.tryLock();

        boolean isFair = lock.tryLock(0, TimeUnit.SECONDS);

        lock.isHeldByCurrentThread();
        lock.getQueueLength();

        if(isRequired){
            try{}finally{
                lock.unlock();
            }
        }
        else{

        }
    }
    public static void main(String[] args) {
        new Thread(()->resource()).start();
        new Thread(()->resource()).start();
        new Thread(()->resource()).start();

    }
}
