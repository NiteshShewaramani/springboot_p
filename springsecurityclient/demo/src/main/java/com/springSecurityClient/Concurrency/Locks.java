package com.springSecurityClient.Concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    private Lock lock = new ReentrantLock();
    private Condition conditionMet = lock.newCondition();
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();
    private static  final int MAX_COUNT=3;
    int count=0;

    public String consume(){
        lock.lock();
        try{

            while(count==0)
                added.await();

            //getData
            removed.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return null;
    }

    public String produce(){
        lock.lock();
        try{
            while(count == MAX_COUNT)
                removed.await();

            //addData();
            added.signal();


        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return null;
    }

    private Object monitor = new Object();

    public static void main(String[] args) {

    }

    public void method1() throws InterruptedException {
        lock.lock();
        try{
            conditionMet.await();//thread will suspend here
            //will resume from here
        }
        finally {
            lock.unlock();
        }

    }

    public void method2(){
        lock.lock();
        try{
            conditionMet.signal();
        }finally{
            lock.unlock();
        }

    }
    public synchronized void execute(){
        try{
            //will call wait here
            monitor.wait();
        }
        catch(Exception e){

        }
        //will notify here
        monitor.notify();
        monitor.notifyAll();
    }

    public void executeLocks(){
        lock.lock();
        try{
            conditionMet.wait();
        }
        catch(Exception e){

        }
        conditionMet.signal();
        conditionMet.signalAll();
        lock.unlock();
    }
}
