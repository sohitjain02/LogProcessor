package com.assignment.logprocessor.dto;

public record LogEntry(long startScanTime,
                       long scanEndTime,
                       long saveStartTime,
                       long saveEndTime,
                       long showStartTime,
                       long showEndTime) {

    public long getScanDuration() {
        return scanEndTime - startScanTime;
    }

    public long getSaveDuration() {
        return saveEndTime - saveStartTime;
    }

    public long getShowDuration() {
        return showEndTime - showStartTime;
    }
}

