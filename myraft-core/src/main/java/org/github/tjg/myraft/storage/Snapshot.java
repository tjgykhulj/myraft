package org.github.tjg.myraft.storage;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.github.tjg.myraft.model.proto.SnapshotMetaData;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 什么作用？什么情况下记录snapshot？
 */
@Slf4j
public class Snapshot {

    private String snapshotDir;
    @Getter
    private SnapshotMetaData metaData;

    private Lock lock = new ReentrantLock();

    public Snapshot(String raftDataDir) {
        this.snapshotDir = raftDataDir + File.separator + "snapshot";
        String snapshotDataDir = snapshotDir + File.separator + "data";
        File file = new File(snapshotDataDir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
