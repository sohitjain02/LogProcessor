package com.assignment.logprocessor;

import com.assignment.logprocessor.dto.LogEntry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OfficeLogManager {

    private final String officeName;
    private final Map<String, UserLogManager> userLogManagers = new HashMap<>();

    public String getOfficeName() {
        return officeName;
    }

    public Map<String, UserLogManager> getUserLogManagers() {
        return Collections.unmodifiableMap(userLogManagers);
    }

    public OfficeLogManager(String officeName) {
        this.officeName = officeName;
    }

    public void addLogEntry(String userName, LogEntry entry) {
        userLogManagers.computeIfAbsent(userName, UserLogManager::new)
                .addLogEntry(entry);
    }

    public double calculateOfficeAverageScanTime() {
        return userLogManagers.values().stream()
                .mapToDouble(UserLogManager::calculateAverageScanTime)
                .average()
                .orElse(0.0);
    }

    public double calculateOfficeAverageSaveTime() {
        return userLogManagers.values().stream()
                .mapToDouble(UserLogManager::calculateAverageSaveTime)
                .average()
                .orElse(0.0);
    }

    public double calculateOfficeAverageShowTime() {
        return userLogManagers.values().stream()
                .mapToDouble(UserLogManager::calculateAverageShowTime)
                .average()
                .orElse(0.0);
    }

    public int getDocumentCount() {
        return userLogManagers.values().stream().mapToInt(UserLogManager::getDocumentCount).sum();
    }

    public long getDocumentCountForOffice() {
        return userLogManagers.values()
                .stream()
                .mapToLong(userLogManager -> userLogManager.getLogEntries().size())
                .sum();
    }
}

