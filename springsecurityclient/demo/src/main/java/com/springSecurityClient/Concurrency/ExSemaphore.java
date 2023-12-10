package com.springSecurityClient.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class ExSemaphore {

    public static void main(String[] args) {
        Semaphore sp = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(5);

        IntStream.of(100).forEach((i)-> service.submit(new Task(sp)));

    }
    static class Task implements Runnable{
        Semaphore sp;
        public void run(){
            sp.acquireUninterruptibly();

            sp.release();

        }
        Task(Semaphore sp)
        {
            this.sp = sp;
        }
    }
}
