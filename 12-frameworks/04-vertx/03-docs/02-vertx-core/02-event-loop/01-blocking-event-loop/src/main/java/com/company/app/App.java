package com.company.app;

import io.vertx.core.Context;
import io.vertx.core.Vertx;

public class App
{
    public static void main( String[] args )
    {
        Vertx vertx = Vertx
            .vertx();

        Context context = vertx.getOrCreateContext();

        /*
        DO NOT call blocking operations directly from an event loop,
        as that would prevent it from doing any other useful work.
         */
        context.runOnContext(v -> {

            blockingCode();

            System.out.println("handler: "+Thread.currentThread().getName() + " end");
        });

        System.out.println("#Main Thread END");

        vertx.close();
    }

    private static void blockingCode() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
output:
#Main Thread END
Jul 16, 2017 10:56:40 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 2860 ms, time limit is 2000
Jul 16, 2017 10:56:41 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 3864 ms, time limit is 2000
Jul 16, 2017 10:56:42 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 4866 ms, time limit is 2000
handler: vert.x-eventloop-thread-0 end
 */
