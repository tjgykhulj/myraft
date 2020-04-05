package org.github.tjg.myraft;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    private Lock lock = new ReentrantLock();

    private void work() {
        lock.lock();
        try {
            System.out.println(2);
        } finally {
            lock.unlock();
        }
    }
    @Test
    public void test() throws InterruptedException {
        lock.lock();
        try {
            System.out.println(1);
            work();
            work();
            new Thread(this::work).start();
            Thread.sleep(10000);
        } finally {
            lock.unlock();
        }
    }
}
