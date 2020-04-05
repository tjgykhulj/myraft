package org.github.tjg.myraft.storage;

import lombok.Data;
import org.github.tjg.myraft.model.proto.LogEntry;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

@Data
public class Segment {

    @Data
    public static class Record {
        private long offset;
        private LogEntry entry;

        public Record(long offset, LogEntry entry) {
            this.offset = offset;
            this.entry = entry;
        }
    }

    private boolean canWrite;
    private long startIndex;
    private long endIndex;
    private long fileSize;
    private String fileName;
    private RandomAccessFile randomAccessFile;
    private List<Record> entries = new ArrayList<>();

    public LogEntry getEntry(long index) {
        if (startIndex == 0 || endIndex == 0 || index < startIndex || index > endIndex) {
            return null;
        }
        int indexInList = (int) (index - startIndex);
        return entries.get(indexInList).entry;
    }
}
