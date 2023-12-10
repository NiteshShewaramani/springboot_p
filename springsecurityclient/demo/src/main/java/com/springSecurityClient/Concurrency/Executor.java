package com.springSecurityClient.Concurrency;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ThreadSafeFormatter{

    //requestcontextholder
    //seciritycontextholder


    //thread local will return new object per thread and then reuse them
    public static ThreadLocal<SimpleDateFormat> tf = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected  SimpleDateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
        @Override
        public SimpleDateFormat get(){
            return super.get();
        }

    };
}
public class Executor {
    public static void main(String[] args) {
        int processorcount= Runtime.getRuntime().availableProcessors();
        ExecutorService ex = Executors.newFixedThreadPool(processorcount);


        //send the signal to shutdown
        ex.shutdown();

        //immideatly shutsdown the pool and returns the list of pending tasks
        List<Runnable> rList = ex.shutdownNow();

        //create a thread pool , will keep on creating new threads if the threads in the pool are busy
        //will delete the thread if it is idel for 60 secs
        ExecutorService service2 = Executors.newCachedThreadPool();

        ScheduledExecutorService ssService = Executors.newScheduledThreadPool(10);

        //task to run after 15 sec delay
        ssService.schedule(()->{},10,TimeUnit.SECONDS);

        //start the task after 15 sec delay and then run them after 10 sec interval(will run the same task again and again)
        ssService.scheduleAtFixedRate(()->{},15,10, TimeUnit.SECONDS);

        //start the task after 15 sec delay and then starts 10 sec after the previous task is finished(will run the same task again and again)
        ssService.scheduleWithFixedDelay(()->{},15,10, TimeUnit.SECONDS);

        ExecutorService serviceSingle = Executors.newSingleThreadExecutor();


        System.out.println("  " +processorcount);

    }
}
