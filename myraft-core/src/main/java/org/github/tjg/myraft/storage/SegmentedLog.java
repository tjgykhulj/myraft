package org.github.tjg.myraft.storage;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.github.tjg.myraft.FileUtils;
import org.github.tjg.myraft.model.proto.LogEntry;
import org.github.tjg.myraft.model.proto.LogMetaData;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.TreeMap;

@Slf4j
@Data
public class SegmentedLog {

    private String logDir;
    private String logDataDir;
    private int maxSegmentFileSize;
    private LogMetaData metaData;
    private TreeMap<Long, Segment> startLogIndexSegmentMap = new TreeMap<>();
    // segment log占用的内存大小，用于判断是否需要做snapshot
    private volatile long totalSize;

    public SegmentedLog(String raftDataDir, int maxSegmentFileSize) {
        //TODO
    }

    public LogEntry getEntry(long index) {
        return null;
        //TODO
    }

    public long getEntryTerm(long index) {
        return 0;
        //TODO
    }

    public long getFirstLogIndex() {
        return metaData.getFirstLogIndex();
    }

    public long getLastLogIndex() {
        // TODO
        return 0;
    }

    public long append(List<LogEntry> entries) {
        return 0;
        //TODO
    }

    public void truncatePrefix(long newFirstIndex) {
        // TODO
    }

    public void truncateSuffix(long newEndIndex) {
        //TODO
    }

    public void loadSegmentData(Segment segment) {
        //TODO
    }

    public void readSegments() {
        //TODO
    }

    public LogMetaData readMetaData() {
        //TODO
        return null;
    }

    // 把数据盖到原先的metaData中，以指定格式写入
    public void updateMetaData(Long currentTerm, Integer voteFor, Long firstLogIndex, Long commitIndex) {
        LogMetaData.Builder builder = LogMetaData.newBuilder(this.metaData);
        if (currentTerm != null) {
            builder.setCurrentTerm(currentTerm);
        }
        if (voteFor != null) {
            builder.setVoteFor(voteFor);
        }
        if (firstLogIndex != null) {
            builder.setFirstLogIndex(firstLogIndex);
        }
        if (commitIndex != null) {
            builder.setCommitIndex(commitIndex);
        }
        this.metaData = builder.build();

        String fileName = logDir + File.separator + "metadata";
        File file = new File(fileName);
        // 总体写入后才关闭文件（即保存）
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            FileUtils.writeProtoToFile(randomAccessFile, this.metaData);
            log.info("new segment meta info, currentTerm={}, votedFor={}, firstLogIndex={}",
                    metaData.getCurrentTerm(), metaData.getVoteFor(), metaData.getFirstLogIndex());
        } catch (IOException ex) {
            log.warn("meta file not exist, name={}", fileName);
        }
    }
}
