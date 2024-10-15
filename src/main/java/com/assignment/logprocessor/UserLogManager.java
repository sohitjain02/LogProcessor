package com.assignment.logprocessor;

import com.assignment.logprocessor.dto.LogEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLogManager {

    private final String userName;
    private final List<LogEntry> logEntries = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public List<LogEntry> getLogEntries() {
        return Collections.unmodifiableList(logEntries);
    }

    public UserLogManager(String userName) {
        this.userName = userName;
    }

    public void addLogEntry(LogEntry entry) {
        logEntries.add(entry);
    }

    public double calculateAverageScanTime() {
        return logEntries.stream()
                .mapToLong(LogEntry::getScanDuration)
                .average()
                .orElse(0.0);
    }

    public double calculateAverageSaveTime() {
        return logEntries.stream()
                .mapToLong(LogEntry::getSaveDuration)
                .average()
                .orElse(0.0);
    }

    public double calculateAverageShowTime() {
        return logEntries.stream()
                .mapToLong(LogEntry::getShowDuration)
                .average()
                .orElse(0.0);
    }

    public int getDocumentCount() {
        return logEntries.size();
    }
}

