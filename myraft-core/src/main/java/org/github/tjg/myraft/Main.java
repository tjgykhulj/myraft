package org.github.tjg.myraft;

import com.baidu.brpc.server.RpcServer;

public class Main {

    public static void main(String args[]) {
        RpcServer server = new RpcServer(8001);
        //   server.registerService(new TestServiceImpl());
        server.start();
        // make server keep running
        synchronized (Main.class) {
            try {
                Main.class.wait();
            } catch (Throwable e) {
            }
        }
    }
}
