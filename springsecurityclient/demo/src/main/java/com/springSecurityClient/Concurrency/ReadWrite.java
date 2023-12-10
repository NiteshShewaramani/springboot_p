package com.springSecurityClient.Concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock read = lock.readLock();
    ReentrantReadWriteLock.WriteLock write = lock.writeLock();

    private void readResource(){
        read.lock();

        read.unlock();

    }

    private void writeResource(){
        write.lock();

        write.unlock();

    }
}
