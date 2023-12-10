package com.springSecurityClient.Concurrency;

import java.util.concurrent.CompletableFuture;

public class ExCompletableFuture {
    public static void main(String[] args) {

        //all done by same thread
//        CompletableFuture.supplyAsync(()->m1())
//                .thenApply((data)->m2(data))
//                .exceptionally(e-> System.out.println(""+e))
//                .thenAccept(data->m3());

        //if we use thenApplyAsyn then each task will be executed by seperate thread
        //by default it will use forkjoinpool
        //will end here
    }
}
